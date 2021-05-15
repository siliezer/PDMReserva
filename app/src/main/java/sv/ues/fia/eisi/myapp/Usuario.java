package sv.ues.fia.eisi.myapp;

public class Usuario {
    private String usuario, cont, nombre;

    public Usuario() {
    }

    public Usuario(String usuario, String cont, String nombre) {
        this.usuario = usuario;
        this.cont = cont;
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
