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

	@Test
	public void testFireTusind() {
		
		
		testSpiller.setPosition(4);
		int expected = 26000;
		testKonto.tilføjKroner(-4000);
		int actual = testKonto.getKroner();
		assertEquals(expected, actual);
		}
		
	@Test
	public void testtiProcent() {
		
		int tiProcent;
		testSpiller.setPosition(4);
		tiProcent = testKonto.getKroner() / 10;
		int expected = 27000;
		testKonto.tilføjKroner(-tiProcent);
		int actual = testKonto.getKroner();
		assertEquals(expected, actual);
	}


}
