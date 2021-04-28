package es.deusto.spq;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PlataformaTest {  //Si hay metodos nuevos habria que crear la logica. 
	
	Plataforma p1; 
	Plataforma p2;
	Plataforma p3;
	
	
	private VideoJuego videojuego = Mockito.mock(VideoJuego.class);
	
    @Before                                         
    public void setUp() throws Exception {

    	p1 = new Plataforma("Play4", "Ps4", "Foto.png");
    	
    	p2 = new Plataforma("Play4", "Ps4");
    	
    	p3 = new Plataforma(); 
    }

	@Test
	public void testGetUrlLogo() {
		assertEquals(p1.getUrlLogo(), "Foto.png");
		
		assertEquals(p2.getUrlLogo(), "");
		
		assertEquals(p3.getUrlLogo(), "");
		
	}
	
	@Test
	public void testGetIdPlataforma() {
		assertEquals(p2.getIdPlataforma(), "Ps4");
		assertEquals(p3.getIdPlataforma(), "");
		
	}

	@Test
	public void testGetNombrePlataforma() {		
		assertEquals(p3.getNombrePlataforma(), "");
	}
	
	
	@Test
	public void testSetLogo() {
		p1.setUrlLogo("\resource");
		assertEquals("\resource", p1.getUrlLogo());
		
	}
	
	@Test
	public void testAddVideoJuego() {
		p1.addVideoJuego(videojuego);
		assertEquals(1, p1.getVideoJuegos().size());
		
	}
	
	@Test
	public void testRemVideojuego() {
		p1.removeVideojuego(videojuego);
		assertEquals(0, p1.getNumberOfVideojuegos());
		
	}
	
	@Test
	public void testSetVideojuego() {
		List<VideoJuego> lista = new ArrayList<>();
		lista.add(videojuego);
		p1.setVideojuego(lista);
		assertEquals(lista, p1.getVideoJuegos());
	}
	

}
