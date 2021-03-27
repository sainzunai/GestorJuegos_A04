package es.deusto.spq;

import java.util.ArrayList;

public class VideoJuego {
	
	
	private String nombre; 
	private String id; 
	private String compania; 
	private int edadRecomendada; 
	
	
	private Plataforma plataforma; 
	
	//Aqui se añadiran atributos necesarios para la logica mas adelante. Ejemplo LINK hacia una foto. 
	
	private ArrayList<Calificacion> calificaciones;  //PUEDE QUE TENGA QUE SE UN HASH MAP. Iremos viendo
	
	
	//Lista de reviews y lista de comentarios. 
	
	
	//Dos posibles metodos: Este lo utilizamos si no tenemos ninguna calificacion
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, Plataforma p ) {
		
		
		this.nombre = nombre; 
		
		this.id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		this.plataforma = p; 
		
		this.calificaciones  = new ArrayList<>(); 
		
		
	}
	
	//Dos posibles metodos: Este lo utilizamos si tenemos la lista de calificaciones
	public VideoJuego(String nombre, String id, String company, int edadRecomendada, Plataforma p, ArrayList<Calificacion> calificaciones) {
		
		
		this.nombre = nombre; 
		
		this.id = id; 
		
		this.compania = company; 
		
		this.edadRecomendada = edadRecomendada; 
		
		this.plataforma = p; 
		
		this.calificaciones = calificaciones; 
		
		
	}
	
	public double calculoNotaMedia() {
		
		
		double notaMedia = 0.0; 
		
		int i; 
		
		for( i = 0; i < calificaciones.size(); i ++  ) {
			
			notaMedia = calificaciones.get(i).getNota();

		}

		return notaMedia / ( i + 1 );
		
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

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}




}
