package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalificacionTest {
	
	Calificacion c; 
	
	
    @Before                                         
    public void setUp() throws Exception {
    	
    	c = new Calificacion(10, 2003, 4, 4); 

    }

	@Test
	public void test() {
		
		c.setNota(10, 2005, 6, 1);  //cuando se cambia la nota que tenemos que dar una fecha nueva. 
		
		
		assertEquals( c.getAnyoAsignacion(), 2005);
		
		assertEquals( c.getMesAsignacion(), 6);
		
		assertEquals( c.getDiaAsignacion(), 1);
		
		
	}

}
