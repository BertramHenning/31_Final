package entity;

public class Grund extends Ejendom {
	
	private int huse = 0, gruppe;
	private int[] leje;

	public Grund(int pris, int gruppe, int[] leje) {
		super(pris);
		this.gruppe = gruppe;
		this.leje = leje;
	}

	public int getHuse() {
		return huse;
	}

	public void setHuse(int huse) {
		this.huse = huse;
	}

	public int getGruppe() {
		return gruppe;
	}

	public int[] getLeje() {
		return leje;
	}
	
	
}
