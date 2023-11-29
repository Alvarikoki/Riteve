package Controller;

import java.util.ArrayList;

/**
 *
 * @author maryc
 */
public interface CRUD <Class> {
    public boolean add(Class obj);
    public Class read(String id);
    public ArrayList<Class> readAll();
    public boolean update(Class obj);
    public boolean delete(String id);
}
