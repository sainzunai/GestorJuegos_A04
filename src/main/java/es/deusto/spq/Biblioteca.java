package es.deusto.spq;

import java.util.ArrayList;

public class Biblioteca {
	
	
	private String id; 
	private int numeroJuegos; 
	private ArrayList<VideoJuego> listaJuegos;  //arraylist de videojeugos. que van a ir directamente a un USUARIO; 
	
	public Biblioteca(String id,ArrayList<VideoJuego> listaJuegos ) {
		
		this.id = id; 
		this.listaJuegos = listaJuegos;  
		
		
	}
	
	public Biblioteca(String id) {  //Creamos solo con un id; 
		
		this.setId(id); 
		this.listaJuegos = new ArrayList<>(); 
		
	}
	
	
	
	
	public VideoJuego calcularVideojuegoAlto() {
		VideoJuego v = new VideoJuego(); 
		
		 
		v.getCalificaciones().add(new Calificacion(0, 0 ,0 ,0)); 
		
		for(int i = 0; i < listaJuegos.size(); i++) {
			
			if( listaJuegos.get(i).getCalificaciones().get(i).getNota() > v.getCalificaciones().get(0).getNota() ) {
				
				
				v =  listaJuegos.get(i); 
				
				
			}
			
			
		}
		
		return v; 
	}
	
	public int numeroDeJuegos() {
		
		return listaJuegos.size(); 
		
	}
	
	public double calcularMediaNotas() { //NECESARIO CREAR CUANDO TENGAMOS UN USUARIO
		//ASI SABREMOS QUE NOTA HA DADO CADA USUARIO 
		
		double nota = 0.0; 
		int i; 
		for(i = 0; i < listaJuegos.size(); i++) {
			
			nota = nota +  listaJuegos.get(i).getCalificaciones().get(i).getNota(); 
			
			
		}
		
		return nota / i ; 
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getNumeroJuegos() {
		return numeroJuegos;
	}

	public void setNumeroJuegos(int numeroJuegos) {
		this.numeroJuegos = numeroJuegos;
	}


	public ArrayList<VideoJuego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(ArrayList<VideoJuego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}

	
	
	
	
	
	
	
	
	
	

	
	
	
	

}
