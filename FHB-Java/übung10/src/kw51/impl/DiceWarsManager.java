package kw51.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import kw51.lib.data.RGB;
import kw51.lib.data.Tile;
import kw51.lib.game.DiceWars;
import util.*;

public class DiceWarsManager {

	protected int playerCount = 4;
	protected RGB[] playerColors = new RGB[] { new RGB(139, 109, 183), new RGB(109, 153, 183), new RGB(109, 183, 176), new RGB(183, 139, 109)};
	protected int fieldsPerPlayer = 6;
	protected int dicesPerPlayer = 21;
	
	private int currentPlayer = 0;
	
	private DiceWars instance = new DiceWars();
	private FieldGenerator fieldGenerator;
	private ClickHandler clickHandler = new ClickHandler(this);
	private ButtonClickHandler buttonClickHandler = new ButtonClickHandler(this);
	private EventHandler eventHandler = new EventHandler(this);
	
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public static void main(String[] args) {
		logger.getInstance().log("\nProgrammstart\n");
		new DiceWarsManager();
	}
	
	public DiceWarsManager() {
		
		this.fieldGenerator = new FieldGenerator(playerCount, fieldsPerPlayer, dicesPerPlayer, this);
		
		instance.reset();
		instance.setMenuHandler(new MenuHandler(this));	
		instance.registerClickHandler(clickHandler);
		instance.registerButtonClickHandler(buttonClickHandler);
		instance.setEventHandler(eventHandler);
	}

	public Tile getTileAt(int x, int y) {
		for(Tile t : tiles) {
			if(t.getFieldPosition().getX() == x && t.getFieldPosition().getY() == y) return t;
		}
		return null;
	}
	
	public void nextPlayer() {
		this.currentPlayer ++;
		if(this.currentPlayer >= playerCount) {
			this.currentPlayer = 0;
			
			//Neue Würfel verteilen
			
			Random rnd = new Random();
			int amount = rnd.nextInt(10)+1;
			for(int i = 0; i < amount; i ++) {
				int x = rnd.nextInt(instance.getBoardManager().getBoardDimensions());
				int y = rnd.nextInt(instance.getBoardManager().getBoardDimensions());
				Tile t = getTileAt(x, y);
				if(t.getPlayer() != -1) {
					t.setDices(t.getDices() + 1);
					instance.getTileManager().setTile(t);
				}
			}
		}
		updateInfoGui();
		for(Tile t : tiles) {
			instance.getTileManager().unHighlightTile(t);
		}
		clickHandler.reset();
	}
	
	public void updateInfoGui() {
		instance.getBoardManager().setInfoText("Spieler #" + (currentPlayer+1) + " ist dran.");
		instance.getBoardManager().setInfoTextColor(playerColors[currentPlayer]);
	}
	
	public int getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public DiceWars getDiceWars() {
		return this.instance;
	}
	
	public FieldGenerator getFieldGenerator() {
		return this.fieldGenerator;
	}
	
	public void unHighlightAll() {
		for(Tile t : tiles) {
			instance.getTileManager().unHighlightTile(t);
		}
	}
	
	public void makeFieldGenerator(int players, int fieldsPerPlayer, int dicesPerPlayer) {
		this.fieldGenerator = new FieldGenerator(players, fieldsPerPlayer, dicesPerPlayer, this);
	}

	public void generateFieldAndSaveFile(File file) {
		Tile[][] tiles = fieldGenerator.generate();
		instance.reset(tiles, playerColors);
		try {
			saveToFile(file);
		}
		catch (IOException e){
			System.out.println("Fehler:\t"+e);
		}
	}
	
	public void saveToFile(File file) throws IOException {
		DiceWarsFileOutput dfo = new DiceWarsFileOutput(new FileOutputStream(file));
		Tile[][] board = new Tile[(int)Math.sqrt(this.tiles.size())][(int)Math.sqrt(this.tiles.size())];
		int temp=0;
		for(int i = 0;i < board.length; i++)
			for(int j = 0;j < board.length; j++)
				board[i][j]=tiles.get(temp++);
		GameStatus gs = new GameStatus(board, this.playerColors, this.currentPlayer);
		dfo.writeGameStatus(gs);
	}
	
	public void loadFileAndGenerate(File file) throws IOException, FileFormatException {
		DiceWarsFileInput dfi = new DiceWarsFileInput(new FileInputStream(file));
		GameStatus gs = dfi.readGameStatus();
		this.currentPlayer = gs.currentPlayer;
		this.playerColors = gs.colors;
		this.playerCount = gs.colors.length;
		this.tiles.clear();

		for(Tile[] tilearray : gs.board)
			for(Tile tile : tilearray)
				tiles.add(tile);
		instance.reset(gs.board, this.playerColors);
	}

}

