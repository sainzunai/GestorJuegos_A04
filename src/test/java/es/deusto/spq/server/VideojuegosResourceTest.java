
package es.deusto.spq.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.IntegrationTest;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.GestorJuegos_A04DAO;
import es.deusto.spq.dao.IGestorJuegos_A04DAO;

@Category(IntegrationTest.class)
public class VideojuegosResourceTest {

	private GestorJuegos_A04DAO dao = Mockito.mock(GestorJuegos_A04DAO.class);
	private VideojuegosResource vr;
	private List<VideoJuego> v;

	@Before
	public void setUp() {

		vr = new VideojuegosResource();

		vr.setDao(dao);

		v = new ArrayList<VideoJuego>();

		v.add(new VideoJuego("FIFA", "1", "EA", 3, null));

	}

	@Test
	public void testSetDao() {
		IGestorJuegos_A04DAO daoTest = new GestorJuegos_A04DAO();
		vr.setDao(daoTest);
		assertEquals(daoTest, vr.getDao());
	}

	@Test
	public void testGetDao() {

		assertEquals(dao, vr.getDao());
	}

	@Test
	public void testGetVideojuegos() {

		when(dao.getAllVideojuegos()).thenReturn(v);

		assertEquals("FIFA", vr.getVideojuegos().get(0).getNombre());
	}

}
