package es.deusto.spq;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	@Test
	public void test1() {
		p1.setUrlLogo("\resource");
		assertEquals("\resource", p1.getUrlLogo());
		VideoJuego v1=new VideoJuego("Cod", "1", "Activision", 16, p1);
		p1.addVideoJuego(v1);
		assertEquals(1, p1.getVideoJuegos().size());
		p1.removeVideojuego(v1);
		assertEquals(0, p1.getNumberOfVideojuegos());
		List<VideoJuego> lista = new ArrayList<>();
		lista.add(v1);
		p1.setVideojuego(lista);
		assertEquals(lista, p1.getVideoJuegos());
	}
	

}
