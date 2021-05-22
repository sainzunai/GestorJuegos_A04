package es.deusto.spq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.ventanas.JPanelVideojuego;

import javax.jdo.annotations.Order;
import javax.jdo.annotations.Extension;

/**
 * 
 * Clase Videojuego, todos los atributos correspondientes a un videojuego 
 * @author Asier
 *
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class VideoJuego implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String videojuego_id;
	private String nombre;
	private String compania;
	private String caratula;
	private int sumaNotas;
	private int numeroNotas;
	private int edadRecomendada;
	@Persistent
	private Plataforma plataforma;

	@Persistent(defaultFetchGroup = "true")
	@Order(extensions = @Extension(vendorName = "datanucleus", key = "list-ordering", value = "biblioteca_id ASC"))
	private List<Biblioteca> biblioteca = new ArrayList<>();

	JPanelVideojuego j;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((videojuego_id == null) ? 0 : videojuego_id.hashCode());
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
		VideoJuego other = (VideoJuego) obj;
		if (videojuego_id == null) {
			if (other.videojuego_id != null)
				return false;
		} else if (!videojuego_id.equals(other.videojuego_id))
			return false;
		return true;
	}
	
	
	/**
	 * Objeto VideoJuego que define un juego en la Biblioteca
	 * @param nombre String de nombre comun del juego
	 * @param id String identificador del juego
	 * @param company String nombre de la compania productora del juego
	 * @param edadRecomendada Integer edad maxima recomendada
	 * @param plataforma objeto Plataforma asignado al VideoJuego
	 * @param caratula String path donde se ubica el jpg de la caratula
	 */
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, Plataforma plataforma,
			String caratula) {

		this.nombre = nombre;

		this.videojuego_id = id;

		this.compania = company;

		this.edadRecomendada = edadRecomendada;

		this.plataforma = plataforma;

		this.caratula = caratula;

	}
	
	/**
	 * Objeto VideoJuego que define un juego en la Biblioteca, sin cataula
	 * @param nombre String de nombre comun del juego
	 * @param id String identificador del juego
	 * @param company company String nombre de la compania productora del juego
	 * @param edadRecomendada Integer edad maxima recomendada
	 * @param plataforma objeto Plataforma asignado al VideoJuego
	 */
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, Plataforma plataforma) {

		this.nombre = nombre;

		this.videojuego_id = id;

		this.compania = company;

		this.edadRecomendada = edadRecomendada;

		this.plataforma = plataforma;

		this.caratula = " ";

	}

	/**
	 * Objeto VideoJuego que define un juego en la Biblioteca, con todos los elemetos vacios
	 */
	public VideoJuego() {

		this.nombre = "";

		this.videojuego_id = "";

		this.compania = "";

		this.edadRecomendada = 0;

		this.caratula = " ";

	}

	/**
	 * Metodo para calcular la nota media del VideoJuego en base a las notas de Usuario
	 * @return double nota media
	 */
	public double calculoNotaMedia() {

		return (double) sumaNotas / numeroNotas;
	}

	/**
	 * Suma la nota enviada por el Usuario al total de notas del VideoJuego
	 * @param nota Integer nota introducida
	 */
	public void addNota(int nota) {

		sumaNotas += nota;

		numeroNotas++;

	}

	/**
	 * Devuelve el nombre comun del VideoJuego
	 * @return Strimg nombre del juego
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece un nuevo nombre para el VideoJuego
	 * @param nombre String nombre del juego
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el string identificador del VideoJuego
	 * @return String id
	 */
	public String getId() {
		return videojuego_id;
	}

	/**
	 * Establece un nuevo identificador de VideoJuego
	 * @param id String identificador
	 */
	public void setId(String id) {
		this.videojuego_id = id;
	}

	/**
	 * Devuelve el String nombre de compania
	 * @return String compania
	 */
	public String getCompania() {
		return compania;
	}

	/**
	 * Establece un nuevo nombre de compania para el VideoJuego
	 * @param compania String nombre compania
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}

	/**
	 * Devuelve el Integer edad recomendada
	 * @return Integer edad recomendada
	 */
	public int getEdadRecomendada() {
		return edadRecomendada;
	}
	
	/**
	 * Establece una nueva edad recomendada para el VideoJuego
	 * @param edadRecomendada Integer edad maxima recomendada
	 */
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	/**
	 * Devuelve el path de la caratula del VideoJuego
	 * @return String path de la caratula
	 */ 
	public String getCaratula() {
		return caratula;
	}

	/**
	 * Establece un nuevo path para la caratula
	 * @param caratula String path caratula
	 */
	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	/**
	 * Anade una Biblioteca a la lista de bibliotecas
	 * @param b objeto Biblioteca a anadir
	 */
	public void addBiblioteca(Biblioteca b) {
		biblioteca.add(b);
	}

	/**
	 * Elimina una Biblioteca de la lista de bibliotecas
	 * @param b objeto Bibloteca a eliminar
	 */
	public void removeBiblioteca(Biblioteca b) {
		biblioteca.remove(b);
	}

	/**
	 * Devuelve la lista de Biblioteca del juego
	 * @return List de biblioteca
	 */
	public List<Biblioteca> getBiblioteca() {
		return biblioteca;
	}

	/**
	 * Devuelve el size de la lista de Biblioteca
	 * @return Integer size de la lista
	 */
	public int getNumberOfBiblioteca() {
		return biblioteca.size();
	}

	/**
	 * Establece una nueva lista de Biblioteca
	 * @param b List de Biblioteca a establecer
	 */
	public void setBiblioteca(List<Biblioteca> b) {
		biblioteca = b;
	}

	/**
	 * Devuelve el JPanelVideojuego asignado al VideoJuego, devuelve uno distinto 
	 * dependiendo de si el VideoJuego tiene una caratula establecida o no 
	 * @param b objeto Biblioteca para el panel
	 * @param stamosHome boolean comprobacion home/biblioteca
	 * @param u objeto Usuario dueno del panel
	 * @return objeto JPanelVideojuego devuelto
	 */
	public JPanelVideojuego getJPanelVideojuego(Biblioteca b , boolean stamosHome, Usuario u) {

		if (caratula.equals(" ")) {
			j = new JPanelVideojuego(this, 1, b, stamosHome, u);
		}
		else {
			j = new JPanelVideojuego(this, b, stamosHome, u);
		}
		return j;
	}

	/**
	 * Devuelve el sumatorio de puntuaciones recibidas por un VideoJuego
	 * @return Integer sumatorio de notas
	 */
	public int getSumaNotas() {
		return sumaNotas;
	}

	/**
	 * Establece un nuevo valor para el sumatorio de notas del VideoJuego
	 * @param sumaNotas Integer valor del sumatorio
	 */
	public void setSumaNotas(int sumaNotas) {
		this.sumaNotas = sumaNotas;
	}

	/**
	 * Devuelve el numero de veces que un VideoJuego ha recibido notas
	 * @return Integer numero total de notas 
	 */
	public int getNumeroNotas() {
		return numeroNotas;
	}

	/**
	 * Establece el valor para el numero total de notas 
	 * @param numeroNotas Integer valor del nuevo numero de notas
	 */
	public void setNumeroNotas(int numeroNotas) {
		this.numeroNotas = numeroNotas;
	}

}
