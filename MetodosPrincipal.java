import java.util.Scanner;

import Validaciones.Validaciones;

public class MetodosPrincipal {

    public int MenuPrincipal (Scanner sc, Validaciones v){
        System.out.println("Listado de ejercicios.");
        System.out.println("1. Banco, Ateción preferencial.");
        System.out.println("2. Atencion de clientes. ");
        System.out.println("3. Salir.");
        System.out.print("Ingrese una opción: ");
        int opt = v.ValidarEntero(sc);
        return opt; 
    }
    
    

}
