/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosPago;

/**
 *
 * @author josej
 */
public class Pago {
    protected float subTotal;
    protected float iva;
    protected float total;
    
    /**
     * Metodo constructor de la clase pago por defecto
     */
    public Pago() {
    }
    /**
     * Metodo String el cual nos da una mejor presentacion, de los atributos de esta clase
     * @return Un formato mejorado de los atributos
     */
    public String detallePago(){
            
    return "Total; "+subTotal+"\nIva;"+iva+"\nTotal;"+total;
    }
    /**
     * Metodo por el cual establecmos el subtotal mediante su paramtero, y establecer el iva y toal a pagar
     * @param subTotal El subtotal de los productos
     */
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
        this.iva=(subTotal*16)/100;
        this.total=iva+subTotal;
    }
    /**
     * Metodo por el cual regresa los atributs de la clase en un formato de cadena.
     * @return Los atributos de la clase
     */   
    @Override
    public String toString(){

        return "Subtotal="+subTotal+", Iva="+iva+", Total; "+total;
    }
    
}
