/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04;

import Plantas.*;

/**
 *
 * @author José Jesús Orozco Hernández
 */
public class Juego {

    private static int solesDisponibles = 400;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Planta planta1;
       
        Lanzaguisantes lanzaguisantes1 = new Lanzaguisantes();
        lanzaguisantes1.atacar();
        Girasol girasol1 = new Girasol();
        for (int i = 0; i < 5; i++) {
            girasol1.generarSoles();
        }

        System.out.println("-------------------------------");
        Juego.desplegarSoles();
        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        Cereza cereza1 = new Cereza();
        cereza1.atacar();
        System.out.println("-------------------------------");
        Jalapenio jalapenio1 = new Jalapenio();
        System.out.println(jalapenio1.getTipoExplosion());
        System.out.println("-------------------------------");

        Jalapenio jalapenio2 = new Jalapenio();
        System.out.println(jalapenio1.equals(jalapenio2));
        System.out.println("-------------------------------");
        PlantaExplosiva plantaExplosiva1;
        Planta[] plantas;
        plantas = new Planta[5];
        plantas[0] = lanzaguisantes1;
        plantas[1] = girasol1;
        plantas[2] = cereza1;
        plantas[3] = jalapenio1;
        plantas[4] = jalapenio2;

        for (int i = 0; i < plantas.length; i++) {
            planta1 = plantas[i];
            System.out.println(planta1.toString());
            System.out.println("-------------------------------");
        }
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < plantas.length; i++) {
            Planta planta = plantas[i];
            if (planta.plantar() == true) {
                System.out.println("Planta plantada");
                System.out.println(planta.toString());
                System.out.println("-------------------------------");

            } else {
                System.out.println("Planta no plantada");
                System.out.println(planta.toString());
                System.out.println("-------------------------------");

            }

        }
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < plantas.length; i++) {
            Planta planta = plantas[i];
            boolean procesos = planta instanceof Jalapenio;
            if (procesos == true) {
                System.out.println(planta.toString());
            }
        }
      
        desplegarSoles();

    }
    /**
     * Metodo por el cual obtenemos los soles disponibles
     * @return  Los soles disponibles
     */
    public static int obtnerSoles() {
        return Juego.solesDisponibles;
    }
   /**
    * Metodo por el cual restamos soles, a la cantidad de soles actuales, este metodo se usa con la plantacion
    * @param soles 
    */
    public static void restarSoles(int soles) {
        if (soles > 0) {
            if ((Juego.solesDisponibles - soles) > 0) {
                Juego.solesDisponibles = Juego.solesDisponibles - soles;
            }
        }
    }

    /**
     * Metodo vacio por el cual sumamos nuevos soles
     *
     * @param soles Los soles a sumar a la cantidad actual
     */
    public static void sumarSoles(int soles) {
        if (soles > 0) {
            Juego.solesDisponibles = Juego.solesDisponibles + soles;
        }
    }

    /**
     * Metodo por el cual obtenemos el numero de soles disponibles
     */
    public static void desplegarSoles() {
        System.out.println("NUMERO DE SOLES DISPONIBLES: " + solesDisponibles);
    }

}
