package entity;

public class RafleSnyd {

	private Terning[] bæger;
	private int[] terning1 = {1,4,3,3,1,6,6,6,5,6,4,1,1,1,4,2,1,6,2,3,3,2,1,5,2,3};
	private int[] terning2 = {1,2,5,6,2,6,6,4,6,6,5,1,1,1,6,2,4,1,1,2,2,1,6,1,1,4};
	private int a = 0;

	/**
	 * Laver forudbestemte slag for at vise spillet
	 */
	public RafleSnyd(int mængde) {

	}

	public void rulTerning() {
		a++;
		if(a >= terning1.length){
			a = 0;
		}
	}

	public int getSum() {
		return terning1[a] + terning2[a];
	}

	public int getTerningSlag(int b) {
		if (b == 0) {
			return terning1[a];
		} else {
			return terning2[a];
		}
	}

}
