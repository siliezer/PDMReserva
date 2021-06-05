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

public class EliminarEvento extends AppCompatActivity {

    ControlBD helper;
    EditText nombre, descripcion, nomb;
    TextView resultado, indicaciones;
    Button registro;
    private static String urlHosting4 = "https://sh15001-pdm115.000webhostapp.com/EliminarEvento.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_evento);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        helper = new ControlBD(this);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        descripcion = (EditText) findViewById(R.id.editTextDescripcion);
        nomb = (EditText) findViewById(R.id.editTextNomEvento);
        resultado = (TextView) findViewById(R.id.textViewCarnet);
        indicaciones = (TextView) findViewById(R.id.textViewIndicaciones);
        registro = (Button) findViewById(R.id.button2);

    }


    public void eliminarEvento1(View v){
        Controlador parser = new Controlador();
        String nombr = nomb.getText().toString();
        String url = urlHosting4+ "nombre="+ nombr;
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