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


	Biblioteca b = new Biblioteca("Mi biblioteca"); //Biblioteca 

	
	ControladorVentanaPrincipal(VentanaPrincipal miVentana){
		this.miVentana = miVentana;
	}

	public void mostrarHomeVideojuegos() {
		miVentana.panelCentralCaratulas.setVisible(false);
		//TODO: llamada a servidor y descargar los videojuegos
//		ArrayList<VideoJuego> listaJuegos = new ArrayList<>();
//		listaJuegos.add(new VideoJuego("Animal crossing", "", "", 10, new Plataforma("", "")));
		
		//Conexion a server -- peticion
		GenericType<List<VideoJuego>> genericType = new GenericType<List<VideoJuego>>() {};
        List<VideoJuego> juegos = videoJuegosTarget.request(MediaType.APPLICATION_JSON).get(genericType);

        miVentana.panelCentralCaratulas.borrarPanel();
        for (VideoJuego juego : juegos) {
            miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(b));
        }

	}

	public void mostrarBibliotecaVideojuegos() {
		miVentana.panelCentralCaratulas.setVisible(true);
		
	}
	
	

}
