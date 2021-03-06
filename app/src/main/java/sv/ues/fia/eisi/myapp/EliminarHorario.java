package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class EliminarHorario extends AppCompatActivity {

    ControlBD helper;
    EditText horafin, horainicio, iddia, idhorario, idhorario2;
    TextView resultado, indicaciones;
    Button registro;
    private static String urlHosting6 = "https://sh15001-pdm115.000webhostapp.com/EliminarHorario.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_horario);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        helper = new ControlBD(this);
        horafin = (EditText) findViewById(R.id.editTextHoraFin);
        horainicio = (EditText) findViewById(R.id.editTextHoraInicio);
        iddia = (EditText) findViewById(R.id.editTextDia);
        idhorario = (EditText) findViewById(R.id.editTextIdHorario);
        idhorario2 = (EditText) findViewById(R.id.editTextHorario);
        resultado = (TextView) findViewById(R.id.textViewCarnet);
        indicaciones = (TextView) findViewById(R.id.textViewIndicaciones);
        registro = (Button) findViewById(R.id.button2);

    }


    public void eliminarHorario1(View v){
        Controlador parser = new Controlador();
        String idhorario1 = idhorario2.getText().toString();
        String url = urlHosting6+ "idhorario="+ idhorario1;
        //Toast.makeText(this, url,Toast.LENGTH_SHORT).show();
        String json = parser.obtenerRespuestaDeURL(url, this);
        try {
            JSONObject obj = new JSONObject(json);
            Toast.makeText(this, obj.getString("resultado"),Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}