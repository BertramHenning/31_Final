package controller;

import boundary.GUIController;
import entity.PlayerList;


public class SpilController {

	private GUIController gui;


	public SpilController() {
		gui = new GUIController();

	}

	public void startGame() {

		gui.createBoard();

		gui.visBesked("REGLER");

		

	}
	
	/**
	 * Tilføjer spillere til spillerlisten ud fra bruger input
	 */

	public void addPlayers() {
		int antalSpillere = gui.spørgBeløb("Indtast antal spillere: ", 3, 6);
		String[] navne = new String[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			//Tests if the new name is the same as another players name
			while(true){
				boolean sammeName = false;
				navne[i] = gui.spørgString("Player " + (i + 1) + " enter your name:");
				for (int j = 0; j < i; j++){
					if (navne[i].equals(navne[j])){
						sammeName = true;
						gui.visBesked("You cant have the same name as another player");
					}
				}
				if (sammeName == false){
					break;
				}
			}
		}
		liste = new SpillerListe(antalSpillere, navne);
	}

}
