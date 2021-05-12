package es.deusto.spq.ventanas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.deusto.spq.ventanas.recursos_test.StarRater;

public class JPanelFeedPrivada extends JPanel{

	public JPanelFeedPrivada() {
		this.setBorder(new LineBorder(Color.black));
		StarRater starRater = new StarRater(5, 3, 3);
		starRater.addStarListener(new StarRater.StarListener() {

			public void handleSelection(int selection) {
				System.out.println(selection);
			}
		});
		
		this.add(starRater);
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
