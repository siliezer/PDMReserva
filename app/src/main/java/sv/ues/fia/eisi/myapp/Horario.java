package sv.ues.fia.eisi.myapp;
import java.util.Date;


public class Horario {
    private String idHorario;
    private String idDia;
    private String Horainicio;
    private String Horafin;


    public Horario() {
    }

    public Horario(String idHorario, String Horafin, String idDia, String Horainicio) {
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

    public String getHorainicio() {
        return Horainicio;
    }

    public void setHorainicio(String horainicio) {
        Horainicio = horainicio;
    }


    public String getHorafin() {
        return Horafin;
    }

    public void setHorafin(String horafin) {
        Horafin = horafin;
    }
}
