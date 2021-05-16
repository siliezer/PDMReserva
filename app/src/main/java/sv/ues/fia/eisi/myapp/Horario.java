package sv.ues.fia.eisi.myapp;
import java.util.Date;


public class Horario {
    private String idHorario;
    private String idDia;
    private Date Horainicio, Horafin;


    public Horario() {
    }

    public Horario(String idHorario, String idDia, Date Horainicio, Date Horafin) {
        this.idHorario = idHorario;
        this.idDia = idDia;
        this.Horainicio = Horainicio;
        this.Horafin = Horafin;
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

    public Date getHorainicio() {
        return Horainicio;
    }

    public void setHorainicio(String Horainicio) {
        this.Horainicio = Horainicio;
    }

    public String getHorafin() {
        return Horainicio;
    }

    public void setHorafin(String Horafin) {
        this.Horafin = Horafin;
    }
}
