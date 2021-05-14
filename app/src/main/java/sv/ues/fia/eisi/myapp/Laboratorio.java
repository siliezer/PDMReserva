package sv.ues.fia.eisi.myapp;

public class Laboratorio {

    private String idMat;
    private String idLab;



    public Laboratorio() {
    }

    public Laboratorio(String idMat, String idLab) {
        this.idMat = idMat;
        this.idLab = idLab;
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
}

