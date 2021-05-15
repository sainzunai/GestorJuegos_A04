package es.deusto.spq.ventanas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.IntegrationTest;
import categories.VentanasTest;

import es.deusto.spq.Usuario;

@Category(VentanasTest.class)
public class ControladorVentanaPrincipalTest {

	VentanaPrincipal v;

	VentanaInicioSesion vs;

	VentanaRegister vr;
	ControladorVentanaPrincipal cvp;
	private Usuario user = Mockito.mock(Usuario.class);

	@Before
	public void setUp() throws Exception {

		v = new VentanaPrincipal(user);

		vs = new VentanaInicioSesion();

		vr = new VentanaRegister();
		cvp = new ControladorVentanaPrincipal(v, user);

	}

	@Test
	public void testIsCarga() { // ASIER
		cvp.setCarga(true);
		assertEquals(true, cvp.isCarga());
		cvp.setCarga(false);
		assertEquals(false, cvp.isCarga());
	}

	@Test
	public void testIsEstamosEnHome() { // ASIER
		cvp.setEstamosEnHome(true);
		assertEquals(true, cvp.isEstamosEnHome());
		cvp.setEstamosEnHome(false);
		assertEquals(false, cvp.isEstamosEnHome());
	}

	@Test
	public void testIsEstamosEnBiblio() { // ASIER
		cvp.setEstamosEnBiblio(true);
		assertEquals(true, cvp.isEstamosEnBiblio());
		cvp.setEstamosEnBiblio(false);
		assertEquals(false, cvp.isEstamosEnBiblio());
	}
}
