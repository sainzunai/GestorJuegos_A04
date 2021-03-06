package es.deusto.spq.ventanas;

import javax.swing.*;
import es.deusto.spq.Usuario;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;


import java.awt.*;
import java.awt.event.*;

/**
 * Ventana formulario para registrar nuevo usuario.
 * Comunica con el servidor las credenciales introducidas, y crea el usuario si el servidor responde diciendo que no existe ese usuario.
 * Una vez creado el usuario se cierra la ventana para volver a la ventana de inicio de sesion.
 * @author Unai
 *
 */
public class VentanaRegister extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Variables Server
	Client client = ClientBuilder.newClient();

	final WebTarget appTarget = client.target("http://localhost:8080/gestorJuegos");
	final WebTarget usersTarget = appTarget.path("usuarios");

	//
	Usuario newUser;

	// Componentes del formulario
	private Container c;
	private JLabel title;
	private JLabel lNombre;
	JTextField tfNombre;
	private JLabel lEmail;
	JTextField tfEmail;
	private JLabel lContrasenya;
	JPasswordField tfContrasenya;
	JPasswordField tfRepetirContrasenya;
	private JLabel lGenero;
	private JRadioButton rbHombre;
	private JRadioButton rbMujer;
	private ButtonGroup gengp;
	private JLabel lFechaNacimiento;
	private JComboBox cbFecha;
	private JComboBox cbMes;
	private JComboBox cbAnyo;
	private JLabel lAnyadir;
	JTextArea taAnyadir;
	JCheckBox cbTerminos;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	JLabel res;
	JTextArea resadd;

	private String dias[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private String meses[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
			"Octubre", "Noviembre", "Diciembre" };
	private String anyos[] = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
			"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
	"2019" };

	/**
	 * Lanza la ventana de registro
	 */
	public VentanaRegister() {
		setTitle("Formulario de registro");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Formulario de registro");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		lNombre = new JLabel("Nombre");
		lNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		lNombre.setSize(120, 20);
		lNombre.setLocation(59, 100);
		c.add(lNombre);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		tfNombre.setSize(190, 20);
		tfNombre.setLocation(200, 100);
		c.add(tfNombre);

		lEmail = new JLabel("Correo");
		lEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		lEmail.setSize(120, 20);
		lEmail.setLocation(59, 150);
		c.add(lEmail);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		tfEmail.setSize(190, 20);
		tfEmail.setLocation(200, 150);
		c.add(tfEmail);

		lContrasenya = new JLabel("Contrasena");// Lo he tocado no compilaba con lo otro
		lContrasenya.setFont(new Font("Arial", Font.PLAIN, 20));
		lContrasenya.setSize(120, 20);
		lContrasenya.setLocation(59, 200);
		c.add(lContrasenya);

		tfContrasenya = new JPasswordField();
		tfContrasenya.setFont(new Font("Arial", Font.PLAIN, 15));
		tfContrasenya.setSize(100, 20);
		tfContrasenya.setLocation(200, 200);
		c.add(tfContrasenya);

		tfRepetirContrasenya = new JPasswordField();
		tfRepetirContrasenya.setFont(new Font("Arial", Font.PLAIN, 15));
		tfRepetirContrasenya.setSize(100, 20);
		tfRepetirContrasenya.setLocation(323, 202);
		c.add(tfRepetirContrasenya);

		lGenero = new JLabel("Genero");
		lGenero.setFont(new Font("Arial", Font.PLAIN, 20));
		lGenero.setSize(120, 20);
		lGenero.setLocation(59, 250);
		c.add(lGenero);

		rbHombre = new JRadioButton("Masculino");
		rbHombre.setFont(new Font("Arial", Font.PLAIN, 15));
		rbHombre.setSelected(true);
		rbHombre.setSize(75, 20);
		rbHombre.setLocation(200, 250);
		c.add(rbHombre);

		rbMujer = new JRadioButton("Femenino");
		rbMujer.setFont(new Font("Arial", Font.PLAIN, 15));
		rbMujer.setSelected(false);
		rbMujer.setSize(80, 20);
		rbMujer.setLocation(275, 250);
		c.add(rbMujer);

		gengp = new ButtonGroup();
		gengp.add(rbHombre);
		gengp.add(rbMujer);

		lFechaNacimiento = new JLabel("F.Nacimiento");
		lFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 20));
		lFechaNacimiento.setSize(120, 20);
		lFechaNacimiento.setLocation(59, 300);
		c.add(lFechaNacimiento);

		cbFecha = new JComboBox(dias);
		cbFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		cbFecha.setSize(50, 20);
		cbFecha.setLocation(200, 300);
		c.add(cbFecha);

		cbMes = new JComboBox(meses);
		cbMes.setFont(new Font("Arial", Font.PLAIN, 15));
		cbMes.setSize(60, 20);
		cbMes.setLocation(250, 300);
		c.add(cbMes);

		cbAnyo = new JComboBox(anyos);
		cbAnyo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbAnyo.setSize(60, 20);
		cbAnyo.setLocation(320, 300);
		c.add(cbAnyo);

		lAnyadir = new JLabel("Direccion");
		lAnyadir.setFont(new Font("Arial", Font.PLAIN, 20));
		lAnyadir.setSize(120, 20);
		lAnyadir.setLocation(59, 350);
		c.add(lAnyadir);

		taAnyadir = new JTextArea();
		taAnyadir.setFont(new Font("Arial", Font.PLAIN, 15));
		taAnyadir.setSize(200, 75);
		taAnyadir.setLocation(200, 350);
		taAnyadir.setLineWrap(true);
		c.add(taAnyadir);

		cbTerminos = new JCheckBox("Aceptar terminos y condiciones");
		cbTerminos.setFont(new Font("Arial", Font.PLAIN, 15));
		cbTerminos.setSize(250, 20);
		cbTerminos.setLocation(150, 450);
		c.add(cbTerminos);

		sub = new JButton("Enviar");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 500);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(270, 500);
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 530);
		//		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 225);
		resadd.setLineWrap(true);
		c.add(resadd);

		setVisible(true);


	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub) {
			if (cbTerminos.isSelected()) {
				String data1;
				String data = "Name : " + tfNombre.getText() + "\n" + "Pass : " + tfContrasenya.getText() + "\n";
				if (rbHombre.isSelected())
					data1 = "Genero : Macho del norte" + "\n";
				else
					data1 = "Genero : Femenino" + "\n";
				String data2 = "Fecha de nacimiento : " + (String) cbFecha.getSelectedItem() + "/"
						+ (String) cbMes.getSelectedItem() + "/" + (String) cbAnyo.getSelectedItem() + "\n";

				String data3 = "Direccion : " + taAnyadir.getText();
				tout.setText(data + data1 + data2 + data3);
				tout.setEditable(false);
				res.setText("Regisro OK");

				// 1. Comprobar contrasenyas
				if (tfContrasenya.getText().equals(tfRepetirContrasenya.getText())) {


					if (tfNombre.getText().equals("") || tfContrasenya.getText().equals("")) {
						System.out.println("Es necesario rellenar los campos");
						JOptionPane.showMessageDialog(this, "Es necesario rellenar los campos");
					} else {
						// LLamar a BD
						crearUsuario();

					}
				} else {
					System.out.println("Contrasenyas no coinciden");
					JOptionPane.showMessageDialog(this, "Las constrasenyas no coinciden");
				}

			} else {
				tout.setText("");
				resadd.setText("");
				res.setText("Es necesario aceptar los terminos y condiciones");
				JOptionPane.showMessageDialog(this, "Es necesario aceptar los terminos y condiciones");
			}
		}

		else if (e.getSource() == reset) {
			resetCampos();
		}
	}
	public void resetCampos() {
		String def = "";
		tfNombre.setText(def);
		taAnyadir.setText(def);
		tfContrasenya.setText(def);
		res.setText(def);
		tout.setText(def);
		cbTerminos.setSelected(false);
		cbFecha.setSelectedIndex(0);
		cbMes.setSelectedIndex(0);
		cbAnyo.setSelectedIndex(0);
		resadd.setText(def);
	}

	/**
	 * Crea el usuario a partir de los campos rellenados, una vez validados
	 */
	public void crearUsuario() {
		newUser = new Usuario(secu(tfEmail.getText()), secu(tfContrasenya.getText()), secu(tfNombre.getText()));
		System.out.println(newUser);

		//Antes de postear miramos si existe el usuario en server
		Usuario u = new Usuario(null, null, null);
		WebTarget usernameTarget = usersTarget.path("getUsuario").queryParam("email", newUser.getGmail()).queryParam("passw", "_");
		GenericType<Usuario> gtUsu = new GenericType<Usuario>(){};
		u = usernameTarget.request(MediaType.APPLICATION_JSON).get(gtUsu);
		if(u == null) //que devuelva null significa que no existe ese usuario
		{
			usersTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(newUser, MediaType.APPLICATION_JSON));
			System.out.println("Registro correcto");
			JOptionPane.showMessageDialog( this, "Registro completado con Usuario: " + newUser.getNombre() + " y passwd: " + newUser.getContrasena());

			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog( this, "Usuario ya existente.");

		}


	}
	/**Devuelve el string "securizado" para volcarlo en SQL
		 (Implementaci???n 1) Sustituye ' por '' y quita saltos de l???nea
		 (Implementaci???n 2) Mantiene solo los caracteres seguros en espa???ol
	 * @param string input
	 * @return
	 */
	public static String secu( String string ) {
		// Implementacion
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@/\\0123456789.".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}



	public static void main(String[] args) throws Exception {
		VentanaRegister f = new VentanaRegister();
	}
}
