/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosPago;

import objetosServicio.Fecha;

/**
 *
 * @author josej
 */
public class TarjetaCredito extends Pago {

    private String banco;
    private String numTarjeta;
    private Fecha fechaVencimiento;
    private String nombre;

    /**
     * Metodo constructor por el cual establecemos los paramatros que recibimos
     * a los atributos de esta clase
     *
     * @param banco El nombre del banco
     * @param numTarjeta El numero de tarjeta
     * @param fechaVencimiento "La fecha de vencimiento de la tarjeta
     * @param nombre El nombre del propietario de la tarjeta
     */
    public TarjetaCredito(String banco, String numTarjeta, Fecha fechaVencimiento, String nombre) {
        this.banco = banco;
        this.numTarjeta = numTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.nombre = nombre;
    }

    /**
     * Metodo String en el cual regresamos datos mas especificados de la compra
     * de la tarjeta de credito, en la cual, se detalla el nombre, numero de
     * tarjeta, y el total a pagar ademas, de su iva, subtotal.
     *
     * @return
     */
    @Override
    public String detallePago() {
        int tarjetAsteriscos = (numTarjeta.length() - 12);
        int tarjetaOficial = numTarjeta.length() - tarjetAsteriscos;
        return  super.detallePago()+"\n Se realizo el pago de $" + this.total + " con la tarjeta de " + banco + "\n con numero **** **** **** " + numTarjeta.substring(tarjetaOficial) + " a nombre de " + nombre;
    }

}
