package com.json.sobremesa.app_json;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MatchsDayActivity extends ActionBarActivity {

    private ListView lstOpciones;
    ArrayList<MatchsDay> lista_partidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchsday);

        MyApplication app = (MyApplication) getApplication();
        lista_partidos = app.getListaPartidos();

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((MatchsDay)a.getAdapter().getItem(position)).getId();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lists_matchs_day, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class AdaptadorTitulares extends ArrayAdapter<MatchsDay>
    {

        Activity context;

        AdaptadorTitulares(Activity context)
        {
            super(context, R.layout.listitem_matchsday, lista_partidos);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View item = convertView;
            ViewHolder holder;

            if(item == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_matchsday, null);

                holder = new ViewHolder();
                holder.id = (TextView)item.findViewById(R.id.LblIdPartido);
                holder.local = (TextView)item.findViewById(R.id.LblLocal);
                holder.visitante = (TextView)item.findViewById(R.id.LblVisitante);

                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag();
            }

            holder.id.setText(lista_partidos.get(position).getId());
            holder.local.setText(lista_partidos.get(position).getLocal());
            holder.visitante.setText(lista_partidos.get(position).getVisitor());

            return(item);
        }
    }

    static class ViewHolder {
        TextView id;
        TextView local;
        TextView visitante;
    }
}
