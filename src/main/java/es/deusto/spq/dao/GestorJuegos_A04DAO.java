package es.deusto.spq.dao;

import java.awt.List;

import javax.management.Query;

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
				
    		pm.close();
	    }
	}

	@Override
	public void getVideojuego(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Videojuego videojuego = null;
	    
		try {
			System.out.println ("   * Seleccionando videojuego: " + name);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Videojuego.class.getName() + " WHERE name == '" + name + "'");
	    	query.setUnique(true);
	    	videojuego = (Videojuego)query.execute();	    
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
	public void getAllVideojuegos() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Videojuego> listavideojuego = null;
	    
		try {
			System.out.println ("   * Seleccionando videojuegos: ");
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT * FROM " + Videojuego.class.getName());
	    	query.setUnique(true);
	    	listavideojuego = query.executeList();	    
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
	public void updateVideojuego(videojuego) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(videojuego);
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
		
		
		Extent<Videojuego> extentU = pm.getExtent(Videojuego.class, true);
		for (Videojuego v : extentU) {
			v.removeReservation();
		}
		// Updating the database so changes are considered before commit
		pm.flush();				
			
		Query<Videojuego> query3 = pm.newQuery(Videojuego.class);
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
	
}
