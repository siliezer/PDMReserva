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

public class GenerarCarnet extends AppCompatActivity {
    ControlBDLj16001 helper;
    EditText apellido1, apellido2, anio, nombres, rol;
    TextView resultado, indicaciones;
    String carnet = null;
    Button registro;
    private static String urlHosting = "https://sh15001-pdm115.000webhostapp.com/GenerarCarnet.php?";
    private static String urlHosting2 = "https://sh15001-pdm115.000webhostapp.com/InsertarDocente.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_carnet);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        helper = new ControlBDLj16001(this);
        apellido1 = (EditText) findViewById(R.id.editTextApellido1);
        apellido2 = (EditText) findViewById(R.id.editTextApellido2);
        anio = (EditText) findViewById(R.id.editTextAnio);
        resultado = (TextView) findViewById(R.id.textViewCarnet);
        indicaciones = (TextView) findViewById(R.id.textViewIndicaciones);
        nombres = (EditText) findViewById(R.id.editTextNombres);
        rol =  (EditText) findViewById(R.id.editTextRol);
        registro = (Button) findViewById(R.id.button2);

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
            carnet = obj.getString("resultado");

            /*----------No puedo implementar esto si ni siquiera funciona-----
            int i = 1;
            helper.abrir();
            do{
                carnet = carnet + i;
                i++;
            }while(helper.consultarDocente(carnet)!=null);
            helper.cerrar();*/
            resultado.setText("Carnet generado: "+carnet);
            indicaciones.setVisibility(View.VISIBLE);
            nombres.setVisibility(View.VISIBLE);
            rol.setVisibility(View.VISIBLE);
            registro.setVisibility(View.VISIBLE);
        } catch (Exception e){
            resultado.setText(e.getMessage());
        }
    }

    public void insertarDocente1(View v){
        if(carnet!=null){
            Controlador parser = new Controlador();
            String apellidos = apellido1.getText().toString()+"+"+apellido2.getText().toString();
            String nomb1 = nombres.getText().toString();
            String nomb = nomb1.replace(' ' ,'+');
            String rolid = rol.getText().toString();
            String url = urlHosting2+ "carnet="+ carnet+ "&rol="+ rolid+ "&nom="+ nomb+ "&ape="+ apellidos;
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
}