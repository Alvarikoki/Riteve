package Controller;

import Models.DAO.RevisionesDao;
import Models.DTO.RevisionesDto;
import Models.DTO.TecnicoDto;
import Models.Revision;
import Views.FrmRevisiones;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author David Duarte Garcia
 */
public class RevisionesController implements CRUD<Revision> {

    private FrmRevisiones frm1;
    private RevisionesDao dao;

    public RevisionesController(FrmRevisiones frm1) {
        this.frm1 = frm1;
        dao = new RevisionesDao();
    }

    @Override
    public boolean add(Revision obj) {
        if (dao.read(obj.getHora()) == null) {
            RevisionesDto dto = new RevisionesDto(obj.getFecha(), obj.getHora(), obj.getTecnico(), obj.getTipoRevision(), obj.getObservaciones(), obj.getEstado());
            dao.add(dto);
            frm1.msj("Se agrego correctamente", 1);
            return true;
        } else {
            frm1.msj("La revision ya existe", 2);
            return false;
        }
    }

    @Override
    public Revision read(String id) {
        if (dao.read(id) != null) {
            RevisionesDto dto = dao.read(id);
            Revision rev = new Revision(dto.getFecha(), dto.getHora(), dto.getTecnico(), dto.getTipoRevision(), dto.getObservaciones(), dto.getEstado());
            return rev;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Revision> readAll() {
        ArrayList<RevisionesDto> arrayDto = dao.readAll();
        ArrayList<Revision> array = new ArrayList();
        if (arrayDto != null) {
            for (RevisionesDto dto : arrayDto) {
                Revision rev = new Revision(dto.getFecha(), dto.getHora(), dto.getTecnico(), dto.getTipoRevision(), dto.getObservaciones(), dto.getEstado());
                array.add(rev);
            }
            return array;
        } else {
            frm1.msj("No hay datos que mostrar", 2);
            return null;
        }
    }

    @Override
    public boolean update(Revision obj) {
        if (dao.read(obj.getHora()) != null) {
            RevisionesDto dto = new RevisionesDto(obj.getFecha(), obj.getHora(), obj.getTecnico(), obj.getTipoRevision(), obj.getObservaciones(), obj.getEstado());
            dao.update(dto);
            frm1.msj("se actualizo la informacion", 1);
            return true;
        } else {
            frm1.msj("No se encontro la revision, asegurese de ingresar la hora correcta", 2);
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
  if(dao.read(id)!=null){
          dao.delete(id);
          frm1.msj("Se elimino correctamente", 1);
          return true;
  }else{
          frm1.msj("No se puede eliminar la revision", 2);
          return false;
      }
    }

}

