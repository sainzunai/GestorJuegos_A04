package es.deusto.spq.dao;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.IntegrationTest;
import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;

@Category(IntegrationTest.class)
public class DaoBDTest implements Serializable {
	private static final long serialVersionUID = 1L;
	private static GestorJuegos_A04DAO dao;
	private static Usuario usuario;

	@BeforeClass
	public static void setup() {

		dao = new GestorJuegos_A04DAO();
		Usuario user = new Usuario("test@gmail.com", "test123", "TEST");
		Biblioteca biblio = new Biblioteca();
		biblio.setUser(user);
		user.setBiblioteca(biblio);
		dao.introducirObjeto(user);
		usuario = dao.getUsuario("test@gmail.com");// Por si acaso
	}

	@AfterClass
	public static void finalcase() {
		dao.deleteUsuario(usuario);
	}

	@Test
	public void getUsuario() {
		usuario = dao.getUsuario("test@gmail.com");
		assertEquals("test@gmail.com", usuario.getGmail());
	}

	@Test
	public void getVideojuego() {
		assertEquals("1", dao.getVideojuego("1").getId());
	}

	@Test
	public void getBiblioteca() {
		assertEquals(usuario.getBiblioteca().getId(), dao.getBiblioteca_Usuario(usuario).getId());
	}

	@Test
	public void getAllVideojuego() {
		assertEquals(10, dao.getAllVideojuegos().size());
	}

	@Test
	public void get_Biblioteca_Videojuego() {
		assertEquals(usuario.getBiblioteca().getId(), dao.getBiblioteca_Usuario(usuario).getId());
	}

}
