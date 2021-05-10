package es.deusto.spq;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import es.deusto.spq.ventanas.JPanelVideojuego;

public class VideoJuegoTest {
	
	private List<Biblioteca> biblioteca= new ArrayList<>();
	private ArrayList<Calificacion> cList;
	private ArrayList<Calificacion> cList2;
	
	private Biblioteca b = Mockito.mock(Biblioteca.class);
	private Calificacion c = Mockito.mock(Calificacion.class);
	private Calificacion c1 = Mockito.mock(Calificacion.class);
	private VideoJuego v; 	
	private VideoJuego v2; 
	private VideoJuego v3; 
	private VideoJuego v4; 
	private VideoJuego v5; 
    @Before                                         
    public void setUp() throws Exception {
    	
    	
    	cList = new ArrayList<>(); 
    	cList2 = new ArrayList<>(); 
    	
    	v = new VideoJuego("Fifa21", "F21", "Ubisoft", 3, null); 
    	
    	v2 = new VideoJuego("FF4", "F4", "Nintendo", 3, null, "hola"); 
    	
    	v3 = new VideoJuego(); 
    	
    	v4 = new VideoJuego("FIfa 18", "F18", "Oracle", 6, cList, null); 
    	
    	v5 = new VideoJuego("PRO 12", "P12", "PEs", 8, cList2, null, "caratula"); 
    	
    	cList.add(c); 
    	
    	cList.add(c1);    	
    	
    	v.setCalificaciones(cList);

    }

	@Test
	public void testCalcularNotaMedia() {
		
		when(c.getNota()).thenReturn(8);
		when(c1.getNota()).thenReturn(6);
		assertEquals( 7.0 , v.calculoNotaMedia(), 0.01); 
		
	}
	
	@Test
	public void testNotaMaxima() {
		
		when(c.getNota()).thenReturn(10);
		when(c1.getNota()).thenReturn(8); 
		assertEquals( 10 , v.notaMaxima());
		
	}
	
	@Test
	public void testCalculaVotosDeNota() {
		
		
		when(c.getNota()).thenReturn(10);
		when(c1.getNota()).thenReturn(0);
		assertEquals(1, v.calculaVotosDeNota(10));
		
	}
	
	@Test
	public void testRemCalificacion() {
		
		v.remCalificacion(c); 
		
		assertEquals(1, v.getCalificaciones().size());
		
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
		
		biblioteca.add(b); 
		
		v3.setBiblioteca(biblioteca);
		
		v3.removeBiblioteca(b);
		
		assertEquals(0, v3.getNumberOfBiblioteca());
		
	}
		
	@Test
	public void testSetBiblioteca() {
		
		
		biblioteca.add(b); 
		v3.setBiblioteca(biblioteca);
		assertEquals(1, v3.getNumberOfBiblioteca());
		
	}
	@Test
	public void testAddCalificacion() {
		v3.addCalificacion(c);
		
		assertEquals(1, v3.getCalificaciones().size());
	}
	
	@Test
	public void testGetBiblioteca() {
		
		v3.addBiblioteca(b);
		
		biblioteca.add(b); 
		
		assertEquals(biblioteca.size(), v3.getBiblioteca().size());
		
	}
	
	
	@Test
	public void testGetJpanelVideojuegos() {
		
		JPanelVideojuego jp1 = new JPanelVideojuego(v5, b); 
	
		assertEquals(jp1.cambioConstructor, v5.getJPanelVideojuego(b).cambioConstructor);
		
		
		
		JPanelVideojuego jp2 = new JPanelVideojuego(v5, 1, b); 
	
		assertEquals(jp2.cambioConstructor, v3.getJPanelVideojuego(b).cambioConstructor);
		
	}
	
	@Test
	public void testEquals() {
		
    	VideoJuego v2 = new VideoJuego("Fifa21", "F21", "Ubisoft", 3, null); 
    	
    	VideoJuego v3 = new VideoJuego("a21", "Fss21", "Ubisoft", 3, null); 
		
		assertTrue(v.equals(v));
		
		assertFalse(v.equals(null)); 
		
		assertFalse(v.equals(b));
		
		assertTrue(v.equals(v2)); 
		
		assertFalse(v.equals(v3)); 
		
		v2.setId(null);
		
		assertFalse(v.equals(v2)); 
		
		v.setId(null);
		
		assertFalse(v.equals(v3)); 
		
		assertTrue(v.equals(v2));
		
	}
	
	
	
	
	

}
