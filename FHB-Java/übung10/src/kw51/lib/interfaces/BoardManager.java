package kw51.lib.interfaces;

import kw51.lib.data.RGB;

/**
 * Provides methods to access and change properties of a {@link kw51.lib.game.DiceWars} game.
 * @author {@literal pkroos@fh-bielefeld.de}
 */
public interface BoardManager {
    /**
     * Accesses the dimension of the board.
     * <p>A board is always quadratic, i.e. the value returned is both the number of rows and columns.</p>
     * @return the board dimensions (width and/or height in fields).
     */
    int getBoardDimensions();

    /**
     * Changes the label of the button on the bottom right of the field.
     * @param text is the label of the button.
     */
    void setButtonText(String text);

    /**
     * Changes the text of the label next to the button.
     * @param text is the new label text.
     */
    void setInfoText(String text);

    /**
     * Changes the color of the label next to the button.
     * @param color is the new label color.
     */
    void setInfoTextColor(RGB color);

    /**
     * Clears the text of the label next to the button.
     */
    void clearInfoText();

    /**
     * Initializes a dice war.
     * <p>If used correctly, this can be used to display results of a dice attack on the board.</p>
     *
     * @see DiceWar for more information.
     * @param diceWar is the implementation of the dice attack.
     */
    void initializeDiceWar(DiceWar diceWar);
}
