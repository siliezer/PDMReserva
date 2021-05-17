package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventoInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre, editDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_insertar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }

    public void insertarEvento(View v){
        String id = editId.getText().toString();
        String nombre = editNombre.getText().toString();
        String descripcion = editDescripcion.getText().toString();
        String regInsertados;

        Evento evento = new Evento(id, nombre, descripcion);
        helper.abrir();
        regInsertados = helper.insertar(evento);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
        editDescripcion.setText("");
    }
}