/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* Representa una carrera universitaria */
public class Carrera {

	private static ArrayList<Carrera> coleccionCarreras;
	private ArrayList<Materia> materias;
	private String nombre;
	private String facultad;
	
	
	/* Constructor genérico */
	public Carrera(){
		super();
		//Instancia una colección vacía y la asigna al atributo (la colección de Carreras
		//es un atributo estático, por lo que debe crearse y asignarse en un método estático
		this.setMaterias(new ArrayList<Materia>());
	}
	
	
	/* Constructor con parámetros */
	public Carrera(String nombre, String facultad){
		super();
		this.setNombre(nombre);
		this.setFacultad(facultad);
		//Instancia una colección vacía y la asigna al atributo (la colección de Carreras
		//es un atributo estático, por lo que debe crearse y asignarse en un método estático
		this.setMaterias(new ArrayList<Materia>());
	}
	
	
	
	
	
	/* Método "main": punto de inicio de la ejecución.
	 * En el presente ejemplo no existe interacción con el usuario: todos los objetos son instanciados y utilizados
	 * dentro del método main y luego la ejecución finaliza. Esto es así a los efectos de una mayor simplicidad, pero
	 * no es la forma habitual de trabajar con Java, ya que generalmente habrá una interacción mediante una interfaz
	 * gráfica, o bien el programa interactuará con otros sistemas mediante pasaje de parámetros. */
	public static void main(String[] args) {
		
		//Crea la colección de carreras y la guarda en el atributo correspondiente
		Carrera.crearColeccion();
		
		//Crea algunas carreras y las agrega a la colección
		Carrera c1 = new Carrera("Administración de Empresas", "Ciencias Exactas");
		Carrera.agregarCarrera(c1);
		Carrera c2 = new Carrera("Licenciatura en Sistemas", "Tecnología");
		Carrera.agregarCarrera(c2);
		
		//Crea algunas materias y las agrega a cada una de las carreras 
		Materia m1 = new Materia("Microeconomía");
		c1.agregarMateria(m1);
		Materia m2 = new Materia("Sociología");
		c1.agregarMateria(m2);
		Materia m3 = new Materia("Derecho Societario");
		c1.agregarMateria(m3);
		
		Materia m4 = new Materia("Introducción a la Programación");
		c2.agregarMateria(m4);
		Materia m5 = new Materia("Programación Orientada a Objetos");
		c2.agregarMateria(m5);
		Materia m6 = new Materia("Introducción a Redes");
		c2.agregarMateria(m6);
		
		//Crea algunos profesores y los agrega como titulares de cada materia
		Profesor p1 = new Profesor("Horacio Montero", 13546, 9000, 5);
		Profesor p2 = new Profesor("Marcela Estevez", 16932, 8630, 2);
		Profesor p3 = new Profesor("Naira Maderos", 19283, 9190, 17);
		c2.encontrarMateria("Introducción a la Programación").setTitular(p1);
		c2.encontrarMateria("Programación Orientada a Objetos").setTitular(p2);
		c2.encontrarMateria("Introducción a Redes").setTitular(p3);
		
		//Crea algunos alumnos y los agrega a las materias de la carrera "Licenciatura en Sistemas",
		//representada por el objeto "c2". 
		Alumno a1 = new Alumno("Marcelo Pérez", 54353);
		Alumno a2 = new Alumno("Jimena Juárez", 53341);
		Alumno a3 = new Alumno("Hernán Meza", 46323);
		Alumno a4 = new Alumno("Martina Orellanos", 56899);
		Alumno a5 = new Alumno("Vanessa Arruabarrena", 49027);
		
		c2.encontrarMateria("Introducción a la Programación").agregarAlumno(a1);
		c2.encontrarMateria("Introducción a la Programación").agregarAlumno(a2);
		c2.encontrarMateria("Introducción a la Programación").agregarAlumno(a5);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAlumno(a1);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAlumno(a2);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAlumno(a3);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAlumno(a4);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAlumno(a5);
		c2.encontrarMateria("Introducción a Redes").agregarAlumno(a3);
		c2.encontrarMateria("Introducción a Redes").agregarAlumno(a5);
		
		//Crea un objeto Calendar (clase propia de Java) para poder instanciar una fecha.
		//Crea asistencias y les agrega la fecha y los alumnos asistentes. Luego, agrega la asistencia 
		//a la colección en la materia "Programación Orientada a Objetos" de la carrera "Licenciatura en Sistemas"
		Calendar cal = Calendar.getInstance();
		
		cal.set(2014, Calendar.MARCH, 17, 0, 0, 0);
		Asistencia as1 = new Asistencia(cal.getTime());
		as1.agregarAlumno(a1);
		as1.agregarAlumno(a2);
		as1.agregarAlumno(a5);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAsistencia(as1);
		
		cal.set(2014, Calendar.MARCH, 24, 0, 0, 0);
		Asistencia as2 = new Asistencia(cal.getTime());
		as1.agregarAlumno(a2);
		as1.agregarAlumno(a5);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAsistencia(as2);
		
		cal.set(2014, Calendar.MARCH, 31, 0, 0, 0);
		Asistencia as3 = new Asistencia(cal.getTime());
		as3.agregarAlumno(a1);
		as3.agregarAlumno(a2);
		as3.agregarAlumno(a4);
		c2.encontrarMateria("Programación Orientada a Objetos").agregarAsistencia(as3);
		
		
		
		//Impresión en consola de la colección de carreras, con sus materias
		for (Carrera c : Carrera.getColeccionCarreras()){
			System.out.print("*** Carrera: ");
			System.out.println(c.getNombre());
			System.out.println("-Materias:");
			for (Materia m : c.getMaterias())
				System.out.println(m.getNombre());
			System.out.println("-------------");
		}
		
		//Impresión en consola de la información de cada materia de "Licenciatura en Sistemas"
		System.out.println("Detalle de " + c2.getNombre());
		for (Materia m : c2.getMaterias())
			System.out.println("Materia: " + m.getNombre() + " - Titular: " + m.getTitular().getNombre() + " - Cantidad de inscriptos: " + m.calcularInscriptos());
		System.out.println("-------------");
		
		//Impresión en consola de los inscriptos en cada materia:
		System.out.println("*** Inscriptos por materia");
		for (Materia m : c2.getMaterias()){
			System.out.println("-" + m.getNombre() + ": Listado de alumnos inscriptos:");
			for (Alumno a : m.getAlumnos())
				System.out.println(a.getNombre());
			System.out.println("-------------");
		}
		
		//Impresión de inscriptos y porcentaje de asistencia a "Programación Orientada a Objetos" el día 17/03/2014:
		System.out.println("*** Cantidad de inscriptos en POO: " + c2.encontrarMateria("Programación Orientada a Objetos").calcularInscriptos());
		System.out.println("*** Asistencia a POO el 17/03/2014");
		cal.set(2014, Calendar.MARCH, 17, 0, 0, 0);
		Date fecha = cal.getTime();
		System.out.println(c2.encontrarMateria("Programación Orientada a Objetos").calcularAsistencia(fecha));
		System.out.println("-------------");
		
		//Impresión del sueldo de "Marcela Estevez":
		System.out.println("Sueldo de Marcela Estevez:");
		System.out.println(p2.calcularSueldo());
		
		
	}
	
	
	
		
	/* Obtiene una instancia de ArrayList (colección) preparada para contener objetos de tipo "Carrera".
	 * Asigna el nuevo ArrayList al atributo estático "coleccionCarreras" */
	public static void crearColeccion(){
		Carrera.coleccionCarreras = new ArrayList<Carrera>();
	}
	
	
	
	
	/* Agrega una nueva carrera universitaria a la colección de carreras.
	 * Utiliza el método "add" de ArrayList para agregar el objeto "carrera" de tipo "Carrera" */
	public static void agregarCarrera(Carrera carrera){
		coleccionCarreras.add(carrera);
	}
	
	
	
	
	/* Elimina una carrera universitaria de la colección de carreras.
	 * Utiliza el método "remove" de ArrayList para ubicar y eliminar el objeto "carrera" de tipo "Carrera" */
	public static void eliminarCarrera(Carrera carrera){
		coleccionCarreras.remove(carrera);
	}


	
	/* Agrega una nueva materia a la colección de materias.
	 * Utiliza el método "add" de ArrayList para agregar el objeto "materia" de tipo "Materia" */
	public void agregarMateria(Materia materia){
		this.getMaterias().add(materia);
	}
	
	
	
	
	/* Elimina una materia de la colección de materias.
	 * Utiliza el método "remove" de ArrayList para ubicar y eliminar el objeto "materia" de tipo "Materia" */
	public void eliminarMateria(Materia materia){
		this.getMaterias().remove(materia);
	}
	
	
	
	
	/* Retorna cuántas materias hay en una carrera.
	 * Para esto, cuenta los elementos de la colección de materias, utilizando el método "size" de ArrayList */
	public int contarMaterias(){
		return this.getMaterias().size();
	}

	
	
	
	/* Busca en la colección una materia, por su nombre, y retorna el objeto Materia que corresponde.
	 * Para esto debe recorrer la colección de materias, comparando el nombre de cada una con el nombre buscado.
	 * Si no encuentra una materia con el nombre indicado, devuelve null*/
	public Materia encontrarMateria(String nombre){
		for (Materia m : this.getMaterias()){
			if (m.getNombre().equals(nombre)){
				return m;
			}
		}
		return null;
	}
	
	
		
	
	/* Getters y Setters de los atributos */
	
	public static ArrayList<Carrera> getColeccionCarreras() {
		return coleccionCarreras;
	}


	public static void setColeccionCarreras(ArrayList<Carrera> coleccionCarreras) {
		Carrera.coleccionCarreras = coleccionCarreras;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


	public ArrayList<Materia> getMaterias() {
		return materias;
	}


	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	
	
	
}
