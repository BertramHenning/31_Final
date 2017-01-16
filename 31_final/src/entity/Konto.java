package entity;

public class Konto {

	private int Kroner;
	
	public Konto(){
		Kroner = 30000;
	}

	public int getKroner(){
		return Kroner;
	}
	
	/**
	 * lægger kroner til men sikrer at den ikke går under nul
	 */
	public void tilføjKroner(int Kroner){
		this.Kroner += Kroner; 
		if(this.Kroner < 0) 
			this.Kroner = 0; 
	}

}
