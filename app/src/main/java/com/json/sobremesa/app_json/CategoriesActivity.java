package com.json.sobremesa.app_json;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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


public class CategoriesActivity extends ActionBarActivity {

    private ListView lstCategories;
    ArrayList<Categories> lista_categorias;
    private static final String ACTIVITY = "CategoriesActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        final String METODO = "onCreate()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        lista_categorias = app.getListaCategorias();

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        lstCategories = (ListView)findViewById(R.id.LstCategories);

        lstCategories.setAdapter(adaptador);

        lstCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((Categories)a.getAdapter().getItem(position)).getId();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();


            }
        });
    }

    protected void onStart()
    {
        final String METODO = "onStart()";
        Log.i(ACTIVITY, METODO);
        super.onStart();
    }

    protected void onRestart()
    {
        final String METODO = "onRestart()";
        Log.i(ACTIVITY, METODO);
        super.onRestart();
    }

    protected void onResume()
    {
        final String METODO = "onResume()";
        Log.i(ACTIVITY, METODO);
        super.onResume();
    }

    protected void onPause()
    {
        final String METODO = "onPause()";
        Log.i(ACTIVITY,METODO);
        super.onPause();
    }

    protected void onStop()
    {
        final String METODO = "onStop()";
        Log.i(ACTIVITY, METODO);
        super.onStop();
    }

    protected void onDestroy()
    {
        final String METODO = "onDestroy()";
        Log.i(ACTIVITY, METODO);
        super.onDestroy();
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
    class AdaptadorTitulares extends ArrayAdapter<Categories>
    {

        Activity context;


        AdaptadorTitulares(Activity context)
        {
            super(context, R.layout.listitem_categorias, lista_categorias);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View item = convertView;
            ViewHolder holder;

            if(item == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_categorias, null);

                holder = new ViewHolder();
                holder.id = (TextView)item.findViewById(R.id.LblIdCategoria);
                holder.nombre = (TextView)item.findViewById(R.id.LblNombreCategoria);

                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag();
            }

            holder.id.setText(lista_categorias.get(position).getId());
            holder.nombre.setText(lista_categorias.get(position).getName());

            return(item);
        }
    }

    static class ViewHolder {
        TextView id;
        TextView nombre;
    }
}
