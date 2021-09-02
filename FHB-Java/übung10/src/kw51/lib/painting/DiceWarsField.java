package kw51.lib.painting;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

import kw51.lib.data.*;

/*
 * Responsible for drawing the field.
 *
 *  @author Gysar Flegel, Anestis Lalidis Mateo
 *  @email gysar.flegel@fh-bielefeld.de,
 *         anestis-pere.lalidis_mateo@fh-bielefeld.de
 */
class DiceWarsField {

	// fixed at top left with an arbitrary border offset
	final DiceWarDisplay diceWarDisplay = new DiceWarDisplay(new Coordinate(5, 20));

	/**
	 * the field matrix of guiTiles
	 */
	private ArrayList<ArrayList<GuiTile>> guiTiles; // first list is bottom
	private HashMap<GuiTile, ArrayList<Dice>> dices;

	private Color[] playerColorsLight;
	private Color[] playerColorsDark;
	private Color[] playerTileColor;

	// offset definition for initial sizing of the gui.
	private final int xOffset = 3;
	private final int yOffset = 4;

	private double tileSepWidth() {
		return 0.1 * GuiTile.getHalfWidth();
	}

	int getRequiredWidth() {
		int dim = guiTiles.size();
		double widthInFields = dim + xOffset;
		double tileWidth = GuiTile.getScreenWidth();
		double quadraticWidth = widthInFields * (tileWidth + tileSepWidth());
		double perspectiveWidth = dim / 2.0 * (tileWidth + tileSepWidth()) / 2;
		return (int)(quadraticWidth + perspectiveWidth);
	}

	int getRequiredHeight() {
		int heightInFields = guiTiles.size() + yOffset;
		return (int)(GuiTile.getCenterFieldHeight() * heightInFields);
	}

	private Color lightColorFor(RGB colorspec) {
		final int maxColor = 240;
		final int minColor = 15;

		int r = colorspec.r;
		int g = colorspec.g;
		int b = colorspec.b;
		if (g < minColor && g < minColor && b < minColor) {
			r = Math.max(r, minColor);
			g = Math.max(g, minColor);
			b = Math.max(b, minColor);
		}
		if (g < maxColor || g < maxColor || b < maxColor) {
			return new Color(r, g, b);
		}
		r = Math.min(r, maxColor);
		g = Math.min(g, maxColor);
		b = Math.min(b, maxColor);
		return new Color(r, g, b);
	}

	private Color mixColor(Color a, Color b) {
		BiFunction<Integer, Integer, Integer> avg = (n0, n1) -> (n0 + n1) / 2;
		return new Color(avg.apply(a.getRed(), b.getRed()),
						 avg.apply(a.getGreen(), b.getGreen()),
						 avg.apply(a.getBlue(), b.getBlue()));
	}


	private void generateColors(RGB[] colors) {
		playerColorsLight =
				Arrays.stream(colors).map(this::lightColorFor).toArray(Color[]::new);
		playerColorsDark =
				Arrays.stream(playerColorsLight).map(Color::darker).toArray(Color[]::new);
		playerTileColor = IntStream.range(0, colors.length).mapToObj(
				i -> mixColor(playerColorsLight[i], playerColorsDark[i])).toArray(Color[]::new);
	}

	private void generateTiles(Tile[][] board) {
		guiTiles = new ArrayList<>();
		int dim = board.length;

		for (int i = 0; i < dim; i++) {
			guiTiles.add(new ArrayList<>());
		}
	}

	private void placeTiles(Tile[][] board) {
		final int dim = board.length;

		// updated in the loop
		Coordinate tileCoordinate = initialTileCoordinate(board);

		for (int i = dim-1; i >= 0; i--) {
			for (int j = 0; j < dim; j++) {
				int player = board[i][j].getPlayer();
				Color bright = player != -1 ? playerTileColor[player] : Color.BLACK.brighter();
				Color dark = player != -1 ? playerColorsDark[player] : Color.BLACK;
				GuiTile gt = new GuiTile(tileCoordinate, bright, dark);
				if (player == -1) {
					gt.setInactive();
				}
				gt.setHighlightColor(Color.WHITE);
				guiTiles.get(i).add(gt);
				tileCoordinate = tileCoordinateForTileRight(gt);
			}
			tileCoordinate = tileCoordinateForTileRightAbove(guiTiles.get(i).get(0));
		}
	}

	private void placeDices(GuiTile tile, int player, int amount) {
		Coordinate c = diceCoordinateForTile(tile);
		var bright = playerColorsLight[player];
		var dark = playerColorsDark[player];
		dices.get(tile).clear();
		var dice = new Dice(c.getX(), c.getY(), bright, dark);
		dices.get(tile).add(dice);
		for (int i = 1; i < amount; i++) {
			c = diceCoordinateForDice(dice);
			dice = new Dice(c.getX(), c.getY(), bright, dark);
			dices.get(tile).add(dice);
		}
	}

