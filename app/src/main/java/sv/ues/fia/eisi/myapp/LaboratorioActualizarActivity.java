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

public class LaboratorioActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdMat, editIdLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_actualizar);
        helper = new ControlBD(this);
        editIdMat = (EditText) findViewById(R.id.editIdMat);
        editIdLab = (EditText) findViewById(R.id.editIdLab);

    }

    public void actualizarLaboratorio(View v) throws ParseException {
        String idMat = editIdMat.getText().toString();
        String idLab = editIdLab.getText().toString();
        Laboratorio laboratorio = new Laboratorio(idMat, idLab);

        helper.abrir();
        String tosti = helper.actualizar(laboratorio);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdMat.setText("");
        editIdLab.setText("");
    }
}