package controller;

import boundary.GUIController;


public class SpilController {
	
	private GUIController gui;
	
	
	public SpilController() {
		gui = new GUIController();
		
	}

	public void startGame() {
		
		gui.createBoard();

}
}
