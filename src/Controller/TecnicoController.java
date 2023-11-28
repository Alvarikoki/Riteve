package Controller;

import Models.DAO.TecnicosDao;
import Models.DTO.TecnicoDto;
import Models.Tecnico;
import Views.FrmTecnicos;
import java.util.List;

/**
 *
 * @author Álvaro Álvarez R
 */
public class TecnicoController implements CRUD<Tecnico>{
    private FrmTecnicos frm;
    private TecnicosDao dao;

    public TecnicoController(FrmTecnicos frm) {
        this.frm = frm;
        dao = new TecnicosDao();
    }

    @Override
    public boolean add(Tecnico obj) {
        if (dao.read(obj.getId())==null){
            TecnicoDto dto = new TecnicoDto(obj.getId(),obj.getNombre(),obj.getFechaNacimiento(),obj.getTelefono(),obj.getEmail(),obj.getSalario(),obj.getPassword());
            dao.add(dto);
            frm.msj("Se agregó correctamente", 1);
            return true;
        }else{
            frm.msj("Usuario ya existente", 2);
            return false;
        }
    }

    @Override
    public Tecnico read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tecnico> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Tecnico obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        if(dao.read(id)!=null){
            dao.delete(id);
            frm.msj("Se eliminó correctamente", 1);
            return true;
        }else{
            frm.msj("No se encontró el tecnico", 2);
            return false;
        }
    }
    
    
    
}
