package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RolDocenteEliminarActivity extends AppCompatActivity {
    EditText editId;
    ControlBDLj16001 helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_docente_eliminar);
        helper = new ControlBDLj16001(this);
        editId = (EditText)findViewById(R.id.edit_id);
    }
    public void eliminarRolDocente(View v){
        String regEliminadas;
        RolDocente rd = new RolDocente();
        rd.setId(editId.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminar(rd);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}