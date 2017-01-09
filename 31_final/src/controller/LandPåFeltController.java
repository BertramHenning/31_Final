package controller;

import boundary.GUIController;
import desktop_resources.GUI;
import entity.Ejendom;
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
			switch (spiller.getPosition()) {
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
			if (spiller.getPosition() == 4) {
				int tiProcent;
				tiProcent = spiller.getKroner() / 10;
				if (gui.vælgString("Hvad vil du helst betale?", "4000 kr.", tiProcent + " kr.").equals("4000 kr.")) {
					spiller.tilføjKroner(-4000);
				} else {
					spiller.tilføjKroner(-tiProcent);
				}
			} else {
				gui.visBesked("Du skal betale 2000 kr. i skat");
				spiller.tilføjKroner(-2000);
			}

		} else if (felt.getClass().getSimpleName().equals("PrøvLykken")) {

		} else {
			Ejendom a = (Ejendom) felt;
			if (a.getEjer() == null && spiller.getKroner() > a.getPris()) {
				// Lets the player buy the field if there is no owner and the
				// player has enough coins
				if (GUI.getUserLeftButtonPressed("Vil du købe " + a.getNavn() + " for " + a.getPris() + " kr.", "Ja", "Nej")) {
					a.setEjer(spiller);
					spiller.tilføjKroner(-a.getPris());
				}
			} else if (a.getEjer() == null) {
				GUI.showMessage("Du har ikke nok penge til at købe denne ejendom.");
			} else if (a.getEjer().equals(spiller)) {
				GUI.showMessage("Du har landet på din ejen ejedom.");
			} else {
				if ()

			}

		}
		return "måske ikke string som return alligevel";
	}

}
