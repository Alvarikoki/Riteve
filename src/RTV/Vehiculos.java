package RTV;

/**
 *
 * @author David Duarte Garcia
 */
public class Vehiculos {
    private String idP;
    private int numplaca;
    private String marca;
    private int modelo;
    private int año;
    private int fechaInscripcion;  

    public Vehiculos(String idP, int numplaca, String marca, int modelo, int año, int fechaInscripcion) {
        this.idP = idP;
        this.numplaca = numplaca;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public int getNumplaca() {
        return numplaca;
    }

    public void setNumplaca(int numplaca) {
        this.numplaca = numplaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(int fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
}
//De los vehículos se desea, número de placa, 
//marca, modelo, año, fecha de inscripción, así como la cedula y el nombre del
//propietario registral. además, al acceder a la información 
//del vehículo se debe mostrar la antigüedad del vehículo 
//(esta edad no se encuentra almacenada en la BD).
