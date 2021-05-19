package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SalonEliminarActivity extends AppCompatActivity {
    EditText editIdSalon;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_eliminar);
        helper = new ControlBD(this);
        editIdSalon = (EditText)findViewById(R.id.editIdSalon);
    }

    public void eliminarSalon(View v){
        String afectados;
        Salon salon = new Salon();
        salon.setIdSalon(editIdSalon.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(salon);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}