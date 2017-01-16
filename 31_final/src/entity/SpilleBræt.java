package entity;

public class SpilleBræt {

	private Felt[] felter = new Felt[40]; 

	public SpilleBræt() {
		for (int i = 0; i < 40; i++) { 
			switch (i) { //Kategoriserer de forskellige typer af felter i spillet efter hvor på brættet de er.
			case 2:
			case 7:
			case 17:
			case 22:
			case 33:
			case 36:
				felter[i] = new PrøvLykken(FeltBeskrivelser.feltNavne[i]); //Sætter ovenstående felter som prøv-lykken felter.
				break; 
			case 4:
			case 38:
				felter[i] = new Skat(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]); //Sætter ovenstående felter som skatte felter.
				break;
			case 5:
			case 15:
			case 25:
			case 35:
				felter[i] = new Rederi(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]); //Sætter ovenstående felter som rederi felter.
				break;
			case 12:
			case 28:
				felter[i] = new Tapperi(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]);//Sætter Ovenstående felter som tapperi felter.
				break;
			case 10:
			case 30:
			case 0:
			case 20:
				felter[i] = new Fri(FeltBeskrivelser.feltNavne[i]); //Sætter ovenstående felter som fri felter.
				break;
			default: //Sætter resten som grund felter.
				felter[i] = new Grund(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i], i / 5,
						FeltBeskrivelser.Leje[i]); 
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
	
	public void ændreHus(int felt, int b) { 
		Grund a = (Grund) felter[felt]; 
		a.setHuse(a.getHuse() + b); 
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
	 * Funktion der returnerer true hvis spilleren ejer begge tapperier
	 */
	public boolean tapperier(Spiller spiller) {
		boolean out = true;
		Ejendom temp = (Ejendom) felter[12]; 
		if (temp.getEjer()!= null && !temp.getEjer().equals(spiller)) { 
			out = false;
		}
		temp = (Ejendom) felter[28]; 
		if (temp.getEjer()!= null && !temp.getEjer().equals(spiller)) {

			out = false;
		}
		return out;
	}
	
	/**
	 * Funktion der returnerer hvor mange rederier spilleren ejer
	 */
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
 * Returnerer et boolean array der hviser hvilke grupper spilleren ejer
 */
	public boolean[] grupperEjet(Spiller spiller) {
		int[] grupper = { 0, 0, 0, 0, 0, 0, 0, 0 }; 
		boolean[] out = new boolean[8]; 
		for (int i = 0; i < 40; i++) { 
			if (felter[i].getClass().getSimpleName().equals("Grund")) { 
				Grund temp = (Grund) felter[i]; 
				if (temp.getEjer() != null && temp.getEjer().equals(spiller)) {
					grupper[i / 5]++; //tæller op i "grupper" hvis spilleren ejer grunden
				}
			}
		}
		//sætter gruppen i "out" til true hvis tallet i "grupper" er højt nok
		for (int i = 0; i < 8; i++) {
			if (i == 0 || i == 7) { //De to grupper med kun to grunde
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
	
	/**
	 * returnere en liste over feltnumrene hvor spilleren kan bygge huse
	 */
	public int[] kanBebygges(Spiller spiller) {
		int[] temp = new int[22]; 
		int a = 0;
		for (int i = 0; i < 40; i++) {
			if (felter[i].getClass().getSimpleName().equals("Grund")) { 
				if (spiller.getKroner() > (i / 10 + 1) * 1000) { 
					if (grupperEjet(spiller)[i / 5]) { 
						//hvis spilleren ejer grunden, har nok penge og ejer alle grunde i gruppen
						Grund temp1 = (Grund) felter[i];
						boolean b = true;
						for (int j = (i / 5) * 5; j < (i / 5) * 5 + 5; j++) {
							if (felter[j].getClass().getSimpleName().equals("Grund")) {
								Grund temp2 = (Grund) felter[j];
								if (temp1.getHuse() > temp2.getHuse() || temp1.getHuse() > 4) {
									b = false; // hvis der er flere huse på en af de andre grunde i gruppen
								}
							}
						}
						//hvis grunden kommer igennem det hele bliver den sat på temp listen
						if (b) {
							temp[a] = i;
							a++;
						}
					}
				}
			}
		}
		//forkorter listen
		int[] out = new int[a];
		for (int i = 0; i < a; i++) {
			out[i] = temp[i];
		}
		return out;
	}
	
	/**
	 * returnere en liste over feltnumrene hvor andre en spilleren ejer dem
	 */
	public int[] andresEjendomme(Spiller spiller) {
		int[] temp = new int[28];
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
		//forkorter listen
		int[] out = new int[a];
		for (int i = 0; i < a; i++) {
			out[i] = temp[i];
		}
		return out;
	}

	/**
	 * returnere  en liste over en spillers grunde med huse på
	 */
	public int[] harHus(Spiller spiller) {
		int[] temp = new int[22];
		int a = 0;
		for (int i = 0; i < 40; i++) {
			if (felter[i].getClass().getSimpleName().equals("Grund")) {
				Grund temp1 = (Grund) felter[i];
				if(temp1.getEjer() != null && temp1.getEjer().equals(spiller))	{
					if(temp1.getHuse() > 0){
						temp[a] = i;
						a++;
					}
				}

			}
		} 
		//forkorter listen
		int[] out = new int[a];
		for (int i = 0; i < a; i++) {
			out[i] = temp[i];
		}
		return out;
	}

	/**
	 * returer en en liste over en spillers ejendomme og sletter spilleren og husene fra ejendommene
	 */
	public int[] fjernSpiller(Spiller spiller) {
		int[] temp = new int[22];
		int a = 0;
		for (int i = 0; i < 40; i++) {
			String type = felter[i].getClass().getSimpleName();
			if (type.equals("Grund") || type.equals("Rederi") || type.equals("Tapperi")) {
				Ejendom temp1 = (Ejendom) felter[i];
				if (temp1.getEjer() != null && temp1.getEjer().equals(spiller)) {
					temp[a] = i;
					a++;
					temp1.setEjer(null);
					if (type.equals("Grund")){
						Grund temp2 = (Grund) temp1;
						temp2.setHuse(0);
					}
					
					
				}
			}
		}
		//forkorter listen
		int[] out = new int[a];
		for (int i = 0; i < a; i++) {
			out[i] = temp[i];
		}
		return out;
		
	}

}
