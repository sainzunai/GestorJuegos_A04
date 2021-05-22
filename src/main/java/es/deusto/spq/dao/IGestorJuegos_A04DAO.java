package es.deusto.spq.dao;


import java.util.List;

import es.deusto.spq.Biblioteca;
import es.deusto.spq.Usuario;
import es.deusto.spq.VideoJuego;
public interface IGestorJuegos_A04DAO {
	
	/**
	 * Descripción del método
	 * Introducimos una clase dentro de la base de datos.Con las correspondientes anotaciones y atributos.
	 * @author Guillermo
	 * @param nos pide un Objecto cualquiera
	 * @return No devuelve nada
	 */
	public void introducirObjeto(Object object);
	
	/**
	 * Descripción del método
	 * Coger un videojuego de la base de datos pasando el parametro primary key
	 * @author Guillermo
	 * @param Se pide el id del objeto
	 * @return Se devuelve el videojuego pedido a la base de datos
	 */
	public VideoJuego getVideojuego(String name);
	
	/**
	 * Descripción del método
	 * Le pedimos a la base de datos todos los videojuegos de la base de datos
	 * @author Guillermo
	 * @return Devuelve una lista de videojuegos
	 */
	public List<VideoJuego> getAllVideojuegos();
	
	/**
	 * Descripción del método Actualiza la biblioteca en la base de datos
	 * @author Guillermo
	 * @param Se le pasa una biblioteca, la objetivo.
	 * @param Se le pasa el elemento a meter en la biblioteca
	 */
	public void updateBiblioteca_Videojuego(Biblioteca biblioteca,VideoJuego videojuego);
	
	/**
	 * Descripcion del metodo para la actualizacion de la relacion biblioteca videojuego
	 * @author Guillermo
	 * @param biblioteca, variable usada para acceder a la biblioteca a actualizar
	 */
	public void updateBiblioteca(Biblioteca biblioteca);
	
	/**
	 * Descripcion del metodo para actualizar los atributos del videojuego
	 * @author Guillermo
	 * @param videojuego, variable para actualizar el videojuego
	 */
	public void updateVideoJuego(VideoJuego videojuego);
	
	/**
	 * Descripción del método
	 * Se elimina todos los videojuegos de la base de datos
	 * @author Guillermo
	 */
	public void deleteAllVideojuegos();
	
	/**
	 * Descripción del método Se elimina todo de la base de datos
	 * @author Guillermo
	 */
	public void deleteAll();
	
	/**
	 * Descripcion del metodo para obtener el Usuario con la biblioteca y los videojuegos
	 * @author Guillermo
	 * @param email, identificador usado para recoger el usuario de la base de datos
	 * @return Nos devuelve el usuario.
	 */
	public Usuario getUsuario(String email);
	
	/**
	 * Descripcion del metodo para recoger la biblioteca del usuario
	 * @author Guillermo
	 * @param user, identificador usado para saber todos los datos necesarios de biblioteca
	 * @return Nos devuelve la Biblioteca actualizada
	 */
	public Biblioteca getBiblioteca_Usuario(Usuario user);
	
	/**
	 * Descripcion del metodo para eliminar el usuario deseado
	 * @author Guillermo
	 * @param user, variable usada para identificar el usuario a eliminar
	 */
	public void deleteUsuario(Usuario user);
}
