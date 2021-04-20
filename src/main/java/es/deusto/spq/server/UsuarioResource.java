package es.deusto.spq.server;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import es.deusto.spq.Biblioteca;
import es.deusto.spq.Usuario;
import es.deusto.spq.dao.IGestorJuegos_A04DAO;

@Path("usuarios")
public class UsuarioResource {
	
	private IGestorJuegos_A04DAO dao;
	
	public UsuarioResource(IGestorJuegos_A04DAO dao) {
		this.dao = dao;
	}

	/**
	 * Método que devuelve un usuario con su Biblioteca correspondiente
	 * @param email String que indica el email del usuario
	 * @return Objeto Usuario recogido de BD con ese mismo email
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUser(String email) {
		Usuario user = dao.getUsuario(email);
		System.out.println("Obteniedo el usuario con email: " + user.getGmail());
		Biblioteca b = dao.getBiblioteca_Usuario(user);
		user.setBiblioteca(b);
		
		return user;
	}
	
	/**
	 * Método que inserta un usuario en BD
	 * @param user Objeto Usuario a insertar en BD
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(Usuario user) {
	 System.out.println("Añadiendo un nuevo usuario con email: " + user.getGmail());
	 dao.introducirObjeto(user);
	}
}
