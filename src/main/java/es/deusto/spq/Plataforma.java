package es.deusto.spq;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Plataforma implements Serializable{  //PS4, NINTENDO etc. 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String idPlataforma;
	
	private String nombrePlataforma; 
	private String urlLogo; //Posible futura implementacion 
	@Persistent(mappedBy="plataforma", dependentElement="true",defaultFetchGroup="true")
	@Join
	private List<VideoJuego> videojuegos = new ArrayList<>();
	
	public Plataforma(String nombre, String id) {
		
		this.setNombrePlataforma(nombre); 
		
		this.setIdPlataforma(id); 
		
	}
	
	public Plataforma(String nombre, String id, String url) {
		
		this.setNombrePlataforma(nombre); 
		
		this.setIdPlataforma(id); 
		
		this.urlLogo = url; 
		
	}
	
	public Plataforma() {
		
		this.setNombrePlataforma(""); 
		
		this.setIdPlataforma(""); 
		
		this.urlLogo = ""; 
		
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	public String getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(String idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	
	public void addVideoJuego(VideoJuego v) {
		videojuegos.add(v);
	}

	public void removeVideojuego(VideoJuego v) {
		videojuegos.remove(v);
	}

	public List<VideoJuego> getVideoJuegos() {
		return videojuegos;
	}

	public int getNumberOfVideojuegos() {
		return videojuegos.size();
	}
	public void setVideojuego(List<VideoJuego> v) {
		videojuegos=v;
	}
}
