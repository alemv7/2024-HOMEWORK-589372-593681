package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaTest {
	Stanza stanza;
	@Before
	public void setUp() {
		stanza = new Stanza("stanza");
	}
	
	//test per getStanzaAdiacente
	@Test
	public void testGetStanzaAdiacente() {
		Stanza stanzaAd = new Stanza("N11");
		stanza.impostaStanzaAdiacente("sud", stanzaAd);
		assertEquals(stanzaAd,stanza.getStanzaAdiacente("sud"));
	}
	
    @Test
    public void testGetStanzaAdiacenteNotNull() {
    	Stanza stanzaAd = new Stanza("N12");
    	stanza.impostaStanzaAdiacente("nord", stanzaAd);
    	assertNotNull(stanza.getStanzaAdiacente("nord"));
    }
    
    @Test
    public void testGetStanzaAdiacenteUguale() {
    	Stanza stanzaAd = new Stanza("N13");
    	stanza.impostaStanzaAdiacente("nord", stanzaAd);
    	assertSame(stanzaAd,stanza.getStanzaAdiacente("nord"));
    }
    
    //test per impostaStanzaAdiacente
    @Test
    public void testImpostaCambiaStanzaAdiacente() {
    	Stanza stanzaAd = costruttoreAdiacente(stanza,"nord");
    	Stanza nuovaAd = costruttoreAdiacente(stanza,"sud");
    	assertEquals(nuovaAd,stanza.getStanzaAdiacente("sud"));
    }
    @Test
    public void testImpostaStanzaAdiacenteAdiacente() {
    	Stanza stanzaAd = costruttoreAdiacente(stanza,"sud");
    	Stanza stanzaAdAd = costruttoreAdiacente(stanzaAd,"sud");
    	assertEquals(stanzaAdAd, stanza.getStanzaAdiacente("sud").getStanzaAdiacente("sud"));
    }
    @Test
    public void testStanzaAdiacenteNull() {
    	Stanza stanzaAd = costruttoreAdiacente(stanza,"sud");
    	assertNull(stanzaAd.getStanzaAdiacente("nord"));
    }
    
    //test per addAttrezzo
    @Test
    public void testAggiungoAttrezzo() {
    	Attrezzo attrezzo = costruttoreAttrezzo(stanza,"attrezzo",1);
    	assertEquals(attrezzo, stanza.getAttrezzo("attrezzo"));
    }

	@Test
	public void testAggiungoNAttrezzi(){
		costruttoreNAttrezzi(stanza, 10);
		assertEquals(10, stanza.getAttrezzi().length);
	}
	
	@Test
	public void testInserimentoTroppiAttrezzi() {
		costruttoreNAttrezzi(stanza, 10);
		Attrezzo attrezzoInPiu = new Attrezzo("attrezzoDiTroppo", 10);
		assertFalse(stanza.addAttrezzo(attrezzoInPiu));
	}
	
//Funzioni di appoggio
	
	private Stanza costruttoreAdiacente(Stanza stanza, String direzione ) {
		Stanza stanzaAd = new Stanza("stanza");
		stanza.impostaStanzaAdiacente(direzione, stanzaAd);
		return stanzaAd;
	}
	
	private Attrezzo costruttoreAttrezzo(Stanza stanza, String nome, int peso) {
		Attrezzo attrezzo = new Attrezzo(nome, peso);
		stanza.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
	private void costruttoreNAttrezzi(Stanza stanza, int n){
		for (int i = 0; i < n; i++) {
			costruttoreAttrezzo(stanza, "attrezzo_" +i, i);
		}
}
}