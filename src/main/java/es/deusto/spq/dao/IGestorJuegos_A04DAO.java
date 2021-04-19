package es.deusto.spq.dao;


import java.util.List;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
public interface IGestorJuegos_A04DAO {
	public void introducirObjeto(Object object);
	public VideoJuego getVideojuego(String name);
	public List<VideoJuego> getAllVideojuegos();
	public void updateVideojuego(VideoJuego videojuego);
	public void updateBiblioteca(Biblioteca biblioteca,VideoJuego videojuego);
	public void deleteAllVideojuegos();
	public void deleteAll();
	public Usuario getUsuario(String email);
	public Biblioteca getBiblioteca_Usuario(Usuario user);
}
