/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plantas;

/**
 *
 * @author josej
 */
public class PlantaExplosiva extends Planta{
    
    private TipoExplosion tipoExplosion;

    /**
     * Metodo Constructor para establecer los atributos de la planta explosiva
     * @param ataque Ataque de la planta en¨Puntos 
     * @param costo Costo de la planta en enteros
     * @param vida Vida de la planta 
     * @param tipoExplosion TIpo de explosion de la planta
     */
    protected PlantaExplosiva(int ataque, int costo, int vida, TipoExplosion tipoExplosion) {
        this.ataque=ataque;
        this.costo=costo;
        this.vida=vida;
        this.tipoExplosion=tipoExplosion;
    }
    /**
     * Metodo para obtener el tipo de explosion de la planta
     * @return El tipo de explosion
     */
    public TipoExplosion getTipoExplosion() {
        return tipoExplosion;
    }
    /**
     * Metodo para establecer el tipo deipo de explosion;
     * @param tipoExplosion 
     */
    public void setTipoExplosion(TipoExplosion tipoExplosion) {
        this.tipoExplosion = tipoExplosion;
    }

    @Override
    public void atacar() {
    }


}
