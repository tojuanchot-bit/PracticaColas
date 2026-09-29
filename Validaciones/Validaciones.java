package Validaciones;
import java.util.Scanner;

public class Validaciones {
        public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Por favor Ingrese un digito numerico: ");
            sc.next();
        }
        return sc.nextInt();
    }


}
