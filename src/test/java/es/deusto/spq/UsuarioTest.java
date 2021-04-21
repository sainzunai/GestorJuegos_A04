package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	Usuario u; 
	
	Biblioteca b; 
	
	String s; 
	
	
    @Before                                         
    public void setUp() throws Exception {

    	u = new Usuario("cboasierg", "Seguridad"); 
    	
    	b = new Biblioteca(); 
    	
    	s = "233332";
    	
    	b.setId(s);
    
    }

	@Test
	public void test() {
		
		u.setBiblioteca(b);
		assertEquals(u.getBiblioteca().getId(), b.getId());
		assertEquals(u.getContrasena(), "Seguridad"); 
		u.setContrasena("Seg");
		assertEquals(u.getContrasena(), "Seguridad");
		assertEquals(u.getGmail(), "cboasierg");
		u.setGmail("JavierLazaro");
		assertEquals(u.getGmail(), "JavierLazaro"); 
		

		
	}
	
}
