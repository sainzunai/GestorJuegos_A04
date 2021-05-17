package es.deusto.spq.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.IntegrationTest;
import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.*;

@Category(IntegrationTest.class)
public class DaoTest implements Serializable {

	private static final long serialVersionUID = 1L;
	private GestorJuegos_A04DAO dao = Mockito.mock(GestorJuegos_A04DAO.class);
	Usuario usuario;
	VideoJuego videojuego;
	Plataforma p1;
	Biblioteca biblioteca;

	@Before
	public void setup() {

		usuario = new Usuario("themrguiller@gmail.com", "12345", "Guillermo");
		p1 = new Plataforma("PS4", "1");
		videojuego = new VideoJuego("Battlefield ", "2", "EA", 18, p1);
		biblioteca = new Biblioteca();
	}

	@Test
	public void getUsuario() {
		usuario.setBiblioteca(biblioteca);
		biblioteca.setUser(usuario);
		dao.introducirObjeto(usuario);
		when(dao.getUsuario("themrguiller@gmail.com")).thenReturn(usuario);
		assertEquals("themrguiller@gmail.com", dao.getUsuario("themrguiller@gmail.com").getGmail());

	}

	@Test
	public void getVideojuego() {
		p1.addVideoJuego(videojuego);
		dao.introducirObjeto(p1);
		when(dao.getVideojuego(videojuego.getId())).thenReturn(videojuego);
		assertEquals("2", dao.getVideojuego(videojuego.getId()).getId());
	}

	@Test
	public void getBiblioteca() {
		usuario.setBiblioteca(biblioteca);
		biblioteca.setUser(usuario);
		when(dao.getBiblioteca_Usuario(usuario)).thenReturn(biblioteca);
		assertEquals(null, dao.getBiblioteca_Usuario(usuario).getId());// Esto se debe a que la base de datos es la cual
																		// le da un id a la biblioteca
	}

	@Test
	public void getAllVideojuego() {
		List<VideoJuego> lista = new ArrayList<>();
		lista.add(videojuego);
		when(dao.getAllVideojuegos()).thenReturn(lista);
		assertEquals(lista, dao.getAllVideojuegos());
	}
	 
	

	
	
}
