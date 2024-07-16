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
public class TrianguloEquilatero extends PoligonoRegular {

    public TrianguloEquilatero() {
        this.numLados = 3;
    }

    @Override
    public double getArea() {
        return (getNumAngulos() * getAnchoLados() / 2) * getNumLados();
    }

    public String getToString() {
        return "Datos del triangulo; "+super.getToSring();
    }
}
