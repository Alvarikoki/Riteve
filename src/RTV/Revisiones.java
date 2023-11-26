package RTV;

/**
 *
 * @author David Duarte Garcia
 */
public class Revisiones {
    private String fecha;
    private String hora;
    private boolean estado;

    public Revisiones(String fecha, String hora, boolean estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
