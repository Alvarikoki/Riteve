package Models.DAO;

import Controller.CRUD;
import Models.DTO.CitasDto;
import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David Duarte Garcia
 */
public class CitasDao implements CRUD<CitasDto> {
    

    @Override
    public boolean add(CitasDto obj) {
        if(obj==null) return false;
       DaoBD bd = new DaoBD();
       bd.createStatement("{CALL InsertCita(null,?,?,?)}");
       bd.set(2, obj.getFecha());
       bd.set(3, obj.getHora());
       bd.set(4, obj.getPlaca());
       return bd.execute(false);
    }

    @Override
    public CitasDto read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectCita(?)}");
        bd.set(1, Integer.parseInt(id));
        bd.execute(true);
        try {
            if (bd.getData().next()){
                int idd = bd.getData().getInt(1);
                Date fecha = bd.getData().getDate(2);
                Time hora = bd.getData().getTime(3);
                String placa = bd.getData().getString(4);
                Boolean estado = bd.getData().getBoolean(5);
                return new CitasDto(idd,fecha,hora,placa,estado);               
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public ArrayList<CitasDto> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL SelectAllCita()}");
        bd.execute(true);
        ArrayList<CitasDto> array = new ArrayList();
        try {
            while (bd.getData().next()){
                int idd = bd.getData().getInt(1);
                Date fecha = bd.getData().getDate(2);
                Time hora = bd.getData().getTime(3);
                String placa = bd.getData().getString(4);
                Boolean estado = bd.getData().getBoolean(5);
                CitasDto dto = new CitasDto(idd,fecha,hora,placa,estado);
                array.add(dto);
            }
            return array;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean update(CitasDto obj) {
        if (this.read(String.valueOf(obj.getId())) != null) {
        DaoBD bd = new DaoBD();
        bd.createStatement("{CALL UpdateTecnico(?,?)}");
        bd.set(1, obj.getId());
        bd.set(2, obj.getEstado());
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
            bd.createStatement("{CALL DeleteCita(?)}");
            bd.set(1, Integer.parseInt(id));
            bd.execute(false);
            return true;
        }else{
            return false;
        }    
    }
    
}
