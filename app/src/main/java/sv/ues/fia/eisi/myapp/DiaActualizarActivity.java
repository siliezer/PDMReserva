package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_actualizar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void actualizarDia(View v){
        Dia dia = new Dia();
        dia.setIdDia(editId.getText().toString());
        dia.setNombreDia(editNombre.getText().toString());
        helper.abrir();
        String t = helper.actualizar(dia);
        helper.cerrar();
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
    }
}