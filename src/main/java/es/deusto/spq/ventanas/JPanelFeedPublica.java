package es.deusto.spq.ventanas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class JPanelFeedPublica extends JPanel{

	/**
	 * @param u Usuario que llama a la ventana. Null si es prueba
	 * @param v Videojuego del que se abre la feed. Null si es prueba
	 */
	public JPanelFeedPublica(Usuario u, final VideoJuego v) {
		this.setBorder(new LineBorder(Color.black));

		JLabel rater = new JLabel("media: " + v.calculoNotaMedia());
		rater.setBounds(365, 245, 80, 16);

		final JPanelFeedPublica jp = this; 
		setLayout(null);
		this.add(rater);

		JLabel lTitulo = new JLabel("Feed Publica del VideoJuego: " + v.getNombre());
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lTitulo.setBounds(221, 10, 643, 39);
		add(lTitulo);


		JTextArea taSubtitulo = new JTextArea();
		taSubtitulo.setEditable(false);
		taSubtitulo.setLineWrap(true);
		taSubtitulo.setRows(2);
		taSubtitulo.setText("Si te gusta el juego, quieres votarlo y comentar no dudes en añadirlo a tu biblioteca");
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

		JLabel lblNewLabel_1_3 = new JLabel("Num votos: " + v.getNumeroNotas());
		lblNewLabel_1_3.setBounds(365, 222, 200, 13);
		add(lblNewLabel_1_3);

		JPanel pNovedades = new JPanel();
		pNovedades.setBorder(new TitledBorder(new LineBorder(null), "Juegos de salida proximamente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pNovedades.setBounds(531, 107, 448, 355);

		JLabelGraficoAjustado lCaratula1 = new JLabelGraficoAjustado("/images/proximamente.jpg", 300, 500);
		add(lCaratula1);
		lCaratula1.setBounds(37, 108, 300, 335);
		lCaratula1.setBorder(LineBorder.createBlackLineBorder());

		pNovedades.add(lCaratula1);
		add(pNovedades);

		//		}

	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.getContentPane().add(new JPanelFeedPublica(new Usuario(null, null, null), new VideoJuego()));
		f.setSize(1280, 720);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}
}