package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SalonConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdSalon, editIdEncargado, editTipo, editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_consultar);
        helper = new ControlBD(this);
        editIdSalon = (EditText)findViewById(R.id.editIdSalon);
        editIdEncargado=(EditText)findViewById(R.id.editIdEncargado);
        editTipo = (EditText)findViewById(R.id.editTipo);
        editNombre = (EditText)findViewById(R.id.editNombre);

    }

    public void consultarSalon(View v){
        helper.abrir();
        Salon salon = helper.consultarSalon(editIdSalon.getText().toString());
        helper.cerrar();
        if (salon == null){
            Toast.makeText(this, "El salon no se encuentra registrado", Toast.LENGTH_LONG).show();
        }
        else{
            editIdSalon.setText(salon.getIdSalon());
            editIdEncargado.setText(salon.getIdEncargado());
            editTipo.setText(salon.getTipo());
            editNombre.setText(salon.getNombre());

        }
    }

    public void limpiarTexto(View v){
        editIdSalon.setText("");
        editIdEncargado.setText("");
        editTipo.setText("");
        editNombre.setText("");
    }
}