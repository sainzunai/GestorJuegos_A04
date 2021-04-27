package es.deusto.spq.server;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.GestorJuegos_A04DAO;

@Category(IntegrationTest.class)
public class ServerTest {
	/*
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	static UsuarioResource usr;
	static VideojuegosResource vr;
	static Usuario user;
	static Usuario test;
	static Biblioteca biblio;
	static GestorJuegos_A04DAO dao;
	static Plataforma p1;
	@BeforeClass
	public static void setup() {
		dao = new GestorJuegos_A04DAO();
		usr = new UsuarioResource();
		vr = new VideojuegosResource();
		user = new Usuario("test@gmail.com","Test", "test");
		biblio = new Biblioteca();
		biblio.setUser(user);
		user.setBiblioteca(biblio);
		dao.introducirObjeto(user);
		user = dao.getUsuario(user.getGmail());
		test = new Usuario("test@com", "12345", "test1");
		p1 = new Plataforma("PS4", "1");
	}
	@Before
	public void setit() {
		dao.introducirObjeto(test);
	}
	@After
	public void finalizar() {
		dao.deleteUsuario(test);
	}
	
	@PerfTest(invocations = 500, threads = 20)
	@Test
	public void testGetUsuario() {
		assertEquals("test@gmail.com", usr.getUser("test@gmail.com", "Test").getGmail());
	}
	
	@PerfTest(invocations = 500, threads = 20)
	@Test
	public void testaddUser() {
		biblio = new Biblioteca();
		biblio.setUser(test);
		test.setBiblioteca(biblio);
		usr.addUser(test);
	}
	
	@PerfTest(invocations = 500, threads = 20)
	@Test
	public void testUpdateUser() {
		
		user.getBiblioteca().addJuego(new VideoJuego("Battlefield V", "1", "EA", 18, p1));
		usr.updateUser(user.getBiblioteca());
	}
	*/
}
