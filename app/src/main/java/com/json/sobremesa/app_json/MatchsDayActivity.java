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

import com.google.gson.Gson;

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
import java.util.Iterator;
import java.util.List;


public class MatchsDayActivity extends ActionBarActivity {

    private ListView lstPartidos;
    ArrayList<MatchsDay> lista_partidos;
    ArrayList<Categories> lista_categorias;
    private static final String ACTIVITY = "MatchsDayActivity";
    ProgressDialog progress_dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchsday);
        final String METODO = "onCreate()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        lista_partidos = app.getListaPartidos();

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        lstPartidos = (ListView)findViewById(R.id.LstMatchsDay);

        lstPartidos.setAdapter(adaptador);

        lstPartidos.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {

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
        getMenuInflater().inflate(R.menu.menu_lists_matchs_day, menu);
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
            String url = CrearURL();
            new PoisJSON().execute(url);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public String CrearURL()
    {
        final String METODO = "CrearURL()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        String req = "categories";
        String country = "es";
        String filter = "all";
        app.setRequire(req);
        //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=&req=categories&key=65f8402127f4aae612732b4cb6089c22&country=es&filter=all
        String url ="http://www.resultados-futbol.com/scripts/api/api.php?tz=" + app.getTimeZone()
                + "&format=" + app.getFormat() + "&req=" + app.getRequire() + "&key=" + app.getKeyPro() + "&country=" + country
                + "&filter=" + filter;

        Log.i(ACTIVITY, METODO + " URL: " + url);

        return url;
    }
    public String getFechaActual()
    {
        final String METODO = "getFechaActual()";
        Log.i(ACTIVITY,METODO);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
            progress_dialog = new ProgressDialog(MatchsDayActivity.this); //Aqui lanzo una ventana para advertir que se estan descargando el JSON de POIS
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
                JSONObject category = jsonObject.getJSONObject("category");
                JSONObject spain = category.getJSONObject("spain");

                JSONArray ligas = spain.getJSONArray("ligas");
                lista_categorias = new ArrayList<Categories>();
                for (int i = 0; i < ligas.length(); ++i)
                {
                    JSONObject item = ligas.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                    Categories c = new Categories();
                    c.setId(item.getString("id").toString().trim());
                    c.setName(item.getString("name").toString().trim());
                    Log.i(ACTIVITY, METODO+" "+c.getName());
                    //---print out the content of the json feed---
                    lista_categorias.add(c);

                }



            }
            catch (JSONException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Toast.makeText(MatchsDayActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                Log.w("WARNING",e.toString());
            }
            catch (Exception e)
            {
                Log.e("ReadPlacesFeedTask", e.getLocalizedMessage());
            }

            progress_dialog.dismiss(); //Cierro el cuadro de dialogo


            app.setListaCategorias(lista_categorias);

            Intent intent = new Intent(MatchsDayActivity.this, CategoriesActivity.class);
            startActivity(intent);

            //Script para mostrar en la misma activity

            /*if(lista_partidos.size()<=0)
            {
                Log.w(ACTIVITY, METODO + " La lista esta vacia");
            }
            else
            {
                Log.w(ACTIVITY, METODO + " La lista no esta vacia");
                for(int i = 0; i < lista_partidos.size(); ++i)
                {
                    String partido = " ID:" + lista_partidos.get(i).getId()+"\n"
                            +"Local:" + lista_partidos.get(i).getLocal()+"\n"
                            +"Visitante:" + lista_partidos.get(i).getVisitor();
                    Log.i(ACTIVITY, METODO+" "+partido);

                    texto.setText(texto.getText()+"\n"+partido);

                }

            }*/

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

    static class ViewHolder
    {
        TextView id;
        TextView local;
        TextView visitante;
    }
}
