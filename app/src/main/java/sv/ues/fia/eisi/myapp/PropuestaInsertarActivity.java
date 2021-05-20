package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PropuestaInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdPropuesta, editIdTeo, editIdMat, editIdLab, editIdHorario,editIdDia, editIdSal, editIdApr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta_insertar);
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

    public void insertarPropuesta(View v){
        String regInsertados;
        String idPropuesta = editIdPropuesta.getText().toString();
        String idteorico = editIdTeo.getText().toString();
        String idMat = editIdMat.getText().toString();
        String idLab = editIdLab.getText().toString();
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();
        String idSalon = editIdSal.getText().toString();
        String idAprobado = editIdApr.getText().toString();
        Propuesta propuesta = new Propuesta(idPropuesta, idteorico, idMat, idLab, idHorario,idDia, idSalon, idAprobado);

        helper.abrir();
        regInsertados = helper.insertar(propuesta);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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