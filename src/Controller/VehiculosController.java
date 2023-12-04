package Controller;

import Models.DAO.VehiculosDao;
import Models.DTO.VehiculosDto;
import Models.Vehiculo;
import Views.FrmVehiculos;
import java.util.ArrayList;

/**
 *
 * @author David Duarte Garcia
 */
public class VehiculosController implements CRUD<Vehiculo> {

    private VehiculosDao dao;

    @Override

    public boolean add(Vehiculo obj) {
        if (dao.read(obj.getIdDueño()) == null) {
            VehiculosDto dto = new VehiculosDto(obj.getPlaca(), obj.getMarca(), obj.getModelo(), obj.getFechaInscripcion(), obj.getIdDueño(), obj.getNombreDueño(), obj.getAño());
            dao.add(dto);
            return true;
        } else {
            return false;
        }
    }

    public VehiculosController() {
        dao = new VehiculosDao();
    }

    @Override
    public Vehiculo read(String id) {
        if (dao.read(id) != null) {
            VehiculosDto dto = dao.read(id);
            Vehiculo vh = new Vehiculo(dto.getPlaca(), dto.getMarca(), dto.getModelo(), dto.getFechaInscripcion(), dto.getIdDueño(), dto.getNombreDueño(), dto.getAño());
            return vh;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Vehiculo> readAll() {
        ArrayList<VehiculosDto> arrayDto = dao.readAll();
        ArrayList<Vehiculo> array = new ArrayList();
        if (arrayDto != null) {
            for (VehiculosDto dto : arrayDto) {
                Vehiculo vh = new Vehiculo(dto.getPlaca(), dto.getMarca(), dto.getModelo(), dto.getFechaInscripcion(), dto.getIdDueño(), dto.getNombreDueño(), dto.getAño());
                array.add(vh);
            }
            return array;
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Vehiculo obj) {
        if (dao.read(obj.getIdDueño()) != null) {
             VehiculosDto vh = new VehiculosDto(obj.getPlaca(), obj.getMarca(), obj.getModelo(), obj.getFechaInscripcion(), obj.getIdDueño(), obj.getNombreDueño(), obj.getAño());
            dao.update(vh);   
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
            dao.delete(id);
            return true;            
    }
    
}
