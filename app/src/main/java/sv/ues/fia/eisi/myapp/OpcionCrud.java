package sv.ues.fia.eisi.myapp;

public class OpcionCrud {
    public String getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(String idopcion) {
        this.idopcion = idopcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumcrud() {
        return numcrud;
    }

    public void setNumcrud(int numcrud) {
        this.numcrud = numcrud;
    }

    private String idopcion, descripcion;
    private int numcrud;

    public OpcionCrud() {
    }

    public OpcionCrud(String idopcion, String descripcion, int numcrud) {
        this.idopcion = idopcion;
        this.descripcion = descripcion;
        this.numcrud = numcrud;
    }
}
