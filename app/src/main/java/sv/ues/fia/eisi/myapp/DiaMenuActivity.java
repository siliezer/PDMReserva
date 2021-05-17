package sv.ues.fia.eisi.myapp;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiaMenuActivity extends ListActivity {
    String[] menu = {"Agregar Dia","Eliminar Dia","Consultar Dia",
            "Actualizar Evento"};
    String[] activities ={"DiaInsertarActivity","DiaEliminarActivity","DiaConsultarActivity",
            "DiaActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.LTGRAY);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id) {
        super.onListItemClick(l, v, position, id);

        String nombreValue = activities[position];

        l.getChildAt(position).setBackgroundColor(Color.DKGRAY);

        try {
            Class<?> clase = Class.forName("sv.ues.fia.eisi.myapp." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
