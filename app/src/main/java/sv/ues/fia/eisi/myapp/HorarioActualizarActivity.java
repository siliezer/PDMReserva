package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HorarioActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdHorario, editIdDia, editHorainicio, editHorafin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_actualizar);
        helper = new ControlBD(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editHorainicio = (EditText) findViewById(R.id.editHorainicio);
        editHorafin = (EditText) findViewById(R.id.editHorafin);

    }

    public void actualizarHorario(View v) throws ParseException {
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();
        String horainicio = editHorainicio.getText().toString();
        String horafin = editHorafin.getText().toString();
        Horario horario = new Horario(idHorario, idDia, horainicio, horafin);

        helper.abrir();
        String tosti = helper.actualizar(horario);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editHorainicio.setText("");
        editHorafin.setText("");
    }
}