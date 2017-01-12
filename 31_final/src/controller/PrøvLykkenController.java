package controller;

import boundary.GUIController;

import entity.Spiller;
import lykkekort.LykkeBeskrivelser;

public class PrøvLykkenController {

	GUIController gui;
	LykkeBeskrivelser beskrivelser = new LykkeBeskrivelser();

	int[] dæk = new int[21];

	public PrøvLykkenController(GUIController gui) {
		this.gui = gui;
		for (int i = 0; i < dæk.length; i++) {
			dæk[i] = i;
		}
		blandKort();
	}

	public void blandKort() {
		for (int i = 0; i < dæk.length; i++) {
			float f = (float) Math.random() * dæk.length;
			int a = (int) f;

			int temp = dæk[i];
			dæk[i] = dæk[a];
			dæk[a] = temp;
		}
	}

	public int trækKort() {
		int temp = dæk[0];
		for (int i = 0; i < dæk.length - 1; i++) {
			dæk[i] = dæk[i + 1];
		}
		dæk[dæk.length - 1] = temp;
		return temp;
	}

	public void prøvLykken(Spiller spiller) {
		int kort = trækKort();
		if (kort < 12) {
			spiller.tilføjKroner(beskrivelser.penge[kort]);
		} else if (kort < 21) {
			spiller.tilføjKroner(-beskrivelser.penge[kort]);

		} else {
//			if(kort < 24){
//				spiller.flytPosition(beskrivelser.ryk[-kort]);
//				gui.flytBil(spiller.getNavn(), spiller.getPosition());
//			} else
//				spiller.flytPosition(beskrivelser.ryk[kort]);
//			gui.flytBil(spiller.getNavn(), spiller.getPosition());
//


		}
		
		gui.visPrøvLykkenKort(beskrivelser.Beskrivelse[kort]);
		gui.visBesked("Du trak dette prøv lykken kort:");

	}

}
