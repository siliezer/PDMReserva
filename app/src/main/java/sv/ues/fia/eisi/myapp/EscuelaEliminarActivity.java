package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EscuelaEliminarActivity extends AppCompatActivity {
    EditText editId;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_eliminar);
        helper = new ControlBD(this);
        editId = (EditText)findViewById(R.id.editId);
    }

    public void eliminarEscuela(View v){
        String afectados;
        Escuela escuela = new Escuela();
        escuela.setId(editId.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(escuela);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}