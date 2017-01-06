package controller;

import entity.Felt;
import entity.SpilleBræt;
import entity.Spiller;

public class LandPåFeltController {
	
	SpilleBræt bræt;
	//Gui
	
	public LandPåFeltController(SpilleBræt bræt){
		this.bræt = bræt;
		//gui
	}
	
	public String landPåFelt(Spiller spiller, Felt felt){
		if(felt.getClass().getSimpleName().equals("Fri")){
			
		}else if(felt.getClass().getSimpleName().equals("Skat")){
			
		}
		return "test";
	}

}
