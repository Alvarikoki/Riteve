package Models.DAO;

import Controller.CRUD;
import Models.DTO.TecnicoDto;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author David Duarte Garcia
 */
public class TecnicosDao implements CRUD<TecnicoDto>{

    @Override
    public boolean add(TecnicoDto obj) {
       if(obj==null) return false;
       DaoBD bd = new DaoBD();
       bd.createStatement("{CALL InsertTecnico(?,?,?,?,?,?,?)}");
       bd.set(1, obj.getId());
       bd.set(2, obj.getNombre());
       bd.set(3, obj.getFechaNacimiento());
       bd.set(4, obj.getTelefono());
       bd.set(5, obj.getEmail());
       bd.set(6, obj.getSalario());
       bd.set(7, obj.getPassword());
       return bd.execute(false);
    }

    @Override
    public TecnicoDto read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectTecnico(?)}");
        bd.set(1, id);
        bd.execute(true);
        try {
            if (bd.getData().next()){
                String idd = bd.getData().getString(1);
                String name = bd.getData().getString(2);
                Date fecha = bd.getData().getDate(3);
                String tel = bd.getData().getString(4);
                String email = bd.getData().getString(5);
                Double salario = bd.getData().getDouble(6);
                int contra = bd.getData().getInt(7);
                return new TecnicoDto(idd,name,fecha,tel,email,salario,contra);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public ArrayList<TecnicoDto> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectAllTecnico()}");
        bd.execute(true);
        ArrayList<TecnicoDto> array = new ArrayList();
        try {
            while (bd.getData().next()){
                String id = bd.getData().getString(1);
                String name = bd.getData().getString(2);
                Date fecha = bd.getData().getDate(3);
                String tel = bd.getData().getString(4);
                String correo = bd.getData().getString(5);
                Double salario = bd.getData().getDouble(6);
                int contra = bd.getData().getInt(7);
                TecnicoDto dto = new TecnicoDto(id,name,fecha,tel,correo,salario,contra);
                array.add(dto);
            }
            return array;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean update(TecnicoDto obj) {
         if (this.read(obj.getId()) != null) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL UpdateTecnico(?,?,?,?,?)}");
        bd.set(1, obj.getId());
        bd.set(2, obj.getNombre());
        bd.set(3, obj.getTelefono());
        bd.set(4, obj.getEmail());
        bd.set(5, obj.getSalario());
     
        bd.execute(false);
        return true;
        } else {
            return false;
        }
    }
    
    public boolean updatePassword(int password, String id){
        if (this.read(id) != null) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL UpdateContraseñaTecnico(?, ?)}");
        bd.set(1, id);
        bd.set(2, password);
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
        bd.createStatement("{CALL DeleteTecnico(?)}");
        bd.set(1, id);
        bd.execute(false);
        return true;
        }else{
            return false;
        }
    }
    
}
