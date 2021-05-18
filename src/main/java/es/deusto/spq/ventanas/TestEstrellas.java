package es.deusto.spq.ventanas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.deusto.spq.ventanas.recursos.StarRater;

public class TestEstrellas {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		JPanel panel = new JPanel();
		StarRater starRater = new StarRater(5, 0, 1);
		starRater.addStarListener(new StarRater.StarListener() {

			public void handleSelection(int selection) {
				System.out.println(selection);
			}
		});
		panel.add(starRater);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		starRater.setPreferredSize(new Dimension(300,  300));
		frame.setSize(500, 500);
	}

}