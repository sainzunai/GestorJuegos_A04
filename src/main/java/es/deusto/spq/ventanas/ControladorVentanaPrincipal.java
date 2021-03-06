package es.deusto.spq.ventanas;

import java.util.ArrayList;
import java.util.List;
import es.deusto.spq.Biblioteca;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

/**
 * Reune todas las funcionalidades de la vetnana principal.
 * @author Unai
 *
 */
public class ControladorVentanaPrincipal {
	VentanaPrincipal miVentana;

	//----------------------------------------------------------------------
	//--------------CONEXION AL SERVIDOR-----------------------------------
	static final long serialVersionUID = 1L;
	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/gestorJuegos");
	final WebTarget videoJuegosTarget = appTarget.path("videojuegos");
	final WebTarget usersTarget = appTarget.path("usuarios");
	//----------------------------------------------------------------------


	private boolean carga = true; 

	private boolean estamosEnHome = false;

	private boolean estamosEnBiblio = false;

	private Usuario u; 

	private ArrayList<VideoJuego> v = new ArrayList<>(); 

	public ControladorVentanaPrincipal(VentanaPrincipal miVentana, Usuario u){
		this.miVentana = miVentana;	
		this.u = u; 
	}

	/**
	 * Muestra fisicamente Home-> Videojuegos en la ventana principal.
	 * Se muestran todos los videojuegos disponibles en esta seccion.
	 */
	public void mostrarHomeVideojuegos() {

		estamosEnBiblio = false;
		estamosEnHome = true;

		if (carga == true) {
			GenericType<List<VideoJuego>> genericType = new GenericType<List<VideoJuego>>() {
			};
			List<VideoJuego> juegos = videoJuegosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
			System.out.println("Leemos de Base Datos. Numero de Juegos:" + juegos.size());
			miVentana.panelCentralCaratulas.borrarPanel();
			for (VideoJuego juego : juegos) {
				miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(u.getBiblioteca(), estamosEnHome, u));
				System.out.println(juego.getNombre());
				v.add(juego);
			}

			carga = false;

		}

		else {

			System.out.println("NO Leemos de Base Datos");
			miVentana.panelCentralCaratulas.borrarPanel();
			for (VideoJuego juego : v) {
				miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(u.getBiblioteca(), estamosEnHome, u));
			}

		}

		miVentana.panelCentralCaratulas.repaint();
		miVentana.panelCentralCaratulas.revalidate();
		miVentana.panelCentralCaratulas.setVisible(true);

	}

	/**
	 * Muestra fisicamente Bibliotca-> Videojuegos en la ventana principal.
	 * Se muestran unicamente los videojuegos que ha anyadido el usuario a la biblioteca.
	 */
	public void mostrarBibliotecaVideojuegos() {

		estamosEnBiblio = true;
		estamosEnHome = false;

		miVentana.panelCentralCaratulas.borrarPanel();
		for (VideoJuego juego : u.getBiblioteca().getListaJuegos()) {
			miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(u.getBiblioteca(), estamosEnHome, u));

		}

		miVentana.panelCentralCaratulas.repaint();
		miVentana.panelCentralCaratulas.revalidate();
		miVentana.panelCentralCaratulas.setVisible(true);

	}

	/**
	 * Al cerrar la ventana es necesario llamar a este metodo.
	 * Actualiza los ultimos cambios en el servidor.
	 */
	public void accionCerrarVentana() {
		System.out.println("ESTE ES MI ID FINAL:" + u.getBiblioteca().getId());
		usersTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(u.getBiblioteca(), MediaType.APPLICATION_JSON));
	}

	// 
	/**M??todo para el filtrado de juegos al pulsar al boton Buscar
	 * @param textoBuscar
	 */
	public void accionBotonBuscar(String textoBuscar) {
		// Se genera una lista donde vamos a guardar todas las que coincidan con el
		// nombre
		ArrayList<VideoJuego> buscador = new ArrayList<>();

		// La creamos cada vez que damos al boton asi se eliminara una vez se entre
		// dentro.
		miVentana.panelCentralCaratulas.borrarPanel();

		System.out.println("Estamos en home: " + estamosEnHome);
		System.out.println("Estamos en biblio: " + estamosEnBiblio);

		if (estamosEnHome) { // Estamos colocados en la ventana de home

			for (int i = 0; i < v.size(); i++) {
				if (v.get(i).getNombre().contains(textoBuscar)) {

					buscador.add(v.get(i));
					System.out.println("HOME: Anyadiendo videjuego a la lista: " + v.get(i).getNombre());
				}
			}
		}

		if (estamosEnBiblio) { // Estamos colocados en la ventana de biblioteca

			for (int i = 0; i < u.getBiblioteca().numeroDeJuegos(); i++) {
				if (u.getBiblioteca().getListaJuegos().get(i).getNombre().contains(textoBuscar)) {

					buscador.add(u.getBiblioteca().getListaJuegos().get(i));
					System.out.println("BIBLIO: Anyadiendo videjuego a la lista: " + v.get(i).getNombre());
				}
			}
		}

		System.out.println("Numero total de juegos encontrador:" + buscador.size());

		for (VideoJuego juego : buscador) {
			miVentana.panelCentralCaratulas.anyadirCaratula(juego.getJPanelVideojuego(u.getBiblioteca(), estamosEnHome, u));
		}

		System.out.println("A??adiendo Juegos al panel");

		miVentana.panelCentralCaratulas.repaint();
		miVentana.panelCentralCaratulas.revalidate();

	}

	/**
	 * Devuelve el objeto Biblioteca asignado al ControladorVentanaPrincipal
	 * @return objeto Biblioteca
	 */
	public Biblioteca getB() {
		return u.getBiblioteca();
	}

	/**
	 * Devuelve el valor booleano de la variable para la carga de la lista de VideoJuego en el panel
	 * @return boolean valor de carga
	 */
	public boolean isCarga() {
		return carga;
	}

	/**
	 * Estblece un valor para el parametro carga del controlador
	 * @param carga valor booleano que se quiera establecer
	 */
	public void setCarga(boolean carga) {
		this.carga = carga;
	}

	/**
	 * Devuelve el valor booleano de la variable que indica si actualmente 
	 * el Usuario esta situado en el panel de home
	 * @return valor booleano de estamosEnHome
	 */
	public boolean isEstamosEnHome() {
		return estamosEnHome;
	}

	/**
	 * Establece un valor para el parametro estamosEnHome
	 * @param estamosEnHome valor booleano a establecer
	 */
	public void setEstamosEnHome(boolean estamosEnHome) {
		this.estamosEnHome = estamosEnHome;
	}

	/**
	 * Devuelve el valor booleano de la variable que indica si el Usuario
	 * esta situado en el panel de biblioteca
	 * @return valor booleano de estamosEnBiblio
	 */
	public boolean isEstamosEnBiblio() {
		return estamosEnBiblio;
	}

	/**
	 * Establece un valor booleano para el parametro estamosEnBiblio
	 * @param estamosEnBiblio valor booleano a establecer
	 */
	public void setEstamosEnBiblio(boolean estamosEnBiblio) {
		this.estamosEnBiblio = estamosEnBiblio;
	}

}
