package es.deusto.spq.server;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import es.deusto.spq.VideoJuego;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("videojuegos")
public class VideojuegosResource {

	/**
	 * Este método devolverá la lista completa de videojuegos que haya en la
	 * BD al usuario. Se devolverá en formato JSON
	 * @return List<VideoJuego> Lista de videojuegos 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VideoJuego> getVideojuegos() {
	 
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Query<VideoJuego> q = pm.newQuery(VideoJuego.class);
		q.setOrdering("nombre desc");
		
		List<VideoJuego> videojuegos = q.executeList();
		pm.close();
		return videojuegos;
	}
	
	
}