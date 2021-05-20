package sv.ues.fia.eisi.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TeoricoActualizarActivity extends Activity {
    ControlBDLj16001 helper;
    EditText editTextIdTeorico;
    EditText editTextIdMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorico_actualizar);
        editTextIdTeorico = (EditText) findViewById(R.id.edit_id_teorico);
        editTextIdMateria = (EditText) findViewById(R.id.edit_id_materia);
    }

    public void actualizarTeorico(View view) {
        Teorico teorico = new Teorico();
        teorico.setIdMateria(editTextIdMateria.getText().toString());
        teorico.setIdTeorico(editTextIdTeorico.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(teorico);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto( View view) {
        editTextIdTeorico.setText("");
        editTextIdMateria.setText("");
    }
}