package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioEliminarActivity extends AppCompatActivity {
    EditText editIdHorario;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_eliminar);
        helper = new ControlBD(this);
        editIdHorario = (EditText)findViewById(R.id.editIdHorario);
    }

    public void eliminarHorario(View v){
        String afectados;
        Horario horario = new Horario();
        horario.setidHorario(editIdHorario.getText().toString());
        helper.abrir();
        afectados = helper.eliminar(horario);
        helper.cerrar();
        Toast.makeText(this, afectados, Toast.LENGTH_SHORT).show();
    }
}