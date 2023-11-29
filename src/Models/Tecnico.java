package Models;

import java.sql.Date;

/**
 *
 * @author maryc
 */
public class Tecnico {
    private String id;
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String email;
    private double salario;
    private double salarioNeto;
    private int password;

    public Tecnico(String id, String nombre, Date fechaNacimiento, String telefono, String email, double salario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.encryp(password);
        this.calcDeducciones();
    }
    
    public Tecnico(String id, String nombre, Date fechaNacimiento, String telefono, String email, double salario, int password) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.password = password;
        this.calcDeducciones();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    public int getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.encryp(password);
    }
    
    public void encryp(String password){
        this.password = password.hashCode();
    }
    
    public void calcDeducciones(){
        double deduccion = (this.salario*13.64)/100;
        if(this.salario>817000&&this.salario<=1226000){
            deduccion += (this.salario*10)/100;
        }
        if(this.salario>1226000){
            deduccion += (this.salario*15)/100;
        }
        this.salarioNeto = this.salario-deduccion;
    }
}
