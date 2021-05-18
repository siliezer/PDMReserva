package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdMat, editIdLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_consultar);
        helper = new ControlBD(this);
        editIdMat = (EditText) findViewById(R.id.editIdMat);
        editIdLab = (EditText) findViewById(R.id.editIdLab);

    }

    public void consultarLaboratorio(View v){
        helper.abrir();
        Laboratorio laboratorio = helper.consultarLaboratorio(editIdMat.getText().toString());
        helper.cerrar();
        if (laboratorio == null){
            Toast.makeText(this, "laboratorio no se encuentra registrada", Toast.LENGTH_LONG).show();
        }
        else{
            editIdMat.setText(laboratorio.getidMat());
            editIdLab.setText(laboratorio.getidLab());

        }
    }

    public void limpiarTexto(View v){
        editIdMat.setText("");
        editIdLab.setText("");
    }
}