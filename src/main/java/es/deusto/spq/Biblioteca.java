package es.deusto.spq;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
@PersistenceCapable
public class Biblioteca {
	//Que van a ir directamente a un USUARIO; 
	private String bilioteca_id; 


	
	@Persistent(table="Biblioteca_VideoJuego")
    @Join(column="biblioteca_id")
    @Element(column="videoJuego_id")
    @Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="id ASC"))
	private List<VideoJuego> listaJuegos= new ArrayList<>();  //arraylist de videojeugos. que van a ir directamente a un USUARIO; 

	public Biblioteca(String id,ArrayList<VideoJuego> listaJuegos ) {
		
		this.bilioteca_id = id; 
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
		return bilioteca_id;
	}

	public void setId(String id) {
		this.bilioteca_id = id;
	}

	public List<VideoJuego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(ArrayList<VideoJuego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
	public void addVideoJuego(VideoJuego v) {
		listaJuegos.add(v);
	}

	public void removeVideojuego(VideoJuego v) {
		listaJuegos.remove(v);
	}
	
	


}
