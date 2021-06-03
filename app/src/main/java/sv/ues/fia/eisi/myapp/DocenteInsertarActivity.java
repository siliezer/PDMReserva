package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteInsertarActivity extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText editTextCarnetDocente;
    EditText editTextIdRol;
    EditText editTextNombre;
    EditText editTextApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_insertar);
        helper = new ControlBDLj16001(this);
        editTextCarnetDocente = (EditText) findViewById(R.id.edit_carnet_docente);
        editTextIdRol = (EditText) findViewById(R.id.id_rol_docente);
        editTextNombre = (EditText) findViewById(R.id.nombre_docente);
        editTextApellido = (EditText) findViewById(R.id.apellido_docente);
    }

    public void insertarDocente(View view) {
        String regInsertados;
        String carnet = editTextCarnetDocente.getText().toString();
        String idRol = editTextIdRol.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();

        Docente d = new Docente();
        d.setCarnet(carnet);
        d.setIdRol(idRol);
        d.setNombre(nombre);
        d.setApellido(apellido);

        helper.abrir();
        regInsertados = helper.insertar(d);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto() {
        editTextCarnetDocente.setText("");
        editTextIdRol.setText("");
        editTextNombre.setText("");
        editTextApellido.setText("");
    }
}