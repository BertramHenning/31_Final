package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Konto;

public class KontoTest {
	Konto testKonto;

	@Before
	public void setUp() throws Exception {
		testKonto = new Konto();
	}

	@After
	public void tearDown() throws Exception {
		testKonto = null;
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
