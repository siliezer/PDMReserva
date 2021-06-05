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

public class GenerarEncargado extends AppCompatActivity {

    ControlBD helper;
    EditText idencargado, nombres, apellidos;
    TextView resultado, indicaciones;
    Button registro;
    private static String urlHosting7 = "https://sh15001-pdm115.000webhostapp.com/InsertarEncargado.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_encargado);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        helper = new ControlBD(this);
        idencargado = (EditText) findViewById(R.id.editTextIdEncargado);
        nombres = (EditText) findViewById(R.id.editTextNombres);
        apellidos = (EditText) findViewById(R.id.editTextApellidos);
        resultado = (TextView) findViewById(R.id.textViewCarnet);
        indicaciones = (TextView) findViewById(R.id.textViewIndicaciones);
        registro = (Button) findViewById(R.id.button2);

    }

    public void insertarEncargado(View v){
        Controlador parser = new Controlador();
        String idencargado1 = idencargado.getText().toString();
        String nombres1 = nombres.getText().toString();
        String apellidos1 = apellidos.getText().toString();
        String url = urlHosting7+ "idencargado="+ idencargado1+ "&nombres="+ nombres1 + "&apellidos="+ apellidos1;
        //Toast.makeText(this, url,Toast.LENGTH_SHORT).show();
        String json = parser.obtenerRespuestaDeURL(url, this);
        try {
            JSONObject obj = new JSONObject(json);
            Toast.makeText(this, obj.getString("resultado"),Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

//    public void eliminarHorario1(View v){
//        Controlador parser = new Controlador();
//        String idhorario2 = idhorario.getText().toString();
//        String url = urlHosting6+ "idhorario="+ idhorario2;
//        //Toast.makeText(this, url,Toast.LENGTH_SHORT).show();
//        String json = parser.obtenerRespuestaDeURL(url, this);
//        try {
//            JSONObject obj = new JSONObject(json);
//            Toast.makeText(this, obj.getString("resultado"),Toast.LENGTH_LONG).show();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
}