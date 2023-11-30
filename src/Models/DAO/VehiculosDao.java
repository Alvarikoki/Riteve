package Models.DAO;

import Controller.CRUD;
import Models.DTO.VehiculosDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        bd.createStatement("{call VehiculoInsert(?,?,?,?,?,?)}");
        bd.set(1, obj.getPlaca());
        bd.set(2, obj.getMarca());
        bd.set(3, obj.getModelo());
        bd.set(4, obj.getFechaInscripcion());
        bd.set(5, obj.getId());
        bd.set(6, obj.getNombre());

        return bd.execute(false);
    }

    @Override
    public VehiculosDto read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("Select * from vehiculos where ID=?");
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
                VehiculosDto dto = VehiculosDto(numplaca, marc, mod, fechaIns, idP, name);
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
        return null;
    }

    @Override
    public boolean update(VehiculosDto obj) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    private VehiculosDto VehiculosDto(String numplaca, String marc, String mod, Date fechaIns, String idP, String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
