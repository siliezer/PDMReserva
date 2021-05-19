package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioEliminarActivity extends AppCompatActivity {
    EditText editIdLab;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_eliminar);
        helper = new ControlBD(this);
        editIdLab = (EditText)findViewById(R.id.editIdLab);
    }

    public void eliminarLaboratorio(View v){
        String afectados;
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setidLab(editIdLab.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(laboratorio);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}