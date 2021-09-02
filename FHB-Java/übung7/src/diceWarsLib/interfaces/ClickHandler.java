package diceWarsLib.interfaces;

/**
 * Interface responsible for delegation of board click events.
 *
 * @author {@literal gysar.flegel@fh-bielefeld.de}
 * @author {@literal anestis-pere.lalidis_mateo@fh-bielefeld.de}
 * @author {@literal pkroos@fh-bielefeld.de}
 */
public interface ClickHandler {
	/**
	 * Handle click events on the coordinates x and y.
	 * <p>
	 *     These coordinates are SCREEN coordinates, not board indices.<br>
	 *         x is minimum on the left of the board.<br>
	 *         y is minimum on the top of the board.
	 * </p>
	 * @param x is the x coordinate (left to right).
	 * @param y is the y coordinate (top to bottom).
	 */
	void onClick(int x, int y);
}
