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
	
	ArrayList<VideoJuego> v; 

	
	
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
    	
    	
    	//b.addJuego(v4);
    	
    	v = new ArrayList<>(); 
    	
    	v.add(v1);
    	v.add(v2);
    	v.add(v3);
    	

    }

	@Test
	public void testRemJuego() {
		
		b.remJuego(v1);
		
		assertEquals(2, b.numeroDeJuegos());
	}

	@Test
	public void testAddJuego() {
		
		b.addJuego(v4);
		assertEquals(4, b.numeroDeJuegos());		
		
	}
	
	@Test
	public void testGetId() {
		
	}
	
	@Test
	public void testSetId() {
		b.setId("HOLA");
		
		assertEquals("HOLA", b.getId());		
		
		
	}
	
	@Test	
	public void testGetListaJuegos() {
		
		assertEquals(3, b.getListaJuegos().size());
		
	}
	
	@Test
	public void testSetListaJuegos() {
		
		b.setListaJuegos(v);
		assertNotNull(b.getListaJuegos());
		
		
	}
	
	@Test	
	public void testGetUser() {
		
		assertNull(b.getUser());
		
	}
	
	@Test
	public void testSetUser() {
		
		b.setUser(new Usuario("HOLA", "HOLA", "PRUEBA"));
		
		assertNotNull(b.getUser());
		
	}
	
	@Test
	public void testNumeroDeJuegos() {
		
		
		assertEquals(3, b.numeroDeJuegos());
		
	}
	
	
	

	

	
}
