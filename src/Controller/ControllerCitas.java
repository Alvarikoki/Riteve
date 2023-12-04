package Controller;

import Models.Cita;
import Models.DAO.CitasDao;
import Models.DTO.CitasDto;
import Views.FrmCitas;
import java.util.ArrayList;

public class ControllerCitas implements CRUD<Cita> {

    private CitasDao dao;
    private FrmCitas frm;

    public ControllerCitas(FrmCitas frm) {
        this.dao = new CitasDao();
        this.frm = frm;
    }
    
    
    
    @Override
    public boolean add(Cita obj) {
        if (dao.read(String.valueOf(obj.getId()))==null){
            CitasDto dto = new CitasDto(obj.getId(),obj.getFecha(),obj.getHora(),obj.getPlaca(),obj.getEstado());
            dao.add(dto);
            frm.msj("Se agregó la cita", 1);
            return true;
        }else{
            frm.msj("Cita ya existente", 2);
            return false;
        }
    }

    @Override
    public Cita read(String id) {
        if(dao.read(id)!=null){
            CitasDto dto = dao.read(id);
            Cita cita = new Cita(dto.getId(),dto.getFecha(),dto.getHora(),dto.getPlaca(),dto.getEstado());
            return cita;
            
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Cita> readAll() {
        ArrayList<CitasDto> arrayDto = dao.readAll();
        ArrayList<Cita> array = new ArrayList();
        if(arrayDto!=null){
            for(CitasDto dto : arrayDto){
                Cita cita = new Cita(dto.getId(),dto.getFecha(),dto.getHora(),dto.getPlaca(),dto.getEstado());
                array.add(cita);
            }
            return array;
        }else{
            return null;
        }
    }

    @Override
    public boolean update(Cita obj) {
        if(dao.read(String.valueOf(obj.getId()))!=null){
            CitasDto dto = new CitasDto(obj.getId(),obj.getFecha(),obj.getHora(),obj.getPlaca(),obj.getEstado());    
            dao.update(dto);
            frm.msj("Se actualizó la información", 1);
            return true;
        }else{
            frm.msj("No se encontró la cita, asegurate de poner el 'ID' correcto", 2);
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        if(dao.read(id)!=null){
            if( (this.readAll().size())>1){
            dao.delete(id);
            frm.msj("Se eliminó correctamente", 1);
            return true;
            }else{
                frm.msj("No se puede eliminar la cita ya que, debe existir al menos una.", 2);
                return false;
            }
        }else{
            frm.msj("No se encontró la cita", 2);
            return false;
        }
    }
    
}
