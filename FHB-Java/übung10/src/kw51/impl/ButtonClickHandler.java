package kw51.impl;

import util.logger;

public class ButtonClickHandler implements kw51.lib.interfaces.ButtonClickHandler {

	private DiceWarsManager manager;
	
	public ButtonClickHandler(DiceWarsManager dwm) {
		this.manager = dwm;
	}
	
	@Override
	public void onButtonClick() {
		logger.getInstance().log("Nächster Spieler ist dran!\n");
		manager.nextPlayer();
	}

}
