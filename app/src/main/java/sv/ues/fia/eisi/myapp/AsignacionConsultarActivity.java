package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AsignacionConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdHorario, editIdDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_consultar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText)findViewById(R.id.editIdPropuesta);
        editIdHorario=(EditText)findViewById(R.id.editIdHorario);
        editIdDia = (EditText)findViewById(R.id.editIdDia);

    }

    public void consultarAsignacion(View v){
        helper.abrir();
        Asignacion asignacion = helper.consultarAsignacion(editIdPropuesta.getText().toString());
        helper.cerrar();
        if (asignacion == null){
            Toast.makeText(this, "Asignacion no se encuentra registrada", Toast.LENGTH_LONG).show();
        }
        else{
            editIdPropuesta.setText(asignacion.getIdPropuesta());
            editIdHorario.setText(asignacion.getIdHorario());
            editIdDia.setText(asignacion.getIdDia());

        }
    }

    public void limpiarTexto(View v){
        editIdPropuesta.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
    }
}