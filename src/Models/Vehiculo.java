/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private Date fechaInscripcion;
    private String id;
    private String nombre;
    private int antiguedad;

    public Vehiculo(String placa, String marca, String modelo, Date fechaInscripcion, String id, String nombre, int antiguedad) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaInscripcion = fechaInscripcion;
        this.id = id;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
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
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    
}
