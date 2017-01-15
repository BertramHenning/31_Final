package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Spiller;

public class SpillerTest {
	
	Spiller testSpiller;

	@Before
	public void setUp() throws Exception {
		testSpiller = new Spiller("test");
	}

	@After
	public void tearDown() throws Exception {
		testSpiller = null;
	}

	@Test
	public void testFlytPosition() {
		int expected = 8;
		testSpiller.flytPosition(8);
		int actual = testSpiller.getPosition();
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testStartPosition() {
		int expected = 34000;
		testSpiller.flytPosition(42);
		int actual = testSpiller.getKroner();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEkstraKast() {
		
	}
}
