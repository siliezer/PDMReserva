package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] menu={"Tabla 1","Tabla 2","Tabla 3","Tabla 4","Tabla 5","Tabla 6","Tabla 7",
            "Tabla 8","Tabla 9","Tabla 10","Tabla 11","Tabla 12","Tabla 13","Tabla 14",
            "Tabla 15","Llenar Base de Datos"};
    String[] activities={"AlumnoMenuActivity","NotaMenuActivity","MateriaMenuActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu));

    }
}