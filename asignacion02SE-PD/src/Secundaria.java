
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Secundaria {
    /**
     * Metodo en el cual nos mostrara las opciones de nuestro menu
     */
    public void mimenu() {

        Scanner teclado = new Scanner(System.in);

        boolean continuar = true;
        int numeroOficial = 0;

        System.out.println("--------------------------------------------------");
        System.out.println("Bienvenidos al modificar de fechas ");
        System.out.println("Selecciones la opcion a realizar; ");
        System.out.println("1. Sumar a algo de la fecha actual ");
        System.out.println("2. Restar a algo de le fecha Actual");
        System.out.println("3. Salir");
        System.out.println("--------------------------------------------------");

        do {
            System.out.println("Escriba su opcion");
            int numeroPrueba = teclado.nextInt();
            if (numeroPrueba >= 1 && numeroPrueba <= 3) {
                numeroOficial = numeroPrueba;
                break;
            } else {
                System.out.println("HA ingresado una opcion invalida, verifica su respuesta antes de aceptar");
            }
        } while (continuar = true);

        switch (numeroOficial) {
            case 1:
                sumando();
                break;
            case 2:
                restando();
                break;
            case 3:
                 System.out.println("Gracias por usar el programa");
                break;
            default:
                System.out.println("--------------------------------------------------");
               
        }

    }
    /** 
     * Metodo en el cual suma a determindado valor 
     */
    public void sumando() {
        Calendar gc = new GregorianCalendar();
        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;
        char fin = 0;
        int numeroOficial = 0, numero;
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("Que quierres hacer; ");
            System.out.println("1. Sumar al dia actual");
            System.out.println("2. Sumar a año actual");
            System.out.println("3. Sumar a los meses actuales");
            System.out.println("--------------------------------------------------");
            do {
                System.out.println("Escriba su opcion");
                int numeroPrueba = teclado.nextInt();
                if (numeroPrueba >= 1 && numeroPrueba <= 2) {
                    numeroOficial = numeroPrueba;
                    break;
                } else {
                    System.out.println("Ha ingresado una opcion invalida, verifica su respuesta antes de aceptar");
                }
            } while (continuar = true);

            switch (numeroOficial) {
                case 1:
                    System.out.println("Hoy es; "+(gc.get(Calendar.DAY_OF_MONTH)));
                    System.out.println("Escriba un numero; ");
                    numero = teclado.nextInt();
                    gc.add(Calendar.DAY_OF_MONTH, numero);
                    System.out.println("El dia de hoy mas " + numero + " dias mas seria el dia: " + gc.get(Calendar.DATE));
                    break;
                case 2:
                    System.out.println("El años es; "+gc.get(Calendar.YEAR));
                    System.out.println("Escriba un numero; ");
                    numero = teclado.nextInt();
                    gc.add(Calendar.YEAR, numero);
                    System.out.println("El año de hoy mas " + numero + " años seria el año: " + gc.get(Calendar.YEAR));
                    break;
                case 3:
                    System.out.println("El numero del mees; "+gc.get(Calendar.MONTH+1));
                    System.out.println("Escriba un numero; ");
                    numero = teclado.nextInt();
                    gc.add(Calendar.MONTH, numero);
                    System.out.println("El mes actual mas " + numero + " meses mas seria el mes: " + gc.get(Calendar.MONTH+1));
                    break;
                default:
                    break;
            }
            do {
                System.out.println("Desea continuar, escriba si o no");
                char finPrueba = teclado.next().charAt(0);
                if (finPrueba == 'S' || finPrueba == 's' || finPrueba == 'N' || finPrueba == 'n') {
                    fin = finPrueba;
                    break;
                } else {
                    System.out.println("Escriba una opcion valida");
                }
            } while (continuar = true);
            if (fin == 'S' || fin == 's') {
                System.out.println("--------------------------------------------------");
            } else {
                break;
            }

        } while (continuar = true);

    }

    public void restando() {
        Calendar gc = new GregorianCalendar();
        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;
        char fin = 0;
        int numeroOficial = 0, numero;
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("Que quierres hacer; ");
            System.out.println("1. Restar al dia actual");
            System.out.println("2. Restar a año actual");
            System.out.println("3. Restar a los meses actuales");
            System.out.println("--------------------------------------------------");
            do {
                System.out.println("Escriba su opcion");
                int numeroPrueba = teclado.nextInt();
                if (numeroPrueba >= 1 && numeroPrueba <= 2) {
                    numeroOficial = numeroPrueba;
                    break;
                } else {
                    System.out.println("Ha ingresado una opcion invalida, verifica su respuesta antes de aceptar");
                }
            } while (continuar = true);

            switch (numeroOficial) {
                case 1:
                    System.out.println("Hoy es; "+gc.get(Calendar.DAY_OF_MONTH));
                    System.out.println("Escriba un numero; ");
                    numero = teclado.nextInt();
                    gc.add(Calendar.DAY_OF_MONTH, numero);
                    System.out.println("El dia de hoy menos " + numero + " dias seria el dia: " + gc.get(Calendar.DATE));
                    break;
                case 2:
                    System.out.println("El años es; "+gc.get(Calendar.YEAR));
                    System.out.println("Escriba un numero; ");
                    numero = teclado.nextInt();
                    gc.add(Calendar.YEAR, numero);
                    System.out.println("El año de hoy menos " + numero + " años seria el año: " + gc.get(Calendar.YEAR));
                    break;
                case 3:
                    System.out.println("El numero del mees; "+gc.get(Calendar.MONTH+1));
                    System.out.println("Escriba un numero; ");
                    numero = teclado.nextInt();
                    gc.add(Calendar.MONTH, numero);
                    System.out.println("El mes actual menos " + numero + " meses seria el mes: " + gc.get(Calendar.MONTH+1));
                    break;
                default:
                    break;
            }
            do {
                System.out.println("Desea continuar, escriba si o no");
                char finPrueba = teclado.next().charAt(0);
                if (finPrueba == 'S' || finPrueba == 's' || finPrueba == 'N' || finPrueba == 'n') {
                    fin = finPrueba;
                    break;
                } else {
                    System.out.println("Escriba una opcion valida");
                }
            } while (continuar = true);
            if (fin == 'S' || fin == 's') {
                System.out.println("--------------------------------------------------");
            } else {
                break;
            }

        } while (continuar = true);

        
    }
}
