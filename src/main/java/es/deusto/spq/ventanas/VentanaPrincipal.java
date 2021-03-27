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
import javax.swing.JTextField;
import java.awt.FlowLayout;


public class VentanaPrincipal extends JFrame{
	private JTextField tfBuscador;
	public VentanaPrincipal() {
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
		
		JPanel panelHome = new JPanel();
		panelHome.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelEntradaMenuHome.add(panelHome);
		panelHome.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelHome.add(lblHome, BorderLayout.CENTER);
		
		JPanel panelVideojuegos = new JPanel();
		panelVideojuegos.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelEntradaMenuHome.add(panelVideojuegos);
		panelVideojuegos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVideojuegos = new JLabel("Videojuegos");
		lblVideojuegos.setHorizontalAlignment(SwingConstants.RIGHT);
		panelVideojuegos.add(lblVideojuegos);
		
		JPanel panelEntradaMenuBiblioteca = new JPanel();
		panelEntradaMenuBiblioteca.setBackground(new Color(192, 192, 192));
		panelEntradaMenuBiblioteca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContenedorMenu.add(panelEntradaMenuBiblioteca);
		panelEntradaMenuBiblioteca.setLayout(new GridLayout(4,1));
		
		JPanel panelBiblioteca = new JPanel();
		panelEntradaMenuBiblioteca.add(panelBiblioteca);
		panelBiblioteca.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBiblioteca = new JLabel("BIBLIOTECA");
		lblBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBiblioteca.add(lblBiblioteca, BorderLayout.CENTER);
		
		JPanel panelBibliotecaVideojuegos = new JPanel();
		panelBibliotecaVideojuegos.setBorder(new LineBorder(new Color(128, 128, 128)));
		panelEntradaMenuBiblioteca.add(panelBibliotecaVideojuegos);
		panelBibliotecaVideojuegos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBibliotecaVideojuegos = new JLabel("Videojuegos");
		lblBibliotecaVideojuegos.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBibliotecaVideojuegos.add(lblBibliotecaVideojuegos, BorderLayout.CENTER);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new LineBorder(new Color(128, 0, 128)));
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHeader.setBackground(new Color(192, 192, 192));
		panelCentral.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfBuscador = new JTextField();
		tfBuscador.setText("Buscador");
		tfBuscador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelHeader.add(tfBuscador);
		tfBuscador.setColumns(10);
	}

	public static void main(String[] args) {
		JFrame ventana = new VentanaPrincipal();
		ventana.setVisible(true);

	}

}
