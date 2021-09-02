package kw51.lib.painting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import kw51.lib.data.Coordinate;
import kw51.lib.data.RGB;
import kw51.lib.data.Tile;
import kw51.lib.game.MouseListenerTemplate;
import kw51.lib.interfaces.MenuHandler;
import kw51.lib.interfaces.TileManager;

/*
 * Used to connect the logic with the gui.
 *
 *  @author Gysar Flegel, Anestis Lalidis Mateo
 *  @email gysar.flegel@fh-bielefeld.de,
 *         anestis-pere.lalidis_mateo@fh-bielefeld.de
 */
@SuppressWarnings("serial")
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
		
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/res/icon_64x64.png")).getImage());
		
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
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		super.paintComponent(g2d);
		diceWarsField.draw(g2d);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(diceWarsField.getRequiredWidth(), diceWarsField.getRequiredHeight());
	}
}
