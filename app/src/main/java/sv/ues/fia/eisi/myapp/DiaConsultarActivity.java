package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_consultar);

        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void consultarDia(View v){
        helper.abrir();
        Dia dia = helper.consultarDia(editId.getText().toString());
        helper.cerrar();
        if(dia == null){
            Toast.makeText(this, "Dia con id " + editId.getText().toString() +
                    " no está registrada.", Toast.LENGTH_LONG).show();
        }
        else {
            editNombre.setText(dia.getNombreDia());
        }

    }


    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
    }
}