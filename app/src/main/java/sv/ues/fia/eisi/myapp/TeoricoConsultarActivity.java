package sv.ues.fia.eisi.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TeoricoConsultarActivity extends Activity {
    ControlBDLj16001 helper;
    EditText editTextIdTeorico;
    EditText editTextIdMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorico_consultar);
        editTextIdTeorico = (EditText) findViewById(R.id.edit_id_teorico);
        editTextIdMateria = (EditText) findViewById(R.id.edit_id_mat);

    }

    public void consultarTeorico(View view) {
        helper.abrir();
        Teorico t = helper.consultarTeorico(editTextIdTeorico.getText().toString(),
                editTextIdMateria.getText().toString());
        helper.cerrar();
        if (t == null) {
            Toast.makeText(this, "Rol con id " +
                            editTextIdTeorico.getText().toString() + " no encontrado.",
                    Toast.LENGTH_LONG).show();
        }
        else {
            editTextIdMateria.setText(t.getIdMateria());
        }
    }

    public void limpiarTexto( View view) {
        editTextIdTeorico.setText("");
        editTextIdMateria.setText("");
    }
}