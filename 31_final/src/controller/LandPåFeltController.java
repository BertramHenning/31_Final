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

	public String landPåFelt(Spiller spiller) {
		int position = spiller.getPosition();
		Felt felt = bank.getFelt(position);
		if (felt.getClass().getSimpleName().equals("Fri")) {
			switch (spiller.getPosition()) {
			case 0:
				gui.visBesked("Du landede på Start og modtager 4000 kr!");
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
				String[] valg = {"4000 kr.", tiProcent + " kr."};
				if (gui.vælgString("Hvad vil du helst betale?", valg).equals("4000 kr.")) {
					spiller.tilføjKroner(-4000);
				} else {
					spiller.tilføjKroner(-tiProcent);
				}
			} else {
				gui.visBesked("Du skal betale 2000 kr. i skat");
				spiller.tilføjKroner(-2000);
			}

		} else if (felt.getClass().getSimpleName().equals("PrøvLykken")) {
			gui.visBesked("Du er landet på et prøv lykken felt, prøv igen imorgen");
		} else {
			Ejendom felt1 = (Ejendom) felt;
			if (felt1.getEjer() == null && spiller.getKroner() > felt1.getPris()) {
				// Lets the player buy the field if there is no owner and the
				// player has enough coins
				if (gui.spørgSandtFalsk("Vil du købe " + felt1.getNavn() + " for " + felt1.getPris() + " kr.")) {
					felt1.setEjer(spiller);
					spiller.tilføjKroner(-felt1.getPris());
					gui.setEjer(position, spiller.getNavn());
				}
			} else if (felt1.getEjer() == null) {
				gui.visBesked("Du har ikke nok penge til at købe denne ejendom.");
			} else if (felt1.getEjer().equals(spiller)) {
				gui.visBesked("Du har landet på din ejen ejendom.");
			} else {
				if (felt.getClass().getSimpleName().equals("Tapperi")) {
					int a = 0;
					if(bank.tapperier(spiller)){
						a = spiller.getSum()*200;
					} else {
						a = spiller.getSum()*100;
					}
					felt1.getEjer().tilføjKroner(a);
					spiller.tilføjKroner(-a);
				} else if (felt.getClass().getSimpleName().equals("Rederi")) {
					int rederier = bank.rederier(felt1.getEjer());
					int a = 250 *(int) Math.pow(2, rederier);
					felt1.getEjer().tilføjKroner(a);
					spiller.tilføjKroner(-a);
				} else {
					Grund felt2 = (Grund) felt1;
					if(bank.grupperEjet(spiller)[position/5] && felt2.getHuse() == 0){
						int a = felt2.getLeje()*2;
						felt2.getEjer().tilføjKroner(a);
						spiller.tilføjKroner(-a);
					} else {
						int a = felt2.getLeje();
						felt2.getEjer().tilføjKroner(a);
						spiller.tilføjKroner(-a);
					}

				}
			}

		}
		return "måske ikke string som return alligevel";
	}

}
