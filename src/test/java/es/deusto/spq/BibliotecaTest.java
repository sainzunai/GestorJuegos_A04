package es.deusto.spq;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BibliotecaTest {
	
	Biblioteca b; 
	
	VideoJuego v1;
	
	VideoJuego v2;
	
	VideoJuego v3;
	
	VideoJuego v4;

	
	
    @Before                                         
    public void setUp() throws Exception {
    	b = new Biblioteca("1");
    	v1 = new VideoJuego();
    	v2 = new VideoJuego();
    	v3 = new VideoJuego();
    	v4 = new VideoJuego();
    	
    	b.addJuego(v1);
    	b.addJuego(v2);
    	b.addJuego(v3);
    	b.addJuego(v4);
    	

    }

	@Test
	public void test() {
		
		assertEquals(4, b.numeroDeJuegos());
		
		b.remJuego(v1);
		
		assertEquals(3, b.numeroDeJuegos());
	}

}
