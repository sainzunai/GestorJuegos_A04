package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.VideoJuego;

public class JPanelVideojuego extends JPanel {
	JLabelGraficoAjustado lImagen;
	JButton btn;
	String textoBtn = "Add";
	
	public int loquesea; 


	public JPanelVideojuego(final VideoJuego v, final Biblioteca b) {
		this.loquesea = 0; 
		lImagen = new JLabelGraficoAjustado(v.getCaratula(), 13 * 20, 15 * 20);
		this.setLayout(new BorderLayout());
		this.add(lImagen, BorderLayout.CENTER);
		btn = new JButton(textoBtn);
		this.add(btn, BorderLayout.SOUTH);
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				b.addJuego(v);
				

			}
		});
	}

//	public JPanelVideojuego(final Biblioteca b) {
//		lImagen = new JLabelGraficoAjustado("", 13 * 20, 15 * 20);
//		this.setLayout(new BorderLayout());
//		this.add(lImagen, BorderLayout.CENTER);
//		btn = new JButton(textoBtn);
//		this.add(btn, BorderLayout.SOUTH);
//		this.setBorder(new LineBorder(Color.black));
//		this.setBackground(Color.white);
//		btn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				b.addJuego(v);
//
//			}
//		});
//
//	}

	public JPanelVideojuego(final VideoJuego v, int loquesea, final Biblioteca b) {
		this.loquesea = loquesea; 
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(13 * 20, 15 * 20));
		JLabel lbl = new JLabel(v.getNombre());
		panel.add(lbl);
		this.setLayout(new BorderLayout());
		btn = new JButton(textoBtn);
		this.add(btn, BorderLayout.SOUTH);
		this.add(panel);
		this.setPreferredSize(new Dimension(13 * 20, 15 * 20));
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				b.addJuego(v);

			}
		});
	}

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setVisible(true);
		ventana.setSize(500, 500);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		VideoJuego v = new VideoJuego("hola", "d", "sss", 10, null); 
		Biblioteca b = new Biblioteca(); //Lo he cambiado
		JPanelVideojuego p = v.getJPanelVideojuego(b); 
		ventana.add(p);
		ventana.revalidate();

	}
}
