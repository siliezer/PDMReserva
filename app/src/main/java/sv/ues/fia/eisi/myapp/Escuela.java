package sv.ues.fia.eisi.myapp;
//SH15001

public class Escuela {
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

    private String id, nombre;

    public Escuela() {
    }

    public Escuela(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
