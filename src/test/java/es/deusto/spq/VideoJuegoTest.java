package es.deusto.spq;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VideoJuegoTest {
	
	private ArrayList<Calificacion> cList; 
	private Calificacion c1;
	private Calificacion c2;
	private Calificacion c3;
	
	private VideoJuego v; 
	
	private VideoJuego v2; 
	
    @Before                                         
    public void setUp() throws Exception {
    	
    	
    	cList = new ArrayList<>(); 
    	c1 = new Calificacion(10, 2021, 3, 29); 
    	c2= new Calificacion(7, 2020, 8, 12); 
    	c3 = new Calificacion(4, 2021, 1, 29); 
    	
    	cList.add(c1);
    	cList.add(c2);
    	cList.add(c3);
    	
    	v = new VideoJuego("Fifa21", "F21", "Ubisoft", 3, null); 
    	
    	v2 = new VideoJuego("Fifa21", "F21", "Ubisoft", 3, null, "hola"); 
    	
    	v.setCalificaciones(cList);

    }

	@Test
	public void test() {
		
		assertEquals( 7.0 , v.calculoNotaMedia(), 0.01); 
		
		assertEquals( 10 , v.notaMaxima());
		
		v.addCalificacion(new Calificacion(10, 2001, 11, 9));
		
		assertEquals(2, v.calculaVotosDeNota(10));
		
		v.remCalificacion(c1); 
		
		assertEquals(3, v.getCalificaciones().size());
		
		assertEquals(" ", v.getCaratula());
		
		v.setCaratula("foto_caratula.png");
		
		assertEquals(v.getCaratula(), "foto_caratula.png");
		
		
	}

}
