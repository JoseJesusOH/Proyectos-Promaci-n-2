/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author josej
 */
public class Registros {

    private List<Taxi> registroTaxis;
    private List<Viaje> registroViajes;
    /**
     * Metodo constructor por el cual damos vida a los atributos de la clase lo las lista para que sean del tipo Array
     */
    public Registros() {
        registroTaxis = new ArrayList<>();
        registroViajes = new ArrayList<>();
    }
  /**
   * Metodo para agragar un taxi a la colecion pero cabe destacar que primeramente se analiza ciertos datos o tienen unas pequeñas restricciones 
   * agregarlo, se analiza si es diferente de nullo, 
   * @param taxi Taxi a comparar y agregar
   */
    public void agregarRegistroTaxi(Taxi taxi) {
        if (taxi != null) {
            int auxiliar = 0;
            for (int i = 0; i < registroTaxis.size(); i++) {
                if (registroTaxis.get(i).equals(taxi)) {
                    auxiliar = i;
                }
            }
            if (auxiliar != 0) {
                System.out.println("Taxi Repetido");
            } else {
                registroTaxis.add(taxi);
            }
        }

    }
/**
 * Metodo que permite agregar un viaje a la coleccion del tipo viaje. Para agregar el viaje se analiza primero 
 * si el viaje es diferente de null, y si no contiene algun taxi;
 * @param viaje Viaje a agregar
 */
    public void agregarRegistroViaje(Viaje viaje) {
        if (viaje != null) {
            if (viaje.getTaxi() != null) {
                registroViajes.add(viaje);
            }
        }
    }
    /**
     * Metodo para elimar un taxi del registro de taxi
     * @param taxi Taxi a eliminar;
     */
    public void eliminarRegistroViaje(Taxi taxi) {
        Iterator<Viaje> eliminar = registroViajes.iterator();
        while (eliminar.hasNext()) {
            if (eliminar.next().getTaxi().getNumTaxi() == taxi.getNumTaxi()) {
                eliminar.remove();
            }
        }
    }
    /**
     * MEtodo para calcular el consumo de gasolina total;
     * @return  Total de gasolina gastada
     */
    public float calculaConsumoGasolina() {
        float auxiliar = 0;
        for (int i = 0; i < registroViajes.size(); i++) {
            Viaje get = registroViajes.get(i);
            auxiliar = auxiliar + get.getKms();
        }

        return (float) ((auxiliar * 19.70) / 12.96);
    }
    /**
     * Total de ganacias por viajes
     * @return Ganancias totales de viajes de la empresa
     */
    public float calculaGananciasViajes() {
        float auxiliar = 0;
        for (int i = 0; i < registroViajes.size(); i++) {
            Viaje get = registroViajes.get(i);
            auxiliar = auxiliar + get.calcularCostoViaje();
        }
        return auxiliar - calculaConsumoGasolina();
    }
    /**
     * Regresa la collecion de registro de viajes
     * @return Registro de viajes
     */
    public List<Viaje> listaRegistrosViajes() {
        return registroViajes;
    }
   /**
    * Regresa aquellos datos de la coleccion que coincidan con el parametro dado, en este caso la zona de destino
    * @param destino Zona de destino
    * @return Lista con los nuevos datos de viajes que coinciden conel paramtero
    */
    public List<Viaje> viajesDestinos(Zona destino) {
        List<Viaje> vi = new ArrayList<>();
        for (int i = 0; i < registroViajes.size(); i++) {
            if (registroViajes.get(i).getDestino() == destino) {
                vi.add(registroViajes.get(i));
            }
        }
        return vi;
    }
   /**
    * Metodo que regresa la lista del registro de taxis
    * @return La lista de taxis
    */
    public List<Taxi> listaRegistrosTaxis() {
        return registroTaxis;
    }
    /**
     * Metodo que regresa una nueva lista de taxis en base a su parametro.Analiza la lista de taxis y obtine aquellos taxis que coincidan con el parametro
     * @param sitio Sitio a analizar
     * @return La nueva lista de taxis en base al parametro
     */
    public List<Taxi> listaTaxiSitio(Sitio sitio) {
        List<Taxi> ta = new ArrayList<>();
        for (int i = 0; i < registroTaxis.size(); i++) {
            if (registroTaxis.get(i).getSitio() == sitio) {
                ta.add(registroTaxis.get(i));
            }
        }
        return ta;
    }
//    
    /**
     * Metodoque ordena la lista de taxis en base a sus placas
     * @return La nueva lista de taxis ordenada
     */
    public List <Taxi>ordenaTaxisNumPlacas() {
        List<Taxi> ordenTaxi = new ArrayList<>();
        ordenTaxi.addAll(registroTaxis);
         List<Taxi> copia = new ArrayList<>();
        Collections.sort(ordenTaxi, new Comparator<Taxi>() {
            @Override
            public int compare(Taxi t, Taxi t1) {
                return t.getNumPlacas().compareTo(t1.getNumPlacas());
            }

        });
        for (Taxi registroTaxi : ordenTaxi) {
            copia.add(registroTaxi);
        }
        return copia;
    }
  /**
   * Metodo que ordena la lista de viajes en base a su destino
   * @return La nueva lista ordenada
   */
    public List <Viaje>ordenaViajesDestino() {
       
        List<Viaje> ordenViaje = new ArrayList<>();
        ordenViaje.addAll(registroViajes);
        List<Viaje> copia = new ArrayList<>();
        Collections.sort(ordenViaje, new Comparator<Viaje>() {
            @Override
            public int compare(Viaje v, Viaje v1) {
                return v.getDestino().name().compareTo(v1.getDestino().name());
            }

        });
        for (Viaje registroViaje : ordenViaje) {
            copia.add(registroViaje);
        }
        return copia;
    }
  /**
   * Metodo que consulta u obtiene un taxi del registro de taxis con apoyo en su numero de taxi
   * @param numTaxi Numero de taxi
   * @return EL taxi ha buscar y si no null;
   */
    public Taxi consultaTaxi(int numTaxi) {
        for (int i = 0; i < registroTaxis.size(); i++) {
            Taxi get = registroTaxis.get(i);
            if (get.getNumTaxi() == numTaxi) {
                return get;
            }
        }
        Taxi taxi = null;
        return taxi;
    }
}
