public class ObjCliente {

    private int identificacion;
    private String nombre;
    private String tipoTramite;
    private boolean prioridad;
    private int turno;
    
    public ObjCliente() {
    }

    public ObjCliente(int identificacion, String nombre, String tipoTramite, boolean prioridad, int turno) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipoTramite = tipoTramite;
        this.prioridad = prioridad;
        this.turno = turno;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
}
