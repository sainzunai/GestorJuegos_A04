package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UsuarioTest {

	private Usuario u; 
	private Biblioteca b = Mockito.mock(Biblioteca.class);; 
	
    @Before                                         
    public void setUp() throws Exception {
    	u = new Usuario("cboasierg", "Seguridad", "Asier"); 
    }
    
    @Test
	public void testGetEmail() {
		assertEquals("cboasierg", u.getGmail());
	}
    
    @Test
	public void testSetEmail() {
		u.setGmail("javilazar");
		assertEquals("javilazar", u.getGmail());
	}
    
    @Test
	public void testGetContrasena() {
    	assertEquals("Seguridad", u.getContrasena());
		
	}
    
    @Test
   	public void testSetContrasena() {
    	u.setContrasena("1234");
       	assertEquals("1234", u.getContrasena());
   		
   	}
    
    @Test
   	public void testGetBiblioteca() {
    	assertNull(u.getBiblioteca());
 
   	}
    
    @Test
   	public void testSetBiblioteca() {
    	u.setBiblioteca(b);
    	when(b.getId()).thenReturn("1");
       	assertEquals(b, u.getBiblioteca());
   		
   	}
    
    @Test
   	public void testGetNombre() {
       	assertEquals("Asier", u.getNombre());
   		
   	}
    
    @Test
   	public void testSetNombre() {
    	u.setNombre("Javi");
       	assertEquals("Javi", u.getNombre());
   		
   	}
    
    @Test
   	public void testToString() {
       	assertEquals("Usuario [gmail=cboasierg, nombre=Asier, contrasena=Seguridad]", u.toString());
   	}	
}
