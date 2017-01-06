package boundary;

import desktop_fields.Field;

import desktop_fields.Street;
import desktop_resources.GUI;
import desktop_fields.Chance;
import desktop_fields.Tax;
import desktop_fields.Shipping;

import java.awt.Color;

import desktop_fields.Brewery;
import desktop_fields.Jail;
import desktop_fields.Refuge;

public class GUIController {
	
	public void createBoard(){
		Field[] fields = new Field[40];
		
		for (int i = 0; i < 40; i++){
			switch(i){
			case 2:
			case 7:
			case 17:
			case 22:
			case 33:
			case 36:
				fields[i] = new Chance.Builder()
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.setFgColor(Color.getHSBColor((float) 0.305,(float) 1.00,(float) 0.63))
						.build();
				break;
			case 4:
			case 38:
				fields[i] = new Tax.Builder()
						.setTitle("" + FeltBeskrivelser.feltVærdi[i])
						.setDescription("")
						.setSubText("" + FeltBeskrivelser.feltNavne[i])
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.build();
				break;
			case 5:
			case 15:
			case 25:
			case 35:
				fields[i] = new Shipping.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setSubText("" + FeltBeskrivelser.feltVærdi[i])
						.setDescription("Leje af grund: " + FeltBeskrivelser.Leje[i][0] + " kr." + '\n' + "Leje ved 2 rederier: " + FeltBeskrivelser.Leje[i][1] + " kr." + '\n' + "Leje ved 3 rederier: " + FeltBeskrivelser.Leje[i][2] + " kr." + '\n' + "Leje ved 4 rederier: " + FeltBeskrivelser.Leje[i][3] + " kr.")
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.build();
				break;
			case 12:
			case 28:
				fields[i] = new Brewery.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.setSubText("" + FeltBeskrivelser.feltVærdi[i])
						.build();
				break;
			case 10:
			case 30:
				fields[i] = new Jail.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setDescription("I fængsel")
						.setSubText("" + FeltBeskrivelser.feltNavne[i])
						.build();
				break;
			case 0:
			case 20:
				if(i == 0){
					fields[i] = new Refuge.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setSubText("Start")
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.build();
				}
				else
					fields[i] = new Refuge.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setSubText("Parkering")
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.setDescription(" " + FeltBeskrivelser.Leje[i][0])
						.build();
				break;
			default:
				fields[i] = new Street.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.setDescription("Leje af grund: " + FeltBeskrivelser.Leje[i][0] + " Kr." + '\n' + "Leje m/ 1 hus: " + FeltBeskrivelser.Leje[i][1] + " Kr." + '\n' +  "Leje med 2 huse: " + FeltBeskrivelser.Leje[i][2] + " Kr." + '\n' +  "Leje med 3 huse: " + FeltBeskrivelser.Leje[i][3] + " Kr." + '\n' +  "Leje med 4 huse: " + FeltBeskrivelser.Leje[i][4] + " Kr." + '\n' +  "Leje med hotel: " + FeltBeskrivelser.Leje[i][5] + "kr." )
						.setSubText(" " + FeltBeskrivelser.feltVærdi[i])
						.build();	
				break;
				
				
				
				
			}

		}
		
		GUI.create(fields);
		
		GUI.setDice(1, 2);

}
	
	/**
	 * Adds a player to the GUI
	 */
	public void tilføjSpiller(String navn){
		GUI.addPlayer(navn, 30000);
	}
	
	/**
	 * Removes a car from the GUI
	 */
	public void fjernBil(String navn){
		GUI.removeAllCars(navn);
	}
	
	/**
	 * Moves a car on the GUI
	 */
	public void flytBil(String navn, int position){
		GUI.removeAllCars(navn);
		GUI.setCar(position, navn);
	}
	
	/**
	 * Displays the players balance on the GUI
	 */
	public void visPengebeholdning(String navn, int balance){
		GUI.setBalance(navn, balance);
	}
	
	/**
	 * Shows a message on the GUI
	 */
	public void visBesked(String Besked){
		GUI.showMessage(Besked);
	}
	
	/**
	 * Asks the player a yes or no question on the GUI
	 */
	public boolean spørgSandtFalsk(String Besked){
		return GUI.getUserLeftButtonPressed(Besked, "Ja", "Nej");
	}

	/**
	 * Asks the player for an amount on the GUI
	 */
	public int spørgBeløb(String Besked, int min, int max){
		return GUI.getUserInteger(Besked, min, max);
	}

	/**
	 * Asks the player for a string on the GUI
	 */
	public String spørgString(String Besked){
		return GUI.getUserString(Besked);
	}

}
