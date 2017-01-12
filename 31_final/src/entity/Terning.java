package entity;

public class Terning {

	private int værdi;

	public Terning() {
		værdi = 6;
	}

	/**
	 * Tilfældig værdi mellem 1-6
	 */
	public void rul() {
		float d1 = (float) Math.random();
		float d2 = d1 * 6;
		int d3 = (int) d2; //Laver værdien til en int
		værdi = d3 + 1; //lægger en til, da den laveste værdi er 0. 
	}

	public int getVærdi() {
		return værdi;
	}

	public void setVærdi(int værdi) {
		this.værdi = værdi;
	}

}
