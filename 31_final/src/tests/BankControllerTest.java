package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import boundary.GUIController;
import controller.BankController;
import controller.LandPåFeltController;
import entity.Spiller;
import entity.Grund;

public class BankControllerTest {

	Spiller spiller1;
	GUIController gui;
	BankController bank;

	@Before
	public void setUp() throws Exception {
		spiller1 = new Spiller("test1");
		gui = new GUIController();
		bank = new BankController(gui);
	}

	@After
	public void tearDown() throws Exception {
		spiller1 = null;
		gui = null;
		bank = null;
	}

	/**
	 * Tester om man får halvdelen af prisen for et hus/hotel tilbage når man sælger dem
	 */
	@Test
	public void test() {
		int expected = 32500;
		((Grund) bank.getFelt(1)).setEjer(spiller1);
		((Grund) bank.getFelt(39)).setEjer(spiller1);
		((Grund) bank.getFelt(1)).setHuse(1);
		((Grund) bank.getFelt(39)).setHuse(5);
		bank.sælgHus(spiller1);
		bank.sælgHus(spiller1);
		int actual = spiller1.getKroner();
		assertEquals("" + actual, expected, actual);
	}
}
