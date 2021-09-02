package diceWarsLib.interfaces;

import diceWarsLib.data.Coordinate;
import diceWarsLib.data.Tile;

/**
 * Provides access to board tile properties.
 */
public interface TileManager {

    /**
     * Resets a board field according to the provided tile.
     * Note: the tile itself is not stored, the properties are copied.
     *
     * @param tile is the definition of a tile.
     */
    void setTile(Tile tile);

    /**
     * Accesses the screen position of the tile in a specific row and column.
     * <p>
     *     Rows are counted top to bottom, columns are counted left to right.
     *     I.e., row=0, column=0 always accesses the tile in the upper left position.
     *     row=1, column=0 always accesses the most left tile in the second row from the top.
     * </p>
     * <p>
     *     The returned array of {@link Coordinate} objects enumerates the screen coordinates
     *     of the referenced tiles' corners in a clockwise manner, starting from the center top.
     *     It always contains all 6 corners.
     * </p>
     *
     * @param row is the y index of the tile in the range [0, board dimension)
     * @param column is the x index of the tile in the range [0, board dimension)
     * @return the screen coordinates of the corners of the indexed tile.
     */
    Coordinate[] getTilePosition(int row, int column);

    /**
     * Selects a tile at specific coordinates to be highlighted.
     * All attributes of the tile BUT its position are ignored.
     * @param tile is an object indexing a field on the board.
     */
    void highlightTile(Tile tile);

    /**
     * Selects a tile at specific coordinates to not be highlighted.
     * All attributes of the tile BUT its position are ignored.
     * @param tile is an object indexing a field on the board.
     */
    void unHighlightTile(Tile tile);
}
