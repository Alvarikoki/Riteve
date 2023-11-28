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

public class Revision implements Estado {

    private Date fecha;
    private String hora;
    private Tecnico tecnico;
    private String tipoRevision;
    private String observaciones;
    private boolean estado;
    private boolean aprobado;
    private boolean desaprobado;

    public Revision(Date fecha, String hora, Tecnico tecnico, String tipoRevision, String observaciones, boolean estado, boolean aprobado, boolean desaprobado) {
        this.fecha = fecha;
        this.hora = hora;
        this.tecnico = tecnico;
        this.tipoRevision = tipoRevision;
        this.observaciones = observaciones;
        this.estado = estado;
        this.aprobado = aprobado;
        this.desaprobado = desaprobado;
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

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public boolean isDesaprobado() {
        return desaprobado;
    }

    public void setDesaprobado(boolean desaprobado) {
        this.desaprobado = desaprobado;
    }


    @Override
    public void aprobado() {
        this.aprobado = true;
    }

    @Override
    public void desaprobado() {
        this.desaprobado = false;
    }
}
