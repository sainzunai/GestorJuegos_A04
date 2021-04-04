package es.deusto.spq.server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class ServerMain {
	
	//URL en la que se encuentra el server
	public static final String BASE_URI = "http://localhost:8080/gestorJuegos/";

	public static HttpServer startServer() {
		//Lanza el servidor 
		final ResourceConfig rc = new ResourceConfig().packages("es.deusto.spq.server"); 
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}
	
	/**
	 * Main del servidor
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
	}

}
