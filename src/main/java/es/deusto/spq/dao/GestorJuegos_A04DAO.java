package es.deusto.spq.dao;

import java.util.List;
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
		PersistenceManager pm = pmf.getPersistenceManager();
		VideoJuego videojuego=null;
		System.out.println("Obteniendo el Videojuego con id: "+id);
		Query<VideoJuego> q = pm.newQuery(VideoJuego.class);
	    try {
	        q.setUnique(true);
	        q.setFilter("videojuego_id == idParam");
	        q.declareParameters("String idParam");
        	videojuego = (VideoJuego) q.execute(id);
        } finally {
            q.closeAll();
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
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();
		List<VideoJuego> listavideojuego = null;
		Query<VideoJuego> q = pm.newQuery(VideoJuego.class);
		try {
			System.out.println("   * Seleccionando videojuegos: ");
			tx.begin();
			q.orderBy("videojuego_id asc");
			listavideojuego = q.executeList();
			System.out.println(listavideojuego);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {

				pm.close();
			}
		}
		return (listavideojuego);
	}
	/**
	 * Descripción del método
	 * Se elimina todos los videojuegos de la base de datos
	 */
	@Override
	public void deleteAllVideojuegos() {
		System.out.println("- Borrando los videojuegos de la base de datos...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Query<VideoJuego> query3 = pm.newQuery(VideoJuego.class);
		try {
			tx.begin();
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
				query3.closeAll();
			}
		}
	}
	/**
	 * Descripción del método Se elimina todo de la base de datos
	 */
	@Override
	public void deleteAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Query<Plataforma> query2 = pm.newQuery(Plataforma.class);
		Query<Biblioteca> query4 = pm.newQuery(Biblioteca.class);
		Query<Usuario> query3 = pm.newQuery(Usuario.class);
		try {
			System.out.println("- Cleaning the DB...");
			tx.begin();
			System.out.println(query2.deletePersistentAll() + "Eliminando Plataforma");
			System.out.println(" * '" + query4.deletePersistentAll() + "' biblioteca borrados de la BD.");
			System.out.println(query3.deletePersistentAll() + "Eliminando Usuario");
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
				query2.closeAll();
				query3.closeAll();
				query4.closeAll();
			}
		}
	}

	/**
	 * Descripción del método Actualiza la biblioteca en la base de datos
	 * 
	 * @param Se le pasa una biblioteca, la objetivo.
	 * @param Se le pasa el elemento a meter en la biblioteca
	 */
	@Override
	public void updateBiblioteca_Videojuego(Biblioteca biblioteca, VideoJuego videojuego) {
		VideoJuego auxiliar = videojuego;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Query<Biblioteca> q = pm.newQuery(Biblioteca.class);
		q.extension("datanucleus.query.flushBeforeExecution", "true");
		q.setUnique(true);
		q.setFilter("biblioteca_id == idParam");
		q.declareParameters("String idParam");
		System.out.println("Actualizando la relacion: " + biblioteca.getId() + " y " + videojuego.getId());
		Query<VideoJuego> query = pm.newQuery(VideoJuego.class);
		query.extension("datanucleus.query.flushBeforeExecution", "true");
		query.setUnique(true);
		query.setFilter("videojuego_id == id1Param");
		query.declareParameters("String id1Param");
		try {
			tx.begin();
			biblioteca = (Biblioteca) q.execute(biblioteca.getId());
			videojuego = (VideoJuego) query.execute(videojuego.getId());
			biblioteca.addJuego(videojuego);
			videojuego.addBiblioteca(biblioteca);
			videojuego.setNumeroNotas(auxiliar.getNumeroNotas());
			videojuego.setSumaNotas(auxiliar.getSumaNotas());
			tx.commit();
		} finally {
			q.closeAll();
			query.closeAll();
			pm.close();
		}
	}
	
	@Override
	public Usuario getUsuario(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Usuario users = null;
		System.out.println("Obteniendo el usuario con email: " + email);
		Query<Usuario> q = pm.newQuery(Usuario.class);
		q.setUnique(true);
		q.setFilter("gmail == gmailParam");
		q.declareParameters("String gmailParam");
		try {
			users = (Usuario) q.execute(email);
			System.out.println("Usuario:" + users.getGmail() + " " + users.getContrasena() + " " + users.getBiblioteca().getId());
		} catch (Exception ex) {
			System.err.println(" $ Error selecting user: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			q.closeAll();
			pm.close();
		}
		users.setBiblioteca(this.getBiblioteca_Usuario(users));
		return (users);
	}

	@Override
	public Biblioteca getBiblioteca_Usuario(Usuario user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Biblioteca biblioteca = null;
		System.out.println("Obteniendo la biblioteca con email: " + user.getBiblioteca().getId());
		Query<Biblioteca> q = pm.newQuery(Biblioteca.class);
		q.setUnique(true);
		q.setFilter("biblioteca_id == idParam");
		q.declareParameters("String idParam");
		try {
			biblioteca = (Biblioteca) q.execute(user.getBiblioteca().getId());
			System.out.println("Biblioteca: " + biblioteca.getId() + " " + biblioteca.getListaJuegos());
		} finally {
			q.closeAll();
			pm.close();
		}
		return (biblioteca);
	}
	
	@Override
	public void updateBiblioteca(Biblioteca biblioteca) {
		PersistenceManager pm = pmf.getPersistenceManager();
		System.out.println("Obteniendo la biblioteca con Id: " + biblioteca.getId());
		Query<Biblioteca> q = pm.newQuery(Biblioteca.class);
		try {
			q.extension("datanucleus.query.flushBeforeExecution", "true");
			q.setUnique(true);
			q.setFilter("biblioteca_id == idParam");
			q.declareParameters("String idParam");

			for (int i = 0; i < biblioteca.getListaJuegos().size(); i++) {
				this.updateBiblioteca_Videojuego(biblioteca, biblioteca.getListaJuegos().get(i));
			}
		} finally {
			q.closeAll();
			pm.close();
		}
	}
	
	@Override
	public void deleteUsuario(Usuario user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Query<Usuario> q = pm.newQuery(Usuario.class);
		Query<Biblioteca> q1 = pm.newQuery(Biblioteca.class);
		try {
			System.out.println("- Cleaning the DB...");
			tx.begin();
			q.setUnique(true);
			q.setFilter("gmail == gmailParam");
			q.declareParameters("String gmailParam");
			Usuario users = (Usuario) q.execute(user.getGmail());
			pm.deletePersistent(users);
			q1.extension("datanucleus.query.flushBeforeExecution", "true");
			q1.setUnique(true);
			q1.setFilter("biblioteca_id == idParam");
			q1.declareParameters("String idParam");
			Biblioteca biblioteca = (Biblioteca) q1.execute(user.getBiblioteca().getId());
			pm.deletePersistent(biblioteca);
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
				q.closeAll();
				q1.closeAll();
			}
		}
	}

	@Override
	public void updateVideoJuego(VideoJuego videojuego) {
		VideoJuego auxiliar = videojuego;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Query<VideoJuego> query = pm.newQuery(VideoJuego.class);
		query.extension("datanucleus.query.flushBeforeExecution", "true");
		query.setUnique(true);
		query.setFilter("videojuego_id == id1Param");
		query.declareParameters("String id1Param");
		try {
			tx.begin();
			videojuego = (VideoJuego) query.execute(videojuego.getId());
			videojuego.setNumeroNotas(auxiliar.getNumeroNotas());
			videojuego.setSumaNotas(auxiliar.getSumaNotas());
			tx.commit();
		} finally {
			query.closeAll();
			pm.close();
		}
		
	}
}
