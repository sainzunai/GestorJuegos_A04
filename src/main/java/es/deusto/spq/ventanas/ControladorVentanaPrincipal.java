package es.deusto.spq.ventanas;

import java.util.ArrayList;
import java.util.List;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class ControladorVentanaPrincipal {
VentanaPrincipal miVentana;

//----------------------------------------------------------------------
//--------------CONEXION AL SERVIDOR-----------------------------------
final long serialVersionUID = 1L;
Client client = ClientBuilder.newClient();
final WebTarget appTarget = client.target("http://localhost:8080/gestorJuegos");
final WebTarget videoJuegosTarget = appTarget.path("videojuegos");
//----------------------------------------------------------------------


	Biblioteca b = new Biblioteca(); //Biblioteca 
	
	boolean carga = true; 

	ArrayList<VideoJuego> v = new ArrayList<>(); 
	
	ControladorVentanaPrincipal(VentanaPrincipal miVentana){
		this.miVentana = miVentana;
	}

	public void mostrarHomeVideojuegos() {
		//miVentana.panelCentralCaratulas.setVisible(false);
		//TODO: llamada a servidor y descargar los videojuegos
//		ArrayList<VideoJuego> listaJuegos = new ArrayList<>();
//		listaJuegos.add(new VideoJuego("Animal crossing", "", "", 10, new Plataforma("", "")));
		
		//Conexion a server -- peticion
		
		if(carga == true ) {
		GenericType<List<VideoJuego>> genericType = new GenericType<List<VideoJuego>>() {};
        List<VideoJuego> juegos = videoJuegosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
        System.out.println("Leemos de Base Datos");
        miVentana.panelCentralCaratulas.borrarPanel();
        for (VideoJuego juego : juegos) {
            miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(b));
            System.out.println(juego.getNombre());
            v.add(juego); 
        }
        
        carga = false; 
       
		}
		
		else {
			
			System.out.println("NO Leemos de Base Datos");
	        miVentana.panelCentralCaratulas.borrarPanel();
	        for (VideoJuego juego : v) {
	            miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(b));
	        }			
			
			
		}
        miVentana.panelCentralCaratulas.setVisible(true);

	}

	public void mostrarBibliotecaVideojuegos() {
        
		miVentana.panelCentralCaratulas.borrarPanel();
        for (VideoJuego juego : b.getListaJuegos()) {
            miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(b));
        }
        miVentana.panelCentralCaratulas.setVisible(true);
		
	}
	
	public void accionBotonBuscar(String textoBuscar) {
		//TODO
		
		ArrayList<VideoJuego> buscador = new ArrayList<>(); //Se genera una lista donde vamos a guardar todas las que coincidan con el nombre 
		

		for(int i = 0; i < v.size(); i ++) {
			if(v.get(i).getNombre().contains(textoBuscar)) {
				
				buscador.add(v.get(i)); 
				System.out.println("Anyadiendo videjuego a la lista: " + v.get(i).getNombre());
			}
			
		}
		System.out.println(buscador.size());
	}
	
	

}
