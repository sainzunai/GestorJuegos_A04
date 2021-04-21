
package es.deusto.spq.server;

import static org.junit.Assert.*; import static org.mockito.Mockito.when;

import java.util.ArrayList; import java.util.Arrays; import java.util.List;

import org.junit.Before; import org.junit.Test; import org.mockito.Mockito;


import es.deusto.spq.Plataforma; import es.deusto.spq.VideoJuego; import
es.deusto.spq.dao.GestorJuegos_A04DAO;

public class VideojuegosResourceTest {

	private GestorJuegos_A04DAO dao = Mockito.mock(GestorJuegos_A04DAO.class);
	private VideojuegosResource vr; 
	private List<VideoJuego> v;

	@Before 
	public void setUp() {
		
		vr = new VideojuegosResource();
		
		vr.setDAO(dao);
		
		v = new ArrayList<VideoJuego>(); 
		
		v.add(new VideoJuego("FIFA", "1", "EA", 3, null)); 
		
	}

	@Test 
	public void testGetVideojuegos() throws InterruptedException {

		when(dao.getAllVideojuegos()).thenReturn(v);

		assertEquals("FIFA", vr.getVideojuegos().get(0).getNombre()); 
	}

}
