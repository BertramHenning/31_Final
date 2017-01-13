package entity;

public class Spiller {
	
	private String navn;
	private int position = 0, ekstraTur = 0, fængsel, sum;
	
	private Konto kroner;
	
	public Spiller(String a){
		navn = a;
		kroner = new Konto();
	}
		
	public void flytPosition(int mængde){ //Metode til at flytte spilleren frem på brættet
		this.position += mængde; //Finder position baseret på nuværende position og summen af terningeslagene (mængde).
		if(this.position > 39){ //Regel for når man er passeret felt nr. 40 i spillet
			this.position = this.position - 40; //Gør at man er tilbage på felt 1
			tilføjKroner(4000); //4000 kr for at passere startfeltet.
		}
	}
	
	
	public void tilføjKroner(int a){ //funktion for at tilføje kroner til spilleren.
		kroner.tilføjKroner(a); //tilføjer spilleren en mængde kroner.
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
		return kroner.getKroner();
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
	
	
	
	


