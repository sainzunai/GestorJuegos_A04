package es.deusto.spq.dao;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.List;

import org.junit.Before;
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
	GestorJuegos_A04DAO dao; 
	Plataforma p;
	Plataforma p1;
	VideoJuego game; 
	VideoJuego game1; 
	Biblioteca b;
	List<VideoJuego> videojuegos;
	 @Before                                         
	    public void setUp() throws Exception {
		dao = new GestorJuegos_A04DAO();
		p= new Plataforma("PS4","1");
		p1= new Plataforma("Xbox","2");
		game= new VideoJuego("Battlefield","1","EA",18,p);
		game1= new VideoJuego("Battlefield","2","EA",18,p);
		b= new Biblioteca("1");	 
		
	    }

	@Test
	public void testIntroducir() {
		try {
			p.addVideoJuego(game);
			p.addVideoJuego(game1);
			videojuegos.add(game);
			videojuegos.add(game1);
			
			dao.introducirObjeto(p);
			dao.introducirObjeto(p1);
			dao.introducirObjeto(b);
			}
			catch(Exception e) {
				System.out.println("Something went wrong:"+ e.getMessage());
				assertFalse(false);
			}
		assertTrue(true);	
	}
	@Test
	public void getTest(){
		VideoJuego v1 = new VideoJuego("Battlefield4","3","EA",18,p);
		p.addVideoJuego(v1);
		dao.introducirObjeto(p);
		VideoJuego v =dao.getVideojuego(v1.getId());
		assertEquals(game.getId() ,v.getId() );
	}
	/*
	@Test
	public void getAllTest(){
		boolean verdadero=true;
		List<VideoJuego> lista = dao.getAllVideojuegos();
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).equals(videojuegos.get(i))) {
				verdadero=true;
			}else {
				verdadero=false;
				break;
			}
		}
		assertTrue(verdadero);
	}
	@Test
	public void deleteTest() {
		dao.deleteAllVideojuegos();
		List<VideoJuego> v=dao.getAllVideojuegos();
		if (v.equals(null)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}
	@Test
	public void deleteAllTest() {
		dao.introducirObjeto(game);
		dao.deleteAll();
		VideoJuego v=dao.getVideojuego(game.getId());
		if (v.equals(null)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}
	
	*/
}
