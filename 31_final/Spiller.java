package entity;

public class Spiller {
	
	private String navn;
	private int position = 0, ekstraTur, fængsel;
	
	private Konto kroner;
	
	public Spiller(String a){
		navn = a;
		kroner = new Konto();
	}
		
	public void flytPosition(int mængde){
		this.position += mængde;
		if(this.position > 40)
			this.position = this.position - 40;
	}
	
	
	public void tilføjKroner(int a){
		kroner.tilføjKroner(a);
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
	

	}
	
	
	
	


