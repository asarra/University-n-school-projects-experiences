package diceWarsLib.painting;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import diceWarsLib.data.*;
import diceWarsLib.game.MouseListenerTemplate;
import diceWarsLib.interfaces.MenuHandler;
import diceWarsLib.interfaces.TileManager;

/*
 * Used to connect the logic with the gui.
 *
 *  @author Gysar Flegel, Anestis Lalidis Mateo
 *  @email gysar.flegel@fh-bielefeld.de,
 *         anestis-pere.lalidis_mateo@fh-bielefeld.de
 */
public class DiceWarsPanel extends JPanel implements TileManager {

	/*
	 * Used internally to draw
	 */
	private DiceWarsField diceWarsField;

	/*
	 * The button on the screen
	 */
	private JButton button;

	/*
	 * The text on the screen
	 */
	private JLabel infoText;

	private JFrame frame;

	private final JMenuBar menuBar;
	private final JMenuItem loadGameMenuItem;
	private final JMenuItem storeGameMenuItem;
	private final JMenuItem newGameMenuItem;

	public void registerButtonListener(ActionListener listener) {
		button.addActionListener(listener);
	}

	public void registerMouseListener(MouseListenerTemplate listener) {
		addMouseListener(listener);
	}

	public void changeButtonLabel(String label) {
		button.setText(label);
	}

	public void setInfoText(String label) {
		this.infoText.setText(label);
	}

	public void setInfoTextColor(RGB color) {
		this.infoText.setForeground(new Color(color.r, color.g, color.b));
	}

	public void initialize(Tile[][] board, RGB[] colors, Runnable whenVisible) {
		frame.setVisible(false);
		frame.add(this);
		frame.setJMenuBar(menuBar);
		SwingUtilities.invokeLater(() -> {
			frame.dispose();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			new Thread(whenVisible::run).start();
		});
		diceWarsField = new DiceWarsField(board, colors);
	}

	public DiceWarsPanel() {
		frame = new JFrame();
		infoText = new JLabel("Welcome to Dice Wars");
		button = new JButton("Next Player");
		//diceWarsField = new DiceWarsField(board, colors);
		setLayout(new BorderLayout());
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.add(infoText);
		bottomPanel.add(button);
		add(bottomPanel,BorderLayout.SOUTH);

		menuBar = new JMenuBar();
		JMenu optionsMenu = new JMenu("Optionen");
		loadGameMenuItem = new JMenuItem("Spielstand laden...");
		storeGameMenuItem = new JMenuItem("Spielstand sichern...");
		newGameMenuItem = new JMenuItem("Neues Spiel...");
		optionsMenu.add(loadGameMenuItem);
		optionsMenu.add(storeGameMenuItem);
		optionsMenu.add(newGameMenuItem);
		menuBar.add(optionsMenu);

		frame.add(this);
		frame.setJMenuBar(menuBar);
	}

	private void scheduleRepaint() {
		SwingUtilities.invokeLater(this::repaint);
	}

	public Coordinate[] getTilePosition(int row, int column) {
		return diceWarsField.getTilePosition(row, column);
	}

	public void setTile(Tile tile) {
		diceWarsField.setTileColor(tile.getFieldPosition(), tile.getPlayer());
		diceWarsField.setTileDices(tile.getFieldPosition(), tile.getPlayer(), tile.getDices());
		scheduleRepaint();
	}

	public void highlightTile(Tile tile) {
		diceWarsField.highlightTile(tile.getFieldPosition());
		scheduleRepaint();
	}

	public void unHighlightTile(Tile tile) {
		diceWarsField.unHighlightTile(tile.getFieldPosition());
		scheduleRepaint();
	}

	public void enableDiceWarDisplay(int attacker, int defender, int attackerDices, int defenderDices) {
		diceWarsField.showDiceWarDisplay(attacker, defender, attackerDices, defenderDices);
		scheduleRepaint();
	}

	public void updateDiceWarDisplay(int[] attacker, int[] defender) {
		diceWarsField.updateDiceWarDisplay(attacker, defender);
		scheduleRepaint();
	}

	public void disableDiceWarDisplay() {
		diceWarsField.hideDiceWarDisplay();
		scheduleRepaint();
	}

	public void setMenuListener(MenuHandler menuHandler) {
		loadGameMenuItem.addActionListener(ignored -> menuHandler.onMenuItemLoadGame(this));
		storeGameMenuItem.addActionListener(ignored -> menuHandler.onMenuItemSaveGame(this));
		newGameMenuItem.addActionListener(ignored -> menuHandler.onMenuItemNewGame(this));
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		diceWarsField.draw(g);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(diceWarsField.getRequiredWidth(), diceWarsField.getRequiredHeight());
	}
}
