package es.deusto.spq.dao;

import java.util.List;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;
public class GestorJuegos_A04DAO implements IGestorJuegos_A04DAO{
	private PersistenceManagerFactory pmf;
	
	public  GestorJuegos_A04DAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
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
	    	Query<?> query = pm.newQuery("SELECT FROM " + VideoJuego.class.getName() + " WHERE id == '" + id + "'");
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

	@Override
	public List<VideoJuego> getAllVideojuegos() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<VideoJuego> listavideojuego = null;
	    
		try {
			System.out.println ("   * Seleccionando videojuegos: ");
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT * FROM " + VideoJuego.class.getName());
	    	query.setUnique(true);
	    	listavideojuego = (List<VideoJuego>) query.executeList();	    
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
	@Override
	public void deleteAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
		try {
			System.out.println("- Cleaning the DB...");			
			
			
			
			tx.begin();
			
			Query<Plataforma> query2 = pm.newQuery(Plataforma.class);
			System.out.println(query2.deletePersistentAll() + "Eliminando Plataforma");
			
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
	
}
