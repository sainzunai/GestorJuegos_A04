package es.deusto.spq.dao;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
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
	public void setup() {
		videojuegos=new ArrayList<>();
		dao = new GestorJuegos_A04DAO();
		p= new Plataforma("PS4","1");
		p1= new Plataforma("Xbox","2");
		game= new VideoJuego("Battlefield","1","EA",18,p);
		game1= new VideoJuego("Battlefield4","2","EA",18,p);
		b= new Biblioteca("1");	
	}
	@Test
	public void testIntroducir() {
				
			p.addVideoJuego(game);
			p.addVideoJuego(game1);
			
			videojuegos.add(game);
			videojuegos.add(game1);
			
			dao.introducirObjeto(p);
			dao.introducirObjeto(p1);
			dao.introducirObjeto(b);
			
			assertEquals(dao.getVideojuego("1").getId(),game.getId());
			assertEquals(dao.getVideojuego("2").getId(),game1.getId());
			dao.deleteAll();
	}

	@Test
	public void getTest(){
		Plataforma p2 = new Plataforma("Nintendo","3");
		VideoJuego v1 = new VideoJuego("Battlefield4","3","EA",18,p2);
		p2.addVideoJuego(v1);
		videojuegos.add(v1);
		dao.introducirObjeto(p2);
		VideoJuego v =dao.getVideojuego(v1.getId());
		assertEquals(v1.getId() ,v.getId() );
		dao.deleteAll();
	}
	
	
	@Test
	public void getAllTest(){
		videojuegos.clear();
		p.addVideoJuego(game);
		p.addVideoJuego(game1);
		videojuegos.add(game);
		videojuegos.add(game1);
		
		dao.introducirObjeto(p);
		List<VideoJuego> lista = dao.getAllVideojuegos();
		System.out.println(lista);
		for(int i=0;i<lista.size();i++) {
			assertEquals(lista.get(i).getId(),videojuegos.get(i).getId());
		}
		
		dao.deleteAll();
	}
	/*
	@Test
	public void updateTest() {
		System.out.println("Realizando update");
		List<VideoJuego> lista = new ArrayList<>();
		p= new Plataforma("PS4","1");
		game= new VideoJuego("Battlefield","1","EA",18,p);
		b=new Biblioteca("1",lista );
		dao.introducirObjeto(b);
		p.addVideoJuego(game);
		dao.introducirObjeto(p);
		System.out.println(b);
		b.addJuego(game);
		System.out.println(b.getListaJuegos());
		dao.updateBiblioteca(b, game);
	}
	*/
	
}
