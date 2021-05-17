package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre, editDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_actualizar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }

    public void actualizarEvento(View v){
        Evento evento = new Evento();
        evento.setIdEvento(editId.getText().toString());
        evento.setNombreEvento(editNombre.getText().toString());
        evento.setDescripcion(editDescripcion.getText().toString());
        helper.abrir();
        String t = helper.actualizar(evento);
        helper.cerrar();
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
        editDescripcion.setText("");
    }
}