package sv.ues.fia.eisi.myapp;
//SH15001
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class EscuelaInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_insertar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void insertarEscuela(View v){
        String id = editId.getText().toString();
        String nombre = editNombre.getText().toString();
        String regInsertados;

        Escuela escuela = new Escuela(id, nombre);
        helper.abrir();
        regInsertados = helper.insertar(escuela);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editNombre.setText("");
    }

}