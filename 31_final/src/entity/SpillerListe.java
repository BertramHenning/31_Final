package entity;

/**
 * Keeps track of a list of players
 */
public class SpillerListe {
	private int antalSpillere;

	private Spiller[] liste;

	public SpillerListe(int antalSpillere, String[] navn) {
		this.antalSpillere = antalSpillere;
		liste = new Spiller[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			liste[i] = new Spiller(navn[i]);
		}
	}

	/**
	 *Adds coins to a specific player
	 */
	public void tilføjKroner(int spiller, int beløb) {
		liste[spiller].tilføjKroner(beløb);
	}
	
	/**
	 *Gets coins from a specific player
	 */
	public int getKroner(int player) {
		return liste[player].getKroner();
	}
	
	/**
	 *Gets position from a specific player
	 */
	public int getPosition(int player) {
		return liste[player].getPosition();
	}

	/**
	 *Moves a specific player
	 */
	public void setPosition(int player, int amount) {
		liste[player].setPosition(amount);
	}
	
	/**
	 *Removes a player from the list and makes i shorter
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
	
	/**
	 *Gets diceSum from a specific player
	 */
	public int getSum(int a){
		return liste[a].getSum();
	}
	
	/**
	 *Sets diceSum of a specific player
	 */
	public void setSum(int player, int sum){
		liste[player].setSum(sum);
	}
	
	/**
	 *Gets name from a specific player
	 */
	public String getNavn(int a){
		return liste[a].toString();
	}
	
	public Spiller getSpiller(int a){
		return liste[a];
	}
}
