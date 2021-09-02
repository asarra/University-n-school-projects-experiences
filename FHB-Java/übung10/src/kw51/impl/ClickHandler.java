package kw51.impl;

import java.awt.Polygon;
import java.util.ArrayList;

import kw51.lib.data.Coordinate;
import kw51.lib.data.Tile;

public class ClickHandler implements kw51.lib.interfaces.ClickHandler{

	private final DiceWarsManager manager;
	
	public ClickHandler(DiceWarsManager dws) {
		this.manager = dws;
	}
	
	private Tile selectedTile;
	
	@Override
	public void onClick(int x, int y) {
		for(int tX = 0; tX < manager.getDiceWars().getBoardManager().getBoardDimensions(); tX ++) {
			for(int tY = 0; tY < manager.getDiceWars().getBoardManager().getBoardDimensions(); tY ++) {
				boolean inField = isCursorInFieldV2(x, y, manager.getDiceWars().getTileManager().getTilePosition(tX, tY));
				if(inField) {
					Tile tile = manager.getTileAt(tX, tY);
					System.out.println("Player: " + tile.getPlayer());
					
					if(selectedTile == null || tile.getPlayer() == manager.getCurrentPlayer()) {
						manager.unHighlightAll();
						if(tile.getPlayer() == manager.getCurrentPlayer()) {
							selectedTile = tile;
							manager.getDiceWars().getTileManager().highlightTile(tile);
							getNeighbours(tile).forEach(t -> {
								if(t.getPlayer() != manager.getCurrentPlayer() && t.getPlayer() != -1 && t.getDices() < selectedTile.getDices()) {
									manager.getDiceWars().getTileManager().highlightTile(t);
								}
							});
						}
					} else {
						if(getNeighbours(selectedTile).contains(tile) && tile.getDices() < selectedTile.getDices()) {
							DiceWar dw = new DiceWar(selectedTile.getPlayer(), tile.getPlayer(), selectedTile, tile);
							manager.getDiceWars().getBoardManager().initializeDiceWar(dw);
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	private boolean isCursorInField(int mouseX, int mouseY, Coordinate[] coords) {
		double calc = 0;
		for(int i = 0; i < coords.length; i ++) {
			Coordinate c1 = coords[i];
			Coordinate c2 = coords[i+1 >= coords.length ? 0 : i + 1];
			Vektor2D v1 = new Vektor2D(mouseX - c1.getX(), mouseY - c1.getY());
			Vektor2D v2 = new Vektor2D(mouseX - c2.getX(), mouseY - c2.getY());
			double angle = Math.acos( (v1.getX()*v2.getX() + v1.getY() * v2.getY()) / (Math.sqrt(v1.getX() * v1.getX() + v1.getY() * v1.getY()) * Math.sqrt(v2.getX() * v2.getX() + v2.getY() * v2.getY())) );
			calc += angle;
		}
		calc = Math.round(Math.toDegrees(calc));
		if(calc >= 359 && calc <= 361) return true;
		else return false;
	}
	
	private boolean isCursorInFieldV2(int mouseX, int mouseY, Coordinate[] coords) {
		Polygon p = new Polygon();
		for(int i = 0; i < coords.length; i ++) {
			p.addPoint((int)coords[i].getX(), (int)coords[i].getY());
		}
		return p.contains(mouseX, mouseY);
	}
	
	public void reset() {
		this.selectedTile = null;
	}
	
	private ArrayList<Tile> getNeighbours(Tile t) {
		ArrayList<Tile> ret = new ArrayList<Tile>();
		int x = t.getFieldPosition().getX();
		int y = t.getFieldPosition().getY();
		
		Tile t1 = manager.getTileAt(x+1, y);
		Tile t2 = manager.getTileAt(x-1, y);
		Tile t3 = manager.getTileAt(x, y+1);
		Tile t4 = manager.getTileAt(x, y-1);
		Tile t5 = manager.getTileAt(x-1, y-1);
		Tile t6 = manager.getTileAt(x+1, y+1);
		
		if(t1 != null) ret.add(t1);
		if(t2 != null) ret.add(t2);
		if(t3 != null) ret.add(t3);
		if(t4 != null) ret.add(t4);
		if(t5 != null) ret.add(t5);
		if(t6 != null) ret.add(t6);
		
		return ret;
	}
	
	private class Vektor2D {
		
		private double x,y;
		
		public Vektor2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getX() {
			return this.x;
		}
		
		public double getY() {
			return this.y;
		}
	}
	
	
	
}
