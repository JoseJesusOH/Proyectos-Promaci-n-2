/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;
import excepciones.ValueException;
/**
 *
 * @author josej
 */
public class Cuadrado extends PoligonoRegular {

    public Cuadrado() {
        this.numLados = 4;
    }

    @Override
    public double getArea() {
        
        return getAnchoLados() * getAnchoLados();
    }

    public String getToString() {
        return "Datos del cuadro; "+super.getToSring();
    }

}
