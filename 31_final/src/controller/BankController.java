package controller;

import boundary.GUIController;
import entity.Felt;
import entity.Grund;
import entity.SpilleBræt;
import entity.Spiller;

public class BankController {

	private SpilleBræt bræt;
	private GUIController gui;

	public BankController(GUIController gui) {
		this.gui = gui;
		bræt = new SpilleBræt();
	}
	/**
	 * Tillader en spiller, at købe huse på sin grund såfremt spilleren ejer grunden
	 * @param spiller
	 */
	public void købHus(Spiller spiller) {
//		//////////
//		Grund test1 = (Grund) bræt.getFelt(1);
//		Grund test2 = (Grund) bræt.getFelt(3);
//		test1.setEjer(spiller);
//		test2.setEjer(spiller);
//		///////////////
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
	
	public void købEjendom(Spiller spiller){
		int[] andresEjendomme = bræt.andresEjendomme(spiller);
		if (andresEjendomme.length == 0) {
			gui.visBesked("Der er ikke nogle ejendomme du kan købe.");
		} else {
		String[] kanKøbe = new String[andresEjendomme.length];
		for (int i = 0; i < andresEjendomme.length; i++) {
			kanKøbe[i] = bræt.getNavn(andresEjendomme[i]);
		}
		String valg = gui.vælgString("Hvilken ejendom vil du prøve at købe?", kanKøbe);
		int a = 1;
		for (int i = 0; i < kanKøbe.length; i++){
			if(valg.equals(kanKøbe[i])){
				a = i;
			}
		}
		int pris = gui.spørgBeløb(bræt.getEjer(andresEjendomme[a])+ ", hvor meget skal du have for " + valg + "?", 0, 100000);
		
		if (spiller.getKroner() < pris){
			gui.visBesked("Det har " + spiller + " ikke råd til at betale.");
		} else {
			if (gui.spørgSandtFalsk(spiller + ", vil du betale " + pris + " for " + valg + "?")){
				bræt.getEjer(andresEjendomme[a]).tilføjKroner(pris);
				spiller.tilføjKroner(-pris);
				bræt.setEjer(andresEjendomme[a], spiller);
				gui.setEjer(andresEjendomme[a], spiller.getNavn());
				
			}
		}
		}
	}
	
	/**
	 * Undersøger, om spilleren er berettiget til at købe hus på sin grund
	 * @param spiller
	 * @return
	 */
	public boolean kanKøbeHus(Spiller spiller){
		boolean out = false;
		boolean[] kanKøbe = bræt.grupperEjet(spiller);
		for (int i = 0; i < kanKøbe.length; i++) {
			if(kanKøbe[i]){
				out = true;
			}
		}
		return out;
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
