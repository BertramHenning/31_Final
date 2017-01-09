package controller;

import boundary.GUIController;
import entity.SpillerListe;


public class SpilController {

	private GUIController gui;
	private SpillerListe liste;


	public SpilController() {
		gui = new GUIController();

	}

	public void startGame() {

		gui.createBoard();

		gui.visBesked("REGLER");
		
		tilføjSpiller();
		//Adds all the players to the gui
		for (int i = 0; i < liste.getPlayerAmount(); i++) {
			System.out.println(i);
			gui.tilføjSpiller(liste.getNavn(i));
		}
		
		

		

	}
	
	/**
	 * Tilføjer spillere til spillerlisten ud fra bruger input
	 */

	public void tilføjSpiller() {
		int antalSpillere = gui.spørgBeløb("Indtast antal spillere: ", 3, 6);
		String[] navne = new String[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			//Tests if the new name is the same as another players name
			while(true){
				boolean sammeNavn = false;
				navne[i] = gui.spørgString("Spiller " + (i + 1) + " indtast dit navn:");
				for (int j = 0; j < i; j++){
					if (navne[i].equals(navne[j])){
						sammeNavn = true;
						gui.visBesked("Du kan ikke have det samme navn.");
					}
				}
				if (sammeNavn == false){
					break;
				}
			}
		}
		liste = new SpillerListe(antalSpillere, navne);
	}
	
	

}
