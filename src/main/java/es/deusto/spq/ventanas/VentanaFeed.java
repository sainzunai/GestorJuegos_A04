package es.deusto.spq.ventanas;

import javax.swing.JFrame;

import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;

public class VentanaFeed extends JFrame {

	public VentanaFeed(VideoJuego v) {

/////////////////////////////////////////////////////
//creacion de panatalla y centrado de la pantalla //
/////////////////////////////////////////////////////

		setTitle("Iniciar sesion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(350, 200);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		// Test
		Plataforma plat = new Plataforma();
		plat.setNombrePlataforma("PC");
		VideoJuego v = new VideoJuego("Battlefield V", "111", "Ubisoft", 18, plat, "path");
		VentanaFeed ventana = new VentanaFeed(v);

	}

}
