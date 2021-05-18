package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PropuestaConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdteorico, editIdMat, editIdLab, editIdHorario, editIdDia, editIdSalon, editAprobado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta_consultar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText) findViewById(R.id.editIdPropuesta);
        editIdteorico = (EditText) findViewById(R.id.editIdteorico);
        editIdMat = (EditText) findViewById(R.id.editIdMat);
        editIdLab = (EditText) findViewById(R.id.editIdLab);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editIdSalon = (EditText) findViewById(R.id.editIdSalon);
        editAprobado = (EditText) findViewById(R.id.editAprobado);

    }

    public void consultarPropuesta(View v){
        helper.abrir();
        Propuesta propuesta = helper.consultarPropuesta(editIdPropuesta.getText().toString());
        helper.cerrar();
        if (propuesta == null){
            Toast.makeText(this, "Propuesta no se encuentra registrada", Toast.LENGTH_LONG).show();
        }
        else{
            editIdPropuesta.setText(propuesta.getidPropuesta());
            editIdteorico.setText(propuesta.getidTeorico());
            editIdMat.setText(propuesta.getidMat());
            editIdMat.setText(propuesta.getidMat());
            editIdHorario.setText(propuesta.getidHorario());
            editIdDia.setText(propuesta.getidDia());
            editIdSalon.setText(propuesta.getidSalon());
            editAprobado.setText(propuesta.getaprobado());

        }
    }

    public void limpiarTexto(View v){
        editIdPropuesta.setText("");
        editIdteorico.setText("");
        editIdMat.setText("");
        editIdLab.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
        editIdSalon.setText("");
        editAprobado.setText("");
    }
}