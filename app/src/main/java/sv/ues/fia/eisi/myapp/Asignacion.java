package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Asignacion {
    private String idAsignacion, idHorario, idDia;


    public Asignacion() {
    }

    public Asignacion(String idAsignacion, String idHorario, String idDia) {
        this.idAsignacion = idAsignacion;
        this.idHorario = idHorario;
        this.idDia = idDia;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getIdDia() {
        return idDia;
    }

    public void setIdDia(String idDia) {
        this.idDia = idDia;
    }
}
