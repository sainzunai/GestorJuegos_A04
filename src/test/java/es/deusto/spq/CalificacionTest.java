package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalificacionTest {
	
	Calificacion c; 
	
	
    @Before                                         
    public void setUp() throws Exception {
    	
    	c = new Calificacion(0, 2003, 4, 4); 

    }
	
	@Test
	public void testSetNotaFecha() {
		
		c.setNota(10, 2005, 6, 1);  //cuando se cambia la nota que tenemos que dar una fecha nueva. 
		
		assertEquals( c.getAnyoAsignacion(), 2005);
		
		assertEquals( c.getMesAsignacion(), 6);
		
		assertEquals( c.getDiaAsignacion(), 1);
		
	}
	
	@Test
	public void testSetAnyoAsignacion() {
		
		c.setAnyoAsignacion(2007);
		
		assertEquals( c.getAnyoAsignacion(), 2007);
		
	}
	
	@Test
	public void testSetDiaAsignacion() {
		
		c.setDiaAsignacion(10);
		
		assertEquals( c.getDiaAsignacion(), 10);
		
	}
	
	@Test
	public void testSetMesAsignacion() {
		
		c.setMesAsignacion(2);
		
		assertEquals( c.getMesAsignacion(), 2);
		

		
	}
	
		
	@Test
	public void testGetNota() {
		
		assertEquals( c.getNota(), 0);
		
		
	}
	
	@Test
	public void testSetNotaPuntuacion() {
		
		c.setNota(10, 0, 0, 0);
		assertEquals( c.getNota(), 10);
	}
	

}
