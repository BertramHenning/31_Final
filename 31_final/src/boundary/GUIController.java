package boundary;

import desktop_fields.Field;

import desktop_fields.Street;
import desktop_fields.Chance;
import desktop_resources.GUI;

public class GUIController {
	
	public void createBoard(){
		Field[] fields = new Field[40];
		for (int i = 0; i < 40; i++){
			switch(i){
			case 3:
			case 8:
			case 18:
			case 23:
			case 34:
			case 37:
				
				fields[i] = new Chance.Builder()
						.build();
				break;
			case 5:
			case 15:
				fields[i] = new Chance.Builder()
						.build();
				break;
			case 33:
			case 39:
				fields[i] = new Chance.Builder()
						.build();
				break;
			case 10:
			case 20:
				fields[i] = new Chance.Builder()
						.build();
				break;
			default:
				fields[i] = new Chance.Builder()
						.build();
				break;
				
			}
		}
		
		
//		for (int i = 0; i < 40; i++){
//				fields[i] = new Street.Builder().setTitle(FeltBeskrivelser.fieldNames[i])
//						.setDescription("Leje af grund: " + FeltBeskrivelser.Leje[i][0] + " Kr.")
//						.setSubText("" + FeltBeskrivelser.fieldValue[i])
//						.build();
//		}
		
		GUI.create(fields);
		
		GUI.setDice(1, 2);

}
}
