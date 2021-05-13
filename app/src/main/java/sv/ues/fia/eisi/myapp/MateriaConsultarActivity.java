package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId, editNombre, editIdCiclo, editIdEscuela, editCarnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_consultar);
        helper = new ControlBD(this);
        editId = (EditText)findViewById(R.id.editId);
        editNombre=(EditText)findViewById(R.id.editNombre);
        editIdCiclo = (EditText)findViewById(R.id.editIdCiclo);
        editIdEscuela = (EditText)findViewById(R.id.editidEscuela);
        editCarnet = (EditText)findViewById(R.id.editCarnetDocente);
    }

    public void consultarMateria(View v){
        helper.abrir();
        Materia materia = helper.consultarMateria(editId.getText().toString());
        helper.cerrar();
        if (materia == null){
            Toast.makeText(this, "Materia no se encuentra registrada", Toast.LENGTH_LONG).show();
        }
        else{
            editNombre.setText(materia.getNombre());
            editIdCiclo.setText(materia.getIdCiclo());
            editIdEscuela.setText(materia.getIdEscuela());
            editCarnet.setText(materia.getCarnetDocente());
        }
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
        editIdCiclo.setText("");
        editIdEscuela.setText("");
        editCarnet.setText("");
    }
}