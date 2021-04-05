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

public class JPanelVideojuego extends JPanel {
	JLabelGraficoAjustado lImagen;
	JButton btn;
	String textoBtn = "Add";

	public JPanelVideojuego(String rutaImagen) {
		lImagen = new JLabelGraficoAjustado(rutaImagen, 13 * 20, 15 * 20);
		this.setLayout(new BorderLayout());
		this.add(lImagen, BorderLayout.CENTER);
		btn = new JButton(textoBtn);
		this.add(btn, BorderLayout.SOUTH);
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}

	public JPanelVideojuego() {
		lImagen = new JLabelGraficoAjustado("", 13 * 20, 15 * 20);
		this.setLayout(new BorderLayout());
		this.add(lImagen, BorderLayout.CENTER);
		btn = new JButton(textoBtn);
		this.add(btn, BorderLayout.SOUTH);
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

	}

	public JPanelVideojuego(String nombre, int loquesea) {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(13 * 20, 15 * 20));
		JLabel lbl = new JLabel(nombre);
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

			}
		});
	}

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setVisible(true);
		ventana.setSize(500, 500);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanelVideojuego p = new JPanelVideojuego();
		ventana.add(p);
		ventana.revalidate();

	}
}
