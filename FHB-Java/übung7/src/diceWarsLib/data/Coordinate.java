package diceWarsLib.data;

import java.util.Objects;

/**
 * Encapsulates x and y coordinates.
 *
 * These are screen coordinates, as opposed to the data encapsulated in {@link Position}.
 *
 * @author {@literal gysar.flegel@fh-bielefeld.de}
 * @author {@literal anestis-pere.lalidis_mateo@fh-bielefeld.de}
 */
public final class Coordinate {

	private final double x;
	private final double y;

	/**
	 * Accesses the x coordinate. x values increase left to right.
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Accesses the y coordinate. y values increase top to bottom.
	 * @return y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Constructs a coordinate.
	 * @param x is the x value (width).
	 * @param y is the y value (height).
	 */
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Coordinate) {
			var otherCoordinate = (Coordinate)other;
			return otherCoordinate.x == x && otherCoordinate.y == y;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}