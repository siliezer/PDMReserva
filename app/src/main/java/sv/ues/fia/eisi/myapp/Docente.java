package sv.ues.fia.eisi.myapp;

public class Docente {
    private String carnet;
    private String nombre;
    private String apellido;
    private String idRol;

    public Docente() { }

    public Docente(String carnet, String nombre, String apellido, String idRol) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idRol = idRol;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
}
