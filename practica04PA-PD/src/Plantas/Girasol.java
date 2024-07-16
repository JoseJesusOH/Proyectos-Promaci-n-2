/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plantas;

import practica04.Juego;

/**
 *
 * @author josej
 */
public class Girasol extends Planta {

    public static final int SOLES = 10;

    /**
     * Metodo constructor por el cual el girasol realiza su ataque, aunque este
     * no tenga.
     */
    @Override
    public void atacar() {
        System.out.println("Un girasol no puede atacar!");
    }

    /**
     * Constructor por defecto del girasol , en el cual establecemos su ataque ,
     * costo y vida
     */
    public Girasol() {
        this.ataque = 0;
        this.costo = 50;
        this.vida = 100;
    }

    /**
     * Metodo String por el le mostramos al usuario las caracteristicas de este
     * girasol, su id,vida y ataque
     * @return Los atributos del girasol en formato de cadena.
     */
    @Override
    public String toString() {
        System.out.println("ID:    " + getId());
        System.out.println("VIDA:  " + getVida());
        System.out.println("TIPO:   GIRASOL");
        return " ";
    }

    /**
     * Metodo vacio por el cual el girasol es capaz dde generar soles.
     */
    public void generarSoles() {
        Juego.sumarSoles(SOLES);
    }

}
