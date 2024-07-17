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
public class Jalapenio extends PlantaExplosiva{

    
    /**
     * Metodo constructor por el cual establecemos los aatributos de un jalapenio con ayuda de su constructor padre
     */
    public Jalapenio() {
        super(1500, 125, 1000, TipoExplosion.LINEA);
    }
    /**
     * Metodo por el cual regresamos los atributos de un jalapenio en formato de texto.
     * @return Los atributos de un jalapenio
     */
    
    @Override
    public String toString(){
        System.out.println("ID:    "+getId());
        System.out.println("VIDA:  "+this.vida);
        System.out.println("TIPO:   JALAPEÑO");       
    return " ";
    }
    /**
     * Metodo por el cual el jalapenio muestra su ataque o tipo de explosion al usuario
     */
    @Override
    public void atacar(){
        System.out.println("Explosion de Jalapeño: ["+getTipoExplosion());
    }
}
