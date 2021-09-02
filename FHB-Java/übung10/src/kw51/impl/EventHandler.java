package kw51.impl;

import kw51.lib.data.Tile;
import kw51.lib.interfaces.BoardManager;
import kw51.lib.interfaces.TileManager;

public class EventHandler implements kw51.lib.interfaces.EventHandler {

	private DiceWarsManager manager;
	
	public EventHandler(DiceWarsManager dwm) {
		this.manager = dwm;
	}
	
	@Override
	public void onInit(Tile[][] board) {}

	@Override
	public void onStart(BoardManager boardManager) {
		boardManager.setInfoText("Spieler #1 ist dran.");
		boardManager.setInfoTextColor(manager.playerColors[0]);
		boardManager.setButtonText("Nächster Spieler");
	}

	@Override
	public void onDiceWarBegin(kw51.lib.interfaces.DiceWar diceWar) {}

	@Override
	public void onDiceWarDone(kw51.lib.interfaces.DiceWar diceWar, TileManager tileManager) {
		if(diceWar instanceof DiceWar) {
			DiceWar dw = (DiceWar)diceWar;
			if(dw.getAttackerResult() > dw.getDefenderResult()) {
				dw.attackerTile.setDices(dw.attackerTile.getDices() - dw.defenderTile.getDices());
				manager.getDiceWars().getTileManager().setTile(dw.attackerTile);
				dw.defenderTile.setPlayer(dw.getAttacker());
				manager.getDiceWars().getTileManager().setTile(dw.defenderTile);
			} else {
				dw.attackerTile.setDices(dw.attackerTile.getDices() - dw.defenderTile.getDices());
				manager.getDiceWars().getTileManager().setTile(dw.attackerTile);
			}
		}
		manager.unHighlightAll();
	}

}
