package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Propuesta {
    private String idPropuesta;
    private String idteorico;
    private String idMat;
    private String idLab;
    private String idHorario;
    private String idDia;
    private String idSalon;
    private String aprobado;

    public Propuesta() {
    }

    public Propuesta(String idPropuesta, String idteorico, String idMat, String idLab, String idHorario, String idDia, String idSalon, String aprobado) {
        this.idPropuesta = idPropuesta;
        this.idteorico = idteorico;
        this.idMat = idMat;
        this.idLab = idLab;
        this.idHorario = idHorario;
        this.idDia = idDia;
        this.idSalon = idSalon;
        this.aprobado = aprobado;
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public String getIdteorico() {
        return idteorico;
    }

    public void setIdteorico(String idteorico) {
        this.idteorico = idteorico;
    }

    public String getIdMat() {
        return idMat;
    }

    public void setIdMat(String idMat) {
        this.idMat = idMat;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
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

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }
}

