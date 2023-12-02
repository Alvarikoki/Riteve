package Models.DAO;

import Controller.CRUD;
import Models.DTO.VehiculosDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author David Duarte Garcia
 */
public class VehiculosDao implements CRUD<VehiculosDto> {

    @Override
    public boolean add(VehiculosDto obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL InsertVehiculo(?,?,?,?,?,?,?)}");
        bd.set(1, obj.getPlaca());
        bd.set(2, obj.getMarca());
        bd.set(3, obj.getModelo());
        bd.set(4, obj.getFechaInscripcion());
        bd.set(5, obj.getIdDueño());
        bd.set(6, obj.getNombreDueño());
        bd.set(7, obj.getAño());
        return bd.execute(false);
    }

    @Override
    public VehiculosDto read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectVehiculo(?)}");
        bd.set(1, id);
        bd.execute(true);
        try {
            if (bd.getData().next()) {
                String numplaca = bd.getData().getString(1);
                String marc = bd.getData().getString(2);
                String mod = bd.getData().getString(3);
                Date fechaIns = bd.getData().getDate(4);
                String idP = bd.getData().getString(5);
                String name = bd.getData().getString(6);
                int año = bd.getData().getInt(7);
                VehiculosDto dto = new VehiculosDto(numplaca, marc, mod, fechaIns, idP, name, año);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<VehiculosDto> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL TecnicosSelect()}");
        bd.execute(true);
        ArrayList<VehiculosDto> array = new ArrayList();
        try {
            while (bd.getData().next()){
                String numplaca = bd.getData().getString(1);
                String marc = bd.getData().getString(2);
                String mod = bd.getData().getString(3);
                Date fechaIns = bd.getData().getDate(4);
                String idP = bd.getData().getString(5);
                String name = bd.getData().getString(6);
                int año = bd.getData().getInt(7);
                VehiculosDto dto = new VehiculosDto(numplaca, marc, mod, fechaIns, idP, name, año);
                array.add(dto);
            }
            return array;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean update(VehiculosDto obj) {
        if (this.read(obj.getIdDueño()) != null) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL UpdateTecnico(?,?,?)}");
        bd.set(1, obj.getPlaca());
        bd.set(2, obj.getNombreDueño());
        bd.set(3, obj.getNombreDueño());
        bd.execute(false);
        return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
             if(this.read(id)!=null){
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL DeleteVehiculo(?)}");
        bd.set(1, id);
        bd.execute(false);
        return true;
        }else{
            return false;
        }
    }
}
