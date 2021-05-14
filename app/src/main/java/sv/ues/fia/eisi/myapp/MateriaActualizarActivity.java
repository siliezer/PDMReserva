package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId, editNombre, editCarnetDocente, editIdCiclo, editIdEscuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_actualizar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editCarnetDocente = (EditText) findViewById(R.id.editCarnetDocente);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);
        editIdEscuela = (EditText) findViewById(R.id.editidEscuela);
    }

    public void actualizarMateria(View v){
        String regInsertados;
        String id = editId.getText().toString();
        String nombre = editNombre.getText().toString();
        String idEscuela = editIdEscuela.getText().toString();
        String idCiclo = editIdCiclo.getText().toString();
        String carnet = editCarnetDocente.getText().toString();

        Materia materia = new Materia(id, idCiclo, idEscuela, nombre, carnet);
        helper.abrir();
        regInsertados = helper.actualizar(materia);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEscuela.setText("");
        editId.setText("");
        editIdCiclo.setText("");
        editCarnetDocente.setText("");
        editNombre.setText("");
    }
}