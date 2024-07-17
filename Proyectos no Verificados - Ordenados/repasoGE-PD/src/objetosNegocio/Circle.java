/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.math.*;
import excepciones.ValueException;

/**
 *
 * @author josej
 */
public class Circle implements IGeometrica {

    private double radio;

    public Circle() {
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new ValueException("El radio es invalido");
        } else {
            this.radio = radio;
        }
    }

    @Override
    public double getArea() {
        if (radio <= 0) {
            throw new ValueException("El radio es invalido");
        } else {
            return ((radio * radio) * Math.PI);
        }
    }

    @Override
    public String getToSring() {
        if (radio <= 0) {
            throw new ValueException("El radio es invalido, no existe informacion detallada ");
        } else {
            return "Datos del circulo; Area=" + getArea() + " Circunferencia=" + getCircunferencia() + " Radio=" + radio;
        }
    }

    public double getCircunferencia() {
        if (radio <= 0) {
            throw new ValueException("El radio es invalido, imposible obtener resultado. ");
        } else {
            return (2 * radio * Math.PI);
        }
    }
}
