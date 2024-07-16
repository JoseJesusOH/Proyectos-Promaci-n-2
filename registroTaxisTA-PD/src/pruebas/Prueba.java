/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import objetosNegocio.Registros;
import objetosNegocio.Sitio;
import objetosNegocio.Taxi;
import objetosNegocio.Viaje;
import objetosNegocio.Zona;

/**
 *
 * @author josej
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Punto A) En estas lineas de codigo se estaran creando objetos del
         * tipo taxi para psteriormente agregarlos a una coleecion
         */
        Taxi taxi1 = new Taxi(1, "WFA-23-45", Sitio.CASA_BLANCA);
        Taxi taxi2 = new Taxi(2, "WEY-21-96", Sitio.CENTRAL);
        Taxi taxi3 = new Taxi(3, "WST-18-45", Sitio.SORIANA);
        Taxi taxi4 = new Taxi(4, "WFE-47-89", Sitio.CASA_BLANCA);
        Taxi taxi5 = new Taxi(5, "ETA-23-45", Sitio.SORIANA);
        Taxi taxi6 = new Taxi(6, "WST-23-45", Sitio.CENTRAL);

        /**
         * Punto B) Se crea un objeto de Registos de una empresa
         */
        Registros empresaTaxista = new Registros();

        /**
         * Punto C) Se agregan los objetos creados al 0objeto de registris taxi
         * crado con aterioridad
         */
        empresaTaxista.agregarRegistroTaxi(taxi1);
        empresaTaxista.agregarRegistroTaxi(taxi2);
        empresaTaxista.agregarRegistroTaxi(taxi3);
        empresaTaxista.agregarRegistroTaxi(taxi4);
        empresaTaxista.agregarRegistroTaxi(taxi5);
        empresaTaxista.agregarRegistroTaxi(taxi6);

        /**
         * Punto D) Se crean 8 objetos del tipo viaje
         */
        Viaje viaje1 = new Viaje(empresaTaxista.consultaTaxi(5), Zona.SUR, 15);
        Viaje viaje2 = new Viaje(empresaTaxista.consultaTaxi(8), Zona.CENTRO, 5);
        Viaje viaje3 = new Viaje(empresaTaxista.consultaTaxi(6), Zona.NORTE, 10);
        Viaje viaje4 = new Viaje(empresaTaxista.consultaTaxi(1), Zona.CENTRO, 3);
        Viaje viaje5 = new Viaje(empresaTaxista.consultaTaxi(7), Zona.NORTE, 12);
        Viaje viaje6 = new Viaje(empresaTaxista.consultaTaxi(4), Zona.SUR, 18);
        Viaje viaje7 = new Viaje(empresaTaxista.consultaTaxi(3), Zona.CENTRO, 20);
        Viaje viaje8 = new Viaje(empresaTaxista.consultaTaxi(2), Zona.NORTE, 2);

        /**
         * Punto E) Se agregan losviajes al registro de la empresa con apoyo de
         * uno de su metodos
         */
        empresaTaxista.agregarRegistroViaje(viaje1);
        empresaTaxista.agregarRegistroViaje(viaje2);
        empresaTaxista.agregarRegistroViaje(viaje3);
        empresaTaxista.agregarRegistroViaje(viaje4);
        empresaTaxista.agregarRegistroViaje(viaje5);
        empresaTaxista.agregarRegistroViaje(viaje6);
        empresaTaxista.agregarRegistroViaje(viaje7);
        empresaTaxista.agregarRegistroViaje(viaje8);

        /**
         * Punto F) A continuacion se mostrara la lista de taxis actuales con
         * apoyo de la empresaTaxista
         */
        System.out.println("----------------------------------");
        System.out.println(empresaTaxista.listaRegistrosTaxis());
        /**
         * Resultados [1, WFA-23-45, CASA_BLANCA, 2, WEY-21-96, CENTRAL, 3,
         * WST-18-45, SORIANA, 4, WFE-47-89, CASA_BLANCA, 5, ETA-23-45, SORIANA,
         * 6, WST-23-45, CENTRAL] Sehan imprimido los taxis actuales de la
         * empresa
         */

        /**
         * Punto G) A comtiuacion se agrega nuevamente el taxi, pero esto no
         * sera posible porque el el metodo de registrar taxi no es posibe
         * agregar yaxi repetidos
         */
        empresaTaxista.agregarRegistroTaxi(taxi5);
        /**
         * Resultados Taxi Repetido No se ha podido agregar porque este es un
         * taxi repetido
         */
        System.out.println("-----------------------------------");
        /**
         * Punto H) Ahora se imprimira la lista de los viajes de la empresa
         * taxista
         */
        System.out.println(empresaTaxista.listaRegistrosViajes());
        /**
         * Resultados [5, ETA-23-45, SORIANA, 15.0, SUR, 6, WST-23-45, CENTRAL,
         * 10.0, NORTE, 1, WFA-23-45, CASA_BLANCA, 3.0, CENTRO, 4, WFE-47-89,
         * CASA_BLANCA, 18.0, SUR, 3, WST-18-45, SORIANA, 20.0, CENTRO, 2,
         * WEY-21-96, CENTRAL, 2.0, NORTE] Se han imprimido los viajes los
         * cuales si habian recibido como paramtero un taxi que fuera difeerente
         * de null
         */
        System.out.println("-----------------------------------");
        /**
         * Punto I) Ahora se utilizara el metodo de ordenar taxis por numero de
         * placas
         */
        System.out.println(empresaTaxista.ordenaTaxisNumPlacas());
        /**
         * Resulatdos [5, ETA-23-45, SORIANA, 2, WEY-21-96, CENTRAL, 1,
         * WFA-23-45, CASA_BLANCA, 4, WFE-47-89, CASA_BLANCA, 3, WST-18-45,
         * SORIANA, 6, WST-23-45, CENTRAL] Se han imprimido los taxis ordenadis
         * por numeros de placas
         */
        System.out.println("-----------------------------------");
        /**
         * Punto J) Ahora se imprimra el registro de taxis
         */
        System.out.println(empresaTaxista.listaRegistrosTaxis());
        /**
         * Resultados [1, WFA-23-45, CASA_BLANCA, 2, WEY-21-96, CENTRAL, 3,
         * WST-18-45, SORIANA, 4, WFE-47-89, CASA_BLANCA, 5, ETA-23-45, SORIANA,
         * 6, WST-23-45, CENTRAL] Nuevamente se imprimieron los taxis de la
         * empresa en el orden en el que se registraron dado a que el metodo
         * anterior unicamente envio una copia de lista en formato ordenado
         */
        System.out.println("-----------------------------------");
        /**
         * Punto k) Ahora se imprimira la lista de viajes ordenados por destino
         */
        System.out.println(empresaTaxista.ordenaViajesDestino());
        /**
         * Resultados [1, WFA-23-45, CASA_BLANCA, 3.0, CENTRO, 3, WST-18-45,
         * SORIANA, 20.0, CENTRO, 6, WST-23-45, CENTRAL, 10.0, NORTE, 2,
         * WEY-21-96, CENTRAL, 2.0, NORTE, 5, ETA-23-45, SORIANA, 15.0, SUR, 4,
         * WFE-47-89, CASA_BLANCA, 18.0, SUR] Se han imprimido la lista de
         * viajes en un formato ordenado enn base a su destino y ademas es
         * similiar al anterior porque se envio una copia
         */
        System.out.println("-----------------------------------");
        /**
         * Punto L) Ahora se imprimira la sita de taxis del sitio de casa blanca
         */
        System.out.println(empresaTaxista.listaTaxiSitio(Sitio.CASA_BLANCA));
        /**
         * Resultados [1, WFA-23-45, CASA_BLANCA, 4, WFE-47-89, CASA_BLANCA] Se
         * han imprimido aquellos taxis que eseten encargados de la zona de
         * casblanca
         */
        System.out.println("------------------------------------");
        /**
         * Punto M) Ahora se imprimira la lista de viajes que han tenido destino
         * la Zona Centro
         */
        System.out.println(empresaTaxista.viajesDestinos(Zona.CENTRO));
        /**
         * Resultados [1, WFA-23-45, CASA_BLANCA, 3.0, CENTRO, 3, WST-18-45,
         * SORIANA, 20.0, CENTRO] Se han imorimido aquellos taxis encargados de
         * la zona centro
         */
        System.out.println("------------------------------------");
        /**
         * Punto N) Ahora se evaluaran las ganancias de viajes obtenidas de la
         * empresa taxista
         */
        if (empresaTaxista.calculaGananciasViajes() > 0) {
            System.out.println("Ganancias Obtenidas por viajes; $" + empresaTaxista.calculaGananciasViajes());
        } else {
            System.out.println("Perdidas; $" + empresaTaxista.calculaGananciasViajes());
        }
        /**
         * Resultados Ganancias Obtenidas por viajes; $473.73584 Se han
         * imprimido las ganacias totales de la empresa dado a que estas no
         * fueron menores a cer
         */
        System.out.println("------------------------------------");
        /**
         * Punto O y P ) Ahora se eliminaran los viajes que ha hecho el taxi 3,
         * y despues de semimprimiran
         */
        empresaTaxista.eliminarRegistroViaje(empresaTaxista.consultaTaxi(3));
        System.out.println(empresaTaxista.listaRegistrosViajes());
        /**
         * Resultados [5, ETA-23-45, SORIANA, 15.0, SUR, 6, WST-23-45, CENTRAL,
         * 10.0, NORTE, 1, WFA-23-45, CASA_BLANCA, 3.0, CENTRO, 4, WFE-47-89,
         * CASA_BLANCA, 18.0, SUR, 2, WEY-21-96, CENTRAL, 2.0, NORTE]
         * Se han eliminado los viajes del taxi tres y se han imprimido nuevamente para verificar.
         */
        System.out.println("-------------------------------------a");
    }

}
