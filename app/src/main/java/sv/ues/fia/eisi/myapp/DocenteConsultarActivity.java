package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteConsultarActivity extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText editTextCarnetDocente;
    EditText editTextIdRol;
    EditText editTextNombre;
    EditText editTextApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_consultar);

        helper = new ControlBDLj16001(this);
        editTextCarnetDocente = (EditText) findViewById(R.id.edit_id);
        editTextIdRol = (EditText) findViewById(R.id.id_rol_docente);
        editTextNombre = (EditText) findViewById(R.id.nombre_docente);
        editTextApellido = (EditText) findViewById(R.id.apellido_docente);
    }

    public void consultarDocente(View view) {
        helper.abrir();
        Docente d = helper.consultarDocente(editTextCarnetDocente.getText().toString());
        helper.cerrar();

        if (d == null) {
            Toast.makeText(this, "Rol con id " +
                            editTextCarnetDocente.getText().toString() +
                            " no encontrado.",
                            Toast.LENGTH_LONG).show();
        }
        else {
            editTextIdRol.setText(d.getIdRol());
            editTextNombre.setText(d.getNombre());
            editTextApellido.setText(d.getApellido());
        }
    }

    public void limpiarTexto() {
        editTextCarnetDocente.setText("");
        editTextIdRol.setText("");
        editTextNombre.setText("");
        editTextApellido.setText("");
    }
}