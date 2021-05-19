package sv.ues.fia.eisi.myapp;

public class Dia {
    public String getIdDia() {
        return idDia;
    }

    public void setIdDia(String idDia) {
        this.idDia = idDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    private String idDia, nombreDia;

    Dia() {

    }

    Dia(String idDia, String nombreDia) {
        this.idDia = idDia;
        this.nombreDia = nombreDia;
    }

}
