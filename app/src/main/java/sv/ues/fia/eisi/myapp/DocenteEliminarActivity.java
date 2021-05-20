package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteEliminarActivity extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText editTextCarnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_eliminar);
        helper = new ControlBDLj16001(this);
        editTextCarnet = (EditText) findViewById(R.id.edit_carnet_docente);
    }

    public void eliminarDocente(View view) {
        String regEliminadas;
        Docente d = new Docente();
        d.setCarnet(editTextCarnet.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminar(d);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}