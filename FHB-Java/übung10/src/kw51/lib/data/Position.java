package kw51.lib.data;

/**
 * Encapsulates x and y board coordinates.
 *
 * These are indices, as opposed to the data encapsulated in {@link Position}.
 *
 * @author {@literal pkroos@fh-bielefeld.de}
 */
public final class Position {
    private final int x;
    private final int y;

    /**
     * Constructs a position from a board index.
     * @param x is the column position (0 is left).
     * @param y is the row position (0 is top).
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Accesses the x position (column).
     * 0 is the most left column, the next one to the right is 1.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Accesses the y position (row).
     * 0 is the top row, the one below the top row is 1.
     * @return y
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Position)) {
            return false;
        }
        return ((Position)other).x == x && ((Position)other).y == y;
    }
}
