package es.deusto.spq;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalificacionTest {
	
	Calificacion c; 
	
	private Usuario u1 = Mockito.mock(Usuario.class);
	
	private Usuario u2 = Mockito.mock(Usuario.class);
	
	private VideoJuego v = Mockito.mock(VideoJuego.class);
	
	private VideoJuego v1 = Mockito.mock(VideoJuego.class);
	
    @Before                                         
    public void setUp() throws Exception {
    	
    	c = new Calificacion(0, 2003, 4, 4, u1,v); 

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
	
    @Test
   	public void testSetUserNota() {
    	
    	c.setUserNota(u2);
    	
    	when(u2.getNombre()).thenReturn("HOLA");
    	
       	assertEquals(c.getUserNota().getNombre(), "HOLA" );
   	}
    
    @Test
   	public void testGetUserNota() {
    	
    	when(u1.getNombre()).thenReturn("HOLA1");
    	
       	assertEquals(c.getUserNota().getNombre(), "HOLA1" );
   	}	
    @Test
    public void testGetVideojuego() {
    	when(v.getId()).thenReturn("1");
    	assertEquals(c.getVideojuego().getId(),"1");
    }
    @Test
    public void testSetVideoJuego() {
    	c.setVideojuego(v1);
    	when(v1.getId()).thenReturn("2");
    	assertEquals(c.getVideojuego().getId(),"2");
    }
}
