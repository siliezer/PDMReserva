package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class GenerarHorario extends AppCompatActivity {

    ControlBD helper;
    EditText horafin, horainicio, iddia, idhorario;
    TextView resultado, indicaciones;
    Button registro;
    private static String urlHosting5 = "https://sh15001-pdm115.000webhostapp.com/InsertarHorario.php?";
//    private static String urlHosting6 = "https://sh15001-pdm115.000webhostapp.com/EliminarHorario.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_horario);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        helper = new ControlBD(this);
        horafin = (EditText) findViewById(R.id.editTextHoraFin);
        horafin.setOnClickListener(this::onClick);
        horainicio = (EditText) findViewById(R.id.editTextHoraInicio);
        horainicio.setOnClickListener(this::onClick);
        iddia = (EditText) findViewById(R.id.editTextDia);
        idhorario = (EditText) findViewById(R.id.editTextIdHorario);
        resultado = (TextView) findViewById(R.id.textViewCarnet);
        indicaciones = (TextView) findViewById(R.id.textViewIndicaciones);
        registro = (Button) findViewById(R.id.button2);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editTextHoraInicio:
                showDatePickerDialog1(horainicio);
                break;

            case R.id.editTextHoraFin:
                showDatePickerDialog1(horafin);
                break;
        }
    }



    public void insertarHorario1(View v){
        Controlador parser = new Controlador();
        String horafin1 = horafin.getText().toString();
        String horainicio1 = horainicio.getText().toString();
        String iddia1 = iddia.getText().toString();
        String idhorario1 = idhorario.getText().toString();
        String url = urlHosting5+ "horafin="+ horafin1+ "&horainicio="+ horainicio1+ "&iddia="+ iddia1+ "&idhorario="+ idhorario1;
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

    //Muestra el DatePicker en un diálogo
    public void showDatePickerDialog1(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = year + "/"  + twoDigits(month+1) + "/"+ twoDigits(day) ;
                editText.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
}