package kw51.lib.painting;

/*
 *
 *  @author Gysar Flegel, Anestis Lalidis Mateo
 *  @email gysar.flegel@fh-bielefeld.de,
 *         anestis-pere.lalidis_mateo@fh-bielefeld.de
 */
class DiceDot {

	private int x;

	private int y;

	DiceDot(double x, double y) {
		this.x = (int) x;
		this.y = (int) y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}