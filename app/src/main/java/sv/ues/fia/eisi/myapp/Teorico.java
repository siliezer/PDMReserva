package sv.ues.fia.eisi.myapp;

public class Teorico {
    private String idTeorico;
    private String idMateria;

    public Teorico(String idTeorico, String idMateria) {
        this.idTeorico = idTeorico;
        this.idMateria = idMateria;
    }

    public String getIdTeorico() {
        return idTeorico;
    }

    public void setIdTeorico(String idTeorico) {
        this.idTeorico = idTeorico;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public Teorico() { }

}
