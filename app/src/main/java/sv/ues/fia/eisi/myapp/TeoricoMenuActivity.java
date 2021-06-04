package sv.ues.fia.eisi.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeoricoMenuActivity extends android.app.ListActivity {
    private String[] menu = {"Insertar registro", "Eliminar registro",
                             "Consultar registro", "Actualizar registro"};
    private String[] activities = {"TeoricoInsertarActivity",
                                   "TeoricoEliminarActivity",
                                   "TeoricoConsultarActivity",
                                   "TeoricoActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        listView.setBackgroundColor(android.graphics.Color.rgb(66, 179, 245));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, menu);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String selectedActivity = activities[position];
        l.getChildAt(position).setBackgroundColor(android.graphics.Color.rgb(66,
                179,
                245));

        try {
            Class<?> selectedClass = Class.forName("sv.ues.fia.eisi.myapp."
                                                   + selectedActivity);
            Intent intent = new Intent(this, selectedClass);
            startActivity(intent);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}