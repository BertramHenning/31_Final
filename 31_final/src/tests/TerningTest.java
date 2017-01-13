package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Terning;

public class TerningTest {

	Terning d1, d2;

	@Before
	public void setUp() throws Exception {
		d1 = new Terning();
		d2 = new Terning();
	}

	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
	}

	@Test
	public void testTerning() {
		int expected = 1000;
		int actual = 0;
		for (int i = 0; i < 1000; i++){
			d1.rul();
			d2.rul();
			int sum = d1.getVærdi() + d2.getVærdi();
			if(sum < 13 && sum > 1){
				actual++;
			} else {
				System.out.println(sum);
			}
		}
		assertEquals(expected, actual);
	}

	@Test
	public void testRoll() {
		int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0;
		for (int i = 0; i < 60000; i++) {
			d1.rul();
			switch(d1.getVærdi()){
			case 1:
				r1++;
				break;
			case 2:
				r2++;
				break;
			case 3:
				r3++;
				break;
			case 4:
				r4++;
				break;
			case 5:
				r5++;
				break;
			case 6:
				r6++;
				break;
			}
		}
		boolean expected = true;
		boolean actual = false;
		if (r1<10400 && r1>9600){
			if (r2<10400 && r2>9600){
				if (r3<10400 && r3>9600){
					if (r4<10400 && r4>9600){
						if (r5<10400 && r5>9600){
							if (r6<10400 && r6>9600){
								actual = true;
							}
						}
					}
				}
			}
		}
		assertEquals(r1 + " " + r2 + " " + r3 + " " + r4 + " " + r5 + " " + r6 , expected, actual);
	}

}

