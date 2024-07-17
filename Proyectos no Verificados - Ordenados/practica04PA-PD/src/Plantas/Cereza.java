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
public class Cereza extends PlantaExplosiva{
   /**
    * Constructor por defecto en el cual establecemos los atributos de una cereza, con apoyo del constructor de su padre
    */
    public Cereza() {
        super(1800,150, 100,TipoExplosion.CIRCULAR);
    }
    /**
     * Metodo por el cual la cereza realiza su ataque y lo muestra al usa en formato de cadena 
     */
    @Override
     public void atacar(){
        System.out.println("Esplosion de Cereza: ["+getTipoExplosion()+"]");
     }
     
     /**
      * Metodo por el cual mostramos al usuario los atributos de la cereza.
      * @return  Los atributos de la cereza.
      */
    @Override
    public String toString(){
        System.out.println("ID:    "+getId());
        System.out.println("VIDA:  "+getVida());
        System.out.println("TIPO:   CEREZA");       
    return " ";
    }
}
