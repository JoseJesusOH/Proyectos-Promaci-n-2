/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

/**
 *
 * @author josej
 */
public class Taxi {

    /**
     * Numero de taxi
     */
    private int numTaxi;
    /**
     * Nyumero de placas del taxi
     */
    private String numPlacas;
    /**
     * Sitio del taxi
     */
    private Sitio sitio;

    /**
     * Metodo constructor que establce el atributo de numero de taxi de la clase
     * con el paramtero, y los demas atributos de la clase los inicializ a null
     *
     * @param numTaxi Numero de taxi
     */
    public Taxi(int numTaxi) {
        this.numTaxi = numTaxi;
        this.numPlacas = null;
        this.sitio = null;
    }

    /**
     * Metodo contructor que establece los atributos cn los paramteros que a
     * este se le envian.Y ademas verifica que unicamente se utilicen los
     * enumaradores correspondientes
     *
     * @param numTaxi Numero de taxi
     * @param numPlacas Numero de placas
     * @param sitio Sitio de taxi
     */
    public Taxi(int numTaxi, String numPlacas, Sitio sitio) {
        this.numTaxi = numTaxi;
        this.numPlacas = numPlacas;
        if (sitio == Sitio.CASA_BLANCA || sitio == Sitio.CENTRAL || sitio == Sitio.SORIANA) {
            this.sitio = sitio;
        }

    }

    /**
     * Metodo para obtener para el numero de taxi
     *
     * @return
     */
    public int getNumTaxi() {
        return numTaxi;
    }

    /**
     * Metodo para establecer el numero de taxi
     *
     * @param numTaxi El numero de taxi
     */
    public void setNumTaxi(int numTaxi) {
        this.numTaxi = numTaxi;
    }

    /**
     * Metodo para obtener el numero de placas del taxi
     *
     * @return El numero de placas
     */
    public String getNumPlacas() {
        return numPlacas;
    }

    /**
     * Metodo para establecer el numero de placas del taxi
     *
     * @param numPlacas El numero de placas del taxi
     */
    public void setNumPlacas(String numPlacas) {
        this.numPlacas = numPlacas;
    }

    /**
     * Metodo para obtener el sitio del taxi
     *
     * @return El sitio del taxi
     */
    public Sitio getSitio() {
        return sitio;
    }

    /**
     * Metodo para establecer el sitio del taxi
     *
     * @param sitio El sitio del taxi
     */
    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    /**
     * Metodo hash code de la clase el cual realiza un haschide del numero de
     * taxi
     *
     * @return El hascode del numero del taxi
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.numTaxi;
        return hash;
    }

    /**
     * Metodo equals el cual hace una comparacion con el numero de taxi
     *
     * @param obj Objeto a compara
     * @return Verdareo o falso
     */
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
        final Taxi other = (Taxi) obj;
        if (this.numTaxi != other.numTaxi) {
            return false;
        }
        return true;
    }

    /**
     * Metodo to String para devolver los atributos de la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return numTaxi + ", " + numPlacas + ", " + sitio;
    }
}
