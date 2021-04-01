package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlataformaTest {  //Si hay metodos nuevos habria que crear la logica. 
	
	Plataforma p1; 
	Plataforma p2;
	Plataforma p3;
	
	
    @Before                                         
    public void setUp() throws Exception {

    	p1 = new Plataforma("Play4", "Ps4", "Foto.png");
    	
    	p2 = new Plataforma("Play4", "Ps4");
    	
    	p3 = new Plataforma(); 
    }

	@Test
	public void test() {
		assertEquals(p1.getUrlLogo(), "Foto.png");
		
		assertEquals(p2.getIdPlataforma(), "Ps4");
		
		assertEquals(p2.getUrlLogo(), "");
		
		assertEquals(p3.getUrlLogo(), "");
		
		assertEquals(p3.getIdPlataforma(), "");
		
		assertEquals(p3.getNombrePlataforma(), "");
	}
	

}
