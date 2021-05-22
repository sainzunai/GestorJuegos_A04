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

/**
 * JPanel para incluir en la ventana Feed.
 * Se muestra la feed publica (igual para todos los usuarios)
 * @author Asier
 *
 */
public class JPanelFeedPublica extends JPanel{

	/**
	 * @param u Usuario que llama a la ventana. Null si es prueba
	 * @param v Videojuego del que se abre la feed. Null si es prueba
	 */
	public JPanelFeedPublica(Usuario u, final VideoJuego v) {
		this.setBorder(new LineBorder(Color.black));

		JLabel rater = new JLabel("Nota media: " + v.calculoNotaMedia());
		rater.setFont(new Font("Tahoma", Font.BOLD, 12));
		rater.setBounds(415, 246, 161, 16);

		final JPanelFeedPublica jp = this; 
		setLayout(null);
		this.add(rater);

		JLabel lTitulo = new JLabel("Feed Publica del VideoJuego: " + v.getNombre());
		lTitulo.setForeground(Color.BLACK);
		lTitulo.setBackground(Color.gray);
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lTitulo.setBounds(0, 0, 1097, 49);
		add(lTitulo);


		JTextArea taSubtitulo = new JTextArea();
		taSubtitulo.setFont(new Font("Constantia", Font.PLAIN, 15));
		taSubtitulo.setEditable(false);
		taSubtitulo.setLineWrap(true);
		taSubtitulo.setRows(2);
		taSubtitulo.setText("Si te gusta el juego, quieres votarlo y comentar no dudes en añadirlo a tu biblioteca");
		taSubtitulo.setBounds(27, 42, 927, 39);
		add(taSubtitulo);
		taSubtitulo.setOpaque(false);

		//		if(u != null && v != null) {
		JLabelGraficoAjustado lCaratula = new JLabelGraficoAjustado(v.getCaratula(), 12 * 27, 15 * 27);
		add(lCaratula);
		lCaratula.setBounds(37, 129, 345, 385);
		//lCaratula.setBorder(LineBorder.createBlackLineBorder());

		JLabel lblNewLabel = new JLabel("Nombre: " + v.getNombre());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(415, 131, 200, 13);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Compania: " + v.getCompania());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(415, 154, 200, 13);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Edad recomendada: " + v.getEdadRecomendada());
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(415, 177, 200, 13);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Identificador: " + v.getId());
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(415, 200, 200, 13);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Num votos: " + v.getNumeroNotas());
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(415, 223, 200, 13);
		add(lblNewLabel_1_3);

		JPanel pNovedades = new JPanel();
		pNovedades.setBorder(new TitledBorder(new LineBorder(null), "Juegos de salida proximamente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pNovedades.setBounds(681, 149, 461, 365);
		pNovedades.setLayout(null);

		JLabelGraficoAjustado lCaratula1 = new JLabelGraficoAjustado("/images/Silksong_cover.jpg", 13 * 19, 15 * 20);
		//add(lCaratula1);
		lCaratula1.setBounds(29, 20, 247, 300);
		lCaratula1.setBorder(LineBorder.createBlackLineBorder());

		pNovedades.add(lCaratula1);
		add(pNovedades);
		
		JLabel lblNewLabel_2 = new JLabel("Hollow Knight");
		lblNewLabel_2.setBounds(302, 39, 139, 29);
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 20));
		pNovedades.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio de salida: 55€");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(302, 78, 139, 13);
		pNovedades.add(lblNewLabel_3);
		
		JLabel lDescripcionVideojuego = new JLabel("Silksong es un videojuego en desarrollo del género Metroidvania, desarrollado y publicado por Team Cherry para Windows, macOS, Linux y Nintendo Switch.");
		lDescripcionVideojuego.setHorizontalAlignment(SwingConstants.CENTER);
		lDescripcionVideojuego.setVerticalAlignment(SwingConstants.TOP);
		String descripcion = "Silksong es un videojuego en desarrollo del género Metroidvania, desarrollado y publicado por Team Cherry para Windows, macOS, Linux y Nintendo Switch." + "El videojuego cuenta la historia del Caballero, en su búsqueda para descubrir los secretos del largamente abandonado reino de Hallownest, cuyas profundidades atraen a los aventureros y valientes con la promesa de tesoros o la respuesta a misterios antiguos.";
		lDescripcionVideojuego.setText("<html><p style=\"width:100px\">"+descripcion+"</p></html>");
		lDescripcionVideojuego.setBounds(302, 101, 149, 244);
		pNovedades.add(lDescripcionVideojuego);
		
		JLabel lblNewLabel_4 = new JLabel("¡¡Reservalo ya!!");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(64, 330, 184, 13);
		pNovedades.add(lblNewLabel_4);
		
		String textoNota = "La nota media viene definida por usuarios como tu, que cada vez que votais contribuis a esta maravilosa comunidad. No olvides anadir el videojuego a tu biblioteca privada si quieres contribuir!";
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setText("<html><p style=\"width:100px\">"+textoNota+"</p></html>");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setBounds(450, 272, 165, 160);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(v.getNombre());
		lblNewLabel_6.setFont(new Font("SWTxt", Font.BOLD, 22));
		lblNewLabel_6.setBounds(27, 70, 517, 49);
		add(lblNewLabel_6);

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