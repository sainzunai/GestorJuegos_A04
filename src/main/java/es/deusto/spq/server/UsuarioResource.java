package es.deusto.spq.server;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import es.deusto.spq.Biblioteca;
import es.deusto.spq.Usuario;
import es.deusto.spq.dao.GestorJuegos_A04DAO;
import es.deusto.spq.dao.IGestorJuegos_A04DAO;

@Path("usuarios")
public class UsuarioResource {
	
	private IGestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
	
	public IGestorJuegos_A04DAO getDao() {
		return dao;
	}

	public void setDao(IGestorJuegos_A04DAO dao) {
		this.dao = dao;
	}

	
	/**
	 * Metodo REST que pide a BD un usuario, comprueba si coincide con
	 * la contraseña enviada y lo devuelve
	 * @param email email del usuario a recoger
	 * @param pass contraseña introducida por el usuario
	 * @return Si la contraseña es correcta se devuelve el usuario y si no se devuelve null
	 */
	@GET
	@Path("getUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUser(@QueryParam("email")String email, @QueryParam("passw") String pass) {
		Usuario user = dao.getUsuario(email);
		System.out.println("Obteniedo el usuario con email: " + user.getGmail());
		
		if (user.getContrasena().equals(pass)) {
			System.out.println("Contraseña correcta, devolviendo usuario...");
			return user;
		}else {
			System.out.println("Error, contraseña incorrecta, devolviendo null...");
			return null;
		}
	}
	
	/**
	 * Metodo REST que inserta un usuario en BD
	 * @param user Objeto Usuario a insertar en BD
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(Usuario user) {
	 System.out.println("Añadiendo un nuevo usuario con email: " + user.getGmail());
	 dao.introducirObjeto(user);
	}
}
