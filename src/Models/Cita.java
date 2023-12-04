package Models;

/**
 *
 * @author maryc
 */
import java.sql.Date;
import java.sql.Time;

public class Cita {

    private int id;
    private Date fecha;
    private Time hora;
    private String placa;
    private boolean estado;

    public Cita(int id, Date fecha, Time hora, String placa) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.placa = placa;
        this.estado = true;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
