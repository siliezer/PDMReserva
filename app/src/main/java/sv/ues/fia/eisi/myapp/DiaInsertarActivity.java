package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_insertar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void insertarDia(View v){
        String id = editId.getText().toString();
        String nombre = editNombre.getText().toString();
        String regInsertados;

        Dia dia = new Dia(id, nombre);
        helper.abrir();
        regInsertados = helper.insertar(dia);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
    }
}