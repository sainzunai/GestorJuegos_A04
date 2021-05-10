package es.deusto.spq;

public class Calificacion {
	

	private Usuario userNota;  //tiene que tener un usuario en concreto para no repetir y usarlo en los metodos de logica etc. 
	
	private int nota; 
	
	private int mesAsignacion; 
	
	private int diaAsignacion; 
	
	private int anyoAsignacion; 
	
	
	public Calificacion(int nota, int anyo, int mes, int dia, Usuario u) {  //No vamos a crear un constructor vacio porque no corresponde a una Calificacion; 
		
		this.nota = nota; 
		
		this.anyoAsignacion = anyo; 
		
		this.mesAsignacion = mes; 
		
		this.diaAsignacion = dia; 
		
		this.userNota = u; 
		
		
	}
	


	public void setNota(int nota, int anyo, int  mes, int dia) { //cuando asignamos una nueva nota guardaremos su fecha de guardado. 
		this.nota = nota;
		
		this.diaAsignacion = dia; 
		
		this.mesAsignacion = mes; 
		
		this.anyoAsignacion = anyo; 
	}
	
	
	
	
	public int getNota() {
		return nota;
	}


	public int getDiaAsignacion() {
		return diaAsignacion;
	}


	public void setDiaAsignacion(int diaAsignacion) {
		this.diaAsignacion = diaAsignacion;
	}
	

	public int getMesAsignacion() {
		return mesAsignacion;
	}


	public void setMesAsignacion(int mesAsignacion) {
		this.mesAsignacion = mesAsignacion;
	}


	public int getAnyoAsignacion() {
		return anyoAsignacion;
	}


	public void setAnyoAsignacion(int anyoAsignacion) {
		this.anyoAsignacion = anyoAsignacion;
	}



	public Usuario getUserNota() {
		return userNota;
	}



	public void setUserNota(Usuario userNota) {  //dudo que haya que utilizar este metodo. 
		this.userNota = userNota;
	}



	
	
}
