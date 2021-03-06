package es.deusto.spq.server;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
	
	/**
	 * Devuelve la interfaz IGestorJuegos_A04DAO establecida
	 * @author javil
	 * @return interfaz IGestorJuegos_A04DAO dao
	 */
	public IGestorJuegos_A04DAO getDao() {
		return dao;
	}

	/**
	 * Establece una nueva interfaz IGestorJuegos_A04DAO
	 * @author javil
	 * @param dao objeto GestorJuegos_A04DAO que implemente la interfaz
	 */
	public void setDao(IGestorJuegos_A04DAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Metodo REST que pide a BD un usuario, comprueba si coincide con
	 * la contrasena enviada y lo devuelve
	 * @author javil
	 * @param email email del usuario a recoger
	 * @param pass contrasena introducida por el usuario
	 * @return Si la contrasena es correcta se devuelve el usuario y si no se devuelve null
	 */
	@GET
	@Path("getUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUser(@QueryParam("email")String email, @QueryParam("passw") String pass) {
		Usuario user;
		try {
			user = dao.getUsuario(email);
			System.out.println("Obteniedo el usuario con email: " + user.getGmail());
		} catch (Exception e) {
			return null;
		}
		
		if(pass.equals("_")) {//esto solo es una comprobacion de username asi que nos saltamos el resto
			return user;
		}
		if (user.getContrasena().equals(pass)) {
			System.out.println("Contrasena correcta, devolviendo usuario...");
			return user;
		}else {
			System.out.println("Error, contrasena incorrecta, devolviendo null...");
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
	 System.out.println("Anadiendo un nuevo usuario con email: " + user.getGmail());
	 //Creamos una biblioteca vacia y relacionamos el usuario y la biblioteca entre si para guardar en BD 
	 Biblioteca b = new Biblioteca();
	 user.setBiblioteca(b);
	 b.setUser(user);
	 try {
		 dao.introducirObjeto(user);
	} catch (Exception e) {
		
	}
	
	}
	
	/**
	 * Metodo REST para realizar el update de la Biblioteca en BD
	 * @param userBiblio Objeto Biblioteca que realizar el update
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(Biblioteca userBiblio) {
		System.out.println("Realizando el update de la biblioteca para el usuario");
		
		dao.updateBiblioteca(userBiblio);
	}
}
