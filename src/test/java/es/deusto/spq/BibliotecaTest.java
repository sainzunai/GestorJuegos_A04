package es.deusto.spq;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import es.deusto.spq.dao.GestorJuegos_A04DAO;

public class BibliotecaTest {
	
	Biblioteca b; 
	
	//EJEMPLO DE USO DE MOCKITO 
	private VideoJuego videojuego = Mockito.mock(VideoJuego.class);
	private VideoJuego videojuego2 = Mockito.mock(VideoJuego.class);
	private Usuario user = Mockito.mock(Usuario.class);
	private ArrayList<VideoJuego> listaVideojuegos;
	
	
	
    @Before                                      
    public void setUp() throws Exception {
    	b = new Biblioteca();
    }

    //EJEMPLO DE USO DE MOCKITO --> Añado el mock, lo elimino y veo que el numero de juegos es el mismo
	@Test
	public void testRemJuego() {
		b.addJuego(videojuego);
		b.remJuego(videojuego);
		assertEquals(0, b.numeroDeJuegos());
	}

	//EJEMPLO DE USO DE MOCKITO --> Añado el objeto mock y le digo cómo se tiene que comportar
	@Test
	public void testAddJuego() {
		b.addJuego(videojuego);
		when(videojuego.getId()).thenReturn("4");
		assertEquals(1, b.numeroDeJuegos());
	}
	
	@Test
	public void testAddJuegoRepetido() {
		b.addJuego(videojuego);
		when(videojuego.getId()).thenReturn("4");
		b.addJuego(videojuego);
		assertEquals(1, b.numeroDeJuegos());			
	}
	
	@Test
	public void testAddJuegoDoble() {
		b.addJuego(videojuego);
		when(videojuego.getId()).thenReturn("4");
		b.addJuego(videojuego2);
		when(videojuego2.getId()).thenReturn("2");
		assertEquals(2, b.numeroDeJuegos());			
	}
	
	@Test
	public void testCrearBiblioteca() {
		listaVideojuegos = new ArrayList<>();
		b = new Biblioteca(listaVideojuegos);
		assertNotNull(b);			
	}
	
	@Test
	public void testGetId() {
		assertNull(b.getId());		
	}
	
	@Test
	public void testSetId() {
		b.setId("HOLA");
		assertEquals("HOLA", b.getId());	
	}
	
	//Nada nuevo con Mockito, solo que a la lista le
	@Test	
	public void testGetListaJuegos() {
		b.addJuego(videojuego);
		assertEquals(1, b.getListaJuegos().size());
	}
	
	@Test
	public void testSetListaJuegos() {
		listaVideojuegos = new ArrayList<>();
		listaVideojuegos.add(videojuego);
		b.setListaJuegos(listaVideojuegos);
		assertNotNull(b.getListaJuegos());
	}
	
	@Test	
	public void testGetUser() {
		assertNull(b.getUser());
	}
	
	@Test
	public void testSetUser() {
		b.setUser(user);
		assertNotNull(b.getUser());
	}
	
	@Test
	public void testNumeroDeJuegos() {
		b.addJuego(videojuego);	
		assertEquals(1, b.numeroDeJuegos());	
	}
	
	@Test
	public void testEqualsBien() {
		assertEquals(b, b);	
	}
	
	@Test
	public void testEqualsMal() {
		assertNotEquals(b, videojuego);	
	}
	
	@Test
	public void testEqualsNull() {
		assertNotEquals(b, null);	
	}
	
	@Test
	public void testEqualsDistintoIdNull() {
		Biblioteca b1 = new Biblioteca();
		b1.setId("1");
		assertNotEquals(b, b1);
	}

	@Test
	public void testEqualsDistintoIdNotNull() {
		Biblioteca b1 = new Biblioteca();
		b1.setId("1");
		b.setId("2");
		assertNotEquals(b, b1);
	}
	
	@Test
	public void testEqualsMismoId() {
		Biblioteca b1 = new Biblioteca();
		b1.setId("1");
		b.setId("1");
		assertEquals(b, b1);
	}	
	
	@Test
	public void testEqualsUltimaBranch() {
		b.setId(null);
		Biblioteca b1 = new Biblioteca();
		b1.setId(null);
		assertTrue(b.equals(b1)); 
		
		
	}
	
}
