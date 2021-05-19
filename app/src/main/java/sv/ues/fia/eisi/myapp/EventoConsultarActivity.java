package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre, editDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_consultar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }

    public void consultarEvento(View v){
        helper.abrir();
        Evento evento = helper.consultarEvento(editId.getText().toString());
        helper.cerrar();
        if(evento == null){
            Toast.makeText(this, "Evento con id " + editId.getText().toString() +
                    " no está registrada.", Toast.LENGTH_LONG).show();
        }
        else {
            editNombre.setText(evento.getNombreEvento());
            editDescripcion.setText(evento.getDescripcion());
        }

    }


    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
        editDescripcion.setText("");
    }
}