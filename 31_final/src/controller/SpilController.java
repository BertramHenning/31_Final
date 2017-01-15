package controller;

import boundary.GUIController;
import entity.Grund;
import entity.RafleBægre;
import entity.SpillerListe;

public class SpilController {

	private GUIController gui;
	private SpillerListe liste;
	private BankController bank;
	private LandPåFeltController landPåFelt;
	private RafleBægre rafle;

	public SpilController() {
		gui = new GUIController();
		bank = new BankController(gui);
		landPåFelt = new LandPåFeltController(bank, gui);
		rafle = new RafleBægre(2);

	}

	public void startGame() {

		/**
		 * Laver spilbrættet på GUI'en
		 */
		gui.createBoard();
		/**
		 * Viser en besked om reglerne til spillerne
		 */
		gui.visBesked(
				"Velkommen til Matador! I matador handler det om at købe, udleje eller sælge ejendomme så fordelagtigt, at man bliver den rigeste spiller og eventuelt eneste matador. Man begynder ved Start og flytter bilerne venstre om ifølge terningekast. Når en spillers brik ender på et felt, der ikke allerede ejes af nogen, kan han købe det af banken og indkassere leje af modstanderne, der standser dér. Lejesummen forøges betydeligt ved opførelse af huse og hoteller. For at skaffe flere penge kan man pantsætte grunde til banken. Felterne 'Prøv lykken' giver ret til at trække et kort, hvis ordre derefter må følges.");

		tilføjSpiller();
		/**
		 * Tilføjer spillere til GUI'en
		 */
		for (int i = 0; i < liste.getPlayerAmount(); i++) {
			System.out.println(i);
			gui.tilføjSpiller(liste.getNavn(i));
			gui.flytBil(liste.getNavn(i), 0);
		}

		// //hus køb test
		// Grund felt1 = (Grund) bank.getFelt(1);
		// Grund felt2 = (Grund) bank.getFelt(3);
		// felt1.setEjer(liste.getSpiller(2));
		// felt2.setEjer(liste.getSpiller(2));
		// gui.setEjer(1, liste.getNavn(2));
		// gui.setEjer(1, liste.getNavn(2));

		int tur = 0;
		/**
		 * Hver tur
		 */
		while (true) {
			if (liste.getPlayerAmount() == 1) {
				gui.visBesked(liste.getNavn(tur) + " , Du vandt!");
				break;
			}

			if (liste.getFængsel(tur) > 0) {
				String[] valg = { "Betal 1000 kr.", "Prøv at slå 2 ens." };
				String valgt = gui.vælgString("Hvordan vil du komme ud af fængslet?", valg);
				if (valgt.equals("Betal 1000 kr.")) {
					liste.tilføjKroner(tur, -1000);
					liste.setFængsel(tur, 0);
				} else {
					rafle.rulTerning();
					gui.setTerning(rafle.getTerningSlag(0), rafle.getTerningSlag(1));
					if (rafle.getTerningSlag(0) == rafle.getTerningSlag(1)) {
						liste.setFængsel(tur, 0);
					} else {
						liste.setFængsel(tur, liste.getFængsel(tur) + 1);
						if (liste.getFængsel(tur) > 3) {
							gui.visBesked("Du har ikke flere forsøg tilbage, betal 1000 kr.");
						}
					}
				}

				gui.visPengebeholdning(liste.getNavn(tur), liste.getKroner(tur));

			}
			if (liste.getFængsel(tur) == 0) {
				gui.visBesked("Det er din tur " + liste.getNavn(tur) + ", tryk ok for at rulle terningerne.");

				rafle.rulTerning();
				gui.setTerning(rafle.getTerningSlag(0), rafle.getTerningSlag(1));
				liste.setSum(tur, rafle.getSum());

				liste.flytPosition(tur, rafle.getSum());
				gui.flytBil(liste.getNavn(tur), liste.getPosition(tur));

				gui.visPengebeholdning(liste.getNavn(tur), liste.getKroner(tur));

				landPåFelt.landPåFelt(liste.getSpiller(tur));

			}

			for (int i = 0; i < liste.getPlayerAmount(); i++) {
				gui.visPengebeholdning(liste.getNavn(i), liste.getKroner(i));
			}

			while (true) {
				String[] valg = { "Slutte din tur", "Købe et hus", "Sælge et hus",
						"Prøve at købe en ejendom fra en anden spiller" };
				String valgt = gui.vælgString(liste.getNavn(tur) + ", hvad vil du gøre?", valg);
				if (valgt.equals("Slutte din tur")) {
					break;
				} else if (valgt.equals("Købe et hus")) {
					bank.købHus(liste.getSpiller(tur));
				} else if (valgt.equals("Sælge et hus")) {
					bank.sælgHus(liste.getSpiller(tur));
				} else if (valgt.equals("Prøve at købe en ejendom fra en anden spiller")) {
					bank.købEjendom(liste.getSpiller(tur));
				}
				for (int i = 0; i < liste.getPlayerAmount(); i++) {
					gui.visPengebeholdning(liste.getNavn(i), liste.getKroner(i));
				}
			}

			if (liste.getKroner(tur) <= 0) {
				gui.fjernBil(liste.getNavn(tur));
				gui.visBesked(liste.getNavn(tur) + ", du tabte");
				bank.fjernSpiller(liste.getSpiller(tur));
				liste.removePlayer(tur);
				tur--;
			}

			if (rafle.getTerningSlag(0) == rafle.getTerningSlag(1) && liste.getExtraTur(tur) > 1) {
				gui.visBesked("Politiet fangede dem efter at have kørt for hurtigt, de fængsles");
				liste.setFængsel(tur, 1);
				liste.setExtraTur(tur, 0);
				liste.setPosition(tur, 10);
				gui.flytBil(liste.getNavn(tur), liste.getPosition(tur));
				tur++;
				if (tur >= liste.getPlayerAmount()) {
					tur = 0;
				}
			} 
			if (rafle.getTerningSlag(0) == rafle.getTerningSlag(1) && liste.getFængsel(tur) == 0) {
				liste.setExtraTur(tur, liste.getExtraTur(tur) + 1);
				
			} else { 
				liste.setExtraTur(tur, 0);
				tur++;
				if (tur >= liste.getPlayerAmount()) {
					tur = 0;
				}
			}
			
		}

	}

	/**
	 * Tilføjer spillere til spillerlisten ud fra bruger input
	 */

	public void tilføjSpiller() {
		int antalSpillere = gui.spørgBeløb("Indtast antal spillere: ", 3, 6);
		String[] navne = new String[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			// Tests if the new name is the same as another players name
			while (true) {
				boolean sammeNavn = false;
				navne[i] = gui.spørgString("Spiller " + (i + 1) + " indtast dit navn:");
				for (int j = 0; j < i; j++) {
					if (navne[i].equals(navne[j])) {
						sammeNavn = true;
						gui.visBesked("Du kan ikke have det samme navn.");
					}
				}
				if (sammeNavn == false) {
					break;
				}
			}
		}
		liste = new SpillerListe(antalSpillere, navne);
	}

}
