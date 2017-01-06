package controller;

import boundary.GUIController;
import entity.Felt;
import entity.Spiller;

public class LandPåFeltController {
	
	private BankController bank;
	private GUIController gui;
	//Gui
	
	public LandPåFeltController(BankController bank, GUIController gui){
		this.bank = bank;
		this.gui = gui;
		//gui
	}
	
	public String landPåFelt(Spiller spiller, Felt felt){
		if(felt.getClass().getSimpleName().equals("Fri")){
			
		}else if(felt.getClass().getSimpleName().equals("Skat")){
			
		}
		return "test";
	}

}
