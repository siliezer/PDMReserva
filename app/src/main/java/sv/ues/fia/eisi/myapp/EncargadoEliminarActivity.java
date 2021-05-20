package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoEliminarActivity extends AppCompatActivity {
    EditText editIdEncargado;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_eliminar);
        helper = new ControlBD(this);
        editIdEncargado = (EditText)findViewById(R.id.editIdEncargado);
    }

    public void eliminarEncargado(View v){
        String afectados;
        Encargado encargado = new Encargado();
        encargado.setIdEncargado(editIdEncargado.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(encargado);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}