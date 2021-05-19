package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleEventoInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editIdEvento, editIdSalon, editIdHorario, editIdDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_evento_insertar);
        helper = new ControlBD(this);
        editIdEvento = (EditText) findViewById(R.id.editIdEvento);
        editIdSalon = (EditText) findViewById(R.id.editIdSalon);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
    }

    public void insertarDetalleEvento(View v){
        String regInsertados;
        String idEvento = editIdEvento.getText().toString();
        String idSalon = editIdSalon.getText().toString();
        String idHorario = editIdHorario.getText().toString();
        String idDia = editIdDia.getText().toString();

        DetalleEvento detalleevento = new DetalleEvento(idSalon, idEvento , idHorario, idDia);
        helper.abrir();
        regInsertados = helper.insertar(detalleevento);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEvento.setText("");
        editIdSalon.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
    }
}