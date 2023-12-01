package Models;

/**
 *
 * @author maryc
 */
import java.sql.Date;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int año;
    private Date fechaInscripcion;
    private String idDueño;
    private String nombreDueño;
    private int edad;

    public Vehiculo(String placa, String marca, String modelo, Date fechaInscripcion, String id, String nombre, int año) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaInscripcion = fechaInscripcion;
        this.idDueño = id;
        this.nombreDueño = nombre;
        this.año = año;
        this.calcEdad();
    }

   

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getId() {
        return idDueño;
    }

    public void setId(String id) {
        this.idDueño = id;
    }

    public String getNombre() {
        return nombreDueño;
    }

    public void setNombre(String nombre) {
        this.nombreDueño = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void calcEdad() {
        this.edad = 2023 - this.año;
    }

}
