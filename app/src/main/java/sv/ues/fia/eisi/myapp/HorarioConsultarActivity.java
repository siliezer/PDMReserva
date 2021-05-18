package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdHorario, editIdDia, editHorainicio, editHorafin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_consultar);
        helper = new ControlBD(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editHorainicio = (EditText) findViewById(R.id.editHorainicio);
        editHorafin = (EditText) findViewById(R.id.editHorafin);

    }

    public void consultarHorario(View v){
        helper.abrir();
        Horario horario = helper.consultarHorario(editIdHorario.getText().toString());
        helper.cerrar();
        if (horario == null){
            Toast.makeText(this, "El horario no se encuentra registrado", Toast.LENGTH_LONG).show();
        }
        else{
            editIdHorario.setText(horario.getidHorario());
            editIdDia.setText(horario.getidDia());
            editHorainicio.setText(horario.getHorainicio());
            editHorafin.setText(horario.getHorafin());

        }
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editHorainicio.setText("");
        editHorafin.setText("");
    }
}