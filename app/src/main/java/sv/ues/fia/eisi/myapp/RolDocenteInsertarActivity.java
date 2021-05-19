package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RolDocenteInsertarActivity extends Activity {

    ControlBDLj16001 helper;
    EditText idEdit;
    EditText nombreEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_docente_insertar);
        helper= new ControlBDLj16001(this);
        idEdit = (EditText) findViewById(R.id.edit_id_rol_docente);
        nombreEdit = (EditText) findViewById(R.id.edit_nombre_rol_docente);
    }

    public void insertarRolDocente(View v) {
        String regInsertados;
        String id = idEdit.getText().toString();
        String nombre = nombreEdit.getText().toString();
        RolDocente rd = new RolDocente();
        rd.setId(id);
        rd.setNombre(nombre);
        helper.abrir();
        regInsertados = helper.insertar(rd);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto() {
        idEdit.setText("");
        nombreEdit.setText("");
    }
}