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

public class SalonActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdSalon, editIdEncargado, editTipo, editNombreSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_actualizar);
        helper = new ControlBD(this);
        editIdSalon = (EditText) findViewById(R.id.editIdSalon);
        editIdEncargado = (EditText) findViewById(R.id.editIdEncargado);
        editTipo = (EditText) findViewById(R.id.editTipo);
        editNombreSalon = (EditText) findViewById(R.id.editNombreSalon);
    }

    public void actualizarSalon(View v) throws ParseException {
        String idSalon = editIdSalon.getText().toString();
        String idEncargado = editIdEncargado.getText().toString();
        String tipo = editTipo.getText().toString();
        String nombreSalon = editNombreSalon.getText().toString();
        Salon salon = new Salon(idSalon, idEncargado, tipo, nombreSalon);

        helper.abrir();
        String tosti = helper.actualizar(salon);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSalon.setText("");
        editIdEncargado.setText("");
        editTipo.setText("");
        editNombreSalon.setText("");
    }
}