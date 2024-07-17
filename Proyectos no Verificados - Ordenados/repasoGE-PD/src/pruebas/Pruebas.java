/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import excepciones.ValueException;
import java.util.Scanner;
import objetosNegocio.Circle;
import objetosNegocio.Cuadrado;
import objetosNegocio.PoligonoRegular;
import objetosNegocio.TrianguloEquilatero;

/**
 *
 * @author josej
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        Pofe en ciertas pruebas le comente otras pruebas que hice para verificar la funcionalidad del programa,
        si gusta puede utilizar.
        */
        try {
            Circle c1 = new Circle();
            c1.setRadio(4);
            System.out.println("Circulo");
            System.out.println(c1.getCircunferencia());
            System.out.println(c1.getToSring());
            System.out.println("---------------------------------");
            System.out.println("Se estable el radio del circulo a 0");
            c1.setRadio(0);
//            c1.setRadio(0);
//            c1.getArea();
//            System.out.println(c1.getAnchoLados());
//             System.out.println(c1.getToSring());
//            System.out.println("La circunferencia del circulo es; "+c1.getCircunferencia());
        } catch (ValueException e) {
            System.out.println("Error; " + e.getMessage());
        }
        System.out.println("-----------------");
        try {
            TrianguloEquilatero t1 = new TrianguloEquilatero();
            t1.setAnchoLados(4);
            System.out.println("Triangulo");
            System.out.println("Area; " + t1.getArea());
            System.out.println("Perimetro; " + t1.getPerimetro());
            System.out.println(t1.getToSring());
            System.out.println("---------------------------------");
            System.out.println("Se estable el ancho del triangulo a 0");
            t1.setAnchoLados(0);
            //            System.out.println(t1.getAnchoLados());
////              System.out.println(t1.getArea());
//            System.out.println("Perimetro; " + t1.getPerimetro());
//            System.out.println(t1.getToSring());
        } catch (ValueException e) {
            System.out.println("Error; " + e.getMessage());
        }
        System.out.println("--------------------------------------");
        try {
            Cuadrado c1 = new Cuadrado();
            c1.setAnchoLados(4);
            System.out.println("Cuadrado");
            System.out.println("Area; " + c1.getArea());
            System.out.println("Perimetro; " + c1.getPerimetro());
            System.out.println(c1.getToSring());
            System.out.println("---------------------------------");
            System.out.println("Se estable el ancho del Cuadrado a 0");
            c1.setAnchoLados(0);
            //            System.out.println(c1.getAnchoLados());
////              System.out.println(c1.getArea());
//            System.out.println("Perimetro; " + c1.getPerimetro());
//            System.out.println(c1.getToSring());
        } catch (ValueException e) {
            System.out.println("Error; " + e.getMessage());
        }
        System.out.println("-----------------------------");
        try {
            PoligonoRegular hexagono = new PoligonoRegular();
            hexagono.setAnchoLados(4);
            hexagono.setNumLados(6);
            System.out.println("Hexagono");
            System.out.println("Area; " + hexagono.getArea());
            System.out.println("Perimetro; " + hexagono.getPerimetro());
            System.out.println(hexagono.getToSring());
            System.out.println("---------------------------------");
            System.out.println("Se estable el ancho del lado del hexagono a 0");
            hexagono.setAnchoLados(0);
////              System.out.println(hexagono.getArea());
// System.out.println("Ancho de lado;");
//            System.out.println(hexagono.getAnchoLados());
//            System.out.println("Numero de lados");
//            System.out.println(hexagono.getNumLados());
//            System.out.println("Perimetro; " + hexagono.getPerimetro());
//            System.out.println(hexagono.getToSring());
        } catch (ValueException e) {
            System.out.println("Error; " + e.getMessage());
        }

    }
}
