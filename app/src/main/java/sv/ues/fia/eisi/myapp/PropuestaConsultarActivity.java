package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PropuestaConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdTeo, editIdMat, editIdLab, editIdHorario,editIdDia, editIdSal, editIdApr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta_consultar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText) findViewById(R.id.editIdPropuesta);
        editIdTeo = (EditText) findViewById(R.id.editIdTeo);
        editIdMat = (EditText) findViewById(R.id.editIdMat);
        editIdLab = (EditText) findViewById(R.id.editIdLab);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editIdSal = (EditText) findViewById(R.id.editIdSal);
        editIdApr = (EditText) findViewById(R.id.editIdApr);

    }

    public void consultarPropuesta(View v){
        helper.abrir();
        Propuesta propuesta = helper.consultarPropuesta(editIdPropuesta.getText().toString());
        helper.cerrar();
        if (propuesta == null){
            Toast.makeText(this, "Propuesta no se encuentra registrada", Toast.LENGTH_LONG).show();
        }
        else{
            editIdPropuesta.setText(propuesta.getIdPropuesta());
            editIdTeo.setText(propuesta.getIdteorico());
            editIdMat.setText(propuesta.getIdMat());
            editIdLab.setText(propuesta.getIdLab());
            editIdHorario.setText(propuesta.getIdHorario());
            editIdDia.setText(propuesta.getIdDia());
            editIdSal.setText(propuesta.getIdSalon());
            editIdApr.setText(propuesta.getAprobado());

        }
    }

    public void limpiarTexto(View v){
        editIdPropuesta.setText("");
        editIdTeo.setText("");
        editIdMat.setText("");
        editIdLab.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
        editIdSal.setText("");
        editIdApr.setText("");
    }
}