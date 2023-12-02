package Models.DTO;

import Models.Vehiculo;
import java.sql.Date;

/**
 *
 * @author David Duarte Garcia
 */
public class VehiculosDto extends Vehiculo{

    private String placa;
    private String marca;
    private String modelo;
    private Date fechaInscripcion;
    private String idDueño;
    private String nombreDueño;
    private int año;

    public VehiculosDto(String placa, String marca, String modelo, Date fechaInscripcion, String idDueño, String nombreDueño, int año) {
        super(placa, marca, modelo, fechaInscripcion, idDueño, nombreDueño, año);
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaInscripcion = fechaInscripcion;
        this.idDueño = idDueño;
        this.nombreDueño = nombreDueño;
        this.año = año;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getId() {
        return idDueño;
    }

    public String getNombre() {
        return nombreDueño;
    }

    public String getIdDueño() {
        return idDueño;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public int getAño() {
        return año;
    }
}
