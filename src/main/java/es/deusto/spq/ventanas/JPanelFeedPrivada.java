package es.deusto.spq.ventanas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.ventanas.recursos.StarRater;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class JPanelFeedPrivada extends JPanel{

	/**
	 * @param u Usuario que llama a la ventana. Null si es prueba
	 * @param v Videojuego del que se abre la feed. Null si es prueba
	 */
	public JPanelFeedPrivada(Usuario u, VideoJuego v) {
		this.setBorder(new LineBorder(Color.black));
		StarRater starRater = new StarRater(5, 3, 3);
		starRater.setBounds(365, 245, 80, 16);
		starRater.addStarListener(new StarRater.StarListener() {

			public void handleSelection(int selection) {
				System.out.println(selection);
			}
		});
		setLayout(null);
		
		this.add(starRater);
		
		JLabel lTitulo = new JLabel("Bienvenido " + u.getNombre() + " a tu feed privada de " + v.getNombre());
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
		
//		if(u != null && v != null) {
			JLabelGraficoAjustado lCaratula = new JLabelGraficoAjustado(v.getCaratula(), 300, 500);
			add(lCaratula);
			lCaratula.setBounds(37, 108, 300, 335);
			lCaratula.setBorder(LineBorder.createBlackLineBorder());
			
			JLabel lblNewLabel = new JLabel("Nombre: " + v.getNombre());
			lblNewLabel.setBounds(365, 130, 200, 13);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Compania: " + v.getCompania());
			lblNewLabel_1.setBounds(365, 153, 200, 13);
			add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Edad recomendada: " + v.getEdadRecomendada());
			lblNewLabel_1_1.setBounds(365, 176, 200, 13);
			add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Identificador: " + v.getId());
			lblNewLabel_1_2.setBounds(365, 199, 200, 13);
			add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Mi puntuacion: ");
			lblNewLabel_1_3.setBounds(365, 222, 200, 13);
			add(lblNewLabel_1_3);
			
			JPanel pNovedades = new JPanel();
			pNovedades.setBorder(new TitledBorder(new LineBorder(null), "Mis ultimas novedades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pNovedades.setBounds(531, 107, 448, 325);
			add(pNovedades);
			
//		}
		
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.getContentPane().add(new JPanelFeedPrivada(new Usuario(null, null, null), new VideoJuego()));
		f.setSize(1280, 720);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}
}