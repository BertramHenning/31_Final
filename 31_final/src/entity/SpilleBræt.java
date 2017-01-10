package entity;

import boundary.FeltBeskrivelser;

public class SpilleBræt {

	private Felt[] felter = new Felt[40];

	public SpilleBræt() {
		for (int i = 0; i < 40; i++) {
			switch (i) {
			case 2:
			case 7:
			case 17:
			case 22:
			case 33:
			case 36:
				felter[i] = new PrøvLykken(FeltBeskrivelser.feltNavne[i]);
				break;
			case 4:
			case 38:
				felter[i] = new Skat(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]);
				break;
			case 5:
			case 15:
			case 25:
			case 35:
				felter[i] = new Rederi(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]);
				break;
			case 12:
			case 28:
				felter[i] = new Tapperi(FeltBeskrivelser.feltNavne[i], FeltBeskrivelser.feltVærdi[i]);
				break;
			case 10:
			case 30:
			case 0:
			case 20:
				felter[i] = new Fri(FeltBeskrivelser.feltNavne[i]);
				break;
			default:
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

	public void tilføjHus(int felt) {
		Grund a = (Grund) felter[felt];
		a.setHuse(a.getHuse() + 1);
	}

	public boolean tapperier(Spiller spiller) {
		boolean out = true;
		Ejendom temp = (Ejendom) felter[12];
		if (!temp.getEjer().equals(spiller)) {
			out = false;
		}
		temp = (Ejendom) felter[28];
		if (!temp.getEjer().equals(spiller)) {
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

	public boolean[] grupperEjet(Spiller spiller) {
		int[] grupper = { 0, 0, 0, 0, 0, 0, 0, 0 };
		boolean[] out = new boolean[8];
		for (int i = 0; i < 40; i++) {
			if (felter[i].getClass().getSimpleName().equals("Grund")) {
				Grund temp = (Grund) felter[i];
				if (temp.getEjer() != null && temp.getEjer().equals(spiller)) {
					grupper[i / 5]++;
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
		int[] temp = new int[22];
		int a = 0;
		for (int i = 0; i < 40; i++) {
			if (felter[i].getClass().getSimpleName().equals("Grund")) {
				if (spiller.getKroner() > (i / 10 + 1) * 1000) {
					if (grupperEjet(spiller)[i / 5]) {
						Grund temp1 = (Grund) felter[i];
						boolean b = true;
						for(int j = (i/5)*5; j < (i/5)*5 + 5; j++){
							if(felter[j].getClass().getSimpleName().equals("Grund")){
								Grund temp2 = (Grund) felter[j];
								if(temp1.getHuse() > temp2.getHuse()){
									b = false;
								}
							}
						}
						if(b){
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

}
