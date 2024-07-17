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
public class PoligonoRegular implements IPoligono {

    protected int numLados;

    protected int anchoLados;

    public PoligonoRegular() {
    }

    public int getNumLados() {
        if (numLados == 0) {
            throw new ValueException("No se han establecido los lados de la figura");
        } else {
            return numLados;
        }
    }

    public void setNumLados(int numLados) {
        if (numLados <= 0) {
            throw new ValueException("Lados negativos verifique porfavor;");
        } else {
            this.numLados = numLados;
        }
    }

    public int getAnchoLados() {
        if (anchoLados == 0) {
            throw new ValueException("No se ha establecido un ancho");
        } else {
            return anchoLados;
        }
    }

    public void setAnchoLados(int anchoLados) {
        if (anchoLados <= 0) {
            throw new ValueException("Ancho de lado es negativo");
        } else {
            this.anchoLados = anchoLados;
        }
    }

    @Override
    public double getPerimetro() {
        if (anchoLados <= 0) {
            throw new ValueException("Ancho de lado es invalido, imposible obtner perimetro");
        } else if (numLados <= 0) {
            throw new ValueException("Lados negativos invalido porfavor, imposible obtner perimetro");
        } else {
            return numLados * anchoLados;
        }
    }

    @Override
    public double getNumAngulos() {
        if (anchoLados <= 0) {
            throw new ValueException("Ancho de lado es negativo");
        } else if (numLados <= 0) {
            throw new ValueException("Lados negativos verifique porfavor;");
        } else {
            return (anchoLados / 2) / Math.tan(Math.toRadians((360 / numLados) / 2));
        }
    }

    @Override
    public double getArea() {
        if (anchoLados <= 0) {
            throw new ValueException("Ancho de lado invalido, imposible obtener area");
        } else if (numLados <= 0) {
            throw new ValueException("Lados invalidos, imposible obtener area");
        } else {
            return ((((anchoLados / 2) / Math.tan(Math.toRadians((360 / numLados) / 2))) * anchoLados) / 2) * numLados;
        }
    }

    @Override
    public String getToSring() {
        if (anchoLados <= 0) {
            throw new ValueException("Ancho de lado invalido, imposible mostrar informacion");
        } else if (numLados <= 0) {
            throw new ValueException("Lados invalidos, imposible mostrar informacion;");
        } else {
            return "Area=" + getArea() + " Perimetro=" + getPerimetro() + " Lados=" + getNumLados() + " Ancho(Lado)=" + getAnchoLados();
        }
    }

}
