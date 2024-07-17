/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.ArrayList;
import java.util.Date;


/* Representa un conjunto de todos los alumnos que asistieron en determinada fecha a una clase de una materia.
 * Se relaciona con un objeto Materia a través de una colección de Asistencias en la Materia. */
public class Asistencia {

	
	private Date fecha;
	private ArrayList<Alumno> alumnos;
	
	
	
	/* Constructor genérico */
	public Asistencia(){
		super();
		//Instancia una colección vacía y la asigna al atributo
		this.setAlumnos(new ArrayList<Alumno>());
	}
	
	
	/* Constructor con parámetros */
	public Asistencia(Date fecha){
		super();
		this.setFecha(fecha);
		//Instancia una colección vacía y la asigna al atributo
		this.setAlumnos(new ArrayList<Alumno>());
	}

	
	
	
	
	
	/* Agrega un nuevo alumno a la colección de alumnos.
	 * Utiliza el método "add" de ArrayList para agregar el objeto "alumno" de tipo "Alumno" */
	public void agregarAlumno(Alumno alumno){
		this.getAlumnos().add(alumno);
	}
	
	
	
	
	/* Elimina una nueva carrera universitaria a la colección de carreras.
	 * Utiliza el método "remove" de ArrayList para ubicar y eliminar el objeto "carrera" de tipo "Carrera" */
	public void eliminarAlumno(Alumno alumno){
		this.getAlumnos().remove(alumno);
	}
	
	
	
	
	/* Devuelve la cantidad de alumnos en la colección. 
	 * 	Para esto, cuenta los elementos de la colección de alumnos, utilizando el método "size" de ArrayList */
	public int contarAlumnos(){
		return this.getAlumnos().size();
	}
	
	
	
	/* Getters y Setters de los atributos */

	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
	
	
}
