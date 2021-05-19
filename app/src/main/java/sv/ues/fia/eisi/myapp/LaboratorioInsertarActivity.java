package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdMat, editIdLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_insertar);
        helper = new ControlBD(this);
        editIdLab = (EditText) findViewById(R.id.editIdLab);
        editIdMat = (EditText) findViewById(R.id.editIdMat);

    }

    public void insertarLaboratorio(View v){
        String regInsertados;
        String idLab = editIdLab.getText().toString();
        String idMat = editIdMat.getText().toString();
        Laboratorio laboratorio = new Laboratorio(idMat, idLab);

        helper.abrir();
        regInsertados = helper.insertar(laboratorio);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdMat.setText("");
        editIdLab.setText("");
    }
}