package entity;

public class Spiller {
	
	private String navn;
	private int position = 0, ekstraTur = 0, fængsel, sum;
	
	private Konto konto;
	
	public Spiller(String a){
		navn = a;
		konto = new Konto();
	}
	
	/**
	 * Flytter spilleren fremad
	 */
	public void flytPosition(int mængde){ 
		this.position += mængde; 
		if(this.position > 39){ 
			this.position = this.position - 40; //Gør at man starter forfra på spillebrættet når man rykker over felt 39
			tilføjKroner(4000); //4000 kr for at passere startfeltet.
		}
	}
	
	/**
	 * Tilføjer kroner til spilleren
	 */
	public void tilføjKroner(int a){ 
		konto.tilføjKroner(a); 
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getEkstraTur() {
		return ekstraTur;
	}

	public void setEkstraTur(int ekstraTur) {
		this.ekstraTur = ekstraTur;
	}

	public int getFængsel() {
		return fængsel;
	}

	public void setFængsel(int fængsel) {
		this.fængsel = fængsel;
	}

	public int getKroner() {
		return konto.getKroner();
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public String toString() {
		return navn;
	}

	}
	
	
	
	


