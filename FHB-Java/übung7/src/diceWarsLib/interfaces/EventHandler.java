package diceWarsLib.interfaces;

import diceWarsLib.data.Tile;

/**
 * Defines events about which an implementer is notified by the game.
 */
public interface EventHandler {
    /**
     * Called when the board has been reset.
     * Use this or {@link #onStart(BoardManager)} to reset the label, button text, or values used internally.
     *
     * @param board is the new board.
     */
    void onInit(Tile[][] board);

    /**
     * Called a short while after the board has been set visible.
     *
     * @param boardManager is the updated {@link BoardManager}.
     */
    void onStart(BoardManager boardManager);

    /**
     * Called when a new dice war begins, i.e. an attack of a single tile.
     * @param diceWar is the data source for the beginning dice war.
     */
    void onDiceWarBegin(DiceWar diceWar);

    /**
     * Called when a dice war ends, i.e. an attack of a single tile is finished.
     * Use this to update the board.
     * @param diceWar is the data source for the beginning dice war.
     * @param tileManager is the {@link TileManager} of the current game.
     */
    void onDiceWarDone(DiceWar diceWar, TileManager tileManager);
}
