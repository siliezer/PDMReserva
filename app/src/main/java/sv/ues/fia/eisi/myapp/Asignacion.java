package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Asignacion {
    private String idPropuesta, idHorario, idDia;


    public Asignacion() {
    }

    public Asignacion(String idPropuesta, String idHorario, String idDia) {
        this.idPropuesta = idPropuesta;
        this.idHorario = idHorario;
        this.idDia = idDia;
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(String idAsignacion) {
        this.idPropuesta = idPropuesta;
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
