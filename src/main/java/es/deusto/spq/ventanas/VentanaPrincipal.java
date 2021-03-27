package es.deusto.spq.ventanas;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;


public class VentanaPrincipal extends JFrame{
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ORIGIN");
		this.setSize(new Dimension(1233, 657));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelContenedorMenu = new JPanel();
		panelContenedorMenu.setBackground(new Color(255, 255, 255));
		panelContenedorMenu.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		getContentPane().add(panelContenedorMenu, BorderLayout.WEST);
		panelContenedorMenu.setLayout(new GridLayout(2,1));
		
		JPanel panelEntradaMenuHome = new JPanel();
		panelEntradaMenuHome.setBorder(new LineBorder(new Color(255, 0, 255), 3));
		panelEntradaMenuHome.setBackground(new Color(192, 192, 192));
		panelContenedorMenu.add(panelEntradaMenuHome);
		panelEntradaMenuHome.setLayout(new GridLayout(4,1));
		
		JPanel panelHome = new JPanel();
		panelEntradaMenuHome.add(panelHome);
		panelHome.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelHome.add(lblHome, BorderLayout.CENTER);
		
		JPanel panelEntradaMenuBiblioteca = new JPanel();
		panelEntradaMenuBiblioteca.setBackground(new Color(192, 192, 192));
		panelEntradaMenuBiblioteca.setBorder(new LineBorder(new Color(128, 0, 128), 3));
		panelContenedorMenu.add(panelEntradaMenuBiblioteca);
		
		JButton btnNewButton_1 = new JButton("BIBLIOTECA");
		panelEntradaMenuBiblioteca.add(btnNewButton_1);
	}

	public static void main(String[] args) {
		JFrame ventana = new VentanaPrincipal();
		ventana.setVisible(true);

	}

}
