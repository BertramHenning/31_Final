package entity;

/**
 * 
 * @author Thomas
 * Felt er en abstract superklasse som de andre typer af felter nedarver String navn fra. 
 *
 */
public abstract class Felt {

	protected String navn;
	
	public Felt(String navn){
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

}
