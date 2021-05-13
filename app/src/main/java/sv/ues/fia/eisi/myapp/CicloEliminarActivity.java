package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CicloEliminarActivity extends AppCompatActivity {
    EditText editId;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_eliminar);
        helper = new ControlBD(this);
        editId = (EditText)findViewById(R.id.editId);
    }

    public void eliminarCiclo(View v){
        String afectados;
        Ciclo ciclo = new Ciclo();
        ciclo.setId(editId.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(ciclo);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}