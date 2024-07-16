/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosPago;

import java.util.Objects;

/**
 *
 * @author josej
 */
public class Producto {

    private String nombre;
    private float precioUnitario;
    /**
     * Metodo por el cual establecemos los paramatros a los atributos de la clase en el cual establecemos el nombre y el precio del producto
     * @param nombre El nombre del producto
     * @param precioUnitario EL precio del producto
     */
    public Producto(String nombre, float precioUnitario) {
        this.nombre = nombre;
        if (precioUnitario >= 0) {
            this.precioUnitario = precioUnitario;
        }
    }
    /**
     * Metodo por el cual Comparamos los objetos de esta clase, su nombre ente otras cosas
     * @param obj El onjeto a cmparar
     * @return Si el producto a comparar es igual
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (getClass()!= obj.getClass()){
        return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.nombre,other.nombre);
    }
   /*+
    Metodo HashCode
    */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    /**
     * Metodo por el cual regresamos los atributos de la clase con una separacion de 7 espacios, en un formato de cadena
     * @return Los atributos de una clase
     */
    @Override
    public String toString() {
        return nombre + "     " + precioUnitario;
    }
   /**
    * Metodo por el cual pobtenemos el nombre dle producto.
    * @return El nombre del producto
    */
    public String getNombre() {
        return nombre;
    }
   /**
    * Metodo set en el cual establecemos el nombre del producto
    * @param nombre El nombre del producto
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo por el cual obtenemos el precio del producto
     * @return El precio del producto
     */
    public float getPrecioUnitario() {
        return precioUnitario;
    }
   /**
    * Metodo por el cual establecemos el precio del productocon el atributo, pero antes de establecerlo se evalua si este es positivo y no negativo
    * @param precioUnitario El precio del producto
    */
    public void setPrecioUnitario(float precioUnitario) {
        if (precioUnitario >= 0) {
            this.precioUnitario = precioUnitario;
        }
        

    }

}
