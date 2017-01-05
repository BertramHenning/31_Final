package entity;

public class Ejendom extends Felt {

	protected int pris;
	protected Spiller ejer;

	public Ejendom(int pris) {
		this.pris = pris;
		this.ejer = null;

	}
}
