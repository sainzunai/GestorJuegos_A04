package es.deusto.spq;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class VideoJuegoTest {
	
	private List<Biblioteca> biblioteca= new ArrayList<>();
	private ArrayList<Calificacion> cList;
	private ArrayList<Calificacion> cList2;
	private Calificacion c;
	private Calificacion c1;
	private Calificacion c2;
	private Calificacion c3;
	
	private Biblioteca b; 
	
	private Biblioteca b2;
	
	private VideoJuego v; 
	
	private VideoJuego v2; 
	
	private VideoJuego v3; 
	
	private VideoJuego v4; 
	
	private VideoJuego v5; 
    @Before                                         
    public void setUp() throws Exception {
    	
    	
    	cList = new ArrayList<>(); 
    	cList2 = new ArrayList<>(); 
    	c1 = new Calificacion(10, 2021, 3, 29); 
    	c2= new Calificacion(7, 2020, 8, 12); 
    	c3 = new Calificacion(4, 2021, 1, 29); 
    	c = new Calificacion(3, 2018, 2, 5); 
    	b = new Biblioteca(); 
    	b2 = new Biblioteca(); 
    	cList.add(c1);
    	cList2.add(c1);
    	cList.add(c2);
    	cList2.add(c2);
    	cList.add(c3);
    	
    	v = new VideoJuego("Fifa21", "F21", "Ubisoft", 3, null); 
    	
    	v2 = new VideoJuego("FF4", "F4", "Nintendo", 3, null, "hola"); 
    	
    	//Probando todos los constructores; 
    	
    	v3 = new VideoJuego(); 
    	
    	v4 = new VideoJuego("FIfa 18", "F18", "Oracle", 6, cList, null); 
    	
    	v5 = new VideoJuego("PRO 12", "P12", "PEs", 8, cList2, null, "caratula"); 
    	
    	v.setCalificaciones(cList);
    	
    	biblioteca.add(b); 
    	
    	biblioteca.add(b2);

    }

	@Test
	public void testCalcularNotaMedia() {
		
		assertEquals( 7.0 , v.calculoNotaMedia(), 0.01); 
		
	}
	
	@Test
	public void testNotaMaxima() {
		
		assertEquals( 10 , v.notaMaxima());
		
	}
	
	@Test
	public void testAddCalificacion1() {
		
		v.addCalificacion(new Calificacion(10, 2001, 11, 9));
		
		assertEquals(2, v.calculaVotosDeNota(10));
		
	}
	
	@Test
	public void testRemCalificacion() {
		
		v.remCalificacion(c1); 
		
		assertEquals(2, v.getCalificaciones().size());
		
	}
	@Test
	public void testGetCaratula() {
		
		assertEquals(" ", v.getCaratula());
		
		v.setCaratula("foto_caratula.png");
		
		assertEquals(v.getCaratula(), "foto_caratula.png");
		
	}
		
		
		//Test que faltaban del primer sprint. 
	@Test
	public void testGetEdadRecomendada() {
		
		assertEquals(0, v3.getEdadRecomendada());
		
	}
	@Test	
	public void testGetNombre() {
		
		assertEquals("PRO 12", v5.getNombre());
		
	}
	@Test	
	public void testSetNombre() {
		v5.setNombre("TestPro");
		
		assertEquals("TestPro", v5.getNombre());
		
	}
	@Test
	public void testGetId() {
		
		assertEquals("F4", v2.getId());
		
	}
	@Test
	public void testSetId() {
		
		v2.setId("FF4R");
		
		assertEquals("FF4R", v2.getId());
		
	}
	@Test
	public void testGetCompania() {
		
		assertEquals("Oracle", v4.getCompania());	
		
	}
	@Test
	public void testSetCompania() {
		
		v4.setCompania("Deusto");
		
		assertEquals("Deusto", v4.getCompania());
		
	}
	@Test
	public void testGetEdadRecomendada1() {
		
		assertEquals(8, v5.getEdadRecomendada());
		
	}
	@Test	
	public void testSetEdadRecomendada() {
		v5.setEdadRecomendada(4);
		
		assertEquals(4, v5.getEdadRecomendada());
		
	}
	@Test
	public void testGetCalificaciones() {
		
		assertEquals(cList, v4.getCalificaciones());	
		
	}
	@Test
	public void testSetCalificaciones() {
		
		v4.setCalificaciones(cList2);
		
		assertEquals(cList2, v4.getCalificaciones());
		
	}
	@Test
	public void testGetCaratula1() {
		
		assertEquals(" ", v3.getCaratula());
		
	}
	
	
	@Test
	public void testSetCaratula() {
		
		v3.setCaratula("Llenado del vacio");
		
		assertEquals("Llenado del vacio", v3.getCaratula());
		
	}
	
	@Test
	public void testAddBiblioteca() {
		
		v3.addBiblioteca(b);
		
		//assertEquals(b, v3.getBiblioteca());
		
		assertEquals(1, v3.getNumberOfBiblioteca());
		
	}
	
	@Test
	public void testRemoveBiblioteca() {
		
		v3.removeBiblioteca(b);
		
		assertEquals(0, v3.getNumberOfBiblioteca());
		
		v.setBiblioteca(biblioteca);
		
		assertEquals(2, v.getNumberOfBiblioteca());
		
	}
		
	

}
