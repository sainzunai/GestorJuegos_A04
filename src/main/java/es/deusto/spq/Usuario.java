package es.deusto.spq;

import java.io.Serializable;

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
	@Persistent(mappedBy="user")
    Biblioteca biblioteca;
	
	public Usuario(String gmail, String contrasena,String nombre) {
		this.gmail = gmail;
		this.contrasena = contrasena;
		this.nombre=nombre;
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
	
	
}
