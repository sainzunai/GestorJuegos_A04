package es.deusto.spq.util;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Plataforma;
import es.deusto.spq.VideoJuego;
import es.deusto.spq.dao.GestorJuegos_A04DAO;

public class PrepararDatos {

	//Introduce todos los datos necesarios en la BD
	public static void main(String[] args) {
		System.out.println("Creando Plataformas...");
		Plataforma p1 = new Plataforma("PS4", "1");
		Plataforma p2 = new Plataforma("XBOX", "2");
		Plataforma p3 = new Plataforma("PC", "3");
		Plataforma p4 = new Plataforma("NS", "4");
		
		System.out.println("Creando Videojuegos...");
		VideoJuego v1 = new VideoJuego("Battlefield V", "1", "EA", 18, p1);
		VideoJuego v2 = new VideoJuego("Battlefield V", "2", "EA", 18, p2);
		VideoJuego v3 = new VideoJuego("Battlefield V", "3", "EA", 18, p3);
		VideoJuego v4 = new VideoJuego("Super Mario 3D World", "4", "Nintendo", 3, p4);
		VideoJuego v5 = new VideoJuego("Horizon Zero Dawn", "5", "Guerrilla Games", 18, p1);
		VideoJuego v6 = new VideoJuego("Horizon Zero Dawn", "6", "Guerrilla Games", 18, p3);
		VideoJuego v7 = new VideoJuego("The Binding of Isaac", "7", "Nicalis", 16, p1);
		VideoJuego v8 = new VideoJuego("The Binding of Isaac", "8", "Nicalis", 16, p2);
		VideoJuego v9 = new VideoJuego("The Binding of Isaac", "9", "Nicalis", 16, p3);
		VideoJuego v10 = new VideoJuego("The Binding of Isaac", "10", "Nicalis", 16, p4);
		
		//System.out.println("Creando Biblioteca...");
		//Biblioteca b = new Biblioteca("1");
		
		p1.addVideoJuego(v1); p1.addVideoJuego(v5); p1.addVideoJuego(v7); 
		p2.addVideoJuego(v2); p2.addVideoJuego(v8); 
		p3.addVideoJuego(v3); p3.addVideoJuego(v6); p3.addVideoJuego(v9);
		p4.addVideoJuego(v4); p4.addVideoJuego(v10);
		
		GestorJuegos_A04DAO dao = new GestorJuegos_A04DAO();
		
		System.out.println("Añadiendo Plataformas y Videojuegos a BD...");
		dao.introducirObjeto(p1); dao.introducirObjeto(p2); dao.introducirObjeto(p3); dao.introducirObjeto(p4);
		
		//System.out.println("Añadiendo Biblioteca a BD...");
		//dao.introducirObjeto(b);
		
		System.out.println("Terminada la inserción de datos en BD.");
	}

}
