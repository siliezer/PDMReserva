package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdHorario, editIdDia, editHorainicio, editHorafin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_insertar);
        helper = new ControlBD(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editHorainicio = (EditText) findViewById(R.id.editHorainicio);
        editHorafin = (EditText) findViewById(R.id.editHorafin);
    }

    public void insertarHorario(View v){
        String regInsertados;
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();
        String horainicio = editHorainicio.getText().toString();
        String horafin = editHorafin.getText().toString();
        Horario horario = new Horario(idHorario, idDia, horainicio, horafin);

        helper.abrir();
        regInsertados = helper.insertar(horario);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editHorainicio.setText("");
        editHorafin.setText("");
    }
}