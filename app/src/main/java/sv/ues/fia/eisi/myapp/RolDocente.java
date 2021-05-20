package sv.ues.fia.eisi.myapp;

public class RolDocente {
    private String id;
    private String nombre;

    public RolDocente() {}

    public RolDocente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
