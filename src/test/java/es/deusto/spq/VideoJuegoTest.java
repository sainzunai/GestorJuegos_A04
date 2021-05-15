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

	private List<Biblioteca> biblioteca = new ArrayList<>();
	private Biblioteca b = Mockito.mock(Biblioteca.class);

	private VideoJuego v;
	private VideoJuego v2;
	private VideoJuego v3;
	private VideoJuego v4;
	private VideoJuego v5;

	@Before
	public void setUp() throws Exception {

		v = new VideoJuego("Fifa21", "F21", "Ubisoft", 3, null);

		v2 = new VideoJuego("FF4", "F4", "Nintendo", 3, null, "hola");

		v3 = new VideoJuego();

		v4 = new VideoJuego("FIfa 18", "F18", "Oracle", 6, null);

		v5 = new VideoJuego("PRO 12", "P12", "PEs", 8, null, "caratula");

	}

	@Test
	public void testCalcularNotaMedia() {

	}

	@Test
	public void testGetCaratula() {

		assertEquals(" ", v.getCaratula());

		v.setCaratula("foto_caratula.png");

		assertEquals(v.getCaratula(), "foto_caratula.png");

	}

	// Test que faltaban del primer sprint.
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

		// assertEquals(b, v3.getBiblioteca());

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
	public void testGetNotaMedia() {

		v.addNota(10);
		v.addNota(3);
		assertEquals(v.calculoNotaMedia(), 6.5, 1.0);
	}

	@Test
	public void testSetNumNotas() {

		v.setNumeroNotas(56);

		assertEquals(56, v.getNumeroNotas());

	}

	@Test
	public void testGetNumNotas() {

		v.setNumeroNotas(561);

		assertEquals(561, v.getNumeroNotas());

	}

	@Test
	public void testSetSumaNotas() {

		v.setSumaNotas(0);

		assertEquals(v.getSumaNotas(), 0);

	}

	@Test
	public void testGetSumaNotas() {

		v.setSumaNotas(9);

		assertEquals(v.getSumaNotas(), 9);

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
