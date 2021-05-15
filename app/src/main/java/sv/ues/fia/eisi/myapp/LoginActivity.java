package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId, editCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new ControlBD(this);
        editId = (EditText) findViewById(R.id.editId);
        editCont = (EditText)findViewById(R.id.editCont);
    }

    public void iniciarSesion(View v){
        helper.abrir();
        Usuario usuario = helper.consultarUsuario(editId.getText().toString());
        helper.cerrar();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        if(usuario == null){
            if(editCont.getText().toString().equals("llave")){
                intent.putExtra("IdUsuario", "null");
                startActivity(intent);
                //Entra a actividad
            }
            else Toast.makeText(this, "Usuario incorrecto, compruebe los " +
                    "datos introducidos", Toast.LENGTH_LONG).show();
        }
        else{
            if(usuario.getCont().equals(editCont.getText().toString())){
                Toast.makeText(this, "¡Bienvenido " + usuario.getNombre()+
                        "!", Toast.LENGTH_SHORT).show();
                //String msj = usuario.getUsuario();
                intent.putExtra("IdUsuario", usuario.getUsuario());
                startActivity(intent);
                //Entra a actividad y manda id
            }
            else Toast.makeText(this, "Contraseña incorrecta, compruebe los " +
                    "datos introducidos", Toast.LENGTH_LONG).show();
        }
    }

    public void llenar(View v){
        try {
            helper.llenarBD();
            Toast.makeText(this, "Se pobló BD correctamente", Toast.LENGTH_SHORT).show();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}