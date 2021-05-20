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

public class AsignacionActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdHorario, editIdDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_actualizar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText) findViewById(R.id.editIdPropuesta);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);

    }

    public void actualizarAsignacion(View v) throws ParseException {
        String idPropuesta = editIdPropuesta.getText().toString();
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();
        Asignacion asignacion = new Asignacion(idPropuesta, idHorario, idDia);

        helper.abrir();
        String tosti = helper.actualizar(asignacion);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdPropuesta.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
    }
}