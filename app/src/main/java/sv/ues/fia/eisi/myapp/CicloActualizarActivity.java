package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CicloActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId, editInicio, editFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_actualizar);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editInicio = (EditText) findViewById(R.id.editInicio);
        editInicio.setOnClickListener(this::onClick);
        editFin = (EditText) findViewById(R.id.editFin);
        editFin.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editInicio:
                showDatePickerDialog(editInicio);
                break;

            case R.id.editFin:
                showDatePickerDialog(editFin);
                break;
        }
    }

    public void actualizarCiclo(View v) throws ParseException {
        String id = editId.getText().toString();
        String inicio = editInicio.getText().toString();
        String fin = editFin.getText().toString();
        Date inicioD = new SimpleDateFormat("dd/MM/yyyy").parse(inicio);
        Date finD = new SimpleDateFormat("dd/MM/yyyy").parse(fin);
        Ciclo ciclo = new Ciclo(id, inicioD, finD);

        helper.abrir();
        String tosti = helper.actualizar(ciclo);
        helper.cerrar();
        Toast.makeText(this, tosti, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId.setText("");
        editInicio.setText("");
        editFin.setText("");
    }

    //Muestra el DatePicker en un diálogo
    public void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month+1) + "/" + year;
                editText.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
}