package diceWarsLib.painting;

import diceWarsLib.data.Coordinate;

import java.awt.*;

/*
 * Holds the information a Tile holds (not player and dices but position in screen coordinates)
 * You dont need to understand or use this class.
 *
 *  @author Gysar Flegel, Anestis Lalidis Mateo
 *  @email gysar.flegel@fh-bielefeld.de,
 *         anestis-pere.lalidis_mateo@fh-bielefeld.de
 */
class GuiTile {
	private final static int TOP = 0;
	private final static int TR = 1;
	private final static int BR = 2;
	private final static int BOTTOM = 3;
	private final static int BL = 4;
	private final static int TL = 5;

	private static final int scale = 40;

	private final static BasicStroke thinStroke = new BasicStroke(1);
	private final static BasicStroke thickStroke = new BasicStroke(2);

	// height of the base -- the 3d effect
	private final static double baseHeight = 0.1;

	// from top or bottom to right/left border
	private final static double halfWidth = 1.2;

	// distance from the top to the line from top left to top right
	private final static double mid0Height = 0.4;

	// distance from the bottom ("upper" bottom in 3d) to the line from bottom left to bottom right
	private final static double mid1Height = 0.9;

	// distance between top left/right and bottom left/right
	private final static double ctrHeight = 1.2;

	final int[] baseX = new int[6];

	final int[] baseY = new int[6];

	final int[] fieldX = new int[6];

	final int[] fieldY = new int[6];

	private final double screenBottomX;

	private final double screenBottomY;

	private final double screenHeight;

	private Color darkColor;
	private Color lightColor;
	private Color highlightColor = Color.RED;

	private boolean isHighlighted = false;
	private boolean inactive = false;

	/*
	 * Construct the geometry of a single tile.
	 * @param coord x and y coordinate of the tile
	 */
	GuiTile(Coordinate coord, Color lightColor, Color darkColor) {
		this.darkColor = darkColor;
		this.lightColor = lightColor;
		screenBottomX = coord.getX() * getScale();
		screenBottomY = coord.getY() * getScale();
		screenHeight = (getBaseHeight() + ctrHeight) * getScale();

		baseX[TOP] = (int) screenBottomX; // bottom upper
		baseY[TOP] = (int) (screenBottomY - getBaseHeight() * getScale());
		baseX[TL] = (int) (getScreenBottomX() - getHalfWidth() * getScale()); // left upper
		baseY[TL] = (int) (getScreenBottomY() - mid0Height * getScale());
		baseX[BL] = baseX[TL]; // left lower
		baseY[BL] = (int) (getScreenBottomY() - (mid0Height - getBaseHeight()) * getScale());
		baseX[BOTTOM] = (int) getScreenBottomX(); // bottom lower
		baseY[BOTTOM] = (int) getScreenBottomY();
		baseX[BR] = (int) (getScreenBottomX() + getHalfWidth() * getScale()); // right lower
		baseY[BR] = baseY[BL];
		baseX[TR] = baseX[BR]; // right upper
		baseY[TR] = baseY[TL];

		fieldX[BOTTOM] = baseX[TOP]; // center bottom
		fieldY[BOTTOM] = baseY[TOP];
		fieldX[BR] = baseX[TR]; // right bottom
		fieldY[BR] = baseY[TR];
		fieldX[TR] = fieldX[BR]; // right top
		fieldY[TR] = (int) (getScreenBottomY() - (getBaseHeight() + getMid1Height()) * getScale());
		fieldX[TOP] = fieldX[BOTTOM]; // center top
		fieldY[TOP] = (int) (getScreenBottomY() - getScreenHeight());
		fieldX[TL] = baseX[TL]; // left top
		fieldY[TL] = fieldY[TR];
		fieldX[BL] = fieldX[TL]; // left bottom
		fieldY[BL] = fieldY[BR];

		boundary = new Coordinate[] {
			new Coordinate(fieldX[TOP], fieldY[TOP]),
			new Coordinate(fieldX[TR], fieldY[TR]),
			new Coordinate(baseX[BR], baseY[BR]),
			new Coordinate(baseX[BOTTOM], baseY[BOTTOM]),
			new Coordinate(baseX[BL], baseY[BL]),
			new Coordinate(fieldX[TL], fieldY[TL])
		};
	}

	private final Coordinate[] boundary;

	static double getScreenWidth() {
		return 2 * halfWidth * scale;
	}

	static double getScreenHeight() {
		return (baseHeight + ctrHeight) * scale;
	}

	static double getCenterFieldHeight() {
		return ctrHeight * scale;
	}

	void setDarkColor(Color color) {
		this.darkColor = color;
	}

	void setLightColor(Color color) {
		this.lightColor = color;
	}

	void setHighlightColor(Color color) { this.highlightColor = color; }

	double getScreenBottomY() {
		return screenBottomY;
	}

	double getScreenBottomX() {
		return screenBottomX;
	}

	static int getScale() {
		return scale;
	}

	double getMid1Height() {
		return mid1Height;
	}

	static double getHalfWidth() {
		return halfWidth;
	}

	static double getBaseHeight() {
		return baseHeight;
	}

	void highlight() { isHighlighted = true; }
	void unHighlight() { isHighlighted = false; }

	void draw(Graphics g) {
		if (inactive) return;

		var borderColor = isHighlighted? lightColor.brighter() : Color.BLACK;
		var stroke = isHighlighted? thickStroke : thinStroke;

		Polygon tilePolygon = new Polygon(baseX, baseY, baseX.length);
		g.setColor(darkColor);
		g.fillPolygon(tilePolygon);
		g.setColor(borderColor);
		((Graphics2D) g).setStroke(stroke);
		g.drawPolygon(tilePolygon);

		tilePolygon = new Polygon(fieldX, fieldY, fieldX.length);
		g.setColor(lightColor);
		g.fillPolygon(tilePolygon);
		((Graphics2D) g).setStroke(stroke);
		g.setColor(borderColor);
		g.drawPolygon(tilePolygon);

		((Graphics2D) g).setStroke(thinStroke);
	}

	public Coordinate[] getBoundary() {
		return boundary;
	}

	public void setInactive() {
		inactive = true;
	}
}