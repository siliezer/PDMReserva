package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HorarioConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdHorario, editIdDia, editInicio, editFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_consultar);
        helper = new ControlBD(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editInicio = (EditText) findViewById(R.id.editInicio);
        editFin = (EditText) findViewById(R.id.editFin);

    }

    public void consultarHorario(View v) throws ParseException {
        helper.abrir();
        Horario horario = helper.consultarHorario(editIdHorario.getText().toString());
        helper.cerrar();
        if(horario == null){
            Toast.makeText(this, "El Horario con id " + editIdHorario.getText().toString() +
                    " no está registrado.", Toast.LENGTH_LONG).show();
        }
        else {
            editIdDia.setText((horario.getidDia()));
            editInicio.setText(getDateTime(horario.getHorainicio()));
            editFin.setText(getDateTime(horario.getHorafin()));
        }
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editInicio.setText("");
        editFin.setText("");
    }

    private String getDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(date);
    }
}