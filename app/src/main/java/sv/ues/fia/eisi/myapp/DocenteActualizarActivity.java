package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteActualizarActivity extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText editTextCarnetDocente;
    EditText editTextIdRol;
    EditText editTextNombre;
    EditText editTextApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_actualizar);
        helper = new ControlBDLj16001(this);
        editTextCarnetDocente = (EditText) findViewById(R.id.edit_carnet_docente);
        editTextIdRol = (EditText) findViewById(R.id.id_rol_docente);
        editTextNombre = (EditText) findViewById(R.id.nombre_docente);
        editTextApellido = (EditText) findViewById(R.id.apellido_docente);
    }

    public void actualizarDocente(View view) {
        Docente docente = new Docente();
        docente.setCarnet(editTextCarnetDocente.getText().toString());
        docente.setIdRol(editTextIdRol.getText().toString());
        docente.setNombre(editTextNombre.getText().toString());
        docente.setApellido(editTextApellido.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(docente);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto() {
        editTextCarnetDocente.setText("");
        editTextIdRol.setText("");
        editTextNombre.setText("");
        editTextApellido.setText("");
    }
}