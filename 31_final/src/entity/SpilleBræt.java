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
				felter[i] = new PrøvLykken();
				break;
			case 4:
			case 38:
				felter[i] = new Skat(FeltBeskrivelser.feltVærdi[i]);
				break;
			case 5:
			case 15:
			case 25:
			case 35:
				felter[i] = new Rederi(FeltBeskrivelser.feltVærdi[i]);
				break;
			case 12:
			case 28:
				felter[i] = new Tapperi(FeltBeskrivelser.feltVærdi[i]);
				break;
			case 10:
			case 30:
			case 0:
			case 20:
				felter[i] = new Fri();
				break;
			default:
				felter[i] = new Grund(FeltBeskrivelser.feltVærdi[i], i / 5 + 1, FeltBeskrivelser.Leje[i]);
				break;

			}
		}
	}

	public Felt[] getFelter() {
		return felter;
	}

	public void setFelter(Felt[] felter) {
		this.felter = felter;
	}
	
}
