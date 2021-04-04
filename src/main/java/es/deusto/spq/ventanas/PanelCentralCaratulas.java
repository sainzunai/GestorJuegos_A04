package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import es.deusto.spq.VideoJuego;


public class PanelCentralCaratulas extends JPanel{
	public JTextField tfBuscador;
	JPanel panelVideojuegosConLayout;
	
	public PanelCentralCaratulas() {
		this.setBorder(new LineBorder(new Color(128, 0, 128)));
		
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHeader.setBackground(new Color(192, 192, 192));
		this.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfBuscador = new JTextField();
		tfBuscador.setText("Buscador");
		tfBuscador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelHeader.add(tfBuscador);
		tfBuscador.setColumns(10);
		
		
		
		FlowLayout fl_panelVideojuegosConLayout = new FlowLayout();
		fl_panelVideojuegosConLayout.setAlignment(FlowLayout.LEFT);
		panelVideojuegosConLayout = new JPanel(fl_panelVideojuegosConLayout);
		
		
		panelVideojuegosConLayout.setPreferredSize(new Dimension(600, 10000));//TODO preguntar a jpanel videojuego sus dimensiones y ajustar el panel
		
		JScrollPane pScroll = new JScrollPane(panelVideojuegosConLayout, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(pScroll, BorderLayout.CENTER);

//		panelVideojuegosConLayout.add(new JPanelVideojuego("recursos_test/Battlefield.jpg"));
//		panelVideojuegosConLayout.add(new JPanelVideojuego("recursos_test/Battlefield.jpg"));
//		panelVideojuegosConLayout.add(new JPanelVideojuego("recursos_test/Battlefield.jpg"));
//		panelVideojuegosConLayout.add(new JPanelVideojuego("recursos_test/Battlefield.jpg"));
//		panelVideojuegosConLayout.add(new JPanelVideojuego("recursos_test/Battlefield.jpg"));
//		panelVideojuegosConLayout.add(new JPanelVideojuego("recursos_test/Battlefield.jpg"));
		
	}
	
	public void anyadirCaratula(JPanelVideojuego caratula) {
		panelVideojuegosConLayout.add(caratula);
	}
	public void borrarPanel() {
		panelVideojuegosConLayout.removeAll();
		panelVideojuegosConLayout.repaint();
	}
	
	//----------- TEST DEL PANEL -----------
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setSize(1000,1000);
		ventana.setVisible(true);
		ventana.getContentPane().setLayout(new BorderLayout());
		PanelCentralCaratulas panel = new PanelCentralCaratulas();
		ventana.getContentPane().add(panel);
		VideoJuego juego = new VideoJuego();
		juego.setCaratula("recursos_test/Battlefield.jpg");
		panel.anyadirCaratula(juego.getJPanelVideojuego());
		panel.borrarPanel();
		panel.anyadirCaratula(juego.getJPanelVideojuego());
		panel.anyadirCaratula(juego.getJPanelVideojuego());
		ventana.revalidate();
		ventana.repaint();
		
	}
	
}
