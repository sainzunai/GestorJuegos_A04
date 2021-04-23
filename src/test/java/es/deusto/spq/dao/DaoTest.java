package es.deusto.spq.dao;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.*;
public class DaoTest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	GestorJuegos_A04DAO dao; 

	@Before
	public void setup() {
		
	dao = new GestorJuegos_A04DAO();
		
		
	}
	@Test
	public void testIntroducir() {
	/*
	Usuario user = new Usuario("themrguiller@gmail.com", "Hackeado","Guillermo");
	Plataforma p1 = new Plataforma("PS4", "1");
	VideoJuego v1 = new VideoJuego("Battlefield V", "1", "EA", 18, p1); 
	VideoJuego v2 = new VideoJuego("Battlefield ", "2", "EA", 18, p1);
	p1.addVideoJuego(v1);
	p1.addVideoJuego(v2);
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
	user1=dao.getUsuario(user1.getGmail());
	user1.getBiblioteca().addJuego(new VideoJuego("Juego de mofeta", "4", "MierdiJuegos", 0, p1));
	user1.getBiblioteca().addJuego(new VideoJuego("Juego de mofeta:La venganza", "5", "MierdiJuegos", 0, p1));
	dao.updateBiblioteca(user1.getBiblioteca());
	*/
	}
	

	
	
}
