package es.deusto.spq.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.deusto.spq.ventanas.recursos_test.StarRater;

public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		JPanel panel = new JPanel();
		StarRater starRater = new StarRater(5, 2, 1);
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
	}

}
