package es.deusto.spq;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Plataforma implements Serializable{  
	
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String idPlataforma;
	@Persistent
	private String nombrePlataforma; 
	@Persistent
	private String urlLogo; //Posible futura implementacion 
	@Persistent(mappedBy="plataforma", dependentElement="true",defaultFetchGroup="true")
	@Join
	private List<VideoJuego> videojuegos = new ArrayList<>();
	
	/**
	 * Crea una Plataforma con nombre e id, sin logo
	 * @param nombre String de la plataforma (ps4, xbox, PC, ...)
	 * @param id String identificador para la plataforma
	 */
	public Plataforma(String nombre, String id) {
		
		this.setNombrePlataforma(nombre); 
		
		this.setIdPlataforma(id); 
		
		this.urlLogo = ""; 
		
	}
	
	/**
	 * Crea una Plataforma con nombre e id, con logo
	 * @param nombre String de la plataforma (ps4, xbox, PC, ...)
	 * @param id String identificador para la plataforma
	 * @param url String con la ruta para la foto del logo
	 */
	public Plataforma(String nombre, String id, String url) {
		
		this.setNombrePlataforma(nombre); 
		
		this.setIdPlataforma(id); 
		
		this.urlLogo = url; 
		
	}
	
	/**
	 * Crea una Plataforma vacia, sin nombre, id ni logo
	 */
	public Plataforma() {
		
		this.setNombrePlataforma(""); 
		
		this.setIdPlataforma(""); 
		
		this.urlLogo = ""; 
		
	}

	/**
	 * Devuelve el nombre de la plataforma
	 * @return String nombre de la plataforma
	 */
	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	/**
	 * Establece un nuevo nombre para la Plataforma
	 * @param nombrePlataforma String nombre de la Plataforma
	 */
	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	/**
	 * Devuelve el id de la Plataforma
	 * @return String identificador de plataforma
	 */
	public String getIdPlataforma() {
		return idPlataforma;
	}

	/**
	 * Establece el id de la Plataforma
	 * @param idPlataforma String id plataforma
	 */
	public void setIdPlataforma(String idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	/**
	 * Devuelve el path del logo
	 * @return String path para del logo
	 */
	public String getUrlLogo() {
		return urlLogo;
	}

	/**
	 * Establece un nuevo path para el logo de la plataforma
	 * @param urlLogo 
	 */
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	
	/**
	 * Anyade un objeto VideoJuego a la plataforma
	 * @param v
	 */
	public void addVideoJuego(VideoJuego v) {
		videojuegos.add(v);
	}

	/**
	 * Elimina un VideoJuego de la plataforma
	 * @param v Objeto VideoJuego a eliminar
	 */
	public void removeVideojuego(VideoJuego v) {
		videojuegos.remove(v);
	}

	/**
	 * Devuelve la lista de VideoJuego en la Plataforma
	 * @return List de VideoJuego devuelta
	 */
	public List<VideoJuego> getVideoJuegos() {
		return videojuegos;
	}

	/**
	 * Devuelve el numero de VideoJuego en la lista de juegos
	 * @return Integer con el numero de juegos
	 */
	public int getNumberOfVideojuegos() {
		return videojuegos.size();
	}
	
	/**
	 * Establece la lista de VideoJuego en la plataforma
	 * @param v List de juegos en la plataforma
	 */
	public void setVideojuego(List<VideoJuego> v) {
		videojuegos=v;
	}
}
