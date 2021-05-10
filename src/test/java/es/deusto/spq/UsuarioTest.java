package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UsuarioTest {

	private Usuario u; 
	private Biblioteca b = Mockito.mock(Biblioteca.class);
	private Calificacion c = Mockito.mock(Calificacion.class);
	private Calificacion c2 = Mockito.mock(Calificacion.class);
	
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
    
    
    
    
    
    @Test
   	public void testGetNotasDadas() {
       	
    	assertEquals(u.getNotasDadas().size(), 0); 
   		
   	}
    
    @Test
   	public void testAddNotas() {
       	
    	u.addNota(c);
    	assertEquals(u.getNotasDadas().size(), 1); 
   		
   	}
    
    @Test
   	public void testSetNotasDadas() {
    	ArrayList<Calificacion> cList = new ArrayList<>(); 
    	cList.add(c); 
    	when(c.getNota()).thenReturn(10);
    	u.setNotasDadas(cList);
       	assertEquals(cList, u.getNotasDadas());
       	assertEquals(10, u.getNotasDadas().get(0).getNota());
   		
   	}
    
    @Test
   	public void testMediaUsuario() {
    	u.addNota(c);
    	u.addNota(c2);
    	when(c.getNota()).thenReturn(10);
    	when(c.getUserNota()).thenReturn(u);
    	when(c2.getUserNota()).thenReturn(u);
    	when(c2.getNota()).thenReturn(6);
    	assertEquals(8.0, u.mediaUsuario(), 0.0);
    	
   	}
    
    

}
