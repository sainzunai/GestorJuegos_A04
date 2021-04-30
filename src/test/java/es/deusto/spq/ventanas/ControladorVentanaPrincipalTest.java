package es.deusto.spq.ventanas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.IntegrationTest;
import categories.VentanasTest;
import es.deusto.spq.Calificacion;
import es.deusto.spq.Usuario;

@Category(VentanasTest.class)
public class ControladorVentanaPrincipalTest {
	
	VentanaPrincipal v;
	
	VentanaInicioSesion vs; 
	
	VentanaRegister vr; 
	
	private Usuario user = Mockito.mock(Usuario.class);	
	
    @Before                                         
    public void setUp() throws Exception {
    	
    	v = new VentanaPrincipal(user); 
    	
    	vs = new VentanaInicioSesion(); 
    	
    	vr = new VentanaRegister(); 

    }
	
	@Test
	public void testIsCarga() { //ASIER 

		
	}
	
	@Test
	public void testSetCarga() { //ASIER 

		
	}
	
	@Test
	public void testIsEstamosEnHome() { //ASIER 

		
	}
	
	@Test
	public void testSetEstamosEnHome() { //ASIER 

		
	}
	
	@Test
	public void testIsEstamosEnBiblio() { //ASIER 

		
	}
	
	@Test
	public void testSetEstamosEnBiblio() {  //ASIER 

		
	}    
	
	@Test
	public void testMostrarHomeVideojuegos() {  //JAVI 
		
		
	}
	
	@Test
	public void testMostrarBibliotecaVideojuegos() { //JAVI 
		

		
	}
	
	@Test
	public void testAccionBotonBuscar() {  //ASIER 

		
	}
	

}
