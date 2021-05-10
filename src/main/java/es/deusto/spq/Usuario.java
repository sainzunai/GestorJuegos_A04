package es.deusto.spq;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Usuario implements Serializable{

	@PrimaryKey
	private String gmail;
	private String nombre; 
	private String contrasena;
	
	//TENEMOS ESTE ARRAY DE NOTAS PARA SABER CUALES HA DADO CADA UNO. 
	
	private ArrayList<Calificacion> notasDadas; 
	
	@Persistent(mappedBy="user", dependentElement="true",defaultFetchGroup="true")
    Biblioteca biblioteca;
	
	public Usuario(String gmail, String contrasena,String nombre) {
		this.gmail = gmail;
		this.contrasena = contrasena;
		this.nombre=nombre;
		notasDadas = new ArrayList<>(); 
	}
	
	
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Usuario [gmail=" + gmail + ", nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}


	public ArrayList<Calificacion> getNotasDadas() {  //test 
		return notasDadas;
	}


	public void setNotasDadas(ArrayList<Calificacion> notasDadas) { //test 
		this.notasDadas = notasDadas;
	}
	
	public double mediaUsuario() {  //test 
		
		double notaMedia = 0.0; 
		
		int i; 
		
		for( i = 0; i < notasDadas.size(); i ++  ) {
			
			if(notasDadas.get(i).getUserNota().equals(this)) {
			
			notaMedia = notaMedia + notasDadas.get(i).getNota();
			
			}
		}

		return notaMedia / ( i );
		
		
	}
	
	
}
