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
public class Viaje {

    /**
     * Complemento del tipo taxi
     */
    private Taxi taxi;
    /**
     * Zona de destino de taxi
     */
    private Zona destino;
    /**
     * Kms recorridos de viaje
     */
    private float kms;

    /**
     * Metodo constructor por el cual establecemos los atributos de la clase con
     * sus parametros
     *
     * @param taxi Taxi
     * @param destino Destino del viaje
     * @param kms Kms recorridos del viaje
     */
    public Viaje(Taxi taxi, Zona destino, float kms) {
        this.taxi = taxi;
        if (destino == Zona.CENTRO || destino == Zona.NORTE || destino == Zona.SUR) {
            this.destino = destino;
        }

        this.kms = kms;
    }

    /**
     * Metodo para obtener el taxi
     *
     * @return El taxi del viaje
     */
    public Taxi getTaxi() {
        return taxi;
    }

    /**
     * Metodo para establecer el taxi del viaje
     *
     * @param taxi El taxi del viaje
     */
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    /**
     * Metodo para obtener el destino del viaje
     *
     * @return El destino del viaje
     */
    public Zona getDestino() {
        return destino;
    }

    /**
     * Metodo para establecer el destino del viaje
     *
     * @param destino El destino del viaje
     */
    public void setDestino(Zona destino) {
        this.destino = destino;
    }

    /**
     * Metodo para obtener los kms del viaje
     *
     * @return Los kms del viaje
     */
    public float getKms() {
        return kms;
    }

    /**
     * Metodo para establecer los kms del viaje
     *
     * @param kms Los kms del viaje
     */
    public void setKms(float kms) {
        this.kms = kms;
    }

    /**
     * Metodo para calcular el costo por viaje
     *
     * @return El costo por viaje
     */
    public float calcularCostoViaje() {
        return (float) ((getDestino() == Zona.CENTRO) ? ((kms * 7.60)) : (getDestino() == Zona.SUR) ? ((kms * 8.70)) : (getDestino() == Zona.NORTE) ? ((kms * 9.60)) : 0);
    }

    /**
     * Metodo toString para regresar los atributos de la clase
     *
     * @return Los atributos de la clase
     */
    @Override
    public String toString() {
        return taxi + ", " + kms + ", " + destino;
    }

}
