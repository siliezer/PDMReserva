package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Evento {

    public Evento() {
    }

    public Evento(String idEvento, String  nombreEvento, String descripcion) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
    }

    public String getIdEvento()
    { return idEvento; }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private String idEvento;
    private String nombreEvento, descripcion;

}
