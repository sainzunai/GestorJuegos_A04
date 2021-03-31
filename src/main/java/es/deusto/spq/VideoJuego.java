package es.deusto.spq;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class VideoJuego {
	
	
	@PrimaryKey 
	private String id; 
	
	private String nombre;
	private String compania; 
	private String caratula; 
	private int edadRecomendada; 
	
	
	
	
	@Join
	private List<Plataforma> plataforma= new ArrayList<>(); 
	
	//Hace falta un array de Reviews y otro de Comentarios! OJO BD. 
	
	private ArrayList<Calificacion> calificaciones;  //Puede que tenga que ser un HASH MAP. Iremos viendo
	
	//Dos posibles metodos: Este lo utilizamos si no tenemos ninguna calificacion
	public VideoJuego(String nombre, String id, String company, int edadRecomendada ) {
		
		
		this.nombre = nombre; 
		
		this.id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		 
		
		this.calificaciones  = new ArrayList<>(); 
		
		
	}

	//Dos posibles metodos: Este lo utilizamos si tenemos la lista de calificaciones
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, ArrayList<Calificacion> calificaciones) {
		
		
		this.nombre = nombre; 
		
		this.id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		
		
		this.calificaciones = calificaciones; 
		
		
	}
	
	
	public VideoJuego() {
		
		
		this.nombre = ""; 
		
		this.id = ""; 
		
		this.compania = ""; 
		
		this.edadRecomendada = 0; 
		
		
		
		this.calificaciones = new ArrayList<>(); 
		
		
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
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public void setPlataformas(List<Plataforma> p) {
		this.plataforma = p;
	}
	public void addPlataforma(Plataforma p) {
		plataforma.add(p);
	}

	public void removePlataforma(Plataforma p) {
		plataforma.remove(p);
	}

	public List<Plataforma> getPlataformas() {
		return plataforma;
	}

	public int getNumberOfPlataformas() {
		return plataforma.size();
	}
	
	//IMPLEMENTACION DE VENTANAS  
	
	/*
	 * public JPanelVideoJuego getJPanelVideoJuego() {
	 * 
	 * JPanelVideoJuego j = new JPanelVideoJuego(this.caratula);
	 * 
	 * return j;
	 * 
	 * }
	 */


}
