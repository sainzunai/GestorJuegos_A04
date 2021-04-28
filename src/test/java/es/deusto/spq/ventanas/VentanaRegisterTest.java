package es.deusto.spq.ventanas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import categories.VentanasTest;

@Category(VentanasTest.class)
public class VentanaRegisterTest {
	VentanaRegister v;
	
	@Before
	public void setup() {
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
	
}
