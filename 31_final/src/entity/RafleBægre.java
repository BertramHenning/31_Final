package entity;

public class RafleBægre {
private Terning[] bæger;
	
	/**
	 * Laver en mængde terninger i et array
	 */
	public RafleBægre(int mængde) {
		bæger = new Terning[mængde];
		for (int i = 0; i < bæger.length; i++) {
			bæger[i] = new Terning();
		}
	}

	/**
	 * Ruller alle terninger i arrayet
	 */
	public void rulTerning() {
		for (int i = 0; i < bæger.length; i++) {
			bæger[i].rul();
		}
	}
	
	/**
	 * Getter summen af alle terningerne i arrayet
	 */
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < bæger.length; i++) {
			sum += bæger[i].getVærdi();
		}
		return sum;
	}
	
	/**
	 * Getter værdien af det specifikke terninge slag
	 */
	public int getTerningSlag(int a) {
		return bæger[a].getVærdi();
	}

}
