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
		int d3 = (int) d2; 
		værdi = d3 + 1; 
	}

	public int getVærdi() {
		return værdi;
	}

	public void setVærdi(int værdi) {
		this.værdi = værdi;
	}

}
