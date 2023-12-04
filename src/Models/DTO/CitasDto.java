package Models.DTO;

import Models.Vehiculo;
import java.sql.Date;
import java.sql.Time;

public class CitasDto {
    
    private int id;
    private Date fecha;
    private Time hora;
    private String placa;
    private boolean estado;

    public CitasDto(int id, Date fecha, Time hora, String placa, boolean estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.placa = placa;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean getEstado() {
        return estado;
    }
    
}
