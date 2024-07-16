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
public class Efectivo extends Pago{
    /**
     * Constructor por defecto de la clase Efectivo
     */
    public Efectivo() {
    }
    /**
     * MEtodo por el cual nos regresa una cadena de caracteres con el total,subtotal, iva, y el tipo de pago,
     * @return Cadena de caracteres del detalle de pago
     */
    @Override
    public String detallePago(){ 
        return  super.detallePago()+"Se realizo el pago de $"+this.total+" en efectivo";
    }
}
