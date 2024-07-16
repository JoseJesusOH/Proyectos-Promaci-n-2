/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;


import java.util.ArrayList;
import java.util.Date;

/* Representa cada una de las materias de una carrera universitaria */
public class Materia {

	private String nombre;
	private Profesor titular;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Asistencia> asistencias;
	
	
	/* Constructor genérico */
	public Materia(){
		super();
		//Instancia colecciones vacías y las asigna a los atributos correspondientes
		this.setAlumnos(new ArrayList<Alumno>());
		this.setAsistencias(new ArrayList<Asistencia>());
	}
	
	
	/* Constructor con parámetros */
	public Materia(String nombre){
		super();
		this.setNombre(nombre);
		//Instancia colecciones vacías y las asigna a los atributos correspondientes
		this.setAlumnos(new ArrayList<Alumno>());
		this.setAsistencias(new ArrayList<Asistencia>());
	}
	
	
	/* Constructor con parámetros */
	public Materia(String nombre, Profesor titular){
		super();
		this.setNombre(nombre);
		this.setTitular(titular);
		//Instancia colecciones vacías y las asigna a los atributos correspondientes
		this.setAlumnos(new ArrayList<Alumno>());
		this.setAsistencias(new ArrayList<Asistencia>());
	}
	
	
	
	
	/* Calcula cuántos alumnos hay inscriptos en la materia.
	* Para esto, cuenta los elementos de la colección de alumnos, utilizando el método "size" de TreeSet */
	public int calcularInscriptos(){
		return this.getAlumnos().size();
	}
	
	
	
	
	/* Calcula el porcentaje de asistencia y lo retorna en un valor entre 0 y 1.
	*  Para esto recorre la colección de asistencias buscando el elemento que coincida con la fecha indicada
	*  Una vez encontrado, calcula el porcentaje utilizando la cantidad de alumnos asistentes en esa fecha y
	*  el total de alumnos inscriptos en la materia. Si no encuentra un elemento coincidente, devuelve 0 */
	public double calcularAsistencia(Date fecha){
		for (Asistencia asist : this.getAsistencias()){
			if ((asist.getFecha()).compareTo(fecha) == 0)
				return (double)asist.contarAlumnos() / (double)this.calcularInscriptos();
		}
		return 0;
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
	
	
	
	
	/* Agrega una nueva asistencia a la colección de asistencias.
	 * Utiliza el método "add" de ArrayList para agregar el objeto "alumno" de tipo "Alumno" */
	public void agregarAsistencia(Asistencia asistencia){
		this.getAsistencias().add(asistencia);
	}
	
	
	
	
	/* Elimina una nueva carrera universitaria a la colección de carreras.
	 * Utiliza el método "remove" de ArrayList para ubicar y eliminar el objeto "carrera" de tipo "Carrera" */
	public void eliminarAsistencia(Asistencia asistencia){
		this.getAsistencias().remove(asistencia);
	}
	
	
	
	
	
	
	
	
	/* Getters y Setters de los atributos */
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Profesor getTitular() {
		return titular;
	}
	
	
	public void setTitular(Profesor titular) {
		this.titular = titular;
	}
	
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	
	
	public void setAlumnos(ArrayList<Alumno> alumno) {
		this.alumnos = alumno;
	}
	
	
	public ArrayList<Asistencia> getAsistencias() {
		return asistencias;
	}
	
	
	public void setAsistencias(ArrayList<Asistencia> asistencia) {
		this.asistencias = asistencia;
	}
	
	
}

