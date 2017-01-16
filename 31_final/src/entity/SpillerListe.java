package entity;

/**
 * Holder styr på en liste a Spiller objekter
 */
public class SpillerListe {
	private int antalSpillere;

	private Spiller[] liste; 
	public SpillerListe(int antalSpillere, String[] navn) {
		this.antalSpillere = antalSpillere;
		liste = new Spiller[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) { 
			liste[i] = new Spiller(navn[i]); //Opretter spillere med hver deres navn
		}
	}

	/**
	 *Tilføjer kroner til en spiller
	 */
	public void tilføjKroner(int spiller, int beløb) { //metode for at give et beløb til alle spilerne
		liste[spiller].tilføjKroner(beløb); //giver kroner til alle spillere i listen
	}
	
	/**
	 *får antal kroner fra en spiller
	 */
	public int getKroner(int player) {
		return liste[player].getKroner();
	}
	
	/**
	 *Får position fra en spiller
	 */
	public int getPosition(int player) {
		return liste[player].getPosition();
	}

	/**
	 *Flytter en spiller fremad med en mængde
	 */
	public void flytPosition(int player, int mængde){
		liste[player].flytPosition(mængde);
	}
	
	public void setPosition(int player, int amount) {
		liste[player].setPosition(amount);
	}
	
	/**
	 *Fjerner en spiller fra listen og laver listen 1 kortere
	 */
	public void removePlayer(int player){
		Spiller[] newlist = new Spiller[antalSpillere-1];
		int j = 0;
		for (int i = 0; i < antalSpillere; i++){
			if (i != player){
				newlist[j] = liste[i];
				j++;
			}
		}
		liste = newlist;
		antalSpillere--;
	}

	public int getPlayerAmount() {
		return antalSpillere;
	}

	public void setPlayerAmount(int playerAmount) {
		this.antalSpillere = playerAmount;
	}
	
	
	public int getSum(int spiller){
		return liste[spiller].getSum();
	}
	
	/**
	 *Sætter en spillers sum
	 */
	public void setSum(int player, int sum){
		liste[player].setSum(sum);
	}
	
	/**
	 *Får en spillers navn
	 */
	public String getNavn(int spiller){
		return liste[spiller].toString();
	}
	
	public Spiller getSpiller(int spiller){
		return liste[spiller];
	}
	
	public int getFængsel(int spiller){
		return liste[spiller].getFængsel();
	}
	
	public void setFængsel(int spiller, int fængsel){
		liste[spiller].setFængsel(fængsel);
	}
	
	public int getExtraTur(int spiller){
		return liste[spiller].getEkstraTur();
	}
	
	public void setExtraTur(int spiller, int ekstra){
		liste[spiller].setEkstraTur(ekstra);
	}
}
