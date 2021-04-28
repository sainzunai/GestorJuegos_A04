package es.deusto.spq.server;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.AfterClass;
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
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	static UsuarioResource usr;
	static VideojuegosResource vr;
	static Usuario user;
	static Usuario test;
	static VideoJuego v1;
	static Biblioteca biblio;
	static Biblioteca biblio1;
	static GestorJuegos_A04DAO dao;
	static Plataforma p1;
	@BeforeClass
	public static void setup() {
		dao = new GestorJuegos_A04DAO();
		usr = new UsuarioResource();
		vr = new VideojuegosResource();
		user = new Usuario("test@gmail.com","Test", "test");
		biblio = new Biblioteca();
		biblio1 = new Biblioteca();
		biblio.setUser(user);
		user.setBiblioteca(biblio);
		dao.introducirObjeto(user);
		user = dao.getUsuario(user.getGmail());
		
		p1 = new Plataforma("PS4", "1");
		v1=new VideoJuego("Battlefield V", "1", "EA", 18, p1);
	}
	@AfterClass
	public static void setermino() {
		
		dao.deleteUsuario(test);
		
		dao.deleteUsuario(user);
	}
	@Before
	public void setit() {
		test = new Usuario("test@com", "12345", "test1");
		biblio1.setUser(test);
		test.setBiblioteca(biblio1);
		dao.introducirObjeto(test);
		test=dao.getUsuario("test@com");
	}
	@After
	public void finalizar() {
		dao.deleteUsuario(test);
		dao.deleteUsuario(user);
	}
	
	@PerfTest(invocations = 500, threads = 20)
	@Test
	public void testGetUsuario() {
		assertEquals("test@com", usr.getUser("test@com", "12345").getGmail());
	}
	
	@Test
	public void testaddUser() {
		usr.addUser(test);
	}
	
	@Test
	public void testUpdateUser() {
		
		test.getBiblioteca().addJuego(v1);
		usr.updateUser(test.getBiblioteca());
	}
	
	@PerfTest(invocations = 500, threads = 20)
	@Test
	public void testGetAllVideojuego() {
		assertEquals(10, vr.getVideojuegos().size());
	}
}
