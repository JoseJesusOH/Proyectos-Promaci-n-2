/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itson;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author josej
 */
public class ControlEscolar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estudiante e1 = new Estudiante("Ricardo Javier", "JFWE124586HS", "ricado@gmail.com", 229141, 42138091);
        Estudiante e2 = new Estudiante("Diego Ayala", "DIED124364", "diego@gmail.com", 229156, 42908123);
        Estudiante e3 = new Estudiante("Jose Jesus ", "OOHJ020110", "jose@gmail.com", 229147, 42138093);
        Estudiante e4 = new Estudiante("Elena Perea", "PEEL258923", "elena@gmail.com", 227856, 42905678);

        Set<Estudiante> estudiantes = new HashSet<>();

        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);
        estudiantes.add(e4);

        

//       for (Estudiante es : estudiantes) {
//            System.out.println("Nombre; "+es.getNombre()+", Correo; "+es.getCorreo());
//        }
//////        
//        System.out.println("-------------------------");
//        for (Estudiante e : estudiantes) {
//
//            if (e.getCorreo().equals("elena@gmail.com")) {
//                estudiantes.remove(e);
//            }
//        }
//        
//        for (Estudiante es : estudiantes) {
//            System.out.println("Nombre; "+es.getNombre()+", Correo; "+es.getCorreo());
//        }
//
//
//         System.out.println("-------------------------");
//        for (Estudiante e : estudiantes) {
//
//            if (e.getCorreo().equals("diego@gmail.com")) {
//                estudiantes.remove(e);
//            }
//        }
//        for (Estudiante es : estudiantes) {
//            System.out.println("Nombre; "+es.getNombre()+", Correo; "+es.getCorreo());
//        }
//        

////
//        System.out.println("-------------------------");
//        Iterator<Estudiante> it = estudiantes.iterator();
//
//        while (it.hasNext()) {
//            String nombre = it.next().getNombre();
//            System.out.println(nombre);
//          System.out.println(it.getClass()); 
//        }
// 

////
        System.out.println("-------------------------");
        Iterator<Estudiante> it = estudiantes.iterator();
         
        while (it.hasNext()) {
            String correo = it.next().getCorreo();
            if(correo.equals("jose@gmail.com")){
                it.remove();
            }
        }
        
        estudiantes.forEach((est) -> {
            System.out.println("Nombre; "+est.getNombre()+", Correo; "+est.getCorreo());
        });
//////        
//        
      }

    }
