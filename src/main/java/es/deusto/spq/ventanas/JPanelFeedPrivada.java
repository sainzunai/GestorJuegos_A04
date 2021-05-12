package es.deusto.spq.ventanas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.ventanas.recursos_test.StarRater;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class JPanelFeedPrivada extends JPanel{

	/**
	 * @param u Usuario que llama a la ventana. Null si es prueba
	 * @param v Videojuego del que se abre la feed. Null si es prueba
	 */
	public JPanelFeedPrivada(Usuario u, VideoJuego v) {
		this.setBorder(new LineBorder(Color.black));
		StarRater starRater = new StarRater(5, 3, 3);
		starRater.setBounds(248, 157, 80, 16);
		starRater.addStarListener(new StarRater.StarListener() {

			public void handleSelection(int selection) {
				System.out.println(selection);
			}
		});
		setLayout(null);
		
		this.add(starRater);
		
		JLabel lTitulo = new JLabel("Bienvenido [Usuario] a tu feed privada de [Videojuego]");
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lTitulo.setBounds(221, 10, 643, 39);
		add(lTitulo);
		
		JTextArea taSubtitulo = new JTextArea();
		taSubtitulo.setEditable(false);
		taSubtitulo.setLineWrap(true);
		taSubtitulo.setRows(2);
		taSubtitulo.setText("En este rincon podras puntuar tus videojuegos e ir comentando avances con tus contactos [proximamente]");
		taSubtitulo.setBounds(27, 58, 927, 39);
		add(taSubtitulo);
		taSubtitulo.setOpaque(false);
		
		if(u != null && v != null) {
			JPanelVideojuego pV = v.getJPanelVideojuego();
			add(pV);
			pV.setBounds(100, 200, 400, 400);
		}
		
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.getContentPane().add(new JPanelFeedPrivada(new Usuario(null, null, null), new VideoJuego("BF4", "", "Ubisoft", 18, null, null, "recursos_test/Battlefield.jpg")));
		f.setSize(1280, 720);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}
}
