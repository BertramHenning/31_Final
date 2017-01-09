package controller;

import boundary.GUIController;
import desktop_resources.GUI;
import entity.Ejendom;
import entity.Felt;
import entity.Grund;
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
			//////// LAV NOGET//////////////////
		} else {
			Ejendom felt1 = (Ejendom) felt;
			if (felt1.getEjer() == null && spiller.getKroner() > felt1.getPris()) {
				// Lets the player buy the field if there is no owner and the
				// player has enough coins
				if (GUI.getUserLeftButtonPressed("Vil du købe " + felt1.getNavn() + " for " + felt1.getPris() + " kr.",
						"Ja", "Nej")) {
					felt1.setEjer(spiller);
					spiller.tilføjKroner(-felt1.getPris());
				}
			} else if (felt1.getEjer() == null) {
				GUI.showMessage("Du har ikke nok penge til at købe denne ejendom.");
			} else if (felt1.getEjer().equals(spiller)) {
				GUI.showMessage("Du har landet på din ejen ejedom.");
			} else {
				if (felt.getClass().getSimpleName().equals("Tapperi")) {
					//hej bank, har ejeren 2?
					if(felt1.getEjer().getFængsel()== 1){
						int a = spiller.getSum()*200;
						felt1.getEjer().tilføjKroner(a);
						spiller.tilføjKroner(-a);
					} else {
						int a = spiller.getSum()*100;
						felt1.getEjer().tilføjKroner(a);
						spiller.tilføjKroner(-a);
					}
				} else if (felt.getClass().getSimpleName().equals("Rederi")) {
					//hej bank, hvor mange har ejeren?
					int a = 3;
					felt1.getEjer().tilføjKroner(250 *(int) Math.pow(2, a));
					spiller.tilføjKroner(-a);
				} else {
					Grund felt2 = (Grund) felt1;
					//har han alle?
					//nej
					if(felt2.getEjer().getFængsel()== 1){
						int a = felt2.getLeje(0);
						felt2.getEjer().tilføjKroner(a);
						spiller.tilføjKroner(-a);
					} else {
						int huse = 3; //antal huse!!!
						int a = felt2.getLeje(huse);
						felt2.getEjer().tilføjKroner(a);
						spiller.tilføjKroner(-a);
					}

				}
			}

		}
		return "måske ikke string som return alligevel";
	}

}
