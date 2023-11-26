package RTV;

/**
 *
 * @author David Duarte Garcia
 */
public class Citas {
   private int id; 
   private String fecha;
   private String hora;

    public Citas(int id, String fecha, String hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }
   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
   
   
}
