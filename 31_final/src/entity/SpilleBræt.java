package entity;

import boundary.FeltBeskrivelser;

public class SpilleBræt {

	private Felt[] felter = new Felt[40]; //opretter et array med 40 feltpladser, som udgør spillebrættet.

	public SpilleBræt() {
		for (int i = 0; i < 40; i++) { //for-løkke, som kører betingelser igennem for de forskellige felter.
			switch (i) { //Kategoriserer de forskellige typer af felter i spillet efter hvor på brættet de er.
			case 2:
			case 7:
			case 17:
			case 22:
			case 33:
			case 36:
				felter[i] = new PrøvLykken(FeltBeskrivelser.feltNavne[i]); //Sætter Ovenstående felter som prøv-lykken kort.
				break; //afsluttter den her, så løkken ikke kører konstant.
			case 4:
			case 38:
				felter[i] = new Skat(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]); //sætter som skatte-felter.
				break;
			case 5:
			case 15:
			case 25:
			case 35:
				felter[i] = new Rederi(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]); //Viser 
				break;
			case 12:
			case 28:
				felter[i] = new Tapperi(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]);
				break;
			case 10:
			case 30:
			case 0:
			case 20:
				felter[i] = new Fri(FeltBeskrivelser.feltNavne[i]); //felter hvor der ikke sker noget.
				break;
			default: //default er det felt, som man typisk vil lande på, og som ik er nogen af de ovenstående.
				felter[i] = new Grund(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i], i / 5,
						FeltBeskrivelser.Leje[i]); //Tildeler feltnavne, beskrivelser, værdi i kr, lejeværdi og hvad gruppe de er i
				break;

			}
		}
	}

	public Felt getFelt(int position) {
		return felter[position];
	}

	public String getNavn(int a) {
		return felter[a].getNavn();
	}
/**
 * 
 * @param felt
 * Tilføjer et hus til et bestemt felt
 */
	public void tilføjHus(int felt) { 
		Grund a = (Grund) felter[felt]; //Sætter en grund til et felt
		a.setHuse(a.getHuse() + 1); //sætter værdien til at tælle fra 1
	}
  
  	public Spiller getEjer(int felt) {
		Ejendom a = (Ejendom) felter[felt];
		return a.getEjer();
	}
	
	public void setEjer(int felt, Spiller spiller) {
		Ejendom a = (Ejendom) felter[felt];
		a.setEjer(spiller);
	}
  

/**
 * 
 * @param spiller
 * @return
 * Funktion til at tjekke om der er en ejer til tapperierne, og om ejeren er den aktuelle spiller
 */
	public boolean tapperier(Spiller spiller) {
		boolean out = true;
		Ejendom temp = (Ejendom) felter[12]; //tapperiet på felt 12
		if (temp.getEjer()!= null && !temp.getEjer().equals(spiller)) { //Tjekker om der er en ejer, og om den eventuelle ejer er den aktuelle spiller
			out = false;
		}
		temp = (Ejendom) felter[28]; //samme procedure, bare for felt 28
		if (temp.getEjer()!= null && !temp.getEjer().equals(spiller)) {

			out = false;
		}
		return out;
	}

	public int rederier(Spiller spiller) {
		int out = 0;
		for (int i = 0; i < 40; i++) {
			if (felter[i].getClass().getSimpleName().equals("Rederi")) {
				Ejendom temp = (Ejendom) felter[i];
				if (temp.getEjer() != null && temp.getEjer().equals(spiller)) {
					out++;
				}
			}
		}
		return out;
	}
/**
 * 
 * @param spiller
 * @return
 * Metode til at tjekke hvor mange grupper hver spiller har
 */
	public boolean[] grupperEjet(Spiller spiller) {
		int[] grupper = { 0, 0, 0, 0, 0, 0, 0, 0 }; //array som viser hvilke spillere der ejer de forskellige grupper.
		boolean[] out = new boolean[8]; //array med hvor mange der grupper der er.
		for (int i = 0; i < 40; i++) { //kører de 40 felter igennem
			if (felter[i].getClass().getSimpleName().equals("Grund")) { //tjekker om feltet er en grund
				Grund temp = (Grund) felter[i]; //fastsætter feltnummeret til aktuelle grund
				if (temp.getEjer() != null && temp.getEjer().equals(spiller)) {
					grupper[i / 5]++; //Tilføjer endnu en grund til spilleren under dens specifikke gruppe af grunde.
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			if (i == 0 || i == 7) {
				if (grupper[i] == 2) {
					out[i] = true;
				} else {
					out[i] = false;
				}
			} else {
				if (grupper[i] == 3) {
					out[i] = true;
				} else {
					out[i] = false;
				}
			}
		}
		return out;
	}

	public int[] kanBebygges(Spiller spiller) {
		int[] temp = new int[22]; //23 felter som kan bebygges
		int a = 0;
		for (int i = 0; i < 40; i++) {
			if (felter[i].getClass().getSimpleName().equals("Grund")) { //tjekker om feltet er en grund
				if (spiller.getKroner() > (i / 10 + 1) * 1000) { //tjekker om spilleren har penge nok
					if (grupperEjet(spiller)[i / 5]) { //tjekker hvilken af de otte grupper af grunde den aktuelle grund tilhører
						Grund temp1 = (Grund) felter[i];
						boolean b = true;
						for (int j = (i / 5) * 5; j < (i / 5) * 5 + 5; j++) {
							if (felter[j].getClass().getSimpleName().equals("Grund")) {
								Grund temp2 = (Grund) felter[j];
								if (temp1.getHuse() > temp2.getHuse() || temp1.getHuse() > 4) {
									b = false;
								}
							}
						}
						if (b) {
							temp[a] = i;
							a++;
						}
					}
				}
			}
		}
		int[] out = new int[a];
		for (int i = 0; i < a; i++) {
			out[i] = temp[i];
		}
		return out;
	}

	public int[] andresEjendomme(Spiller spiller) {
		int[] temp = new int[22];
		int a = 0;
		for (int i = 0; i < 40; i++) {
			String type = felter[i].getClass().getSimpleName();
			if (type.equals("Grund") || type.equals("Rederi") || type.equals("Tapperi")) {
				Ejendom temp1 = (Ejendom) felter[i];
				if(temp1.getEjer() != null && !temp1.getEjer().equals(spiller)){
					temp[a] = i;
					a++;
				}

			}
		}
		int[] out = new int[a];
		for (int i = 0; i < a; i++) {
			out[i] = temp[i];
		}
		return out;
	}

}
