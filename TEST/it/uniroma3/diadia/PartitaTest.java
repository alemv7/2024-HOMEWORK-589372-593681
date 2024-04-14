package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	Partita partita;
	@Before
	public void setUp(){
		partita = new Partita();
	}

	@Test
	public void testPartitaFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testPartitaNonFinita() {
		assertFalse(partita.isFinita());
	}
	
	@Test
	public void testPartitaNonVinta() {
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testPartitaVinta() {
		assertFalse(partita.vinta());
	}

}