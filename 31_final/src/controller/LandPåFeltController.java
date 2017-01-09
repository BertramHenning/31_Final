package controller;

import boundary.GUIController;
import entity.Felt;
import entity.Spiller;

public class LandPåFeltController {

	private BankController bank;
	private GUIController gui;

	public LandPåFeltController(BankController bank, GUIController gui) {
		this.bank = bank;
		this.gui = gui;
	}

	public String landPåFelt(Spiller spiller, Felt felt) {
		if (felt.getClass().getSimpleName().equals("Fri")) {
			switch(spiller.getPosition()){
			case 0:
				gui.visBesked("Du landede på Start!");
				break;
			case 10:
				gui.visBesked("Du er på besøg i fængslet.");
				break;
			case 20:
				gui.visBesked("Gratis Parkering.");
				break;
			case 30:
				gui.visBesked("Du har lavet ballade, puhaaaaa, i fængsel med dig!!!");
				spiller.setPosition(10);
				gui.flytBil(spiller.getNavn(), spiller.getPosition());
				spiller.setFængsel(1);
				break;
			}
		} else if (felt.getClass().getSimpleName().equals("Skat")) {
			if(spiller.getPosition()==4){
				int tiProcent;
				tiProcent = spiller.getKroner()/10;
				gui.
			} else {
				
			}

		} else if (felt.getClass().getSimpleName().equals("PrøvLykken")) {

		} else {

		}
		return "test";
	}

}
