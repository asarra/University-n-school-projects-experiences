package kw51.lib.interfaces;

import java.awt.*;

/**
 * Defines methods called on menu item clicks.
 */
public interface MenuHandler {

    /**
     * Called when a user chooses to load a game.
     * This should open a file chooser dialog to select a valid board file.
     * Use the passed argument for swing/awt methods requiring a parent context.
     *
     * @param parent is the graphical parent component.
     */
    void onMenuItemLoadGame(Component parent);

    /**
     * Called when a user chooses to save a game.
     * This should open a file chooser dialog to create a valid board file.
     * Use the passed argument for swing/awt methods requiring a parent context.
     *
     * @param parent is the graphical parent component.
     */
    void onMenuItemSaveGame(Component parent);

    /**
     * Called when a user chooses to start a new game.
     * This should generate a random board.
     * Optionally, an implementing class might opt to define a dialog instead, so that
     * the user can select parameters for board size, amount of dices, etc.
     * Use the passed argument for swing/awt methods requiring a parent context.
     *
     * @param parent is the graphical parent component.
     */
    void onMenuItemNewGame(Component parent);
}
