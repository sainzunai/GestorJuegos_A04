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
    	b = new Biblioteca();
    	v1 = new VideoJuego("Battlefield","1","EA",18,new Plataforma());
    	v2 = new VideoJuego("Battlefield","2","EA",18,new Plataforma());
    	v3 = new VideoJuego("Battlefield","3","EA",18,new Plataforma());
    	v4 = new VideoJuego("Battlefield","4","EA",18,new Plataforma());
    	
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
