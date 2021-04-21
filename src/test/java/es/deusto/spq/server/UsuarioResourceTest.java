package es.deusto.spq.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import es.deusto.spq.Usuario;
import es.deusto.spq.dao.GestorJuegos_A04DAO;
import es.deusto.spq.dao.IGestorJuegos_A04DAO;

public class UsuarioResourceTest {

	private GestorJuegos_A04DAO dao = Mockito.mock(GestorJuegos_A04DAO.class);
	private UsuarioResource ur;
	private Usuario u;
	
	@Before
	public void setUp() {
		ur = new UsuarioResource();
		ur.setDao(dao);
		u = new Usuario("javi@gmail.com", "1234","Javi");
	}
	
	@Test 
	public void testSetDao() {
		IGestorJuegos_A04DAO daoTest = new GestorJuegos_A04DAO();
		ur.setDao(daoTest);
		assertEquals(daoTest, ur.getDao()); 
	}
	
	@Test 
	public void testGetDao() {
		
		assertEquals(dao, ur.getDao()); 
	}
	
	@Test
	public void testGetUser() {
		when(dao.getUsuario("javi@gmail.com")).thenReturn(u);
		when(dao.getBiblioteca_Usuario(u)).thenReturn(null);
		
		assertEquals("javi@gmail.com", ur.getUser("javi@gmail.com").getGmail());
		
	}
	
}
