package es.deusto.spq.server;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

@Category(IntegrationTest.class)
public class ServerResourcesTest {

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	private static HttpServer server;
	private static WebTarget target;
	private static ServerResources sr;

	@BeforeClass
	public static void setUp() throws Exception {
		server = ServerMain.startServer();
		Client cliente = ClientBuilder.newClient();
		target = cliente.target(ServerMain.BASE_URI);
		sr = new ServerResources();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		server.stop();
	}

	/**
	 * Test para comprobar la funcionalidad del metodo get it
	 */
	@Test
	public void testGetIt() {
		assertEquals("Hola desde Jersey: Servidor de Gestor de Juegos", sr.getIt());
	}

	/**
	 * Test de performance basico para el metodo que devuelve un string
	 */
	@Test
	@PerfTest(invocations = 1000, threads = 40)
	public void testGetItPerformance() {
		GenericType<String> genericType = new GenericType<String>() {
		};
		String response = target.path("serverResources").request(MediaType.TEXT_PLAIN).get(genericType);
		assertEquals("Hola desde Jersey: Servidor de Gestor de Juegos", response);
	}

}
