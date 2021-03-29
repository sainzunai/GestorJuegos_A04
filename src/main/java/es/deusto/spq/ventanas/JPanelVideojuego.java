package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
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

	
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setVisible(true);
		ventana.setSize(500,500);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanelVideojuego p = new JPanelVideojuego("recursos_test/Battlefield.jpg");
		ventana.add(p);
		ventana.revalidate();

	}
}
