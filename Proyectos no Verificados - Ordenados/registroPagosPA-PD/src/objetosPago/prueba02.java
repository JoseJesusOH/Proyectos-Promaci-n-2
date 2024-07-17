/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosPago;

import objetosServicio.*;
import objetosPago.*;
/**
 *
 * @author josej
 */
public class prueba02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto producto1 = new Producto("Te Jazmin", 25);
        Producto producto2 = new Producto("Papas 62gr", 12);
        Producto producto3 = new Producto("Coca 3lt", 25);
        Producto producto4 = new Producto("Sopa", 8);
        Producto producto5 = new Producto("Lechera", 12);
        Producto producto6 = new Producto("Mayonesa", 27);
        System.out.println("----------------------------");
        System.out.println(producto1.toString());
        System.out.println(producto2.toString());
        System.out.println(producto3.toString());
        System.out.println(producto4.toString());
        System.out.println(producto5.toString());
        System.out.println(producto6.toString());
        System.out.println("----------------------------");
        producto5.setNombre("Atun");
        System.out.println(producto5.toString());
        System.out.println("----------------------------");
        System.out.println("Producto 1 es igual al producto 2; " + producto1.equals(producto2));
        System.out.println("Producto 3 es igual al producto 3; " + producto3.equals(producto3));
        System.out.println("----------------------------");

        Fecha fechaPago1 = new Fecha(11, 12, 2016);
        Pago pago1 = new TarjetaCredito("Bital", "1234123412341234", fechaPago1, "Juan Perez");
        Fecha fechaPago2 = new Fecha(11, 12, 2018);
        Pago pago2 = new TarjetaCredito("Banco Mexicano", "182713401331897", fechaPago2, "Juan Perez");

        Pago pago3 = new Efectivo();

        Fecha fechaUno = new Fecha();

        Fecha fechaDos = new Fecha(18, 12, 2015);

        Fecha fechaTres = new Fecha(fechaDos);

        fechaTres.vencimiento(40);

        Ticket ticket1 = new Ticket(pago1, 1234, fechaUno);
        Ticket ticket2 = new Ticket(pago2, 1458, fechaDos);
        Ticket ticket3 = new Ticket(pago3, 2736, fechaTres);
//        
        ticket1.agregarProducto(producto1);
        ticket1.agregarProducto(producto2);
        ticket1.agregarProducto(producto3);
        ticket1.agregarProducto(producto3);
        ticket1.agregarProducto(producto3);

        ticket2.agregarProducto(producto3);
        ticket2.agregarProducto(producto4);
        ticket2.agregarProducto(producto5);
        ticket2.agregarProducto(producto6);

        ticket3.agregarProducto(producto4);
        ticket3.agregarProducto(producto4);
        ticket3.agregarProducto(producto5);
        ticket3.agregarProducto(producto1);

        Ticket[] tickets = new Ticket[3];
        tickets[0] = ticket1;
        tickets[1] = ticket2;
        tickets[2] = ticket3;
        System.out.println("-------------------------------------");

        for (int i = 0; i < tickets.length; i++) {
            System.out.println("--------------------------------------");
            tickets[i].generarTicket();
            System.out.println("--------------------------------------");
        }
        Fecha desde = new Fecha(18, 12, 2015);
        Fecha hasta = new Fecha(15, 3, 2016);
        Periodo periodo = new Periodo(desde, hasta);
        System.out.println("-------------------------------------");
        for (int i = 0; i < 2; i++) {

            int dia = tickets[i].getFechaCompra().getDay();
            int mes = tickets[i].getFechaCompra().getMonth();
            int year = tickets[i].getFechaCompra().getYear();
            Fecha fecha = new Fecha(dia, mes, year);
            if (periodo.contiene(fecha)) {
                tickets[i].generarTicket();
            }
        }
    }

}
