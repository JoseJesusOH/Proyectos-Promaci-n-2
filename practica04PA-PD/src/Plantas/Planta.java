/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plantas;

import java.util.Objects;
import practica04.Juego;

/**
 *
 * @author josej
 */
public abstract class Planta {

    protected long id;
    protected int vida;
    protected int ataque;
    protected int costo;
    protected static long contadorPlantas = 1;
//  
   /**
    * Metodo por el cual plantamos las plantas, depdiendo de ciertos factores, uno el cual si soles menos el costo de la planta es mayor que cero,
    * el costo se restara y podra ser plantada la planta.
    * @return Si la planta o no va ser plantada
    */
    public boolean plantar() {
        if ((Juego.obtnerSoles() - getCosto()) > 0) {
            Juego.restarSoles(getCosto());
            return true;
        }
        return false;
    }
    /**
     * Metodo  el cual recibe un objeto del tipo planta y los compara
     * @param planta El objeto a comparar
     * @return Verdare o falso, depiendo si este cumple con las condiciones 
     */
    @Override
    public boolean equals(Object planta) {
        if (planta == null) {
            return false;
        }
        if (getClass() != planta.getClass()) {
            return false;
        }
        final Planta other = (Planta) planta;
        //To change body of generated methods, choose Tools | Templates.
        return Objects.equals(this.id, other.id);
    }
    /**
     * Metodo hash code 
     * @return El codigo de los atributos
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + this.vida;
        hash = 83 * hash + this.ataque;
        hash = 83 * hash + this.costo;
        hash = 83 * hash + (int) (Planta.contadorPlantas ^ (Planta.contadorPlantas >>> 32));
        return hash;
    }
    /**
     * Metodo vor el cual regresamos el id  y vida de la planta
     * @return EL id y vida de la planta en un formato de cadena
     */
    @Override
    public String toString() {
        return "ID:    " + getId() + "\nVIDA:  " + getVida();
    }

    public abstract void atacar();
     /**
      * Metoconstructor por defecto en el cual se establecen nuevos valores al id i contador
      */
    protected Planta() {

        this.id = contadorPlantas;
        contadorPlantas++;
    }

    /**
     * Metodo por el cual obtenemos el id de la planta
     *
     * @return El id
     */
    public long getId() {
        return id;
    }

    /**
     * Metodo por el cual obtenemos la vida de la planta
     *
     * @return La vida de la planta
     */
    public int getVida() {
        return vida;
    }

    /**
     * Metotodo por el cual obtenemos la cantidad de ataque de la planta
     *
     * @return
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Metodo por el cual obtenemos el costo de la planta
     *
     * @return
     */
    public int getCosto() {
        return costo;
    }

}
