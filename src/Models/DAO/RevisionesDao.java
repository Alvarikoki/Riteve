
package Models.DAO;

import Controller.CRUD;
import Models.DTO.RevisionesDto;
import Models.DTO.TecnicoDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David Duarte Garcia
 */
public class RevisionesDao implements CRUD<RevisionesDto> {

    @Override
    public boolean add(RevisionesDto obj) {
        if (obj == null) {
            return false;
        }

        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL insertRevisiones(?,?,?,?,?,?)}");
        bd.set(1, obj.getFecha());
        bd.set(1, obj.getHora());
        bd.set(1, obj.getTecnico());
        bd.set(1, obj.getTipoRevision());
        bd.set(1, obj.getObservaciones());
        bd.set(1, obj.getEstado());
        return bd.execute(false);

    }

    @Override
    public RevisionesDto read(String id) {

        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectRevisiones(?)}");
        bd.set(1, id);
        bd.execute(true);
        try {
            if (bd.getData().next()) {
                Date fecha = bd.getData().getDate(1);
                String hora = bd.getData().getString(2);
                TecnicoDto tecnico=(TecnicoDto) bd.getData().getObject(3);
                String tipoRevision = bd.getData().getString(4);
                String observaciones = bd.getData().getString(5);
                String estado = bd.getData().getString(6);
                return new RevisionesDto((java.sql.Date) fecha,hora,tecnico, tipoRevision, observaciones,estado);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
        
    }

    @Override
    public ArrayList<RevisionesDto> readAll() {

        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectAllRevisiones()}");
        bd.execute(true);
        ArrayList<RevisionesDto> array = new ArrayList();
        try {
            while (bd.getData().next()) {
                Date fecha = bd.getData().getDate(1);
                String hora = bd.getData().getString(2);
                TecnicoDto tecnico=(TecnicoDto) bd.getData().getObject(3);
                String tipoRevision = bd.getData().getString(4);
                String observaciones = bd.getData().getString(5);
                String estado = bd.getData().getString(6);
                RevisionesDto dto = new RevisionesDto((java.sql.Date) fecha, hora, tecnico, tipoRevision, observaciones, estado);
                array.add(dto);
            }
            return array;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean update(RevisionesDto obj) {
        if (this.read(obj.getTipoRevision()) != null) {
            DaoBD bd = new DaoBD();
            bd.createStatement("{CALL UpdateRevisiones(?,?,?,?,?,?)}");
            bd.set(1, obj.getFecha());
            bd.set(2, obj.getHora());
            bd.set(3, obj.getTecnico());
            bd.set(4, obj.getTipoRevision());
            bd.set(5, obj.getObservaciones());
            bd.set(6, obj.getEstado());
            bd.execute(false);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        if (this.read(id) != null) {
            DaoBD bd = new DaoBD();
            bd.createStatement("{CALL DeleteRevisiones(?)}");
            bd.set(1, bd);
            bd.execute(false);
            return true;
        } else {
            return false;
        }
    }

}

