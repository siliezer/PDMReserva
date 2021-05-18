package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PropuestaEliminarActivity extends AppCompatActivity {
    EditText editIdPropuesta;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta_eliminar);
        helper = new ControlBD(this);
        editIdPropuesta = (EditText)findViewById(R.id.editIdPropuesta);
    }

    public void eliminarPropuesta(View v){
        String afectados;
        Propuesta propuesta = new Propuesta();
        propuesta.setidPropuesta(editIdPropuesta.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(propuesta);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}