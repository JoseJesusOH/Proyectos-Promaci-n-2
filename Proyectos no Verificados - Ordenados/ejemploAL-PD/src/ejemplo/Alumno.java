/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;



/* Representa un alumno */
public class Alumno {

	private String nombre;
	private int legajo;
	
	
	/* Constructor genérico */
	public Alumno(){
		super();
	}
	
	
	/* Constructor con parámetros */
	public Alumno(String nombre, int legajo){
		super();
		this.setNombre(nombre);
		this.setLegajo(legajo);
	}
	
	
	
	
	/* Getters y Setters de los atributos */
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public int getLegajo() {
		return legajo;
	}
	
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	
	
}
