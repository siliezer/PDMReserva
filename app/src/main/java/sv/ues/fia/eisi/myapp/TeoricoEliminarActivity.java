package sv.ues.fia.eisi.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TeoricoEliminarActivity extends Activity {
    ControlBDLj16001 helper;
    EditText editTextIdTeorico;
    EditText editTextIdMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorico_eliminar);
        helper = new ControlBDLj16001(this);
        editTextIdTeorico = (EditText)findViewById(R.id.edit_id_teorico);
        editTextIdMateria = (EditText)findViewById(R.id.edit_id_mat);
    }

    public void eliminarTeorico(View v) {
        String regEliminadas;
        Teorico t = new Teorico();
        t.setIdTeorico(editTextIdTeorico.getText().toString());
        t.setIdMateria(editTextIdMateria.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminar(t);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}