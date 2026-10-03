import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        Validaciones v = new Validaciones();
        Queue<ObjCliente> agendamiento = new LinkedList<>();

        System.out.println("Ejercicio 1 'Banco, Atención preferencial'");
        System.out.println("--------------------------------------");

        while (continuar) {
            int opt = m.opcionesMenu1(sc, v);

            switch (opt) {
                case 1:
                    agendamiento = m.registrarUsuario(agendamiento, new ObjCliente(), v, sc);
                    break;

                case 2:
                    m.mostrarTurnosPendientes(agendamiento);
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
