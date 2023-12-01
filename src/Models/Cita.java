package Models;

/**
 *
 * @author maryc
 */
import java.sql.Date;

public class Cita implements StatusControl {

    private int id;
    private Date fecha;
    private String hora;
    private Vehiculo vehiculo;
    private boolean activate;
    private boolean desactivate;

    public Cita(int id, Date fecha, String hora, Vehiculo vehiculo, boolean activate) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        this.activate = activate;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public void activate() {
        this.activate = true;
    }

    @Override
    public void desactivate() {
        this.desactivate = false;
    }
}
