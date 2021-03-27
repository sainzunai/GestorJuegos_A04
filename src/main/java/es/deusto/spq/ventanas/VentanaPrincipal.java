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
		panelContenedorMenu.setLayout(new GridLayout(4,1));
		
		JPanel panelEntradaMenu2 = new JPanel();
		panelEntradaMenu2.setBorder(new LineBorder(new Color(255, 0, 255), 3));
		panelEntradaMenu2.setBackground(new Color(192, 192, 192));
		panelContenedorMenu.add(panelEntradaMenu2);
		
		JLabel lblNewLabel = new JLabel("MENU");
		panelEntradaMenu2.add(lblNewLabel);
		
		JPanel panelEntradaMenu = new JPanel();
		panelEntradaMenu.setBackground(new Color(192, 192, 192));
		panelEntradaMenu.setBorder(new LineBorder(new Color(128, 0, 128), 3));
		panelContenedorMenu.add(panelEntradaMenu);
	}

	public static void main(String[] args) {
		JFrame ventana = new VentanaPrincipal();
		ventana.setVisible(true);

	}

}
