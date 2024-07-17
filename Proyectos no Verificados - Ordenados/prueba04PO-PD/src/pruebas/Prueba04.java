package pruebas;

import exepciones.PersistenciaException;
import interfaces.IPersistencia;
import objetosNegocio.Conferencia;
import objetosNegocio.Profesionista;
import objetosServicio.Fecha;
import objetosServicio.Periodo;
import persistencia.PersistenciaListas;

public class Prueba04 {

    public static void main(String[] args) {
        // A
        IPersistencia ob = new PersistenciaListas();
        Profesionista p1 = null;
        Profesionista p2 = null;
        Profesionista p3 = null;
        //B
        try {
            p1 = new Profesionista("Arquitecta de Software", "PR18", "Marina Salinas Cruz", "msalinas@hp.com");
            ob.agregar(p1);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        try {
            p2 = new Profesionista("Gerente de Ventas", "PR20", "Carlos Diaz Rosas", "cdiaz@prodigy.cob.net");
            ob.agregar(p2);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        try {
            p3 = new Profesionista("Arquitecta de Software", "PR30", "Sofia Lara Gómez", "slara@sun.com");
            ob.agregar(p3);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        //C
        try {
            System.out.println(ob.consultarProfesionistas());
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("---------------------------------");
        //      D   
        try {
            System.out.println(ob.consultarProfesionistas("Arquitecta de Software"));
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("-------------------------------");
        //   E
        try {
            ob.agregar(p1);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("-----------------------------------");
        //F
        try {
            Profesionista p = ob.obtener(p2);
            if (p != null) {
                p.setNombre("Juan Diaz Rosas");
                ob.actualizar(p);
            }
            System.out.println(ob.obtener(p2));
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("------------------------------------");

        //G
        try {
            ob.eliminar(p1);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        //h
        try {
            System.out.println(ob.consultarProfesionistas());
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("----------------------------");
//
        Conferencia c1 = null;

        Conferencia c4 = null;
        //I
        try {
            c1 = new Conferencia(p3, "CO01", "Computadoras multiprocesadoras", new Fecha(1, 11, 2021), 9);
            ob.agregar(c1);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        try {
            Conferencia c2 = new Conferencia(p2, "CO02", "Servicios Empresariales de TELMEX", new Fecha(2, 11, 2021), 9);
            ob.agregar(c2);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        try {
            Conferencia c3 = new Conferencia(p3, "CO03", "Nuevas Tecnologias en Servidores de Aplicaciones", new Fecha(2, 11, 2021), 9);
            ob.agregar(c3);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        try {
            c4 = new Conferencia(p2, "CO04", "Computacion en la Nube", new Fecha(1, 11, 2021), 11);
            ob.agregar(c4);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        // J
        System.out.println("-----------------------------");
        try {
            System.out.println(ob.consultarConferencias());
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("----------------------------");
        //K
        try {
            Conferencia c;
            c = ob.obtener(c1);
            if (c1 != null) {
                c.setTitulo("Computo Paralelo");
                ob.actualizar(c);
            }

        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("--------------------------");
        //L
        try {
            ob.eliminar(c4);
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        // M
        try {
            System.out.println(ob.consultarConferencias());
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }
        System.out.println("-------------------------------");
        // O        
        try {
            Periodo p = new Periodo(new Fecha(1, 11, 2021), new Fecha(1, 11, 2021));
            System.out.println(ob.consultarConferencias(p));
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

        System.out.println("-----------------------------");
        //P
        try {
            System.out.println(ob.consultarConferencias(p3));
        } catch (PersistenciaException fe) {
            System.out.println("Error: " + fe.getMessage());
        }

    }

}
