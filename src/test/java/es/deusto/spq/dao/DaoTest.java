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
	Usuario user = new Usuario("themrguiller@gmail.com", "Hackeado");
	Biblioteca biblio= new Biblioteca();
	biblio.setUser(user);
	user.setBiblioteca(biblio);
	dao.introducirObjeto(user);
	Usuario prueba=dao.getUsuario(user.getGmail());
	System.out.println("El usuario introducido es:"+prueba.getGmail()+"\t"+prueba.getContrasena()+"\t"+prueba.getBiblioteca().getId());
	Biblioteca pruebabb= dao.getBiblioteca_Usuario(prueba);
	*/
	}

	
	
}
