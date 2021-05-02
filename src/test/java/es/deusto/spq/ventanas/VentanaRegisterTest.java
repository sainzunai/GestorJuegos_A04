package es.deusto.spq.ventanas;

import static org.junit.Assert.assertEquals;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import categories.VentanasTest;
import es.deusto.spq.dao.GestorJuegos_A04DAO;
import es.deusto.spq.server.ServerMain;

@Category(VentanasTest.class)//para que el test no se lanze cuando haves mvn test. Solo con mvn verify.
public class VentanaRegisterTest {
	private static VentanaRegister v;
	private static HttpServer server;
	
	
	
	@BeforeClass
	public static void setup() {
		//lanzar server
		server = ServerMain.startServer();
		//lanzar ventana
		v = new VentanaRegister();
	}
	
	@Test
	public void testValidacionSecu() {
		String nombreUsuario1 = "Unai";
		String nombreUsuario2 = "Unai";
		assertEquals(nombreUsuario1, v.secu(nombreUsuario2));
	}
	
	@Test
	public void testCorreccionSecu() {
		String nombreUsuario1 = "Unai!";
//		String nombreUsuario2 = "Unai";
		assertEquals("Unai", v.secu(nombreUsuario1));	//no se permiten las exclamaciones
	}
	
	@Test
	public void testResetCampos() {
		String def = "";
		v.tfNombre.setText("esto deberia borrarse");
		v.taAnyadir.setText("y esto tambien");
		v.resetCampos();
		assertEquals(v.tfNombre.getText(), "");
		assertEquals(v.taAnyadir.getText(), "");
		
	}
	
	@Test
	public void testCrearUsuario() {
		v.tfNombre.setText("Unai");
		v.tfContrasenya.setText("TestPasswd");
		v.tfRepetirContrasenya.setText("TestPasswd");
		
		v.cbTerminos.setSelected(false);
		
//		v.cbFecha.setSelectedIndex(0);
//		v.cbMes.setSelectedIndex(0);
//		v.cbAnyo.setSelectedIndex(0);
//		v.resadd.setText("");
		v.crearUsuario();
		assertEquals(v.newUser.getNombre(), "Unai");
	}
	
	/**
	 * Para apagar el servidor cuando termina el test. Sin este metodo no funciona.
	 */
	@AfterClass
	public static void tearDown() {
		server.stop();
		//GestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
		//dao.deleteUsuario(dao.getUsuario("test@hotmail.com"));
	}
	
}
