package es.deusto.spq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * @author javil
 *
 */
/**
 * @author javil
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Biblioteca implements Serializable{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private String biblioteca_id; 

	@Column(name="gmail")
    Usuario user;
	
	@Persistent(table="Biblioteca_VideoJuego",defaultFetchGroup="true",dependentElement="true")
    @Join(column="biblioteca_id")
    @Element(column="videojuego_id")
	@Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="videojuego_id ASC"))
	private List<VideoJuego> listaJuegos= new ArrayList<>();   
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biblioteca_id == null) ? 0 : biblioteca_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biblioteca other = (Biblioteca) obj;
		if (biblioteca_id == null) {
			if (other.biblioteca_id != null)
				return false;
		} else if (!biblioteca_id.equals(other.biblioteca_id))
			return false;
		return true;
	}

	/**
	 * Biblioteca con una lista de juegos 
	 * @param listaJuegos lista de VideoJuego que está en la Biblioteca
	 */
	public Biblioteca(List<VideoJuego> listaJuegos ) {
		
		this.user = null;  
		this.listaJuegos = listaJuegos;  

	}
	
	/**
	 * Biblioteca con una lista de juegos vacía y sólo id
	 */
	public Biblioteca() { 
		
		this.user = null; 
		this.listaJuegos = new ArrayList<>(); 
		
	}
	
	/**
	 * Devuelve el numero de juegos en la Biblioteca
	 * @return tamanyo de la lista de juegos de la Biblioteca
	 */
	public int numeroDeJuegos() {   
		
		return listaJuegos.size(); 
		
	}
	
	/**
	 * Anyade un objeto VideoJuego a la lista de la Biblioteca
	 * Comprueba si el VideoJuego esta duplicado o no antes de meterlo
	 * @param v objeto VideoJuego a introducir
	 */
	public void addJuego(VideoJuego v) {

		boolean add = true;

		for (int i = 0; i < listaJuegos.size(); i++) {

			if (listaJuegos.get(i).getId().equals(v.getId())) {

				add = false;

			}

		}

		if (add == true) {
			listaJuegos.add(v);

		}
	}
	
	/**
	 * Elimina un VideoJuego de la lista de la Biblioteca
	 * @param v objeto VideoJuego a eliminar
	 */
	public void remJuego(VideoJuego v) {
		
		listaJuegos.remove(v); 
		
	}
	
	/**
	 * Devuelve la id de la Biblioteca
	 * @return String id de la Biblioteca
	 */
	public String getId() {
		return biblioteca_id;
	}

	/**
	 * Establece un nuevo id para la Biblioteca
	 * @param id String nuevo id
	 */
	public void setId(String id) {
		this.biblioteca_id = id;
	}

	/**
	 * Devuelve la lista de juegos de la Biblioteca
	 * @return List de VideoJuegos de la Biblioteca
	 */
	public List<VideoJuego> getListaJuegos() {
		return listaJuegos;
	}

	/**
	 * Establece una nueva lista de juegos para la Biblioteca
	 * @param listaJuegos List de VideoJuegos nuevo
	 */
	public void setListaJuegos(List<VideoJuego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
	
	/**
	 * Devuelve el usuario de la Biblioteca
	 * @return objeto User de la Biblioteca
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * Establece el usuario para la Biblioteca
	 * @param user objeto User para establecer en la Biblioteca
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}
}
