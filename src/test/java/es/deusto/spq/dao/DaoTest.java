package es.deusto.spq.dao;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.Test;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.*;
public class DaoTest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
	@Test
	public void test() {
		Plataforma p= new Plataforma("PS4","1");
		Plataforma p1= new Plataforma("Xbox","2");
		VideoJuego game = new VideoJuego("Battlefield","1","EA",18,p);
		VideoJuego game1 = new VideoJuego("Battlefield","2","EA",18,p);
		p.addVideoJuego(game);
		p.addVideoJuego(game1);
		dao.introducirObjeto(p);
		dao.introducirObjeto(p1);
		Biblioteca b= new Biblioteca("1");
		b.addVideoJuego(game);
		dao.introducirObjeto(b);
		//dao.deleteAll();
		
		assertTrue(true);
		
	}

}
