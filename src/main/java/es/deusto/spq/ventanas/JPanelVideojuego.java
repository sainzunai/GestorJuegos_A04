package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;

/**
 * Panel de un videojuego, que incluye un boton para anyadirlo a la biblioteca personal del usuario
 * El panel muestra la caratula del videojuego
 * @author Unai
 *
 */
public class JPanelVideojuego extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabelGraficoAjustado lImagen;
	JButton btn;
	String textoBtn = "Add";
	
	public int cambioConstructor; 

	public JPanelVideojuego(final VideoJuego v, final Biblioteca b, final boolean stamosHome,final Usuario u) {
		this.cambioConstructor = 0; 
		lImagen = new JLabelGraficoAjustado(v.getCaratula(), 13 * 20, 15 * 20);
		this.setLayout(new BorderLayout());
		this.add(lImagen, BorderLayout.CENTER);
		btn = new JButton(textoBtn);
		this.add(btn, BorderLayout.SOUTH);
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				b.addJuego(v);
				

			}
		});
		
		lImagen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(e.getClickCount() == 2) {
					System.out.println("Doble click efectivo");
					
					System.out.println("Estamos en casa: "+ stamosHome);
					
					VentanaFeed vF = new VentanaFeed(v, u, stamosHome);
				}
				
			}
		});
	}

	public JPanelVideojuego(final VideoJuego v, int cambioConstructor, final Biblioteca b, final boolean stamosHome, final Usuario u) {
		this.cambioConstructor = cambioConstructor; 
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(13 * 20, 15 * 20));
		JLabel lbl = new JLabel(v.getNombre());
		panel.add(lbl);
		this.setLayout(new BorderLayout());
		btn = new JButton(textoBtn);
		this.add(btn, BorderLayout.SOUTH);
		this.add(panel);
		this.setPreferredSize(new Dimension(13 * 20, 15 * 20));
		this.setBorder(new LineBorder(Color.black));
		this.setBackground(Color.white);
		
		lImagen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(e.getClickCount() == 2) {
					System.out.println("Doble click efectivo");
					
					System.out.println("Estamos en casa: "+ stamosHome);
					
					VentanaFeed vF = new VentanaFeed(v, u, stamosHome);
				}
				
			}
		});

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				b.addJuego(v);

			}
		});
		
		
	}

	/*
	 * public static void main(String[] args) { JFrame ventana = new JFrame();
	 * ventana.getContentPane().setLayout(new FlowLayout());
	 * ventana.setVisible(true); ventana.setSize(500, 500);
	 * ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); VideoJuego v = new
	 * VideoJuego("hola", "d", "sss", 10, null); Biblioteca b = new Biblioteca();
	 * JPanelVideojuego p = v.getJPanelVideojuego(b, true, ); ventana.add(p);
	 * ventana.revalidate();
	 * 
	 * }
	 */
}
