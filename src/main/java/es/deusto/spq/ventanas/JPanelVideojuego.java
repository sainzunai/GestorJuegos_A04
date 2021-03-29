package es.deusto.spq.ventanas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JPanelVideojuego extends JPanel{
	JLabelGraficoAjustado lImagen;
	
	public JPanelVideojuego(String rutaImagen) {
		lImagen = new JLabelGraficoAjustado(rutaImagen, 13*20, 15*20);
		this.add(lImagen);
		this.setBorder(new LineBorder(Color.black));
		
	
	}

	
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setVisible(true);
		ventana.setSize(500,500);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanelVideojuego p = new JPanelVideojuego("recursos_test/Battlefield.jpg");
		ventana.add(p);
		ventana.revalidate();

	}
}
