package boundary;

import java.awt.Color;

public class FeltBeskrivelser {
	// Laver et array med felt navne
	public static String[] feltNavne = {
				"Start",
				"Rødovrevej",
				"Prøv lykken",
				"Hvidovrevej", 
				"Betal indkomstskat:",
				"Scandlines H-H", 
				"Roskildevej",
				"Prøv lykken", 
				"Valby Langgade", 
				"Allégade",
				"Fængsel", 
				"Frederiksberg Allé",
				"Tuborg Squash",
				"Bülowsvej", 
				"Gl.Kongevej",
				"Mols-linien", 
				"Bernstorffsvej",
				"Prøv lykken", 
				"Hellerupvej", 
				"Strandvejen",
				"Parkering", 
				"Trianglen",
				"Prøv lykken",
				"Østerbrogade",
				"Grønningen",
				"Scandlines G-R",
				"Bredgade",
				"Kgs.Nytorv",
				"Coca-Cola",
				"Østergade",
				"De fængsles",
				"Amagertorv",
				"Vimmelskaftet",
				"Prøv lykken",
				"Nygade",
				"Scandlines R-P",
				"Prøv lykken",
				"Frederiksberg gade",
				"Betal statsskat",
				"Rådhuspladsen"
				};	
	public static int[] feltVærdi = {
			0,
			1200,
			0,
			1200, 
			4000,
			4000, 
			2000, 
			0, 
			2000, 
			2400, 
			0, 
			2800,
			3000, 
			2800, 
			3200, 
			4000, 
			3600,
			0, 
			3600, 
			4000,
			0,
			4400,
			0,
			4400,
			4800,
			4000,
			5200,
			5200,
			3000,
			5600,
			0,
			6000,
			6000,
			0,
			6400,
			4000,
			0,
			7000,
			2000,
			8000
			};
	
	public static Color[] feltFarve = {
			Color.getHSBColor((float) 0,(float) 0.95,(float) 0.92), // Start Felt (1)
			Color.getHSBColor((float)0.630,(float) 0.73,(float) 0.57), // Rødovrevej (2)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // Prøv lykken (3)
			Color.getHSBColor((float)0.630,(float) 0.73,(float) 0.57), // Hvidovrevej (4)
			Color.getHSBColor((float)0.07,(float) 0.76,(float) 0.40), // Indkomst skat (5)
			Color.getHSBColor((float)0.65,(float) 1.00,(float) 0.70), // Rederi (6)
			Color.getHSBColor((float)0.07,(float) 1.00,(float) 0.89), // Roskildevej (7)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // Prøv lykken (8)
			Color.getHSBColor((float)0.07,(float) 1.00,(float) 0.89), // Valby Langgade (9)
			Color.getHSBColor((float)0.07,(float) 1.00,(float) 0.89), // Allégade (10)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // På besøg (11)
			Color.getHSBColor((float)0.19,(float) 0.72,(float) 0.92), // Frederiksberg Allé (12)
			Color.getHSBColor((float) 0,(float) 0.95,(float) 0.92), // Squash (13)
			Color.getHSBColor((float)0.19,(float) 0.72,(float) 0.92), // Bülowsvej (14)
			Color.getHSBColor((float)0.19,(float) 0.72,(float) 0.92), // Gl. Kongevej (15)
			Color.getHSBColor((float)0.65,(float) 1.00,(float) 0.70), // Rederi (16)
			Color.getHSBColor((float) 0.177,(float) 0.058,(float) 0.72), // Bernstorffsvej (17)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // Prøv lykken (18)
			Color.getHSBColor((float) 0.177,(float) 0.058,(float) 0.72), // Hellerupvej (19)
			Color.getHSBColor((float) 0.177,(float) 0.058,(float) 0.72), // Strandvejen (20)
			Color.getHSBColor((float) 0.525,(float) 0.62,(float) 0.88), // Parkering (21)
			Color.getHSBColor((float) 0,(float) 0.95,(float) 0.92), // Trianglen (22)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // Prøv lykken (23)
			Color.getHSBColor((float) 0,(float) 0.95,(float) 0.92), // Østerbrogade (24)
			Color.getHSBColor((float) 0,(float) 0.95,(float) 0.92), // Grønningen (25)
			Color.getHSBColor((float)0.65,(float) 1.00,(float) 0.70), // Rederi (26)
			Color.getHSBColor((float) 0,(float) 0,(float) 1.00), // Bredgade (27)
			Color.getHSBColor((float) 0,(float) 0,(float) 1.00), // Kgs. Nytorv (28)
			Color.getHSBColor((float) 0,(float) 0.95,(float) 0.92), // Coca Cola (29)
			Color.getHSBColor((float) 0,(float) 0,(float) 1.00), // Østergade (30)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // De fængsles (31)
			Color.getHSBColor((float)0.147,(float) 1.00,(float) 1.00), // Amagertorv (32)
			Color.getHSBColor((float)0.147,(float) 1.00,(float) 1.00), // Vimmelskaftet (33)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // Prøv lykken (34)
			Color.getHSBColor((float)0.147,(float) 1.00,(float) 1.00), // Nyborg (35)
			Color.getHSBColor((float)0.65,(float) 1.00,(float) 0.70), // Rederi (36)
			Color.getHSBColor((float)0,(float) 0,(float) 0), // Prøv lykken (37)
			Color.getHSBColor((float)0.86,(float) 0.58,(float) 0.68), // Frederiksberggade (38)
			Color.getHSBColor((float)0.07,(float) 0.76,(float) 0.40), // Indkomst skat (39)
			Color.getHSBColor((float)0.86,(float) 0.58,(float) 0.68), // Ekstraordinær statsskat (40)
	};

	
	
	public static int [][] Leje = new int [][]{
		{0}, 
		{50, 250, 750, 2250, 4000, 6000},
		{0},
		{50, 250, 750, 2250, 4000, 6000},
		{0},
		{500, 1000, 2000, 4000},
		{100, 600, 1800, 5400, 8000, 11000},
		{0},
		{100, 600, 1800, 5400, 8000, 11000},
		{150, 800, 2000, 6000, 9000, 12000},
		{0},
		{200, 1000, 3000, 9000, 12500, 15000},
		{0},
		{200, 1000, 3000, 9000, 12500, 15000},
		{250, 1250, 3750, 10000, 14000, 18000},
		{500, 1000, 2000, 4000},
		{300, 1400, 4000, 11000, 15000, 19000},
		{0},
		{300, 1400, 4000, 11000, 15000, 19000},
		{350, 1600, 4400, 12000, 16000, 20000},
		{0},
		{350, 1800, 5000, 14000, 17500, 21000},
		{0},
		{350, 1800, 5000, 14000, 17500, 21000},
		{400, 2000, 6000, 15000, 18000, 22000},
		{500, 1000, 2000, 4000},
		{450, 2200, 6600, 16000, 19500, 23000},
		{450, 2200, 6600, 16000, 19500, 23000},
		{0},
		{500, 2400, 7200, 17000, 20500, 24000},
		{0},
		{550, 2600, 7800, 18000, 22000, 25000},
		{550, 2600, 7800, 18000, 22000, 25000},
		{0},
		{600, 3000, 9000, 20000, 24000, 28000},
		{500, 1000, 2000, 4000},
		{0},
		{700, 3500, 10000, 22000, 26000, 30000},
		{0},
		{1000, 4000, 12000, 28000, 34000, 40000}
	};
		
			
	}
	
	


