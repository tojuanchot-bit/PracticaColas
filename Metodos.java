import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    private int contadorTurnos = 0;

    public int opcionesMenu1 (Scanner sc, Validaciones v){
        System.out.println("Listado de opciones: ");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Mostrar todos los turnos pendientes. ");
        System.out.println("3. Salir.");
        System.out.print("Ingrese una opción: ");
        int opt = v.ValidarEntero(sc);
        return opt;
    }

    public Queue<ObjCliente> registrarUsuario (Queue<ObjCliente> agendamiento, ObjCliente o, Validaciones v, Scanner sc){

        System.out.println("Bienvenido a BancaRota");
        System.out.println("Ingrese su numero de identificación: ");
        o.setIdentificacion(v.ValidarEntero(sc));
        System.out.println("Ingrese nombre: ");
        sc.nextLine();
        o.setNombre(sc.nextLine());
        System.out.println("Ingrese tipo de tramite: ");
        o.setTipoTramite(asignarTipoTramite(v, sc));
        System.out.println("¿Prioritario? (1. Sí / 2. No)");
        o.setPrioridad(asignarPrioridad(v, sc));
        sc.nextLine();
        o.setTurno(asignarTurno());

        agendamiento.offer(o);

        return agendamiento;
    }

    public Boolean asignarPrioridad (Validaciones v, Scanner sc){
         boolean prioridad = false, valido = false;

         while (!valido) {
            int opt = v.ValidarEntero(sc);
            if (opt == 1) {
                prioridad = true;
                valido = true;
            } else {
                if (opt == 2) {
                    prioridad = false;
                    valido = true;
                } else {
                    System.out.println("Ingrese una opción válida ( 1.Sí / 2.No)");
                }
            }
        }
        return prioridad;
    }

    public String asignarTipoTramite (Validaciones v, Scanner sc){
        String tipoTramite = "";

        while (tipoTramite.equals("")) {
            System.out.println("1. Obtención de servicios.");
            System.out.println("2. Certificados y documentos.");
            System.out.println("3. Caja.");
            System.out.print("Ingrese una opción: ");
            int opt = v.ValidarEntero(sc);

            switch (opt) {
                case 1:
                    tipoTramite = "Obtención de servicios";
                    break;

                case 2:
                    tipoTramite = "Certificados y documentos";
                    break;

                case 3:
                    tipoTramite = "Caja";
                    break;

                default:
                    System.out.println("Ingrese una opción valida (1 / 2 / 3)");
                    break;
            }
        }

        return tipoTramite;
    }

    public int asignarTurno() {
        contadorTurnos++;
        return contadorTurnos;
    }

    public String mostrarTurnosPendientes(Queue<ObjCliente> agendamiento){
        for (ObjCliente objCliente : agendamiento) {
            System.out.println("Turno: " + objCliente.getTurno());
            System.out.println("Nombre: " + objCliente.getNombre());
            System.out.println("Identificación: " + objCliente.getIdentificacion());
            if (objCliente.isPrioridad()) {
                System.out.println("Turno prioritario.");
            } else {
                System.out.println("Turno no prioritario. ");
            }
            System.out.println("Servicio: " + objCliente.getTipoTramite());
        }
        return "Turnos mostrados";
    }

}
