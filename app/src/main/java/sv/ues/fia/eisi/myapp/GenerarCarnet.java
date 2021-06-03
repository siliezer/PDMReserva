package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class GenerarCarnet extends AppCompatActivity {
    EditText apellido1, apellido2, anio;
    TextView resultado;
    private static String urlHosting = "https://sh15001-pdm115.000webhostapp.com/GenerarCarnet.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_carnet);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        apellido1 = (EditText) findViewById(R.id.editTextApellido1);
        apellido2 = (EditText) findViewById(R.id.editTextApellido2);
        anio = (EditText) findViewById(R.id.editTextAnio);
        resultado = (TextView) findViewById(R.id.textViewCarnet);
    }

    public void generarCarnet(View v){
        Controlador parser = new Controlador();
        String ape1 = apellido1.getText().toString();
        String ape2 = apellido2.getText().toString();
        String year = anio.getText().toString();
        String url = urlHosting+ "ape1="+ ape1+ "&ape2="+ ape2+ "&year="+ year;
        String json = parser.obtenerRespuestaDeURL(url, this);
        try {
            JSONObject obj = new JSONObject(json);
            resultado.setText("Carnet generado: "+obj.getString("resultado"));

        } catch (Exception e){
            resultado.setText(e.getMessage());
        }
    }
}