	DiceWarsField(Tile[][] board, RGB[] colors) {
		generateTiles(board);
		generateColors(colors);
		placeTiles(board);

		dices = new HashMap<>();
		for (int i = 0; i < guiTiles.size(); i++) {
			for (int j = 0; j < guiTiles.size(); j++) {
				var guiTile = guiTiles.get(j).get(i);
				var boardTile = board[j][i];
				dices.put(guiTile, new ArrayList<>());
				if (boardTile.getPlayer() != -1) {
					placeDices(guiTile, boardTile.getPlayer(), boardTile.getDices());
				}
			}
		}
	}

	/*
	 * @param variable minimal value for the random number
	 * @param range maximal value for the random number
	 * @return a random number
	 */
	private double randomize(double variable, double range) {
		return variable + (Math.random() * range - range / 2);
	}

	/*
	 * @param tile the corresponding dice coordination for this tile
	 * @return the corresponding dice coordinate.
	 */
	private Coordinate diceCoordinateForTile(GuiTile tile) {
		return new Coordinate(randomize(tile.getScreenBottomX() / Dice.SCALE, 0.4),
				randomize((tile.getScreenBottomY() - 0.3 * GuiTile.getScreenHeight()) / Dice.SCALE, 0.5));
	}

	private Coordinate initialTileCoordinate(Tile[][] board) {
		final int dim = board.length;
		double x = GuiTile.getScreenWidth() / GuiTile.getScale();
		double y = (yOffset+dim-1) * GuiTile.getCenterFieldHeight() / GuiTile.getScale();
		return new Coordinate(x, y);
	}

	/*
	 * @param dice the corresponding dice coordination for this dice
	 * @return the corresponding dice coordinate
	 */
	private Coordinate diceCoordinateForDice(Dice dice) {
		return new Coordinate(randomize(dice.getScreenX() / Dice.SCALE, 0.3),
				randomize(dice.getScreenY() / Dice.SCALE - dice.getFrontHeight(), 0.2));
	}

	/*
	 * get coordinate to place a tile to the right of a given tile
	 * @param tile the given tile
	 * @return coordinates to place a new tile
	 */
	private Coordinate tileCoordinateForTileRight(GuiTile tile) {
		return new Coordinate(tile.getScreenBottomX() / GuiTile.getScale() + GuiTile.getHalfWidth() * 2 + tileSepWidth(),
				tile.getScreenBottomY() / GuiTile.getScale());
	}

	/*
	 * get coordinate to place a tile above of a given tile
	 * @param tile the given tile
	 * @return coordinates to place a new tile
	 */
	private Coordinate tileCoordinateForTileRightAbove(GuiTile tile) {
		return new Coordinate(tile.getScreenBottomX() / GuiTile.getScale() + GuiTile.getHalfWidth() + 0.05 * GuiTile.getHalfWidth(),
				tile.getScreenBottomY() / GuiTile.getScale() - tile.getMid1Height() - GuiTile.getBaseHeight() - 0.05 * GuiTile.getHalfWidth());
	}

	/*
	 * get coordinate to place a tile below of a given tile
	 * @param tile the given tile
	 * @return coordinates to place a new tile
	 */
//	private Coordinate tileCoordinateForTileRightBelow(GuiTile tile) {
//		return new Coordinate(tile.getScreenBottomX() / GuiTile.getScale() + tile.getHalfWidth() + 0.05 * tile.getHalfWidth(),
//				tile.getScreenBottomY() / GuiTile.getScale() + tile.getMid1Height() + tile.getBaseHeight() + 0.05 * tile.getHalfWidth());
//	}

	/*
	 * Used to draw all the placed objects
	 * @param g swing graphics object
	 */
	void draw(Graphics g) {

		for (var row: guiTiles) {
			row.forEach(gt -> gt.draw(g));
			row.forEach(gt -> dices.get(gt).forEach(dice -> dice.draw(g)));
		}

		diceWarDisplay.draw(g);
	}

	/*
	 * used to get the gui position of a tile
	 * @return matrix of all the tiles with window coordinates
	 */
	Coordinate[] getTilePosition(int x, int y) {
		return guiTiles.get(y).get(x).getBoundary();
	}

	public void setTileColor(Position fieldPosition, int colorIndex) {
		var tile = guiTiles.get(fieldPosition.getY()).get(fieldPosition.getX());
		tile.setDarkColor(playerColorsDark[colorIndex]);
		tile.setLightColor(playerTileColor[colorIndex]);
	}

	public void setTileDices(Position fieldPosition, int colorIndex, int dices) {
		GuiTile tile = guiTiles.get(fieldPosition.getY()).get(fieldPosition.getX());
		placeDices(tile, colorIndex, dices);
	}

	public void highlightTile(Position fieldPosition) {
		guiTiles.get(fieldPosition.getY()).get(fieldPosition.getX()).highlight();
	}

	public void unHighlightTile(Position fieldPosition) {
		guiTiles.get(fieldPosition.getY()).get(fieldPosition.getX()).unHighlight();
	}

	public void showDiceWarDisplay(int attacker, int defender, int attackerDices, int defenderDices) {
		diceWarDisplay.reinit(playerColorsLight[attacker], playerColorsLight[defender], attackerDices, defenderDices);
	}

	public void updateDiceWarDisplay(int[] attacker, int[] defender) {
		diceWarDisplay.update(attacker, defender);
	}

	public void hideDiceWarDisplay() {
		diceWarDisplay.hide();
	}
}