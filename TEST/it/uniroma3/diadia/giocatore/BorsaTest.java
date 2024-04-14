package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsa;

	@Before
	public void setUp(){
		borsa = new Borsa();
	}

	/*Test addAttrezzo*/
	@Test
	public void testAggiungoAttrezzoBorsaVuota() {
		Attrezzo nuovoAttrezzo = costruttoreAttrezzo(borsa, "nuovoAttrezzo", 1);
		assertEquals(nuovoAttrezzo, borsa.getAttrezzo("nuovoAttrezzo"));
	}
	
	@Test
	public void testAggiungiNAttrezzi() {
		costruttoreNAttrezzi(borsa, 4);
		assertEquals(8, borsa.getPeso());
	}
	
	@Test
	public void testAggiungiAttrezziBorsaPiena() {
		costruttoreNAttrezzi(borsa, 8);
		Attrezzo nuovoAttrezzoDiTroppo = new Attrezzo("nuovoAttrezzoDiTroppo", 1);
		assertFalse(borsa.addAttrezzo(nuovoAttrezzoDiTroppo));
	}
	
	/*Funzioni di appoggio*/
	
	private Attrezzo costruttoreAttrezzo(Borsa borsa, String nome, int peso) {
		Attrezzo nuovoAttrezzo = new Attrezzo(nome, peso);
		borsa.addAttrezzo(nuovoAttrezzo);
		return nuovoAttrezzo;
	}
	
	private void costruttoreNAttrezzi(Borsa borsa, int n) {
		for (int i = 0; i < n; i++) {
			costruttoreAttrezzo(borsa, "nuovoAttrezzo_"+i, 2);
		}
	}
}
