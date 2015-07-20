package com.json.sobremesa.app_json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class ListTeamsActivity extends ActionBarActivity
{
    private static final String ACTIVITY = "ListTeamsActivity";
    private ListView lstListTeams;
    ArrayList<ListTeams> lista_equipos;
    ArrayList<Teams> equipos;
    ProgressDialog progress_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_teams);
        final String METODO = "onCreate()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        lista_equipos = app.getListaEquipos();

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        lstListTeams = (ListView)findViewById(R.id.LstListaEquipos);

        lstListTeams.setAdapter(adaptador);

        lstListTeams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada = ((ListTeams) a.getAdapter().getItem(position)).getId();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();

                String url = CrearURL(lista_equipos.get(position).getId());
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
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_teams, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public String CrearURL(String id)
    {
        final String METODO = "CrearURL()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        String req = "team";
        app.setRequire(req);
        //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=xml&req=team&key=65f8402127f4aae612732b4cb6089c22&id=1617
        String url ="http://www.resultados-futbol.com/scripts/api/api.php?tz=" + app.getTimeZone()
                + "&format=" + app.getFormat() + "&req=" + app.getRequire() + "&key=" + app.getKeyPro()
                + "&id=" + id;

        Log.i(ACTIVITY, METODO + " URL: " + url);

        return url;
    }

    private class PoisJSON extends AsyncTask<String, Void, String> //Hilo para descargar el JSON
    {
        @Override
        protected void onPreExecute()
        {
            final String METODO = "onPreExecute()";
            Log.i(ACTIVITY,METODO);
            progress_dialog = new ProgressDialog(ListTeamsActivity.this); //Aqui lanzo una ventana para advertir que se estan descargando el JSON de POIS
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
            Teams t = new Teams();
            final String METODO = "onPostExecute()";
            Log.i(ACTIVITY, METODO);
            MyApplication app = (MyApplication) getApplication();
            try
            {
                JSONObject jsonObject = new JSONObject(result);
                JSONObject equipo = jsonObject.getJSONObject("team");

                t.setId(equipo.getString("id").toString().trim());
                t.setName_show(equipo.getString("nameShow").toString().trim());
                Log.i(ACTIVITY, METODO + " " + t.getName_show());
                /*JSONArray teams = jsonObject.getJSONArray("team");
                equipos = new ArrayList<Teams>();
                for (int i = 0; i < teams.length(); ++i)
                {
                    JSONObject item = teams.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                    Teams t = new Teams();
                    t.setId(item.getString("id").toString().trim());
                    t.setName_show(item.getString("nameShow").toString().trim());
                    Log.i(ACTIVITY, METODO+" "+t.getName_show());
                    //---print out the content of the json feed---
                    equipos.add(t);

                }*/



            }
            catch (JSONException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Toast.makeText(ListTeamsActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                Log.w("WARNING",e.toString());
            }
            catch (Exception e)
            {
                Log.e("ReadPlacesFeedTask", e.getLocalizedMessage());
            }

            progress_dialog.dismiss(); //Cierro el cuadro de dialogo

            app.setListaEquipos(lista_equipos);

            Intent intent = new Intent(ListTeamsActivity.this, TeamsActivity.class);
            intent.putExtra("equipo",t.getName_show());
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

    class AdaptadorTitulares extends ArrayAdapter<ListTeams>
    {

        Activity context;


        AdaptadorTitulares(Activity context)
        {
            super(context, R.layout.listitem_categorias, lista_equipos);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View item = convertView;
            ViewHolder holder;

            if(item == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_equipos, null);

                holder = new ViewHolder();
                holder.id = (TextView)item.findViewById(R.id.LblIdEquipo);
                holder.nombre = (TextView)item.findViewById(R.id.LblNombreEquipo);

                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag();
            }

            holder.id.setText(lista_equipos.get(position).getId());
            holder.nombre.setText(lista_equipos.get(position).getNameShow());

            return(item);
        }
    }

    static class ViewHolder {
        TextView id;
        TextView nombre;
    }
}
