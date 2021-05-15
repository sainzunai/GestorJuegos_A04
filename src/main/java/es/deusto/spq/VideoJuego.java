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


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class VideoJuego implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey 
	private String videojuego_id; 
	
	private String nombre;
	
	private String compania;
	
	private String caratula; 
	
	private int edadRecomendada; 
	@Persistent
	private Plataforma plataforma; 

	//Hace falta un array de Reviews y otro de Comentarios! OJO BD. 
	@Persistent(defaultFetchGroup="true")
    @Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="biblioteca_id ASC"))
    private List<Biblioteca> biblioteca= new ArrayList<>();
    
    
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

	private ArrayList<Calificacion> calificaciones;  //Puede que tenga que ser un HASH MAP. Iremos viendo
	
	/**
	 * Prueba para ver si la documentacion funciona
	 */
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, Plataforma plataforma, String caratula ) {
		
		
		this.nombre = nombre; 
		
		this.videojuego_id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		this.plataforma=plataforma;
		
		this.calificaciones  = new ArrayList<>(); 
		
		this.caratula = caratula; 
		
	}
	
	
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, Plataforma plataforma) {
		
		
		this.nombre = nombre; 
		
		this.videojuego_id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		this.plataforma=plataforma;
		
		this.calificaciones  = new ArrayList<>(); 
		
		this.caratula = " "; 
		
	}
	
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, ArrayList<Calificacion> calificaciones,Plataforma plataforma) {
				
		this.nombre = nombre; 
		
		this.videojuego_id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		this.plataforma=plataforma;
		
		this.calificaciones = calificaciones; 
		
		this.caratula = " "; 
		
	}
	
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, ArrayList<Calificacion> calificaciones,Plataforma plataforma, String caratula) {
				
		this.nombre = nombre; 
		
		this.videojuego_id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		this.plataforma=plataforma;
		
		this.calificaciones = calificaciones; 
		
		this.caratula = caratula; 
		
	}
	
	
	public VideoJuego() {
				
		this.nombre = ""; 
		
		this.videojuego_id = ""; 
		
		this.compania = ""; 
		
		this.edadRecomendada = 0; 
		
		this.calificaciones = new ArrayList<>(); 
		
		this.caratula = " "; 
			
	}
	
	public double calculoNotaMedia() {
				
		double notaMedia = 0.0; 
		
		int i; 
		
		for( i = 0; i < calificaciones.size(); i ++  ) {
			
			notaMedia = notaMedia + calificaciones.get(i).getNota();

		}

		return notaMedia / ( i );
		
	}
	
	public int calculaVotosDeNota(int votacion) { //Nos dice el numero de 10 o 9 que ha habido para el juego. 
		
		int i; 
		
		int numeroNotas = 0; 
		
		for( i = 0; i < calificaciones.size(); i ++  ) {
			
			if(votacion == calificaciones.get(i).getNota()) {
				
				numeroNotas ++; 
	
			}
		}	
		
		return numeroNotas;
				
	}
	
	
	public int notaMaxima() {

		int i; 

		int nota = 0; 

		for( i = 0; i < calificaciones.size(); i ++  ) {

			if (nota < calificaciones.get(i).getNota()) {

				nota = calificaciones.get(i).getNota(); 
			}

		}		
		return nota; 

	}
	
	public void addCalificacion(Calificacion c) {
		
		this.calificaciones.add(c); 
	}
	
	public boolean remCalificacion(Calificacion c) {
		
		return this.calificaciones.remove(c); 
	}
	

	public String getNombre() {
		return nombre;
	}

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

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
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
		biblioteca=b;
	}
	
	
	public JPanelVideojuego getJPanelVideojuego(Biblioteca b) {

	  if(caratula == " ") {
		  j = new JPanelVideojuego(this, 1, b); 		  
	  }
	  
	  else {	  
		  j = new JPanelVideojuego(this, b);	  
	  }
	  	  
	  return j;
	  
	}
	 
}
