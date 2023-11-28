package RTV;
/**
 *
 * @author David Duarte Garcia
 */
public class Tecnicos {
    private String id;
    private String name;
    private String fechaN;
    private int tel;
    private String email;
    private double salario;

    public Tecnicos(String id, String name, String fechaN, int tel, String email, double salario) {
        this.id = id;
        this.name = name;
        this.fechaN = fechaN;
        this.tel = tel;
        this.email = email;
        this.salario = salario;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
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

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
//De los técnicos se desea almacenar, numero de cedula, nombre completo
// fecha de nacimiento, teléfono, correo electrónico y salario.//