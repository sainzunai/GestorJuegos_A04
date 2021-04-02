package es.deusto.spq;

import java.util.ArrayList;

public class Biblioteca {  //PUEDE QUE FALTEN METODOS ADICIONALES PARA VENTANA. 
	
	
	private String id; 
	private ArrayList<VideoJuego> listaJuegos;  //arraylist de videojeugos. 
	//Que van a ir directamente a un USUARIO; 
	
	public Biblioteca(String id,ArrayList<VideoJuego> listaJuegos ) {
		
		this.id = id; 
		this.listaJuegos = listaJuegos;  
		
		
	}
	
	public Biblioteca(String id) {  //Creamos solo con un id; 
		
		this.setId(id); 
		this.listaJuegos = new ArrayList<>(); 
		
	}
	
	public int numeroDeJuegos() {  //Devuelve el numero de juegos en la biblioteca. 
		
		return listaJuegos.size(); 
		
	}
	
	public void addJuego(VideoJuego v) {
		
		listaJuegos.add(v); 
		
	}
	
	public void remJuego(VideoJuego v) {
		
		listaJuegos.remove(v); 
		
		
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<VideoJuego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(ArrayList<VideoJuego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}

	
	


}
