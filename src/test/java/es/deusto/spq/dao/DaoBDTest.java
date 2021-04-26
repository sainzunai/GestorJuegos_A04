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
public class DaoBDTest implements Serializable{
	private static final long serialVersionUID = 1L;
	private static GestorJuegos_A04DAO dao;
	private static Usuario usuario;
	@BeforeClass
	public static void setup() {
		
		dao=new GestorJuegos_A04DAO();
		Usuario user = new Usuario("test@gmail.com", "test123", "TEST");
		Biblioteca biblio = new  Biblioteca();
		biblio.setUser(user);
		user.setBiblioteca(biblio);
		dao.introducirObjeto(user);
		usuario=dao.getUsuario("test@gmail.com");//Por si acaso
	}
	@AfterClass
	public static void finalcase() {
		dao.deleteUsuario(usuario);
	}
	@Test
	public void getUsuario() {
		usuario=dao.getUsuario("test@gmail.com");
		assertEquals("test@gmail.com", usuario.getGmail());
	}
	@Test
	public void getVideojuego() {
		assertEquals("1", dao.getVideojuego("1").getId());
	}
	@Test
	public void getBiblioteca() {
		assertEquals(usuario.getBiblioteca().getId(),dao.getBiblioteca_Usuario(usuario).getId());
	}
	@Test
	public void getAllVideojuego() {
		assertEquals(10, dao.getAllVideojuegos().size());
	}
	@Test
	public void get_Biblioteca_Videojuego() {
		assertEquals(usuario.getBiblioteca().getId(), dao.getBiblioteca_Usuario(usuario).getId());
	}
	/*
		Usuario user = new Usuario("themrguiller@gmail.com", "Hackeado","Guillermo");
		Plataforma p1 = new Plataforma("PS4", "1");
		VideoJuego v1 = new VideoJuego("Battlefield V", "1", "EA", 18, p1); 
		VideoJuego v2 = new VideoJuego("Battlefield ", "2", "EA", 18, p1);
		VideoJuego v3= new VideoJuego("Juego de mofeta", "4", "MierdiJuegos", 0, p1);
		VideoJuego v4=new VideoJuego("Juego de mofeta:La venganza", "5", "MierdiJuegos", 0, p1);
		p1.addVideoJuego(v1);
		p1.addVideoJuego(v2);
		p1.addVideoJuego(v3);
		p1.addVideoJuego(v4);
		Biblioteca biblio= new Biblioteca();
		biblio.setUser(user);
		v1.addBiblioteca(biblio);
		biblio.addJuego(v1);
		v1.addBiblioteca(biblio);
		user.setBiblioteca(biblio);
		dao.introducirObjeto(user);
		 
		Usuario prueba=dao.getUsuario(user.getGmail());
		System.out.println("El usuario introducido es:"+prueba.getGmail()+"\t"+prueba.getContrasena()+"\t"+prueba.getNombre()+"\t"+prueba.getBiblioteca().getId()+"\t"+prueba.getBiblioteca().getListaJuegos());
		
		dao.updateBiblioteca_Videojuego(prueba.getBiblioteca(), v2);
		prueba.setBiblioteca(dao.getBiblioteca_Usuario(prueba));
		System.out.println("Biblioteca actualizada,lista de videojuegos:"+prueba.getBiblioteca().getListaJuegos());
		
		
		Biblioteca b= new Biblioteca();
		Usuario user1 = new Usuario("themrguiller22@gmail.com", "Hackeado","Guillermo");
		user1.setBiblioteca(b);
		b.setUser(user1);
		
		dao.introducirObjeto(user1);
		
		Usuario user2=dao.getUsuario(user1.getGmail());
		
		System.out.println("XD:"+user2.getBiblioteca().getId());
		List<Biblioteca> lista = new ArrayList<>();
		v3.setBiblioteca(lista);
		v3.addBiblioteca(user2.getBiblioteca());
		user2.getBiblioteca().addJuego(v3);
		System.out.println("A ver si no casca"+v3.getBiblioteca());
		v4.setBiblioteca(lista);
		v4.addBiblioteca(user2.getBiblioteca());
		user2.getBiblioteca().addJuego(v4);
		System.out.println(user2.getBiblioteca().getListaJuegos());
		dao.updateBiblioteca(user2.getBiblioteca());
		dao.updateBiblioteca(prueba.getBiblioteca());
		*/
	
}
