package diceWarsLib.painting;

import java.awt.*;

/*
 * Holds all the information the GUI needs to draw a dice.
 * You dont need to understand or use this class.
 *
 *  @author Gysar Flegel, Anestis Lalidis Mateo
 *  @email gysar.flegel@fh-bielefeld.de,
 *         anestis-pere.lalidis_mateo@fh-bielefeld.de
 */
class Dice {

	public static final int SCALE = 35;
	private static final double HALF_WIDTH = 0.6;
	private static final double BORDER_HEIGHT = 0.25;
	private static final double TOP_HEIGHT = 0.5;
	private static final double FRONT_HEIGHT = 0.75;

	private final int[] topX = new int[4];
	private final int[] topY = new int[4];
	private final int[] leftX = new int[4];
	private final int[] leftY = new int[4];
	private final int[] rightX = new int[4];
	private final int[] rightY = new int[4];

	private final Color bright;
	private final Color dark;

	private final double screenX;
	private final double screenY;

	// fixed amount of dots for every dice (3 sides)
	private final DiceDot[] dots = new DiceDot[6];

	private final Polygon cubeTop;
	private final Polygon cubeLeft;
	private final Polygon cubeRight;

	double getScreenX() {
		return screenX;
	}

	double getScreenY() {
		return screenY;
	}

	/**
	 * Construct the screen geometry of a dice, including dots (always the same).
	 * <p>
	 * Screen height of the dice is (FRONT_HEIGHT + TOP_HEIGHT) * scale. Screen
	 * width is 2*HALF_WIDTH * scale. Its lowest screen coordinate is
	 * (centerX,centerY) * scale.
	 *
	 * @param x is the lowest x coordinate of the dice.
	 * @param y is the lowest y coordinate of the dice.
	 */
	Dice(double x, double y, Color bright, Color dark) {
		this.bright = bright;
		this.dark = dark;
		screenX = (x * SCALE);
		screenY = (y * SCALE);

		// top
		// front
		topX[0] = (int) screenX;
		topY[0] = (int) (screenY - getFrontHeight() * SCALE);
		// left
		topX[1] = (int) (screenX - HALF_WIDTH * SCALE);
		topY[1] = (int) (screenY - (getFrontHeight() + BORDER_HEIGHT) * SCALE);
		// top
		topX[2] = (int) screenX;
		topY[2] = (int) (screenY - (getFrontHeight() + TOP_HEIGHT) * SCALE);
		// right
		topX[3] = (int) (screenX + HALF_WIDTH * SCALE);
		topY[3] = topY[1];

		// left side
		// center
		leftX[0] = topX[0];
		leftY[0] = topY[0];
		// left top
		leftX[1] = topX[1];
		leftY[1] = topY[1];
		// left bottom
		leftX[2] = leftX[1];
		leftY[2] = (int) (screenY - BORDER_HEIGHT * SCALE);
		// center bottom
		leftX[3] = leftX[0];
		leftY[3] = (int) screenY;

		// right side
		// center
		rightX[0] = topX[0];
		rightY[0] = topY[0];
		// right top
		rightX[1] = topX[3];
		rightY[1] = topY[3];
		// right bottom
		rightX[2] = rightX[1];
		rightY[2] = leftY[2];
		// center bottom
		rightX[3] = leftX[3];
		rightY[3] = leftY[3];

		// 1 on front left
		dots[0] = new DiceDot((leftX[1] + leftX[0]) * 0.5, (leftY[1] + rightY[3]) * 0.5);
		// 2 on top
		dots[1] = new DiceDot(topX[1] * 0.3 + topX[2] * 0.7, topY[1]); // left
		dots[2] = new DiceDot(topX[2] * 0.7 + topX[3] * 0.3, topY[1]);
		// 3 on front right
		dots[4] = new DiceDot((rightX[0] + rightX[1]) * 0.5, (leftY[0] + leftY[2]) * 0.5); // center
		dots[3] = new DiceDot((dots[4].getX() + rightX[1]) * 0.5, (dots[4].getY() + rightY[1]) * 0.5); // right
		dots[5] = new DiceDot((dots[4].getX() + rightX[3]) * 0.5, (dots[4].getY() + rightY[3]) * 0.5); // left

		cubeTop = new Polygon(topX, topY, topX.length);
		cubeLeft = new Polygon(leftX, leftY, leftX.length);
		cubeRight = new Polygon(rightX, rightY, rightX.length);
	}

	double getFrontHeight() {
		return FRONT_HEIGHT;
	}

	void draw(Graphics g) {

		g.setColor(bright);
		g.fillPolygon(cubeTop);
		g.fillPolygon(cubeLeft);
		g.setColor(dark);
		g.fillPolygon(cubeRight);

		g.setColor(Color.BLACK);
		g.drawPolygon(cubeTop);
		g.drawPolygon(cubeLeft);
		g.drawPolygon(cubeRight);

		final int radi = 2;
		for (DiceDot dot : dots) {
			g.fillOval(dot.getX()-radi, dot.getY()-radi, 2*radi, 2*radi);
		}
	}
}
