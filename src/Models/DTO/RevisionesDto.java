package Models.DTO;

import java.sql.Date;

/**
 *
 * @author David Duarte Garcia
 */
public class RevisionesDto {
    private Date fecha;
    private String hora;
    private TecnicoDto tecnico;
    private String tipoRevision;
    private String observaciones;
    private String estado;

  

    public RevisionesDto(Date fecha, String hora, Models.DTO.TecnicoDto tecnico, String tipoRevision, String observaciones, String estado) {
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

    public String getHora() {
        return hora;
    }

    public TecnicoDto getTecnico() {
        return tecnico;
    }



    public String getTipoRevision() {
        return tipoRevision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getEstado() {
        return estado;
    }

 

    
    
}
