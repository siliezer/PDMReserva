package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleEventoEliminarActivity extends AppCompatActivity {
    EditText editIdEvento;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_evento_eliminar);
        helper = new ControlBD(this);
        editIdEvento = (EditText)findViewById(R.id.editIdEvento);
    }

    public void eliminarDetalleEvento(View v){
        String afectados;
        DetalleEvento detallevento = new DetalleEvento();
        detallevento.setIdEvento(editIdEvento.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(detallevento);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}