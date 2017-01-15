package entity;

public class LykkeBeskrivelser {
	
	public String[] Beskrivelse = {
			
		//Modtag	
		"Eftergivelse af Kvartals skat: Modtag 3000 kr.",
		"Præmieobligation udtrækkelse: Modtag 1000 kr.",
		"Præmieobligation udtrækkelse: Modtag 1000 kr.",
		"Gageforhøjelse: Modtag 1000 kr.",
		"Aktieudbytte: Modtag 1000 kr.",
		"Aktieudbytte: Modtag 1000 kr.",
		"Aktieudbytte: Modtag 1000 kr.",
		"Møbel auktion: Modtag 1000 kr.",
		"Klasselotteriet: Modtag 500 kr.",
		"Klasselotteriet: Modtag 500 kr.",
		"Tipning: Modtag 1000 kr.",
		"Avl fra nyttehaven: Modtag 200 kr.",
		
		//Betal
		"Reparation af vogn: Betal 3000 kr.",
		"Reparation af vogn: Betal 3000 kr.",
		"Rødt lys bøde: Betal 1000 kr.",
		"2 kasser øl: Betal 200 kr.",
//		"Olie prisstigning: Betal 500 kr. pr. hus og 2000 kr. pr. hotel.",
		"Parkeringsbøde: Betal 200 kr.",
		"Bilforsikring: Betal 1000 kr.",
		"Nye dæk: Betal 1000 kr.",
		"Tandlægeregning: Betal 2000 kr.",
		"Cigaret told: Betal 200 kr.",
//		"Ejendomsskat stigning: Betal 800 kr. pr. hus og 2300 kr. pr. hotel.",
//		"Ejendomsskat stigning: Betal 800 kr. pr. hus og 2300 kr. pr. hotel.",
		
		//Ryk
		"Gå i fængsel: Flyt til fængsel og modtag ikke 4000 kr. ved passering af start.",
		"Gå i fængsel: Flyt til fængsel og modtag ikke 4000 kr. ved passering af start.",
		"Ryk tre felter tilbage.",
		"Ryk tre felter tilbage.",
		"Ryk til Frederiksberg Allé og modtag 4000 kr. ved passering af start.",
		"Ryk til Mols-Linien og modtag 4000 kr. ved passering af start.",
		"Ryk tre felter frem.",
		"Ryk til Strandvejen og modtag 4000 kr. ved passering af start.",
		"Ryk til den nærmeste færge og modtag 4000 kr. ved passering af start.",
		"Ryk til det nærmeste rederi og betal ejeren to gange leje. Hvis der ingen ejer er, kan feltet købes.",
		"Ryk til det nærmeste rederi og betal ejeren to gange leje. Hvis der ingen ejer er, kan feltet købes.",
		"Ryk frem til Grønningen og modtag 4000 kr. ved passering af start.",
		"Ryk frem til Start",
		"Ryk frem til Start",
		"Ryk frem til Rådhuspladsen.",
		"Ryk frem til Vimmelskaftet og modtag 4000 kr. ved passering af start.",
		
	};
	
	// kun ca 24, dem med modtag og betal til banken
	public int[] penge = {
			
			// modtag
			3000,
			1000,
			1000,
			1000,
			1000,
			1000,
			1000,
			1000,
			500,
			500,
			1000,
			200,
			
			// betal
			3000,
			3000,
			1000,
			200,
			//500 pr hus 2000 pr hotel,
			200,
			1000,
			1000,
			2000,
			200,
			//800 pr hus 2300 pr hotel,
			//800 pr hus 2300 pr hotel,
			
	};
	
	public int[] ryk = {
			
			// Antal felter, der skal rykkes
			3,
			3,
			3,
	};
}
