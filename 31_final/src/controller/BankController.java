package controller;

import boundary.GUIController;
import entity.Felt;
import entity.Grund;
import entity.SpilleBræt;
import entity.Spiller;

public class BankController {

	SpilleBræt bræt;
	GUIController gui;

	public BankController(GUIController gui) {
		this.gui = gui;
		bræt = new SpilleBræt();
	}

	public void købHus(Spiller spiller) {
		//////////
		Grund test1 = (Grund) bræt.getFelt(1);
		Grund test2 = (Grund) bræt.getFelt(3);
		test1.setEjer(spiller);
		test2.setEjer(spiller);
		///////////////
		int[] temp = bræt.kanBebygges(spiller);
		if (temp.length == 0) {
			gui.visBesked("Du ejer ikke nogen grunde der kan bygges på.");
		} else {
			String[] kanBygge = new String[temp.length];
			for (int i = 0; i < temp.length; i++) {
				kanBygge[i] = bræt.getNavn(temp[i]);
			}
			String valg = gui.vælgString("Hvilken grund vil du bygge et hus på?", kanBygge);
			int a = 1;
			for (int i = 0; i < kanBygge.length; i++){
				if(valg.equals(kanBygge[i])){
					a = i;
				}
			}
			bræt.tilføjHus(temp[a]);
			Grund grund1 = (Grund) bræt.getFelt(temp[a]);
			gui.setHusHotel(temp[a]+1, grund1.getHuse());
			spiller.tilføjKroner(-(temp[a]/10+1)*1000);
		}
	}
	
	public Felt getFelt(int position){
		return bræt.getFelt(position);
	}
	
	public boolean[] grupperEjet(Spiller spiller){
		return bræt.grupperEjet(spiller);
	}
	
	public boolean tapperier(Spiller spiller){
		return bræt.tapperier(spiller);
	}
	
	public int rederier(Spiller spiller){
		return bræt.rederier(spiller);
	}

}
