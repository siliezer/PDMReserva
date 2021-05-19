package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SalonInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdSalon, editIdEncargado, editTipo, editNombreSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_insertar);
        helper = new ControlBD(this);
        editIdSalon = (EditText) findViewById(R.id.editIdSalon);
        editIdEncargado = (EditText) findViewById(R.id.editIdEncargado);
        editTipo = (EditText) findViewById(R.id.editTipo);
        editNombreSalon = (EditText) findViewById(R.id.editNombreSalon);
    }

    public void insertarSalon(View v){
        String regInsertados;
        String idSalon = editIdSalon.getText().toString();
        String idEncargado = editIdEncargado.getText().toString();
        String tipo = editTipo.getText().toString();
        String nombreSalon = editNombreSalon.getText().toString();

        Salon salon = new Salon(idSalon, idEncargado, tipo, nombreSalon);
        helper.abrir();
        regInsertados = helper.insertar(salon);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSalon.setText("");
        editIdEncargado.setText("");
        editTipo.setText("");
        editNombreSalon.setText("");

    }
}