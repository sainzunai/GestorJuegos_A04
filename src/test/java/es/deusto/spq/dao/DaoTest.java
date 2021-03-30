package es.deusto.spq.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.*;
public class DaoTest {
	GestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
	@Test
	public void test() {
		Plataforma p= new Plataforma("PS4","1");
		Plataforma p1= new Plataforma("PS4","2");
		VideoJuego game = new VideoJuego("Battlefield","1","EA",18);
		VideoJuego game1 = new VideoJuego("Battlefield","2","EA",18);
		game.addPlataforma(p1);
		//game1.addPlataforma(p);
		
		dao.introducirObjeto(game);
		
		dao.introducirObjeto(game1);
		game1.setNombre("Cod");
		dao.introducirObjeto(p);
		game1.addPlataforma(p);
		dao.updateVideojuego(game1);
		assertTrue(true);
		
	}

}
