package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleEventoConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editIdEvento, editIdSalon, editIdHorario, editIdDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_evento_consultar);
        helper = new ControlBD(this);
        editIdEvento = (EditText)findViewById(R.id.editIdEvento);
        editIdSalon=(EditText)findViewById(R.id.editIdSalon);
        editIdHorario = (EditText)findViewById(R.id.editIdHorario);
        editIdDia = (EditText)findViewById(R.id.editIdDia);
    }

    public void consultarDetalleEvento(View v){
        helper.abrir();
        DetalleEvento detalleEvento = helper.consultarDetalleEvento(editIdEvento.getText().toString());
        helper.cerrar();
        if (detalleEvento == null){
            Toast.makeText(this, "Detalle del evento no se encuentra registrado", Toast.LENGTH_LONG).show();
        }
        else{
            editIdEvento.setText(detalleEvento.getIdEvento());
            editIdSalon.setText(detalleEvento.getIdSalon());
            editIdHorario.setText(detalleEvento.getIdHorario());
            editIdDia.setText(detalleEvento.getIdDia());
        }
    }

    public void limpiarTexto(View v){
        editIdEvento.setText("");
        editIdSalon.setText("");
        editIdHorario.setText("");
        editIdDia.setText("");
    }
}