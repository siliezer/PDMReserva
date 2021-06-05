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

public class HorarioInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editIdHorario, editIdDia, editHoraInicio, editHoraFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_insertar);
        helper = new ControlBD(this);
        editIdHorario = (EditText) findViewById(R.id.editIdHorario);
        editIdDia = (EditText) findViewById(R.id.editIdDia);
        editHoraInicio = (EditText) findViewById(R.id.editHoraInicio);
        editHoraInicio.setOnClickListener(this::onClick);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
        editHoraFin.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editHoraInicio:
                showDatePickerDialog(editHoraInicio);
                break;

            case R.id.editHoraFin:
                showDatePickerDialog(editHoraFin);
                break;
        }
    }

    public void insertarHorario(View v) throws ParseException{
        String id = editIdHorario.getText().toString();
        String idDia = editIdHorario.getText().toString();
        String inicio = editHoraInicio.getText().toString();
        String fin = editHoraFin.getText().toString();
        Date inicioD = new SimpleDateFormat("dd/MM/yyyy").parse(inicio);
        Date finD = new SimpleDateFormat("dd/MM/yyyy").parse(fin);
        String regInsertados;

        Horario horario = new Horario(id, idDia,inicioD, finD);
        helper.abrir();
        regInsertados = helper.insertar(horario);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editIdDia.setText("");
        editHoraInicio.setText("");
        editHoraFin.setText("");
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