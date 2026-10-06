import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    private int contadorTurnos = 0;

    public int opcionesMenu1(Scanner sc, Validaciones v) {
        System.out.println("Listado de opciones: ");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Mostrar todos los turnos. ");
        System.out.println("3. Mostrar pendientes.");
        System.out.println("4. Mostrar atendidos.");
        System.out.println("5. Atender siguiente.");
        System.out.println("6. Buscar cliente.");
        System.out.println("7. Cambiar prioridad.");
        System.out.println("8. Cancelar turno.");
        System.out.println("9. Mostrar cancelados.");
        System.out.println("10. Mostrar cuantos turnos pendientes hay.");
        System.out.println("11. Mostrar cuantos turnos prioritarios pendientes hay.");
        System.out.println("12. Mostrar cuantos turnos no prioritarios pendiente hay.");
        System.out.println("0. Salir.");
        System.out.print("Ingrese una opción: ");
        int opt = v.ValidarEntero(sc);
        System.out.println("--------------------------------------");
        return opt;
    }

    public Queue<ObjCliente> registrarUsuario(Queue<ObjCliente> agendamiento, ObjCliente o, Validaciones v,
            Scanner sc) {

        System.out.println("Bienvenido a BancaRota");
        System.out.println("Ingrese su numero de identificación: ");
        o.setIdentificacion(v.ValidarEntero(sc));
        System.out.println("Ingrese nombre: ");
        sc.nextLine();
        o.setNombre(sc.nextLine());
        System.out.println("Ingrese su edad: ");
        o.setEdad(v.ValidarEntero(sc));
        sc.nextLine();
        System.out.println("Ingrese tipo de tramite: ");
        o.setTipoTramite(asignarTipoTramite(v, sc));
        System.out.println("¿Prioritario? (1. Sí / 2. No)");
        o.setPrioridad(asignarPrioridad(v, sc));
        sc.nextLine();
        o.setTurno(asignarTurno());


        agendamiento.offer(o);

        return agendamiento;
    }

    public Boolean asignarPrioridad(Validaciones v, Scanner sc) {
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

    public String asignarTipoTramite(Validaciones v, Scanner sc) {
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

    public void mostrarTodosLosTurnos(Queue<ObjCliente> agendamiento) {
        for (ObjCliente objCliente : agendamiento) {
            if (objCliente.isPrioridad()) {
                System.out.println("Turno prioritario.");
            } else {
                System.out.println("Turno no prioritario. ");
            }
            mostrarCliente(objCliente);

        }
    }


    public void mostrarSegunPendiente(Queue<ObjCliente> agendamiento, int estado) {
        if (agendamiento.isEmpty()) {
            System.out.println("No hay turnos agendados.");
        } else {
        
            for (ObjCliente objCliente : agendamiento) {

                if (agendamiento.isEmpty()) {
                    System.out.println("No hay agendamientos hasta el momento.");
                    return;
                }

                if(objCliente.isPrioridad() && objCliente.getEstado() == estado){
                System.out.println("PRIORITARIO:");
                mostrarCliente(objCliente);
                }

                if(!objCliente.isPrioridad() && objCliente.getEstado() == estado){
                System.out.println("NO PRIORITARIO.");
                mostrarCliente(objCliente);
                }
            }
        }    
    }
     

    public Queue<ObjCliente> atenderTurnoSiguiente(Queue<ObjCliente> agendamiento, Validaciones v, Scanner sc) {

        if (agendamiento.isEmpty()) {
            System.out.println("No hay turnos agendados.");
            return agendamiento;
        } else {

            for (ObjCliente objCliente : agendamiento) {

                if (objCliente.isPrioridad() && objCliente.getEstado() == 1) {
                    System.out.println("Atendiendo TURNO PRIORITARIO");
                    mostrarCliente(objCliente);
                    System.out.println(marcarComoAtendido(sc, objCliente, v));
                    return agendamiento;
                }
            }

        }

        for (ObjCliente objCliente : agendamiento) {
            if (!objCliente.isPrioridad() && objCliente.getEstado() == 1) {
                System.out.println("atendiendo turno NO PRIORITARIO.");
                mostrarCliente(objCliente);
                System.out.println(marcarComoAtendido(sc, objCliente, v));
                return agendamiento;
            }

        }
        return agendamiento;
     }

    public void mostrarCliente (ObjCliente o){
        System.out.println("Turno: " + o.getTurno());
        System.out.println("Nombre: " + o.getNombre());
        System.out.println("Identificación: " + o.getIdentificacion());
        System.out.println("Edad: " + o.getEdad());
        System.out.println("Servicio: " + o.getTipoTramite());
        System.out.println("--------------------------------------");
    }

    public String marcarComoAtendido(Scanner sc, ObjCliente o, Validaciones v){
        boolean asignado = false;
        String mensaje = "";
        while (!asignado) {
            System.out.println("¿Marcar como atendido? (1.Sí / 2.No)");
            int opt = v.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    o.setEstado(2);
                    mensaje = "Se marcó como atendido.";
                    asignado = true;
                    break;
                
                case 2:
                    mensaje = "Se retorna a lista de pendientes.";
                    asignado = true;
                break;

                default:
                    System.out.println("Ingrese una opción válida (1 / 2)");
                break;
            }
        }
        return mensaje;
    }

    public ObjCliente buscarCliente (Scanner sc, Queue<ObjCliente> agendamiento, Validaciones v){
        ObjCliente obj = null;

        System.out.println("Ingrese la identificación del cliente a buscar: ");
        int id = v.ValidarEntero(sc);
        for (ObjCliente o : agendamiento) {
            if (o.getIdentificacion() == id) {
                obj = o;
                break;
            }

        }

        if (obj != null) {
            System.out.println("Cliente encontrado.");
            mostrarCliente(obj);
        } else {
            System.out.println("Cliente no encontrado");
        }
        return obj;
    }

    public Queue<ObjCliente> cambiarPrioridad(Scanner sc, Queue <ObjCliente> agendamiento, Validaciones v){
        ObjCliente o = buscarCliente(sc, agendamiento, v);
        if (o != null) {
            o.setPrioridad(true);
            System.out.println("Prioridad actualizada.");            
        } else {
            System.out.println("No se pudo modificar la prioridad.");
        }
        return agendamiento;
    }

    public Queue<ObjCliente> cancelarClientes(Scanner sc, Queue <ObjCliente> agendamiento, Validaciones v){

        ObjCliente o = buscarCliente(sc, agendamiento, v);
        
        if (o != null) {
            if (o.getEstado() == 1) {
                System.out.println("Turno cancelado.");
                o.setEstado(3);
            } else if (o.getEstado() == 2) {
                System.out.println("No se puede cancelar, el turno ya ha sido atendido.");
            } else if (o.getEstado() == 3) {
                System.out.println("No se puede cancelar, el turno ya fue cancelado.");
            }
        }
        return agendamiento;
    }

    public int contarTodosLosPendientes(Queue<ObjCliente> agendamiento){
        int contador = 0;
        for (ObjCliente o : agendamiento) {
            if (o.getEstado() == 1){
                contador++;
            }
        }
        return contador;
    }

    public int contarTodosLosPendientesPrioritarios(Queue<ObjCliente> agendamiento){
        int contador = 0;
        for (ObjCliente o : agendamiento) {
            if (o.getEstado() == 1 && o.isPrioridad()){
                contador++;
            }
        }
        return contador;
    }

    public int contarTodosLosPendientesNoPrioritarios(Queue<ObjCliente> agendamiento){
        int contador = 0;
        for (ObjCliente o : agendamiento) {
            if (o.getEstado() == 1 && !o.isPrioridad()){
                contador++;
            }
        }
        return contador;
    }
}