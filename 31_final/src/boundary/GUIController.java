package boundary;

import desktop_fields.Field;

import desktop_fields.Street;
import desktop_resources.GUI;

public class GUIController {
	
	public void createBoard(){
		Field[] fields = new Field[40];
		
		for (int i = 0; i < 40; i++){
				fields[i] = new Street.Builder().setTitle(FeltBeskrivelser.fieldNames[i])
						.setDescription("Leje af grund: " + FeltBeskrivelser.Leje[i][0] + " Kr.")
						.setSubText("" + FeltBeskrivelser.fieldValue[i])
						.build();
		}
		
		GUI.create(fields);
		
		GUI.setDice(1, 2);

}
}
