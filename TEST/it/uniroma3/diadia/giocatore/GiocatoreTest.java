package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	Giocatore giocatore;

	@Before
	public void setUp(){
		giocatore = new Giocatore();
	}

	@Test
	public void testCFUStart() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testCambiaCFU() {
		giocatore.setCfu(25);
		assertEquals(25, giocatore.getCfu());
	}
}