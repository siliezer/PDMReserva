package sv.ues.fia.eisi.myapp;

public class AccesoUsuario {
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(String idopcion) {
        this.idopcion = idopcion;
    }

    private String usuario, idopcion;

    public AccesoUsuario(String usuario, String idopcion) {
        this.usuario = usuario;
        this.idopcion = idopcion;
    }

    public AccesoUsuario() {
    }

}
