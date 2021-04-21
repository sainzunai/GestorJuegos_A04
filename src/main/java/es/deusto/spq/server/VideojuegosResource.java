package es.deusto.spq.server;

import java.util.List;

import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.GestorJuegos_A04DAO;
import es.deusto.spq.dao.IGestorJuegos_A04DAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("videojuegos")
public class VideojuegosResource {

	private IGestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
	
	/**
	 * Este método devolverá la lista completa de videojuegos que haya en la
	 * BD al usuario. Se devolverá en formato JSON
	 * @return List<VideoJuego> Lista de videojuegos 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VideoJuego> getVideojuegos() {
		
		List<VideoJuego> videojuegos = dao.getAllVideojuegos();
		
		return videojuegos;
	}
	
	public void setDao(IGestorJuegos_A04DAO dao) {
		this.dao = dao; 
	}
	
	public IGestorJuegos_A04DAO getDao() {
		return dao;
	}
	
}
