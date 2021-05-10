package es.deusto.spq;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Calificacion implements Serializable{
	

	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private String calificacion_id; 
	
	

	private int nota; 
	
	private int mesAsignacion; 
	
	private int diaAsignacion; 
	
	private int anyoAsignacion; 

	private Usuario userNota;  //tiene que tener un usuario en concreto para no repetir y usarlo en los metodos de logica etc. 
	
	private VideoJuego videojuego;
	public Calificacion(int nota, int anyo, int mes, int dia, Usuario u,VideoJuego videojuego) {  //No vamos a crear un constructor vacio porque no corresponde a una Calificacion; 
		
		this.nota = nota; 
		
		this.anyoAsignacion = anyo; 
		
		this.mesAsignacion = mes; 
		
		this.diaAsignacion = dia; 
		
		this.userNota = u; 
		
		this.videojuego= videojuego;
	}
	


	



	public void setNota(int nota, int anyo, int  mes, int dia) { //cuando asignamos una nueva nota guardaremos su fecha de guardado. 
		this.nota = nota;
		
		this.diaAsignacion = dia; 
		
		this.mesAsignacion = mes; 
		
		this.anyoAsignacion = anyo; 
	}
	
	
	public String getCalificacion_id() {
		return calificacion_id;
	}



	public void setCalificacion_id(String calificacion_id) {
		this.calificacion_id = calificacion_id;
	}

	
	public int getNota() {
		return nota;
	}


	public int getDiaAsignacion() {
		return diaAsignacion;
	}


	public void setDiaAsignacion(int diaAsignacion) {
		this.diaAsignacion = diaAsignacion;
	}
	

	public int getMesAsignacion() {
		return mesAsignacion;
	}


	public void setMesAsignacion(int mesAsignacion) {
		this.mesAsignacion = mesAsignacion;
	}


	public int getAnyoAsignacion() {
		return anyoAsignacion;
	}


	public void setAnyoAsignacion(int anyoAsignacion) {
		this.anyoAsignacion = anyoAsignacion;
	}



	public Usuario getUserNota() {
		return userNota;
	}



	public void setUserNota(Usuario userNota) {  //dudo que haya que utilizar este metodo. 
		this.userNota = userNota;
	}

	public VideoJuego getVideojuego() {
		return videojuego;
	}



	public void setVideojuego(VideoJuego videojuego) {
		this.videojuego = videojuego;
	}

	
	
}
