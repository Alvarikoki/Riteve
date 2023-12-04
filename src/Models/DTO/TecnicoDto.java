package Models.DTO;

import java.sql.Date;

/**
 *
 * @author maryc
 */
public class TecnicoDto {
    private String id;
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String email;
    private double salario;
    private int password;

    public TecnicoDto(String id, String nombre, Date fechaNacimiento, String telefono, String email, double salario, int password) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.password = password;
    }
    
    public TecnicoDto(String nombre) {
        this.nombre = nombre;
    }
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public double getSalario() {
        return salario;
    }
 
    public int getPassword() {
        return password;
    }
    
}
