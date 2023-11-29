package Controller;

import Models.DAO.TecnicosDao;
import Models.DTO.TecnicoDto;
import Models.Tecnico;
import Views.FrmBuscarTecnico;
import Views.FrmTecnicos;
import java.util.ArrayList;

/**
 *
 * @author Álvaro Álvarez R
 */
public class TecnicoController implements CRUD<Tecnico>{
    private FrmTecnicos frm;
    private FrmBuscarTecnico frm2;
    private TecnicosDao dao;

    public TecnicoController(FrmTecnicos frm) {
        this.frm = frm;
        dao = new TecnicosDao();
    }
    
    public TecnicoController(FrmBuscarTecnico frm2){
        this.frm2 = frm2;
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
            frm.msj("El técnico ya existe", 2);
            return false;
        }
    }

    @Override
    public Tecnico read(String id) {
        if(dao.read(id)!=null){
            TecnicoDto dto = dao.read(id);
            Tecnico tc = new Tecnico(dto.getId(),dto.getNombre(),dto.getFechaNacimiento(),dto.getTelefono(),dto.getEmail(),dto.getSalario(),dto.getPassword());
            return tc;
        }else{
            frm.msj("No se encontró el técnico, asegurate de poner el 'ID' correcto", 2);
            return null;
        }
    }

    @Override
    public ArrayList<Tecnico> readAll() {
        ArrayList array = dao.readAll();
        if (array!=null){
            frm2.mostrarTodo(array);
        }
        return array;
    }

    @Override
    public boolean update(Tecnico obj) {
        if(dao.read(obj.getId())!=null){
            TecnicoDto dto = new TecnicoDto(obj.getId(),obj.getNombre(),obj.getFechaNacimiento(),obj.getTelefono(),obj.getEmail(),obj.getSalario(),obj.getPassword());    
            dao.update(dto);
            frm.msj("Se actualizó la información", 1);
            return true;
        }else{
            frm.msj("No se encontró el técnico, asegurate de poner el 'ID' correcto", 2);
            return false;
        }
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
