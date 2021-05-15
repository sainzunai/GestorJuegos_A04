package es.deusto.spq;

public class Calificacion {
	
	
	//Va a ir directamente relacionada con un USUARIO. FUTURA creacion 

	//private User u;
	
	private int nota; 
	
	private int mesAsignacion; 
	
	private int diaAsignacion; 
	
	private int anyoAsignacion; 
	
	
	public Calificacion(int nota, int anyo, int mes, int dia) {  //No vamos a crear un constructor vacio porque no corresponde a una Calificacion; 
		
		this.nota = nota; 
		
		this.anyoAsignacion = anyo; 
		
		this.mesAsignacion = mes; 
		
		this.diaAsignacion = dia; 
		
		
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



	
	
}
