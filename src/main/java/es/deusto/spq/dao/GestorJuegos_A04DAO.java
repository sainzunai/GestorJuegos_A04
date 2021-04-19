package es.deusto.spq.dao;

import java.util.List;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
public class GestorJuegos_A04DAO implements IGestorJuegos_A04DAO{
	private PersistenceManagerFactory pmf;
	
	public  GestorJuegos_A04DAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	/**
	 * Descripción del método
	 * Introducimos una clase dentro de la base de datos.Con las correspondientes anotaciones y atributos.
	 * @param nos pide un Objecto cualquiera
	 * @return No devuelve nada
	 */
	@Override
	public void introducirObjeto(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Introducciendo un objeto: " + object);
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error al guardar un objeto: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
	    	if (pm != null && !pm.isClosed()) {
				pm.close();
				
			}	
    		
	    }
	}
	/**
	 * Descripción del método
	 * Coger un videojuego de la base de datos pasando el parametro primary key
	 * @param Se pide el id del objeto
	 * @return Se devuelve el videojuego pedido a la base de datos
	 */
	@Override
	public VideoJuego getVideojuego(String id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		VideoJuego videojuego = null;
	    
		try {
			System.out.println ("   * Seleccionando videojuego: " + id);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + VideoJuego.class.getName() + " WHERE videoJuego_id == '" + id + "'");
	    	query.setUnique(true);
	    	videojuego = (VideoJuego)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }
		return(videojuego);
	}
	/**
	 * Descripción del método
	 * Le pedimos a la base de datos todos los videojuegos de la base de datos
	 * @return Devuelve una lista de videojuegos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<VideoJuego> getAllVideojuegos() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		
		Transaction tx = pm.currentTransaction();
		List<VideoJuego> listavideojuego=null;
	    
		try {
			System.out.println ("   * Seleccionando videojuegos: ");
			
	    	tx.begin();
	    	Query<VideoJuego> q = pm.newQuery(VideoJuego.class);
			q.orderBy("videoJuego_id asc");
			listavideojuego = q.executeList();
	 
	    	System.out.println(listavideojuego);
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }
		return(listavideojuego);
	}
	/**
	 * Descripción del método
	 * Se actualiza el videojuego en la base de datos; sus atributos y relaciones.
	 * @param Se pasa un videojuego.
	 */
	@Override
	public void updateVideojuego(VideoJuego videojuego) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	VideoJuego j=(VideoJuego) pm.getObjectById(VideoJuego.class,videojuego.getId());
	    	j.setCalificaciones(videojuego.getCalificaciones());
	    	j.setCaratula(videojuego.getCaratula());
	    	j.setCompania(videojuego.getCompania());
	    	j.setEdadRecomendada(videojuego.getEdadRecomendada());
	    	j.setNombre(videojuego.getNombre());
	    	j.setBiblioteca(videojuego.getBiblioteca());
	    	System.out.println("   * Actualizando videojuego: " + videojuego);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error al actulizar : " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
	/**
	 * Descripción del método
	 * Se elimina todos los videojuegos de la base de datos
	 */
	@Override
	public void deleteAllVideojuegos() {
		// No terminada
		System.out.println("- Borrando los videojuegos de la base de datos...");			
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {		
		tx.begin();
					
			
		Query<VideoJuego> query3 = pm.newQuery(VideoJuego.class);
		System.out.println(" * '" + query3.deletePersistentAll() + "' videojuegos borrados de la BD.");
		
		tx.commit();
		
	} catch (Exception ex) {
		System.err.println(" $ Error al borrar la DB: " + ex.getMessage());
		ex.printStackTrace();
	} finally {
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}
		
		if (pm != null && !pm.isClosed()) {
			pm.close();
		}
	}
	}
	/**
	 * Descripción del método
	 * Se elimina todo de la base de datos
	 */
	@Override
	public void deleteAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
		try {
			System.out.println("- Cleaning the DB...");			
			
			
			
			tx.begin();
			
			Query<Plataforma> query2 = pm.newQuery(Plataforma.class);
			System.out.println(query2.deletePersistentAll() + "Eliminando Plataforma");
			Query<Biblioteca> query4 = pm.newQuery(Biblioteca.class);
			System.out.println(" * '" + query4.deletePersistentAll() + "' biblioteca borrados de la BD.");
			//End the transaction
			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
	}
	/**
	 * Descripción del método
	 * Actualiza la biblioteca en la base de datos
	 * @param Se le pasa una biblioteca, la objetivo.
	 * @param Se le pasa el elemento a meter en la biblioteca
	 */
	@Override
	public void updateBiblioteca(Biblioteca biblioteca,VideoJuego videojuego) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	System.out.println("Accediendo a la biblioteca");
	    	Biblioteca b=(Biblioteca) pm.getObjectById(Biblioteca.class,biblioteca.getId());
	    	System.out.println("Accediendo a videojuego");
	    	VideoJuego j =(VideoJuego)pm.getObjectById(VideoJuego.class,videojuego.getId());
	    	b.setListaJuegos(biblioteca.getListaJuegos());
	    
	    	j.setBiblioteca(videojuego.getBiblioteca());
	    	System.out.println("   * Actualizando biblioteca: " + biblioteca);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error al actulizar : " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
	@Override
	public Usuario getUsuario(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;
	    
		try {
			System.out.println ("   * Seleccionando Usuario: " + email);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE gmail == '" + email + "'");
	    
	    	usuario = (Usuario) query.execute();	    
 	    	tx.commit();
 	    	
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }
		System.out.println(usuario.getContrasena());
		return(usuario);
		
	}
	@Override
	public Biblioteca getBiblioteca_Usuario(Usuario user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Biblioteca biblioteca = null;
	    
		try {
			System.out.println ("   * Seleccionando Biblioteca con email: " + user.getGmail());
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Biblioteca.class.getName() + " WHERE gmail == '" + user.getGmail() + "'");
	    	query.setUnique(true);
	    	biblioteca = (Biblioteca)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }
		return(biblioteca);
		
	}
	
}
