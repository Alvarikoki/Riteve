package Controller;

import Models.DAO.VehiculosDao;
import Models.DTO.VehiculosDto;
import Models.Vehiculo;

import java.util.ArrayList;

/**
 *
 * @author David Duarte Garcia
 */
public class VehiculosController implements CRUD<Vehiculo>{
    private VehiculosDao dao;
    
    
    @Override
    public boolean add(Vehiculo obj) {
          if (dao.read(obj.getId())==null){
            VehiculosDto dto = new VehiculosDto(obj.getPlaca(),obj.getMarca(),obj.getModelo(),obj.getFechaInscripcion(),obj.getId(),obj.getNombre(),obj.getAño());
            dao.add(dto);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Vehiculo read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Vehiculo> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Vehiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
