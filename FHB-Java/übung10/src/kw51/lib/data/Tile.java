package kw51.lib.data;

/**
 * Encapsulates relevant information about a board field (tile). A tile knows
 * where on the board it is located and which player occupies it with how many
 * dices.
 */
public final class Tile {
	final Position fieldPosition;
	int player;
	int dices;

	/**
	 * Constructs a tile for a specific position.
	 *
	 * <p>
	 * Board coordinates are oriented from the top left to the bottom right; i.e.
	 * passing x=0, y=0 refers to the most top left tile.
	 * </p>
	 * 
	 * @see Position
	 * @param x is the column index.
	 * @param y is the row index.
	 */
	public Tile(int x, int y) {
		this(x, y, -1, 0);
	}

	private Tile(int x, int y, int player, int dices) {
		this.fieldPosition = new Position(x, y);
		this.player = player;
		this.dices = dices;
	}

	/**
	 * Accesses the index of the player occupying this tile.
	 *
	 * @return a player id; -1 if not set via {@link #setPlayer}
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * Accesses the amount of dices on this tile.
	 *
	 * @return the number of dices; 0 if not set via {@link #setDices(int)}
	 */
	public int getDices() {
		return dices;
	}

	/**
	 * Sets the amount of dices on this tile.
	 * 
	 * @param dices is the amount.
	 */
	public void setDices(int dices) {
		this.dices = dices;
	}

	/**
	 * Sets the player for this tile.
	 * 
	 * @param player is the player index.
	 */
	public void setPlayer(int player) {
		this.player = player;
	}

	/**
	 * Accesses the position of this tile.
	 * 
	 * @return the position (column/row index).
	 */
	public Position getFieldPosition() {
		return fieldPosition;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (other instanceof Tile) {
			Tile otherTile = (Tile) other;
			return otherTile.getFieldPosition().equals(fieldPosition);
		}
		return false;
	}
	
}
