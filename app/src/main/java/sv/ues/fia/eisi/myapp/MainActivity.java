package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;

public class MainActivity extends ListActivity {

    String[] menu={"Tabla Escuela","Tabla Ciclo","Tabla Materia","Docente","Rol de docente","Teorico","Tabla Evento",
            "Tabla Detalle Evento","Tabla Dia","Asignacion","Encargado","Salon","Tabla Laboratorio","Tabla Horario","Tabla Propuesta","Servicios Web", "Llenar Base de Datos"};
    
    String[] activities={"EscuelaMenuActivity","CicloMenuActivity","MateriaMenuActivity","DocenteMenuActivity","RolDocenteMenuActivity","TeoricoMenuActivity","EventoMenuActivity",
            "DetalleEventoMenuActivity","DiaMenuActivity","AsignacionMenuActivity","EncargadoMenuActivity",
            "SalonMenuActivity","LaboratorioMenuActivity","HorarioMenuActivity","PropuestaMenuActivity","ServiciosWebMenuActivity", "Llenar Base de Datos"};

    ControlBD helper;
    String idUsuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu));
        helper = new ControlBD(this);
        idUsuario = getIntent().getExtras().getString("IdUsuario");

    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);

        if(position!=16){

            String nombreValue=activities[position];
            helper.abrir();
            Boolean acceso = helper.consultarAcceso(idUsuario, String.valueOf(position));
            helper.cerrar();
            if(acceso){
                try{
                    Class<?>
                            clase=Class.forName("sv.ues.fia.eisi.myapp."+nombreValue);
                    Intent inte = new Intent(this,clase);
                    this.startActivity(inte);
                }catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
            else {
                Toast.makeText(this, "No posee permisos para ver el men??", Toast.LENGTH_SHORT).show();
            }

        }else{
            helper.abrir();
            String t = "Error de llamado";
            try {
                t = helper.llenarBD();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            helper.cerrar();
            Toast.makeText(this, t, Toast.LENGTH_SHORT).show();

        }
    }
}