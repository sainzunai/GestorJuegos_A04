package es.deusto.spq.ventanas;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.deusto.spq.Usuario;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class VentanaInicioSesion extends JFrame{
	//Variables Server
	Client client = ClientBuilder.newClient();
	final WebTarget appTarget = client.target("http://localhost:8080/gestorJuegos");
	final WebTarget usersTarget = appTarget.path("usuarios");
//	final WebTarget getUsersTarget = usersTarget.path("getUsuario");
	
	public VentanaInicioSesion() {

		///////////////////////////////////
		// creaacion de panatalla y centrado
		////////////////////////////////////

		setTitle("Iniciar sesion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(350, 200);
		setLocationRelativeTo(null);
		// de la pantalla

		///////////////////////////////////
		// creacion de contenido dentro
		///////////////////////////////////

		JPanel pPrincipal = new JPanel();
		JPanel pUsuario = new JPanel();
		JPanel pContrasenya = new JPanel();
		JPanel pNuevoUser = new JPanel();
		JPanel pNuevoUserMini = new JPanel();
		JPanel pEntrar = new JPanel();
		JPanel pEntrarMini = new JPanel();

		this.add(pPrincipal);

		pPrincipal.setLayout(new GridLayout(4, 1));
		pPrincipal.add(pUsuario);
		pPrincipal.add(pContrasenya);
		pPrincipal.add(pEntrar);
		pPrincipal.add(pNuevoUser);
		pNuevoUser.add(pNuevoUserMini); // este panel sera lo mas pequenyo posible y se adaptara al tamanyp de la letra.
		pEntrar.add(pEntrarMini); // Asi se podra hacer un link mas preciso

		// para subrayar el label
		final JLabel lNuevoUsuario = new JLabel("Crear nuevo usuario");
		lNuevoUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		final Font font = lNuevoUsuario.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lNuevoUsuario.setFont(font.deriveFont(attributes));

		// para crear otro label
		final JLabel lEntrar = new JLabel("Entrar");
		lEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		Font font1 = lEntrar.getFont();
		Map attributes1 = font1.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lEntrar.setFont(font1.deriveFont(attributes1));

		pUsuario.add(new JLabel("Nombre usuario:"));
		final JTextField usu = new JTextField(7);
		pUsuario.add(usu);
		pContrasenya.add(new JLabel("Contrasenya: "));
		final JPasswordField pCon = new JPasswordField(7);
		pContrasenya.add(pCon);
		pEntrarMini.add(lEntrar);
		pNuevoUserMini.add(lNuevoUsuario);

		// pintado de paneles
		// pUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// pContrasenya.setBorder(BorderFactory.createLineBorder(Color.blue));
		// pNuevoUser.setBorder(BorderFactory.createLineBorder(Color.magenta));
		// pNuevoUserMini.setBorder(BorderFactory.createLineBorder(Color.magenta));

		pNuevoUserMini.addMouseListener(new MouseAdapter() {

			 @Override
			 public void mouseReleased(MouseEvent e) {
			 // abrir panel creacion de usuario
			 }

			@Override
			public void mouseClicked(MouseEvent e) {

				VentanaRegister v = new VentanaRegister();
//				v.setVisible(true);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// cuando el raton entre en el area el texto se hara mass grande
				lNuevoUsuario.setFont(new Font("Arial", Font.BOLD, 14));
				Font font = lNuevoUsuario.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lNuevoUsuario.setFont(font.deriveFont(attributes));
			}

		});

		pNuevoUser.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // para cuando el raton salga del jpanel ajustado al texto, este se

				lNuevoUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
				Font font = lNuevoUsuario.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lNuevoUsuario.setFont(font.deriveFont(attributes));
			}

		});

		pEntrarMini.addMouseListener(new MouseAdapter() {
			

			@SuppressWarnings({ "unlikely-arg-type", "deprecation" })
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario u = new Usuario(null, null, null);
				WebTarget usernameTarget = usersTarget.path("getUsuario").queryParam("email", usu.getText()).queryParam("passw", pCon.getText());
				System.out.println(usernameTarget);
				GenericType<Usuario> gtUsu = new GenericType<Usuario>(){};
				u = usernameTarget.request(MediaType.APPLICATION_JSON).get(gtUsu);
				if(u!= null) {
					System.out.println("usuario correcto: "+u);
					VentanaPrincipal v = new VentanaPrincipal(u);//creacion de la ventana principal
					v.setVisible(true);
					dispose();

				}
				else {
					System.err.println("Credenciales incorrectas :(");
				}
				
				dispose();

			}


			@Override
			public void mouseEntered(MouseEvent e) {
				// cuando el raton entre en el area el texto se hara m�s grande
				lEntrar.setFont(new Font("Arial", Font.BOLD, 14));
				Font font1 = lEntrar.getFont();
				Map attributes1 = font1.getAttributes();
				attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lEntrar.setFont(font.deriveFont(attributes1));
			}
		});



		pEntrar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // para cuando el raton salga del jpanel ajustado al texto, este se
				// vuelva mas pequenyo
				lEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
				Font font1 = lEntrar.getFont();
				Map attributes1 = font1.getAttributes();
				attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lEntrar.setFont(font.deriveFont(attributes1));
			}

		});

		addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

	

}
	// ----------- TEST DE LA VENTANA -----------
		public static void main(String[] args) {
			VentanaInicioSesion v = new VentanaInicioSesion();
			v.setVisible(true);

		}}
