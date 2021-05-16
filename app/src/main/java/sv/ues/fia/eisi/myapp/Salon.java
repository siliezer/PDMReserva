package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Salon {
    private String idSalon, idEncargado, tipo, nombre;


    public Salon() {
    }

    public Salon(String idSalon, String idEncargado, String tipo, String nombre) {
        this.idSalon = idSalon;
        this.idEncargado = idEncargado;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
