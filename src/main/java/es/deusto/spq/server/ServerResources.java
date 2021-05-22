package es.deusto.spq.server;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("serverResources")
public class ServerResources {
		
	/**
	 * Metodo encargado de gestionar las HTTP GET para la clase Server Resources. 
	 * Se devolverá al usuario un texto plano de bienvenida
	 * @author javil
	 * @return String en texto plano 
	 */
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hola desde Jersey: Servidor de Gestor de Juegos";
    }
	

}
