package sv.ues.fia.eisi.myapp;

public class Propuesta {
    private String idPropuesta;
    private String idteorico;
    private String idMat;
    private String idLab;
    private String idHorario;
    private String idDia;
    private String idSalon;
    private boolean aprobado;


    public Propuesta() {
    }

    public Propuesta(String idPropuesta, String idteorico, String idMat, String idLab, String idHorario, String idDia, String idSalon) {
        this.idPropuesta = idPropuesta;
        this.idteorico = idteorico;
        this.idMat = idMat;
        this.idLab = idLab;
        this.idHorario = idHorario;
        this.idDia = idDia;
        this.idSalon = idSalon;
    }

    public String getidPropuesta() {
        return idPropuesta;
    }

    public void setidPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public String getidteorico() {
        return idteorico;
    }

    public void setidteorico(String idteorico) {
        this.idteorico = idteorico;
    }

    public String getidMat() {
        return idMat;
    }

    public void setidMat(String idMat) {
        this.idMat = idMat;
    }

    public String getidLab() {
        return idLab;
    }

    public void setidLab(String idLab) {
        this.idLab = idLab;
    }

    public String getidHorario() {
        return idHorario;
    }

    public void setidHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getidDia() {
        return idDia;
    }

    public void setidDia(String idDia) {
        this.idDia = idDia;
    }

    public String getidSalon() {
        return idSalon;
    }

    public void setidSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public boolean getaprobado() {
        return aprobado;
    }

    public void setaprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
}

