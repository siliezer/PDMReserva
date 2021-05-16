package sv.ues.fia.eisi.myapp;

import java.util.Date;

public class Ciclo {
    private String id;
    private Date inicio, fin;


    public Ciclo() {
    }

    public Ciclo(String id, Date inicio, Date fin) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
