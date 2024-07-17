/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;
import objetosServicio.*;
/**
 *
 * @author josej
 */
public class Pruebas01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          
        Fecha hoy = new Fecha();
        Fecha ayer = new Fecha(15, 8, 2004);
        Fecha manhana = new Fecha(hoy);
        manhana.vencimiento(0, 0, 1);
        // no jala no se agregan los años, manhana.vencimiento(0, 0, 1);
        System.out.println("------------------------------------------------------");
        System.out.println("Fecha de Hoy; " + hoy.toString());
        System.out.println("Fecha de Ayer;" + ayer.toString());
        System.out.println("Fecha de manhana;" + manhana.toString());
        System.out.println("Mes de hoy; " + (hoy.getMonth()));
        System.out.println("------------------------------------------------------");
        ayer.setFecha(12, 6, 2008);
        System.out.println("Fecha de Ayer modificada;" + ayer.getDay() + "/" + (ayer.getMonth()) + "/" + ayer.getYear());
        System.out.println("------------------------------------------------------");
        
        System.out.println("Numero de dias entre hoy y manhana; " + hoy.lapso(manhana));
        System.out.println("Fecha de manhana;" + manhana.getDay() + "/" + (manhana.getMonth()) + "/" + manhana.getYear());
        System.out.println("Fecha de Hoy; " + hoy.getDay() + "/" + (hoy.getMonth()) + "/" + hoy.getYear());
        System.out.println("------------------------------------------------------");
        if (hoy.equals(hoy) == true) {
            System.out.println("Hoy es diferente de hoy; false son iguales");
        } else {
            System.out.println("Hoy es diferente de hoy; true son diferentes");
        }

        System.out.println("Fecha de Hoy; " + hoy.getDay() + "/" + (hoy.getMonth()) + "/" + hoy.getYear());
        System.out.println("Fecha de Hoy; " + hoy.getDay() + "/" + (hoy.getMonth()) + "/" + hoy.getYear());
        System.out.println("------------------------------------------------------");
        System.out.println("Ayer esta despues de manhana " + ayer.after(manhana));
        System.out.println("Ayer es igual a manhana " + ayer.equals(manhana));
        System.out.println("Fecha de Ayer;" + ayer.getDay() + "/" + ayer.getMonth() + "/" + ayer.getYear());

        System.out.println("Fecha de manhana;" + manhana.getDay() + "/" + manhana.getMonth() + "/" + manhana.getYear());
        System.out.println("------------------------------------------------------");
        System.out.println("Hoy esta antes que manhana; " + hoy.before(manhana));

        System.out.println("Fecha de manhana; " + manhana.getDay() + "/" + manhana.getMonth() + "/" + manhana.getYear());

        System.out.println("Fecha de Hoy; " + hoy.getDay() + "/" + hoy.getMonth() + "/" + hoy.getYear());
        System.out.println("------------------------------------------------------");
        Fecha desde = new Fecha();
        Fecha hasta = new Fecha(hoy);
        desde.set(2004, 2, 5);
        Periodo periodo = new Periodo(desde, hasta);

        System.out.println("Periodo ; " + periodo.toString());
        System.out.println("Fecha de Ayer; " + ayer.getDay() + "/" + ayer.getMonth() + "/" + ayer.getYear());

        System.out.println("Ayer esta dentro de periodo; " + periodo.contiene(ayer));
    
        
    }
    
}
