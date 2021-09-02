package kw51.impl;

import java.util.Arrays;
import java.util.Random;

import kw51.lib.data.Tile;

public class DiceWar extends kw51.lib.interfaces.DiceWar {

	protected Tile attackerTile, defenderTile;
	private int[] lastDefenderSequenz, lastAttackerSequenz;	
	
	public DiceWar(int attacker, int defender, Tile attackerTile, Tile defenderTile) {
		super(attacker, defender);
		this.attackerTile = attackerTile;
		this.defenderTile = defenderTile;
	}

	@Override
	public int getAttackerDicesCount() {
		return attackerTile.getDices();
	}

	@Override
	public int getDefenderDicesCount() {
		return defenderTile.getDices();
	}

	@Override
	public int[] nextAttackerSequence() {
		Random rnd = new Random();
		int[] ret = new int[getAttackerDicesCount()];
		for(int i = 0; i < ret.length; i ++) {
			ret[i] = rnd.nextInt(6)+1;
		}
		lastAttackerSequenz = ret;
		return ret;
	}

	@Override
	public int[] nextDefenderSequence() {
		Random rnd = new Random();
		int[] ret = new int[getDefenderDicesCount()];
		for(int i = 0; i < ret.length; i ++) {
			ret[i] = rnd.nextInt(6)+1;
		}
		lastDefenderSequenz = ret;
		return ret;
	}

	@Override
	public int getAmountOfSequences() {
		return new Random().nextInt(10)+5;
	}

	@Override
	public int getAttackerResult() {
		if(lastAttackerSequenz != null)
			return Arrays.stream(lastAttackerSequenz).sum();
		return 0;
	}

	@Override
	public int getDefenderResult() {
		if(lastDefenderSequenz != null)
			return Arrays.stream(lastDefenderSequenz).sum();
		return 0;
	}
}
