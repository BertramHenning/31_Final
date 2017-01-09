package entity;

public abstract class Felt {
	
	protected String navn;
	
	public Felt(String navn){
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

}
