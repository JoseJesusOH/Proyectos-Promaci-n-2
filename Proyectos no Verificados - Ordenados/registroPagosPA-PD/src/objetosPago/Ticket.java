/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosPago;

import java.util.Objects;
import objetosServicio.Fecha;

/**
 *
 * @author josej
 */
public class Ticket {

    private Pago pago;
    private int folio;
    private Producto[] productos;
    private Fecha fechaCompra;

    /**
     * Metodo por el cual establecemos la fecha de compra del cliente
     *
     * @return La fecha de compra.
     */
    public Fecha getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Metodo por el cual establecemos la fecha de compra que es enviada por el
     * usuario, instanciado como objeto
     *
     * @param fechaCompra
     */
    public void setFechaCompra(Fecha fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Meto constructor en el cual establecmos los parameros de pago,folio,fecha
     * de compra
     *
     * @param pago Pago que realiza el cliente
     * @param folio Numero de folio del ticket
     * @param fechaCompra Fecha de compra del cliente
     */
    public Ticket(Pago pago, int folio, Fecha fechaCompra) {
        this.pago = pago;
        this.folio = folio;
        this.fechaCompra = fechaCompra;
        productos = new Producto[4];
    }

    /**
     * MEtodo por el cual asignamos productos al arreglo de productos
     *
     * @param producto El producto a agregar al arreglo
     */
    public void agregarProducto(Producto producto) {
        int j = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                j++;
            }
        }
        if (j == 4) {
            System.out.println("No hay espacios disponibles");
        }
        int n = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                n = i;
                productos[n] = producto;
                break;
            }
        }

    }

    /**
     * Metodo por el cual nos permite eliminar cierto producto dentro del
     * arreglo que coincida con el paramtero
     *
     * @param nombre Nombre del producto a eliminar
     */
    public void elimiarProducto(String nombre) {

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                    productos[i].setNombre(null);
                    productos[i].setPrecioUnitario(0);
                }
            }
        }

    }

    /**
     * MEtodo vacio por el cual nos regresa el total obtenido de la suma de los
     * productos dentro de l arreglo.
     *
     * @return El total de la suma de los arreglos.
     */
    public float calcularSubtotal() {
        return productos[0].getPrecioUnitario() + productos[1].getPrecioUnitario() + productos[2].getPrecioUnitario() + productos[3].getPrecioUnitario();
    }

    /**
     * Metodo por el cual nos genera el ticket del cliente con los datos de la
     * compra, total,subtotal e iva
     */
    public void generarTicket() {
        System.out.println("-----------------------------------");
        System.out.println("Folio ticket; " + folio);
        System.out.println("Producto        Precio Unitario");
        System.out.println("------------    ---------------");
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].getNombre() != null) {
                System.out.format("%-15s %-14.2f %n", productos[i].getNombre(), productos[i].getPrecioUnitario());

            }
        }
   
        System.out.println("------------    ---------------");
    pago.setSubTotal(calcularSubtotal());
    pago.detallePago();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.pago);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (!Objects.equals(this.pago, other.pago)) {
            return false;
        }
        return true;
    }

    /**
     * Metodo por el cual nos regresa los atributos de la clase en una cadena de
     * texto.
     *
     * @return Cadena de texto
     */
    @Override
    public String toString() {
        return pago + "       " + folio + "       " + productos + "       " + fechaCompra;
    }

}
