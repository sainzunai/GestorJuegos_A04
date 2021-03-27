package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelEntradaMenu extends JPanel{
	
	JPanel pAVisualizar;
	
	public JPanelEntradaMenu(String titulo) {
		this.pAVisualizar = pContenido;
		Font fuente = new Font("Bauhaus 93", Font.CENTER_BASELINE, 30);
		JLabel l = new JLabel(titulo);
		l.setFont(fuente);
		l.setForeground(Color.WHITE);	
		this.add(l);
		l.setSize(l.getPreferredSize());
		revalidate();
	}
}
