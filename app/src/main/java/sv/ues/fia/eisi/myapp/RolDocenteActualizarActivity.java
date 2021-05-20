package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RolDocenteActualizarActivity extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText editTextId;
    EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_docente_actualizar);
        helper = new ControlBDLj16001(this);
        editTextId = (EditText) findViewById(R.id.edit_id);
        editTextNombre = (EditText) findViewById(R.id.edit_nombre);
    }

    public void actualizarRolDocente(View view) {
        RolDocente rolDocente = new RolDocente();
        rolDocente.setId(editTextId.getText().toString());
        rolDocente.setNombre(editTextNombre.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(rolDocente);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto() {
        editTextId.setText("");
        editTextNombre.setText("");
    }
}