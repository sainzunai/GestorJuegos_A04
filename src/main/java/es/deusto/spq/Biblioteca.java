package es.deusto.spq;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Biblioteca {

	
	@PrimaryKey
	private String biblioteca_id; 
	@Persistent
	private int numeroJuegos;

	//Que van a ir directamente a un USUARIO; 




	
	@Persistent(table="Biblioteca_VideoJuego",defaultFetchGroup="true")
    @Join(column="biblioteca_id")
    @Element(column="videoJuego_id")
	@Order(extensions=@Extension(vendorName="datanucleus", key="list-ordering", value="videoJuego_id ASC"))
	private List<VideoJuego> listaJuegos= new ArrayList<>();  //arraylist de videojeugos. que van a ir directamente a un USUARIO; 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biblioteca_id == null) ? 0 : biblioteca_id.hashCode());
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
		Biblioteca other = (Biblioteca) obj;
		if (biblioteca_id == null) {
			if (other.biblioteca_id != null)
				return false;
		} else if (!biblioteca_id.equals(other.biblioteca_id))
			return false;
		return true;
	}

	public Biblioteca(String id,List<VideoJuego> listaJuegos ) {
		
		this.biblioteca_id = id; 
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
		
		boolean add = true; 
		
		for(int i = 0; i < listaJuegos.size(); i ++) {
			
			if (listaJuegos.get(i).getId() == v.getId()) {
				
				add = false; 
				
			} 
			
		}
		
		if(add == true) {
			listaJuegos.add(v); 
		
		}
	}
	
	public void remJuego(VideoJuego v) {
		
		listaJuegos.remove(v); 
		
	}
	public String getId() {
		return biblioteca_id;
	}

	public void setId(String id) {
		this.biblioteca_id = id;
	}

	public List<VideoJuego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<VideoJuego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
}
