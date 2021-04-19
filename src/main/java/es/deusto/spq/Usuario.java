package es.deusto.spq;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {

	@PrimaryKey
	private String gmail;
	private String contrasena;
	@Persistent(mappedBy="user")
    Biblioteca biblioteca;
	
	//Asier añade lo que quieras, esto es solo una base para la base de datos
	public Usuario(String gmail, String contrasena) {
		this.gmail = gmail;
		this.contrasena = contrasena;
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
	
}
