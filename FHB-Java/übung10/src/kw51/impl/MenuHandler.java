package kw51.impl;

import util.FileFormatException;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuHandler implements kw51.lib.interfaces.MenuHandler {

	private final DiceWarsManager manager;

	public MenuHandler(DiceWarsManager dws) {
		this.manager = dws;
	}

	@Override
	public void onMenuItemLoadGame(Component parent) {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Spielstand öffnen...");
		fc.setFileFilter(new FileNameExtensionFilter("DiceWars Spielstanddatei (.dwss)", "dwss"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fc.showOpenDialog(parent);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				manager.loadFileAndGenerate(file);
			}
			catch (IOException|FileFormatException e){
				System.out.println("Fehler:");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onMenuItemSaveGame(Component parent) {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Spielstand speichern...");
		fc.setFileFilter(new FileNameExtensionFilter("DiceWars Spielstanddatei (.dwss)", "dwss"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fc.showSaveDialog(parent);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!file.getName().toLowerCase().endsWith(".dwss")) {
				file = new File(file.getParentFile().getPath() + File.separator + file.getName() + ".dwss");
			}
			try {
				manager.saveToFile(file);
			}
			catch (IOException e){
				System.out.println("Fehler:\t"+e);
			}
		}
	}

	@Override
	public void onMenuItemNewGame(Component parent) {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Neuen Spielstand anlegen...");
		fc.setFileFilter(new FileNameExtensionFilter("DiceWars Spielstanddatei (.dwss)", "dwss"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fc.showSaveDialog(parent);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!file.getName().toLowerCase().endsWith(".dwss")) {
				file = new File(file.getParentFile().getPath() + File.separator + file.getName() + ".dwss");
			}
			manager.generateFieldAndSaveFile(file);
		} else {
			return;
		}
	}

}
