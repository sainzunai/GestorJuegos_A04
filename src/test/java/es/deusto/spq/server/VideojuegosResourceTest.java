package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Test;

import es.deusto.spq.VideoJuego;

public class VideojuegosResourceTest {
	
	private void prepareData() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			VideoJuego videojuego = new VideoJuego("Fifa 20", "fif20ps4", "Electronic Arts", 3, null);
			pm.makePersistent(videojuego);
			
			tx.commit();
		}finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Test
	public void test() {
		VideojuegosResource vr = new VideojuegosResource();
		List<VideoJuego> v = vr.getVideojuegos();
		System.out.println(v.get(1).getNombre());
		
		assertEquals(vr.getVideojuegos().get(0).getNombre(), "Fifa 20");
		//fail("Not yet implemented");
	}

}
