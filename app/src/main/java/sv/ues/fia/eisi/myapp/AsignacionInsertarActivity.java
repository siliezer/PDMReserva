package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AsignacionInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdHorario, editIdDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_insertar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText) findViewById(R.id.editIdPropuesta);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
    }

    public void insertarMateria(View v){
        String regInsertados;
        String idPropuesta = editIdPropuesta.getText().toString();
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();

        Asignacion asignacion = new Asignacion(idPropuesta, idHorario, idDia);
        helper.abrir();
        regInsertados = helper.insertar(asignacion);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdPropuesta.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
    }
}