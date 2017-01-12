package entity;

public class Konto {

	private int Kroner;
	
	public Konto(){
		Kroner = 30000;
	}

	public int getKroner(){
		return Kroner;
	}
	
	public void tilføjKroner(int Kroner){
		this.Kroner += Kroner; //lægger et bestemt beløb oven i spillerens nuværende saldo.
		if(this.Kroner < 0) //if-sætning, som tjekker om spillerens konto er positiv eller 0.
			this.Kroner = 0; //Sætter den til at være 0, da alt under resulterer i bankerot.
	}

}
