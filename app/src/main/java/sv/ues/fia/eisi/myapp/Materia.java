package sv.ues.fia.eisi.myapp;

public class Materia {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnetDocente() {
        return carnetDocente;
    }

    public void setCarnetDocente(String carnetDocente) {
        this.carnetDocente = carnetDocente;
    }

    private String idCiclo;
    private String idEscuela;
    private String nombre;
    private String carnetDocente;

    public Materia() {
    }

    public Materia(String id, String idCiclo, String idEscuela, String nombre, String carnetDocente) {
        this.id = id;
        this.idCiclo = idCiclo;
        this.idEscuela = idEscuela;
        this.nombre = nombre;
        this.carnetDocente = carnetDocente;
    }
}
