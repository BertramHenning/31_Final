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
			gui.getClass(); // placeholder
		} else if (felt.getClass().getSimpleName().equals("Skat")) {

		} else if (felt.getClass().getSimpleName().equals("Skat")) {

		} else {

		}
		return "test";
	}

}
