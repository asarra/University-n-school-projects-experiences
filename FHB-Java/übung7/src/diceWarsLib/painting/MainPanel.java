package diceWarsLib.painting;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        JLabel infoText = new JLabel("");
        JButton button = new JButton("");
        this.setLayout(new BorderLayout());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(infoText);
        bottomPanel.add(button);

        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Optionen");
        JMenuItem loadGameMenuItem = new JMenuItem("Spielstand laden...");
        JMenuItem storeGameMenuItem = new JMenuItem("Spielstand sichern...");
        JMenuItem newGameMenuItem = new JMenuItem("Neues Spiel...");
        optionsMenu.add(loadGameMenuItem);
        optionsMenu.add(storeGameMenuItem);
        optionsMenu.add(newGameMenuItem);
        menuBar.add(optionsMenu);

        JPanel paintingPanel = new JPanel();
        paintingPanel.setPreferredSize(new Dimension(200, 400));
        this.add(menuBar, BorderLayout.NORTH);
        this.add(paintingPanel);
        this.add(bottomPanel,BorderLayout.SOUTH);
    }
}
