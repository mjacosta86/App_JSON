package com.json.sobremesa.app_json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class CategoriesActivity extends ActionBarActivity {

    private ListView lstCategories;
    ArrayList<Categories> lista_categorias;
    ArrayList<ListTeams> lista_equipos;
    ProgressDialog progress_dialog;
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
                String opcionSeleccionada = ((Categories) a.getAdapter().getItem(position)).getId();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();

                String url = CrearURL(lista_categorias.get(position).getId());
                new PoisJSON().execute(url);


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

    public String CrearURL(String league)
    {
        final String METODO = "CrearURL()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        String req = "teams";
        String filter = "all";
        app.setRequire(req);
        //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=&req=categories&key=65f8402127f4aae612732b4cb6089c22&country=es&filter=all
        //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=xml&req=teams&key=65f8402127f4aae612732b4cb6089c22&league=1&year=2015
        String url ="http://www.resultados-futbol.com/scripts/api/api.php?tz=" + app.getTimeZone()
                + "&format=" + app.getFormat() + "&req=" + app.getRequire() + "&key=" + app.getKeyPro() + "&league=" + league
                + "&year=" + getYear();

        Log.i(ACTIVITY, METODO + " URL: " + url);

        return url;
    }
    public String getYear()
    {
        final String METODO = "getFechaActual()";
        Log.i(ACTIVITY,METODO);
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        Log.i(ACTIVITY, METODO + " Fecha: " + dateFormat.format(cal.getTime())); //2014/08/06

        return dateFormat.format(cal.getTime());
    }

    private class PoisJSON extends AsyncTask<String, Void, String> //Hilo para descargar el JSON
    {
        @Override
        protected void onPreExecute()
        {
            final String METODO = "onPreExecute()";
            Log.i(ACTIVITY,METODO);
            progress_dialog = new ProgressDialog(CategoriesActivity.this); //Aqui lanzo una ventana para advertir que se estan descargando el JSON de POIS
            progress_dialog.setMessage("Descargando archivos...");
            progress_dialog.setCancelable(false);
            progress_dialog.show();
        }
        protected String doInBackground(String... urls)
        {
            final String METODO = "doInBackground()";
            Log.i(ACTIVITY,METODO);
            return readJSONFeed(urls[0]); //Desde aqui llamo al metodo que descarga el JSON
        }

        protected void onPostExecute(String result)
        {
            final String METODO = "onPostExecute()";
            Log.i(ACTIVITY, METODO);
            MyApplication app = (MyApplication) getApplication();
            try
            {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray teams = jsonObject.getJSONArray("team");
                lista_equipos = new ArrayList<ListTeams>();
                for (int i = 0; i < teams.length(); ++i)
                {
                    JSONObject item = teams.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                    ListTeams lt = new ListTeams();
                    lt.setId(item.getString("id").toString().trim());
                    lt.setNameShow(item.getString("nameShow").toString().trim());
                    Log.i(ACTIVITY, METODO+" "+lt.getNameShow());
                    //---print out the content of the json feed---
                    lista_equipos.add(lt);

                }



            }
            catch (JSONException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Toast.makeText(CategoriesActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                Log.w("WARNING",e.toString());
            }
            catch (Exception e)
            {
                Log.e("ReadPlacesFeedTask", e.getLocalizedMessage());
            }

            progress_dialog.dismiss(); //Cierro el cuadro de dialogo

            app.setListaEquipos(lista_equipos);

            Intent intent = new Intent(CategoriesActivity.this, ListTeamsActivity.class);
            startActivity(intent);


        }
    }
    public String readJSONFeed(String URL) //Metodo para descargar el JSON
    {
        final String METODO = "readJSONFeed()";
        Log.i(ACTIVITY,METODO);
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(URL);
        try
        {
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200)
            {
                HttpEntity entity = response.getEntity();
                InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    stringBuilder.append(line);
                }
                inputStream.close();
            }
            else
            {
                Log.d(ACTIVITY, METODO+" Failed to download file");
            }
        }
        catch (Exception e)
        {
            Log.d(ACTIVITY,METODO+" readJSONFeed "+ e.getLocalizedMessage());
        }
        return stringBuilder.toString();
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
