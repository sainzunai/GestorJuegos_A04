package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.GestorJuegos_A04DAO;

public class VideojuegosResourceTest {
	
	GestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
	@Test
	public void test() throws InterruptedException {
		/*
		dao.deleteAll(); //Dejamos limpia la BD
		
		//Crear los objetos a introducir
		Plataforma p = new Plataforma("PS4","1");
		VideoJuego game = new VideoJuego("FIFA 20","1","EA",3, p);
		//Introducirlos en BD
		dao.introducirObjeto(game);
		
		//Lista esperada de videojuegos
		List<VideoJuego> expected = new ArrayList<>();
		expected.add(game);

		//Creamos el resource del servidor
		VideojuegosResource vr = new VideojuegosResource();
		List<VideoJuego> actual = vr.getVideojuegos();
		//System.out.println(v.get(1).getNombre());
		
		//System.out.println(expected);
		
		dao.deleteAll();
		assertEquals(actual.get(0).getId(), expected.get(0).getId());
	
		//fail("Not yet implemented");
		 
		 */
	}

}
