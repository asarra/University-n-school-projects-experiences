package kw51.impl;

import java.util.ArrayList;
import java.util.Random;

import kw51.lib.data.Tile;

public class FieldGenerator extends kw51.lib.game.FieldGenerator {

	private int players, fieldPerPlayer, dicesPerPlayer;
	private DiceWarsManager manager;

	public FieldGenerator(int players, int fieldsPerPlayer, int dicesPerPlayer, DiceWarsManager dws) {
		super(players, fieldsPerPlayer, dicesPerPlayer);
		this.players = players;
		this.fieldPerPlayer = fieldsPerPlayer;
		this.dicesPerPlayer = dicesPerPlayer;
		this.manager = dws;
	}

	@Override
	protected Tile[][] generate() {
		int fields = fieldPerPlayer * players;
		int size = (int) Math.ceil(Math.sqrt(fields));
		Tile[][] tiles = new Tile[size][size];

		Random rnd = new Random();

		for (int player = 0; player < players; player ++) {
			for (int field = 0; field < fieldsPerPlayer; field ++) {
				int x = -1;
				int y = -1;
				do {
					x = rnd.nextInt(size);
					y = rnd.nextInt(size);
				} while (tiles[x][y] != null);
				tiles[x][y] = new Tile(y, x);
				tiles[x][y].setPlayer(player);
				tiles[x][y].setDices(1);
			}
		}

		for (int x = 0; x < size; x ++) {
			for (int y = 0; y < size; y ++) {
				if (tiles[x][y] == null) {
					tiles[x][y] = new Tile(y, x);
					tiles[x][y].setPlayer(-1);
				}
			}
		}

		for (int player = 0; player < players; player ++) {
			int dicesLeft = dicesPerPlayer - fieldPerPlayer;
			while (dicesLeft > 0) {
				ArrayList<Tile> playerTiles = new ArrayList<Tile>();
				for (int x = 0; x < size; x ++) {
					for (int y = 0; y < size; y ++) {
						if (tiles[x][y].getPlayer() == player) {
							playerTiles.add(tiles[x][y]);
						}
					}
				}
				ArrayList<Tile> smallTiles = new ArrayList<Tile>();
				int smallest = Integer.MAX_VALUE;
				for (Tile t : playerTiles) {
					if (t.getDices() < smallest) {
						smallest = t.getDices();
						smallTiles.clear();
						smallTiles.add(t);
					} else if(t.getDices() == smallest) {
						smallTiles.add(t);
					}
				}
				Tile fillTile = smallTiles.get(rnd.nextInt(smallTiles.size()));
				int add = rnd.nextInt(dicesLeft > 2 ? 2 : dicesLeft) + 1;
				fillTile.setDices(fillTile.getDices() + add);
				dicesLeft -= add;
			}
		}
		
		for(int x = 0; x < tiles.length; x ++) {
			for(int y = 0; y < tiles[x].length; y ++) {
				manager.tiles.add(tiles[x][y]);
			}
		}
		
		return tiles;
	}

}
