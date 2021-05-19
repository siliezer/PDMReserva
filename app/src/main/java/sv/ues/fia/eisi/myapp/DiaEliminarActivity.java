package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaEliminarActivity extends AppCompatActivity {

    EditText editId;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_eliminar);
        helper = new ControlBD(this);
        editId = (EditText)findViewById(R.id.editId);
    }

    public void eliminarDia(View v){
        String afectados;
        Dia dia = new Dia();
        dia.setIdDia(editId.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(dia);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}