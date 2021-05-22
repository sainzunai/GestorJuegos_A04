package es.deusto.spq;

import java.io.Serializable;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase Usuario con todos sus atributos y metodos.
 * Sera utilizado para guardar datos referidos a personas y bibliotecas con videojuegos dentro. 
 * @author Asier
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Usuario implements Serializable{

	@PrimaryKey
	private String gmail;
	private String nombre; 
	private String contrasena;
	
	@Persistent(mappedBy="user", dependentElement="true",defaultFetchGroup="true")
    Biblioteca biblioteca;
	
	/**
	 * Usuario con un email, una contrasena y un nombre
	 * @param gmail String email usado para registrarse/iniciar
	 * @param contrasena String contrasena alfanumerica para registrarse/iniciar
	 * @param nombre String nombre caracteristico del Usuario
	 */
	public Usuario(String gmail, String contrasena,String nombre) {
		this.gmail = gmail;
		this.contrasena = contrasena;
		this.nombre=nombre;
	}
	
	
	/**
	 * Devuelve el email que utiliza el Usuario
	 * @return String email
	 */
	public String getGmail() {
		return gmail;
	}
	
	/**
	 * Establece un nuevo email para el Usuario
	 * @param gmail String que define el email
	 */
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	/**
	 * Devuelve la contrasena del Usuario
	 * @return String contrasena usada por el Usuario
	 */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * Establece una nueva contrasena para el Usuario
	 * @param contrasena String de la nueva contrasena para el Usuario
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	/**
	 * Devuelve el objeto Biblioteca asignado al Usuario
	 * @return objeto Biblioteca del Usuario
	 */
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	
	/**
	 * Establece la Biblioteca asignada al Usuario
	 * @param biblioteca objeto Biblioteca que asignar
	 */
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	/**
	 * Devuelve el nombre asignado al Usuario
	 * @return String nombre del Usuario
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece un nuevo nombre para el Usuario
	 * @param nombre String nombre para el Usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Usuario [gmail=" + gmail + ", nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}
	
	
}
