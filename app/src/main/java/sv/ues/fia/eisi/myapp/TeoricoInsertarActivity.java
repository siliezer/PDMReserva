package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TeoricoInsertarActivity extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText editTextIdTeorico;
    EditText editTextIdMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorico_insertar);
        helper = new ControlBDLj16001(this);
        editTextIdTeorico = (EditText) findViewById(R.id.edit_id_teorico);
        editTextIdMateria = (EditText) findViewById(R.id.edit_id_materia);
    }

    public void insertarTeorico(View view) {
        String regInsertados;
        String idteo = editTextIdTeorico.getText().toString();
        String idmat = editTextIdMateria.getText().toString();
        Teorico t = new Teorico();
        t.setIdTeorico(idteo);
        t.setIdMateria(idmat);
        helper.abrir();
        regInsertados = helper.insertar(t);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto() {
        editTextIdTeorico.setText("");
        editTextIdMateria.setText("");
    }
}