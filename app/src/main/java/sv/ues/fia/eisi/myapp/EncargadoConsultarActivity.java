package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoConsultarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdEncargado, editNombresEncargado, editApellidosEncargado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_consultar);
        helper = new ControlBD(this);
        editIdEncargado = (EditText)findViewById(R.id.editIdEncargado);
        editNombresEncargado=(EditText)findViewById(R.id.editNombresEncargado);
        editApellidosEncargado = (EditText)findViewById(R.id.editApellidosEncargado);

    }

    public void consultarEncargado(View v){
        helper.abrir();
        Encargado encargado = helper.consultarEncargado(editIdEncargado.getText().toString());
        helper.cerrar();
        if (encargado == null){
            Toast.makeText(this, "El encargado no se encuentra registrado", Toast.LENGTH_LONG).show();
        }
        else{
            editIdEncargado.setText(encargado.getIdEncargado());
            editNombresEncargado.setText(encargado.getNombresEncargado());
            editApellidosEncargado.setText(encargado.getApellidosEncargado());

        }
    }

    public void limpiarTexto(View v){
        editIdEncargado.setText("");
        editNombresEncargado.setText("");
        editApellidosEncargado.setText("");
    }
}