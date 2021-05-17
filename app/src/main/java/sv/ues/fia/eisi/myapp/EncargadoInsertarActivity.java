package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdEncargado, editNombresEncargado, editApellidosEncargados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_insertar);
        helper = new ControlBD(this);
        editIdEncargado = (EditText) findViewById(R.id.editIdPropuesta);
        editNombresEncargado = (EditText) findViewById(R.id.editIdHorario);
        editApellidosEncargados = (EditText) findViewById(R.id.editIdDia);
    }

    public void insertarMateria(View v){
        String regInsertados;
        String idEncargado = editIdEncargado.getText().toString();
        String nombresEncargado = editNombresEncargado.getText().toString();
        String apellidosEncargado = editApellidosEncargados.getText().toString();

        Encargado encargado = new Encargado(idEncargado, nombresEncargado, apellidosEncargado);
        helper.abrir();
        regInsertados = helper.insertar(encargado);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEncargado.setText("");
        editNombresEncargado.setText("");
        editApellidosEncargados.setText("");
    }
}