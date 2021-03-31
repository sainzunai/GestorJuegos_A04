package es.deusto.spq;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Plataforma {  //PS4, NINTENDO etc. 
	
	@PrimaryKey
	private String idPlataforma;
	
	private String nombrePlataforma; 
	private String urlLogo; //Posible futura implementacion 
	

	
	
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
	
	
}
