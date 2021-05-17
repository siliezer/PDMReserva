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

public class EncargadoActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdEncargado, editNombresEncargado, editApellidosEncargados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_actualizar);
        helper = new ControlBD(this);
        editIdEncargado = (EditText) findViewById(R.id.editIdEncargado);
        editNombresEncargado = (EditText) findViewById(R.id.editNombresEncargado);
        editApellidosEncargados = (EditText) findViewById(R.id.editApellidosEncargado);

    }

    public void actualizarEncargado(View v) throws ParseException {
        String idEncargado = editIdEncargado.getText().toString();
        String nombresEncargado = editNombresEncargado.getText().toString();
        String apellidosEncargado = editApellidosEncargados.getText().toString();
        Encargado encargado = new Encargado(idEncargado, nombresEncargado, apellidosEncargado);

        helper.abrir();
        String tosti = helper.actualizar(encargado);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEncargado.setText("");
        editNombresEncargado.setText("");
        editApellidosEncargados.setText("");
    }
}