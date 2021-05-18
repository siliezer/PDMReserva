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

public class PropuestaActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdteorico, editIdMat, editIdLab, editIdHorario, editIdDia, editIdSalon, editAprobado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta_actualizar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText) findViewById(R.id.editIdPropuesta);
        editIdteorico = (EditText) findViewById(R.id.editIdteorico);
        editIdMat = (EditText) findViewById(R.id.editIdMat);
        editIdLab = (EditText) findViewById(R.id.editIdLab);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editIdSalon = (EditText) findViewById(R.id.editIdSalon);
        editAprobado = (EditText) findViewById(R.id.editAprobado);

    }

    public void actualizarPropuesta(View v) throws ParseException {
        String idPropuesta = editIdPropuesta.getText().toString();
        String idteorico = editIdteorico.getText().toString();
        String idMat = editIdMat.getText().toString();
        String idLab = editIdLab.getText().toString();
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();
        String idSalon = editIdSalon.getText().toString();
        String idAprobado = editAprobado.getText().toString();
        Propuesta propuesta = new Propuesta(idPropuesta, idteorico, idMat, idLab, idHorario,idDia, idSalon, idAprobado);

        helper.abrir();
        String tosti = helper.actualizar(propuesta);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdPropuesta.setText("");
        editIdteorico.setText("");
        editIdMat.setText("");
        editIdLab.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
        editIdSalon.setText("");
        editAprobado.setText("");
    }
}