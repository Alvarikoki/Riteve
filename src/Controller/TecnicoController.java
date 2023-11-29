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
            return null;
        }
    }

    @Override
    public ArrayList<Tecnico> readAll() {
        ArrayList<TecnicoDto> arrayDto = dao.readAll();
        ArrayList<Tecnico> array = new ArrayList();
        if(arrayDto!=null){
            for(TecnicoDto dto : arrayDto){
                Tecnico tc = new Tecnico(dto.getId(),dto.getNombre(),dto.getFechaNacimiento(),dto.getTelefono(),dto.getEmail(),dto.getSalario(),dto.getPassword());
                array.add(tc);
            }
            return array;
        }else{
            frm.msj("No hay datos por mostrar", 2);
            return null;
        }
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
            if( (this.readAll().size())>1){
            dao.delete(id);
            frm.msj("Se eliminó correctamente", 1);
            return true;
            }else{
                frm.msj("No se puede eliminar el técnico ya que, debe existir al menos uno.", 2);
                return false;
            }
        }else{
            frm.msj("No se encontró el tecnico", 2);
            return false;
        }
    }
     
}
