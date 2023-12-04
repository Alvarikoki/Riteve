/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author maryc
 */
import Models.DTO.TecnicoDto;
import java.sql.Date;

public class Revision {

    private Date fecha;
    private String hora;
    private TecnicoDto tecnico;
    private String tipoRevision;
    private String observaciones;
    private String estado;

    public Revision(Date fecha, String hora, TecnicoDto tecnico, String tipoRevision, String observaciones, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.tecnico = tecnico;
        this.tipoRevision = tipoRevision;
        this.observaciones = observaciones;
        this.estado = estado;

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

    public TecnicoDto getTecnico() {
        return tecnico;
    }

    public void setTecnico(TecnicoDto tecnico) {
        this.tecnico = tecnico;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
