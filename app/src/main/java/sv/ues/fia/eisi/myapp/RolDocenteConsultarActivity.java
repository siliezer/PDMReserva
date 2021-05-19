package sv.ues.fia.eisi.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RolDocenteConsultarActivity extends Activity {
    ControlBDLj16001 helper;
    EditText id;
    EditText nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_docente_consultar);

        helper= new ControlBDLj16001(this);
        id= (EditText) findViewById(R.id.edit_id);
        nombre = (EditText) findViewById(R.id.edit_nombre);
    }

    public void consultarRolDocente(View view) {
        helper.abrir();
        RolDocente rd = helper.consultarRolDocente(id.getText().toString());
        helper.cerrar();
        if (rd == null) {
            Toast.makeText(this, "Rol con id " +
                           id.getText().toString() + " no encontrado.",
                           Toast.LENGTH_LONG).show();
        }
        else {
            nombre.setText(rd.getNombre());
        }
    }

    public void limpiarTexto(View view) {
        id.setText("");
        nombre.setText("");
    }
}