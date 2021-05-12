package es.deusto.spq.ventanas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JPanelFeedPrivada extends JPanel{

	public JPanelFeedPrivada() {
		this.setBorder(new LineBorder(Color.black));
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.add(new JPanelFeedPrivada());
		f.setSize(1280, 720);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

}
