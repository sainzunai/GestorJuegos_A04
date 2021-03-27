package es.deusto.spq.ventanas;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class VentanaPrincipal extends JFrame{
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ORIGIN");
		this.setSize(new Dimension(1233, 657));
		getContentPane().setLayout(new BorderLayout());
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		getContentPane().add(panelMenu, BorderLayout.WEST);
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{0};
		gbl_panelMenu.rowHeights = new int[]{0};
		gbl_panelMenu.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelMenu.rowWeights = new double[]{Double.MIN_VALUE};
		panelMenu.setLayout(gbl_panelMenu);
	}

	public static void main(String[] args) {
		JFrame ventana = new VentanaPrincipal();
		ventana.setVisible(true);

	}

}
