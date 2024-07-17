/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import objetosServicio.*;
import objetosNegocio.*;
/**
 *
 * @author josej
 */
public class Prueba03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Alumno alumno1 = new Alumno("LDG", "AL01", "Juan Perez Lopez", "jperez@gmail.com");
        Alumno alumno2 = new Alumno("ISW", "AL02", "Luis Ramos Soto", "lramos@outlook.mx");
        Alumno alumno3 = new Alumno("LTA", "AL03", "José Beltrán Luis", "jbeltram@live.com");

        System.out.println(alumno1.toString());
        System.out.println(alumno2.toString());
        System.out.println(alumno3.toString());
        System.out.println("----------------------------------");
        System.out.println(alumno1.getNombre());
        System.out.println("---------------------------------");
        if (alumno1.equals(alumno1)) {
            System.out.println(alumno1.equals(alumno1) + " Son iguales");
            System.out.println(alumno1.toString());
            System.out.println(alumno1.toString());
        } else {
            System.out.println(alumno1.equals(alumno1) + " Son Diferentes ");
            System.out.println(alumno1.toString());
            System.out.println(alumno1.toString());
        }

        System.out.println("----------------------------------");
        if (alumno2.equals(alumno3)) {
            System.out.println(alumno2.equals(alumno3) + " Son iguales");
            System.out.println(alumno2.toString());
            System.out.println(alumno3.toString());
        } else {
            System.out.println(alumno2.equals(alumno3) + " Son Diferentes ");
            System.out.println(alumno2.toString());
            System.out.println(alumno3.toString());
        }

        System.out.println("----------------------------------");

        Profesionista profesionista1 = new Profesionista("Administradora de Proyectos", "PR18", "Marina Salinas Cruz", "msalinas@hp.com");

        Profesionista profesionista2 = new Profesionista("Gerente de ventas", "PR20", "Carlos Diaz Rosas", "cdiaz@prodigy.cob.net");

        Profesionista profesionista3 = new Profesionista("Aquitecto de Software", "PR20", "Sofía Lara Gómez", "slara@sun.com");

        System.out.println(profesionista1.toString());
        System.out.println(profesionista2.toString());
        System.out.println(profesionista3.toString());

        System.out.println("---------------------------------");
        System.out.println(profesionista2.getPuesto());
        System.out.println("---------------------------------");
        if (profesionista1.equals(profesionista3)== true) {
            System.out.println(profesionista1.equals(profesionista3) + " Son iguales");
            System.out.println(profesionista1.toString());
            System.out.println(profesionista3.toString());
        } else {
            System.out.println(profesionista1.equals(profesionista3) + " Son diferentes");
            System.out.println(profesionista1.toString());
            System.out.println(profesionista3.toString());
        }
        System.out.println("---------------------------------");
        if (profesionista2.equals(profesionista3) ) {
            System.out.println(profesionista2.equals(profesionista3) + " Son iguales");
            System.out.println(profesionista2.toString());
            System.out.println(profesionista3.toString());
        } else {
            System.out.println(profesionista2.equals(profesionista3) + " Son diferentes");
            System.out.println(profesionista2.toString());
            System.out.println(profesionista3.toString());
        }

        System.out.println("--------------------------------");
        profesionista3.setClave("PR30");
        System.out.println(profesionista3.toString());
        System.out.println("--------------------------------");

        Ponencia ponencia1 = new Ponencia(alumno1, "Recibida", "PO89", "Implementacion de VolP en una empresa", new Fecha(1, 11, 2019), 11);
        Ponencia ponencia2 = new Ponencia(alumno2, "Aceptada", "PO95", "Usos de las TI en la industria local", new Fecha(2, 11, 2019), 12);
        Ponencia ponencia3 = new Ponencia(alumno1, "Aceptada", "PO99", "Software libre y las PyMEs", new Fecha(2, 11, 2019), 12);

        System.out.println(ponencia1.toString());
        System.out.println(ponencia2.toString());
        System.out.println(ponencia3.toString());
        System.out.println("----------------------------");
        System.out.println(ponencia1.getPonente());

        System.out.println("----------------------------");
        ponencia2.setTitulo("Software libre y las PyMEs");
        ponencia3.setTitulo("Usos de las TI en la industria local");
        System.out.println(ponencia2.toString());
        System.out.println(ponencia3.toString());
        System.out.println("------------------------------");
        if (ponencia1.equals(ponencia2)) {
            System.out.println("Son iguales");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia2.toString());
        }
        else{
          System.out.println("Son diferentes");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia2.toString());
        }

        System.out.println("------------------------------");
        if (ponencia1.equals(ponencia3)) {
            System.out.println("Son iguales");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia3.toString());
        }
        else{
             System.out.println("Son diferentes");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia3.toString());
        }
        System.out.println("------------------------------");
        if(ponencia1.empalma(ponencia1)){
            System.out.println("Se empalma; ");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia1.toString());
        }
        else{
            System.out.println("No se empalman");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia1.toString());
        }
        System.out.println("--------------------------------");
        if(ponencia1.empalma(ponencia2)){
            System.out.println("Se empalma; ");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia2.toString());
        }
        else{
            System.out.println("No se empalman");
            System.out.println(ponencia1.toString());
            System.out.println(ponencia2.toString());
        }
        System.out.println("-------------------------------");
        if(ponencia2.empalma(ponencia3)){
            System.out.println("Se empalma; ");
            System.out.println(ponencia2.toString());
            System.out.println(ponencia3.toString());
        }
        else{
            System.out.println("No se empalman");
            System.out.println(ponencia2.toString());
            System.out.println(ponencia3.toString());
        }
        System.out.println("-------------------------------");
        Conferencia conferencia1 = new Conferencia(profesionista1, "CO01", "Computadoras multiprocesadoras", new Fecha(1, 11, 2019), 9);
        Conferencia conferencia2 = new Conferencia(profesionista2, "CO02", "Servicios empresariales de TELMEX", new Fecha(2, 11, 2019), 9);
        Conferencia conferencia3 = new Conferencia(profesionista3, "CO03", "Nuevas Tecnologias en Servidores de Aplicaciones", new Fecha(2, 11, 2019), 9);
        System.out.println(conferencia1.toString());
        System.out.println(conferencia2.toString());
        System.out.println(conferencia3.toString());
        System.out.println("-----------------------------");
        System.out.println("Fecha; " + conferencia3.getFecha() + " Hora; " + conferencia3.getHora());
        System.out.println("-----------------------------");
        if(conferencia1.equals(conferencia2)){
            System.out.println("Son iguales");
            System.out.println(conferencia1.toString());
        System.out.println(conferencia2.toString());
        }
        else{
            System.out.println("Son Diferentes");
            System.out.println(conferencia1.toString());
        System.out.println(conferencia2.toString());
        }
        System.out.println("------------------------------");
        if(conferencia2.equals(conferencia3)){
            System.out.println("Iguales");
             System.out.println(conferencia2.toString());
        System.out.println(conferencia3.toString());
        }
        else{
            System.out.println("Son diferentes");
             System.out.println(conferencia2.toString());
        System.out.println(conferencia3.toString());
        }
        System.out.println("------------------------------");
        if(conferencia1.empalma(conferencia1)){
            System.out.println("Se empalma; ");
            System.out.println(conferencia1.toString());
            System.out.println(conferencia1.toString());
        }
        else{
            System.out.println("No se empalman");
            System.out.println(conferencia1.toString());
            System.out.println(conferencia1.toString());
        }
        System.out.println("---------------------------------");
        if(conferencia1.empalma(conferencia3)){
            System.out.println("Se empalma; ");
            System.out.println(conferencia1.toString());
            System.out.println(conferencia3.toString());
        }
        else{
            System.out.println("No se empalman");
            System.out.println(conferencia1.toString());
            System.out.println(conferencia3.toString());
        }
        System.out.println("----------------------------------");
        if(conferencia2.empalma(conferencia3)){
            System.out.println("Se empalma; ");
            System.out.println(conferencia2.toString());
            System.out.println(conferencia3.toString());
        }
        else{
            System.out.println("No se empalman");
            System.out.println(conferencia2.toString());
            System.out.println(conferencia3.toString());
        }
    }

}
