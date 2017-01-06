package entity;

public class SpillerListe {
	private int SpillerTal;
	private Spiller[] liste;
	
	public SpillerListe(int SpillerTal, String[] navne){
		this.SpillerTal = SpillerTal;
		liste = new Spiller[SpillerTal];
		for(int i = 0; i <  SpillerTal; i++){
			liste[i] = new Spiller(navne[i]);
		}
	}
	
	public void tilføjKroner(int Spiller, int mængde){
		liste[Spiller].tilføjKroner(mængde);
	}

	public int getKroner(int Spiller){
		return liste[Spiller].fåKroner();
	}
	
	public Spiller[] getListe() {
		return liste;
	}

	public void setListe(Spiller[] liste) {
		this.liste = liste;
	}

	public int getPosition(int Spiller){
		return liste[Spiller].getPosition();
	}
	
	public void flytPosition(int Spiller, int mængde){
		liste[Spiller].flytPosition(mængde);
	}
	
	public int getTerningeSum(int Spiller){
		return liste[Spiller].getSum();
	}

	public void setTerningeSum(){
		
	}

	public int getSpillerTal() {
		return SpillerTal;
	}
	
	public void fjernSpiller(int Spiller){
		Spiller[] nyListe = new Spiller[SpillerTal - 1];
		int j = 0;
		for (int i = 0; i < SpillerTal; i++){
			if (i != Spiller)
				nyListe[j] = liste[i];
			j++;
		}
	}

	public void setSpillerTal(int spillerTal) {
		SpillerTal = spillerTal;
	}

}
