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

public class LandPåFeltTest {
	
	Spiller spiller1, spiller2;
	GUIController gui;
	LandPåFeltController landPåFelt;
	BankController bank;

	@Before
	public void setUp() throws Exception {
		spiller1 = new Spiller("test1");
		spiller2 = new Spiller("test2");
		gui = new GUIController();
		bank = new BankController(gui);
		landPåFelt = new LandPåFeltController(bank, gui);
	}

	@After
	public void tearDown() throws Exception {
		spiller1 = null;
		spiller2 = null;
		gui = null;
		bank = null;
		landPåFelt = null;
	}
	
	/**
	 * Tester om man betaler dobbelt så meget for at lande på en grund hvor ejeren ejer hele gruppen
	 */
	@Test
	public void testEjerAlleGrunde() {
		int expected = 29850;
		((Grund) bank.getFelt(1)).setEjer(spiller1);
		spiller2.setPosition(1);
		landPåFelt.landPåFelt(spiller2);
		((Grund) bank.getFelt(3)).setEjer(spiller1);
		spiller2.setPosition(3);
		landPåFelt.landPåFelt(spiller2);
		int actual = spiller2.getKroner();
		assertEquals(""+actual,expected, actual);
	}
	
	
	/**
	 * Tester om spillet tager 4000 kr fra spilleren når han vælger 4000
	 */
	@Test
	public void testFireTusind() {
		spiller1.setPosition(4);
		gui.visBesked("Klik ok");
		landPåFelt.landPåFelt(spiller1);
		int expected = 26000;
		int actual = spiller1.getKroner();
		assertEquals(expected, actual);
		}
	
	/**
	 * Tester om spillet tager 3000 kr fra spilleren når han vælger den nederste 
	 */	
	@Test
	public void testtiProcent() {
		spiller1.setPosition(4);
		gui.visBesked("Vælg nederste");
		landPåFelt.landPåFelt(spiller1);
		int expected = 27000;
		int actual = spiller1.getKroner();
		assertEquals(expected, actual);
	}

}
