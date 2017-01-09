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
						.setDescription("Ved passering af start modtag 4000 kr.")
						.build();
				}
				else
					fields[i] = new Refuge.Builder()
						.setTitle(FeltBeskrivelser.feltNavne[i])
						.setSubText("Parkering")
						.setBgColor(FeltBeskrivelser.feltFarve[i])
						.setDescription("Hold en pause")
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
}
