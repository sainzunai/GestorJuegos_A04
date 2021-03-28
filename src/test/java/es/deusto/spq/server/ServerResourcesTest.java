package es.deusto.spq.server;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServerResourcesTest {

	ServerResources sr = new ServerResources();
	
	@Test
	public void test() {
		assertEquals("Hola desde Jersey: Servidor de Gestor de Juegos", sr.getIt());
	}

}
