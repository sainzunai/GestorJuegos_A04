package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class VentanaPrincipal extends JFrame{
	ControladorVentanaPrincipal miControlador;
	
	
	public VentanaPrincipal() {
		miControlador = new ControladorVentanaPrincipal(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ORIGIN");
		this.setSize(new Dimension(1233, 657));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelContenedorMenu = new JPanel();
		panelContenedorMenu.setBackground(new Color(255, 255, 255));
		panelContenedorMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panelContenedorMenu, BorderLayout.WEST);
		panelContenedorMenu.setLayout(new GridLayout(2,1));
		
		JPanel panelEntradaMenuHome = new JPanel();
		panelEntradaMenuHome.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEntradaMenuHome.setBackground(new Color(192, 192, 192));
		panelContenedorMenu.add(panelEntradaMenuHome);
		panelEntradaMenuHome.setLayout(new GridLayout(4,1));
		
		JPanel panelMenuHome = new JPanel();
		panelMenuHome.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelEntradaMenuHome.add(panelMenuHome);
		panelMenuHome.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenuHome.add(lblHome, BorderLayout.CENTER);
		
		JPanel panelMenuHomeVideojuegos = new JPanel();
		panelMenuHomeVideojuegos.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelEntradaMenuHome.add(panelMenuHomeVideojuegos);
		panelMenuHomeVideojuegos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVideojuegos = new JLabel("Videojuegos");
		lblVideojuegos.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMenuHomeVideojuegos.add(lblVideojuegos);
		
		JPanel panelEntradaMenuBiblioteca = new JPanel();
		panelEntradaMenuBiblioteca.setBackground(new Color(192, 192, 192));
		panelEntradaMenuBiblioteca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContenedorMenu.add(panelEntradaMenuBiblioteca);
		panelEntradaMenuBiblioteca.setLayout(new GridLayout(4,1));
		
		JPanel panelMenuBiblioteca = new JPanel();
		panelEntradaMenuBiblioteca.add(panelMenuBiblioteca);
		panelMenuBiblioteca.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBiblioteca = new JLabel("BIBLIOTECA");
		lblBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenuBiblioteca.add(lblBiblioteca, BorderLayout.CENTER);
		
		JPanel panelMenuBibliotecaVideojuegos = new JPanel();
		panelMenuBibliotecaVideojuegos.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelEntradaMenuBiblioteca.add(panelMenuBibliotecaVideojuegos);
		panelMenuBibliotecaVideojuegos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBibliotecaVideojuegos = new JLabel("Videojuegos");
		lblBibliotecaVideojuegos.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMenuBibliotecaVideojuegos.add(lblBibliotecaVideojuegos, BorderLayout.CENTER);
		
		JPanel panelCentralCaratulas = new PanelCentralCaratulas();
		getContentPane().add(panelCentralCaratulas, BorderLayout.CENTER);

			
	}

	public static void main(String[] args) {
		JFrame ventana = new VentanaPrincipal();
		ventana.setVisible(true);

	}

}
