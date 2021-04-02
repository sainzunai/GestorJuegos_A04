package es.deusto.spq.ventanas;

public class ControladorVentanaPrincipal {
VentanaPrincipal miVentana;
	
	ControladorVentanaPrincipal(VentanaPrincipal miVentana){
		this.miVentana = miVentana;
	}

	public void mostrarHomeVideojuegos() {
		miVentana.panelCentralCaratulas.setVisible(false);
		
	}

	public void mostrarBibliotecaVideojuegos() {
		miVentana.panelCentralCaratulas.setVisible(true);
		
	}
	
	

}
