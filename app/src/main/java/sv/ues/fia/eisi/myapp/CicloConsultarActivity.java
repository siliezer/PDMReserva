package sv.ues.fia.eisi.myapp;
//SH15001
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CicloConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editInicio, editFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_consultar);

        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editInicio = (EditText) findViewById(R.id.editInicio);
        editFin = (EditText) findViewById(R.id.editFin);
    }

    public void consultarCiclo(View v) throws ParseException {
        helper.abrir();
        Ciclo ciclo = helper.consultarCiclo(editId.getText().toString());
        helper.cerrar();
        if(ciclo == null){
            Toast.makeText(this, "El ciclo con id " + editId.getText().toString() +
                    " no está registrado.", Toast.LENGTH_LONG).show();
        }
        else {
            editInicio.setText(getDateTime(ciclo.getInicio()));
            editFin.setText(getDateTime(ciclo.getFin()));
        }

    }

    public void limpiarTexto(View v){
        editId.setText("");
        editInicio.setText("");
        editFin.setText("");
    }

    private String getDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(date);
    }
}