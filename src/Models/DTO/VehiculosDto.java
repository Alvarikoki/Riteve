package Models.DTO;

import java.sql.Date;

/**
 *
 * @author David Duarte Garcia
 */
public class VehiculosDto {

    private String placa;
    private String marca;
    private String modelo;
    private Date fechaInscripcion;
    private String idDueño;
    private String nombreDueño;
    private int año;

    public VehiculosDto(String placa, String marca, String modelo, Date fechaInscripcion, String id, String nombre, int año) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaInscripcion = fechaInscripcion;
        this.idDueño = id;
        this.nombreDueño = nombre;
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
