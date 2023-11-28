package Models.DAO;

import Controller.CRUD;
import Models.DTO.TecnicoDto;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author David Duarte Garcia
 */
public class TecnicosDao implements CRUD<TecnicoDto>{

    @Override
    public boolean add(TecnicoDto obj) {
        if(obj==null) return false;
       DaoBD bd = new DaoBD();
       bd.createStatement("Insert into tecnicos values(?,?,?,?,?,?,?)");
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
        bd.createStatement("Select * from tecnicos where ID=?");
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
    public List<TecnicoDto> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(TecnicoDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        if(this.read(id)!=null){
        DaoBD bd = new DaoBD();
        bd.createStatement("DELETE FROM tecnicos WHERE id=?");
        bd.set(1, id);
        bd.execute(false);
        return true;
        }else{
            return false;
        }
    }
    
}
