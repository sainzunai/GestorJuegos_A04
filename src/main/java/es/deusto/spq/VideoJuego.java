package es.deusto.spq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.ventanas.JPanelVideojuego;

import javax.jdo.annotations.Order;
import javax.jdo.annotations.Extension;

/**
 * @author javil
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

	public String getId() {
		return videojuego_id;
	}

	public void setId(String id) {
		this.videojuego_id = id;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public void addBiblioteca(Biblioteca b) {
		biblioteca.add(b);
	}

	public void removeBiblioteca(Biblioteca b) {
		biblioteca.remove(b);
	}

	public List<Biblioteca> getBiblioteca() {
		return biblioteca;
	}

	public int getNumberOfBiblioteca() {
		return biblioteca.size();
	}

	public void setBiblioteca(List<Biblioteca> b) {
		biblioteca = b;
	}

	public JPanelVideojuego getJPanelVideojuego(Biblioteca b) {

		if (caratula.equals(" ")) {
			j = new JPanelVideojuego(this, 1, b);
		}
		else {
			j = new JPanelVideojuego(this, b);
		}
		return j;
	}

	public int getSumaNotas() {
		return sumaNotas;
	}

	public void setSumaNotas(int sumaNotas) {
		this.sumaNotas = sumaNotas;
	}

	public int getNumeroNotas() {
		return numeroNotas;
	}

	public void setNumeroNotas(int numeroNotas) {
		this.numeroNotas = numeroNotas;
	}

}
