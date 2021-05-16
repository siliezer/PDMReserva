package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Encargado {
    private String idEncargado, nombresEncargado, apellidosEncargado;


    public Encargado() {
    }

    public Encargado(String idEncargado, String nombresEncargado, String apellidosEncargado) {
        this.idEncargado = idEncargado;
        this.nombresEncargado = nombresEncargado;
        this.apellidosEncargado = apellidosEncargado;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getNombresEncargado() {
        return nombresEncargado;
    }

    public void setNombresEncargado(String nombresEncargado) {
        this.nombresEncargado = nombresEncargado;
    }

    public String getApellidosEncargado() {
        return apellidosEncargado;
    }

    public void setApellidosEncargado(String apellidosEncargado) {
        this.apellidosEncargado = apellidosEncargado;
    }
}
