package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JPanelVideojuego extends JPanel{
	JLabelGraficoAjustado lImagen;
	
	public JPanelVideojuego(String rutaImagen) {
		lImagen = new JLabelGraficoAjustado(rutaImagen, 13*20, 15*20);
		this.add(lImagen);
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);
	}
	
	public JPanelVideojuego() {
		lImagen = new JLabelGraficoAjustado("", 13*20, 15*20);
		this.add(lImagen);
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);
	}

	public JPanelVideojuego(String nombre, int loquesea) {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(13*20, 15*20));
		JLabel lbl = new JLabel(nombre);
		panel.add(lbl);
		this.add(panel);
		this.setPreferredSize(new Dimension(13*20, 15*20));
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);
	}
	
	
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setVisible(true);
		ventana.setSize(500,500);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanelVideojuego p = new JPanelVideojuego("FIFA20", 1);
		ventana.add(p);
		ventana.revalidate();

	}
}
