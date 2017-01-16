package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Konto;
import entity.Spiller;

public class KontoTest {
	Konto testKonto;
	Spiller testSpiller;

	@Before
	public void setUp() throws Exception {
		testKonto = new Konto();
		testSpiller = new Spiller(null);
	}

	@After
	public void tearDown() throws Exception {
		testKonto = null;
		testSpiller = null;
	}


	@Test
	public void testAddCoins() {
		int expected = 20000;
		testKonto.tilføjKroner(-5000);
		testKonto.tilføjKroner(-3000);
		testKonto.tilføjKroner(7000);
		testKonto.tilføjKroner(-9000);
		int actual = testKonto.getKroner();
		assertEquals(expected, actual);
	}

	@Test
	public void testAccount() {
		int expected = 30000;
		int actual = testKonto.getKroner();
		assertEquals(expected, actual);		
	}



}
