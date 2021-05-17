package sv.ues.fia.eisi.myapp;

public class DetalleEvento {
    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
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

    private String idSalon, idEvento, idHorario, idDia;

    public DetalleEvento() {
    }

    public DetalleEvento(String idSalon, String  idEvento, String idHorario, String idDia) {
        this.idEvento = idEvento;
        this.idSalon = idSalon;
        this.idHorario = idHorario;
        this.idDia = idDia;
    }
}
