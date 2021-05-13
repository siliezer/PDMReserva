package sv.ues.fia.eisi.myapp;
//SH15001
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EscuelaConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_consultar);

        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void consultarEscuela(View v){
        helper.abrir();
        Escuela escuela = helper.consultarEscuela(editId.getText().toString());
        helper.cerrar();
        if(escuela == null){
            Toast.makeText(this, "Escuela con id " + editId.getText().toString() +
                    " no está registrada.", Toast.LENGTH_LONG).show();
        }
        else {
            editNombre.setText(escuela.getNombre());
        }

    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
    }
}