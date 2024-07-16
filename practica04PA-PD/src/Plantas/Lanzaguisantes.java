/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plantas;

/**
 *
 * @author josej
 */
public class Lanzaguisantes extends Planta{
    /**
     * Metodo constructor por defecto, en el cual establecemos los atrubutos de un lanzaguisantes, su ataque
     * costo y vida
     */
    public Lanzaguisantes() {
        this.ataque=5;
        this.costo=100;
        this.vida=50;
    }
    
    /**
     * Metodo vacio por el cual el lanzaguistantes muestra al usuario un ataque
     */
    @Override
    public void atacar(){
        System.out.println("EL lanzaguisantes ["+getId()+"] atacó: ATK-"+getAtaque()+"]");
    }
    
    /**
     * Metodo String por el cual regresamos los atributos en formato de cadena id, vida, y tipo de planta del lanzaguisantes.
     * @return Los atributos del lanzaguisantes actual
     */
    @Override
    public String toString(){
        System.out.println("ID:    "+getId());
        System.out.println("VIDA:  "+getVida());
        System.out.println("TIPO:   LANZAGUISANTES");       
    return " ";
    }
    
}
