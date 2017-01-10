package controller;

import boundary.GUIController;
import desktop_codebehind.Car;
import entity.RafleBægre;
import entity.SpillerListe;
import entity.Terning;


public class SpilController {

	private GUIController gui;
	private SpillerListe liste;
	private BankController bank;
	private LandPåFeltController landPåFelt;
	private RafleBægre rafle;


	public SpilController() {
		gui = new GUIController();
		bank = new BankController(gui);
		landPåFelt = new LandPåFeltController(bank, gui);
		rafle = new RafleBægre(2);

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
		
		int tur = 0;
		//Hver tur
		while(true){
			if(liste.getPlayerAmount() == 1){
				gui.visBesked("Du vandt!");
				break;
			}
			
			if (liste.getFængsel(tur) > 0){
				//hvad der sker i fængsel
			} else {
				gui.visBesked("Det er din tur " + liste.getNavn(tur)+", tryk ok for at rulle terningerne.");
				
				rafle.rulTerning();
				gui.setTerning(rafle.getTerningSlag(0), rafle.getTerningSlag(1));
				liste.setSum(tur, rafle.getSum());
				
				liste.flytPosition(tur, rafle.getSum());
				gui.flytBil(liste.getNavn(tur), liste.getPosition(tur));
				
				landPåFelt.landPåFelt(liste.getSpiller(tur));
				
				
				
			
			}
			
			for (int i = 0; i < liste.getPlayerAmount(); i++){
				gui.visPengebeholdning(liste.getNavn(i), liste.getKroner(i));
			}
			
			while(gui.spørgSandtFalsk("Vil du købe et hus?")){
				bank.købHus(liste.getSpiller(tur));
			}
			
			if(liste.getKroner(tur) <= 0){
				gui.fjernBil(liste.getNavn(tur));
				gui.visBesked("du tabte");
				liste.removePlayer(tur);
			}
			
			tur++;
			if (tur >= liste.getPlayerAmount()) {
				tur = 0;
			}
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
