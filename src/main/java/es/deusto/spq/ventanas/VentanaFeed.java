package es.deusto.spq.ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import es.deusto.spq.Plataforma;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaFeed extends JFrame {

	public VentanaFeed(VideoJuego v, Usuario u, boolean stamosHome) {

		/////////////////////////////////////////////////////
		//creacion de panatalla y centrado de la pantalla //
		/////////////////////////////////////////////////////

		setTitle("Comunidad de " + v.getNombre());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1020, 720);
		setLocationRelativeTo(null);

		setResizable(false);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel pPublica = new JPanel();
		pPublica.setBorder(new LineBorder(Color.ORANGE, 3));
		pPublica.setToolTipText("Comunidad");
		ImageIcon icon1 = createImageIcon("publico.png",
				"publico");
		tabbedPane.addTab("Comunidad Publica", icon1, pPublica, null);

		JPanel pPrivada = new JPanel();
		pPrivada.setBorder(new LineBorder(Color.GREEN, 3));
		pPrivada.setToolTipText("Feed Privada");
		ImageIcon icon2 = createImageIcon("stich4.png",
				"privado");

		if(stamosHome == false) {

			tabbedPane.addTab("Feed Privada", icon2, pPrivada, null);

		}

		setVisible(true);


		/////////////////////////////////////////////////////////////////////////
		///_________________GESTION INDIVIDUAL DE PANELES_____________________///
		/////////////////////////////////////////////////////////////////////////

		//PARTE PUBLICA
		JPanelFeedPublica pFeedP = new JPanelFeedPublica(u, v);
		pPublica.setLayout(null);
		pPublica.add(pFeedP);
		pFeedP.setBounds(0,0,1000,1000);

		//PARTE PRIVADA
		JPanelFeedPrivada pFeedPriv = new JPanelFeedPrivada(u, v);
		pPrivada.setLayout(null);
		pPrivada.add(pFeedPriv);
		pFeedPriv.setBounds(0,0,1000,1000);

	}




	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void main(String[] args) {
		// Test
		Plataforma plat = new Plataforma();
		plat.setNombrePlataforma("PC");
		VideoJuego v = new VideoJuego("Battlefield V", "111", "Ubisoft", 18, plat, "path");
		Usuario u = new Usuario("", "", "Unaii");
		VentanaFeed ventana = new VentanaFeed(v, u, false);

	}

}