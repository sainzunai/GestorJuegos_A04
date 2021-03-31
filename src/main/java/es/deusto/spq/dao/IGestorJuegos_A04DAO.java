package es.deusto.spq.dao;


import java.util.List;

import es.deusto.spq.VideoJuego;
public interface IGestorJuegos_A04DAO {
	public void introducirObjeto(Object object);
	public VideoJuego getVideojuego(String name);
	public List<VideoJuego> getAllVideojuegos();
	public void updateVideojuego(VideoJuego videojuego);
	public void deleteAllVideojuegos();
}
