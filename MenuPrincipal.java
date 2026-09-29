import java.util.Scanner;

import Validaciones.Validaciones;

public class MenuPrincipal {
    public static void main(String[] args) {

        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        MetodosPrincipal m = new MetodosPrincipal();
        Validaciones v = new Validaciones();
        
        System.out.println("Recopilatorio de ejercicios de colas");
        System.out.println("--------------------------------------");

        while (continuar) {
           int opt = m.MenuPrincipal(sc, v);
           switch (opt) {
            case 1:
                
                break;

            case 2:

                 break;
                
            case 3:
                System.out.println("Saliendo...");
                continuar = false;
                break;
            default:
                System.out.println("Ingrese una opción valida (1 / 2 / 3)");
                break;
           }
        }
    }
}
