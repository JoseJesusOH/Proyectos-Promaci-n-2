package Fruteria;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Fruteria {

    public static void main(String[] args) {

        Fruta fruta = new Fruta();

        Set<Fruta> frutas = new HashSet<>();

        Fruta f1 = new Fruta("Manzana", "Roja", 6, "0301");
        Fruta f2 = new Fruta("Pera", "Verde", 4, "0721");
        Fruta f3 = new Fruta("Naranja", "Naranja", 7, "0274");
        Fruta f4 = new Fruta("Manzana", "Verde", 7, "4792");
        Fruta f5 = new Fruta("Platano", "Amarillo", 5, "1253");
        Fruta f6 = new Fruta("Manzana", "Verde", 7, "8314");
        Fruta f7 = new Fruta("Pera", "Amarilla", 6, "6372");
        Fruta f8 = new Fruta("Manzana", "Verde", 7, "0022");
        Fruta f9 = new Fruta("Naranja", "Naranja", 7, "7481");
        Fruta f10 = new Fruta("Manzana", "Roja", 6, "6936");

        frutas.add(f1);
        frutas.add(f2);
        frutas.add(f3);
        frutas.add(f4);
        frutas.add(f5);
        frutas.add(f6);
        frutas.add(f7);
        frutas.add(f8);
        frutas.add(f9);
        frutas.add(f10);

        //Se imprime la colección
        Iterator<Fruta> it1 = frutas.iterator();

        while (it1.hasNext()) {
            fruta = it1.next();
            System.out.println(fruta);

        }

        //Se eliminan las manzanas verdes.
        Iterator<Fruta> it2 = frutas.iterator();

        while (it2.hasNext()) {           
        fruta = it2.next();
            
            if (fruta.getNombre().equals("Manzana") && fruta.getColor().equals("Verde")) {
                it2.remove();
            }

        }

        System.out.println("");

        //Se imprime la colección
        Iterator<Fruta> it3 = frutas.iterator();

        while (it3.hasNext()) {
            System.out.println(it3.next().toString());

        }

    
    }

}
