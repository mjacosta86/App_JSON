package com.json.sobremesa.app_json;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    private static final String ACTIVITY = "MainActivity";
    ProgressDialog progress_dialog;

    ArrayList<MatchsDay> lista_partidos;
    //TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String METODO = "onCreate()";
        Log.i(ACTIVITY, METODO);

        String url = CrearURL();

        new PoisJSON().execute(url);

        //texto = (TextView)findViewById(R.id.tvTexto); Linea para mostrar la informacion obtenida en la misma activity


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
        Log.i(ACTIVITY,METODO);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public String CrearURL()
    {
        final String METODO = "CrearURL()";
        Log.i(ACTIVITY, METODO);

        MyApplication app = (MyApplication) getApplication();
        String req = "matchsday";
        app.setRequire(req);
        String url ="http://www.resultados-futbol.com/scripts/api/api.php?tz=" + app.getTimeZone()
                + "&format=" + app.getFormat() + "&req=" + app.getRequire() + "&key=" + app.getKeyPro()
                + "&date=" + getFechaActual();

        Log.i(ACTIVITY, METODO+" URL: "+url);

        return url;
    }
    public String getFechaActual()
    {
        final String METODO = "getFechaActual()";
        Log.i(ACTIVITY,METODO);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        Log.i(ACTIVITY,METODO+" Fecha: "+dateFormat.format(cal.getTime())); //2014/08/06

        return dateFormat.format(cal.getTime());
    }

    private class PoisJSON extends AsyncTask<String, Void, String> //Hilo para descargar el JSON
    {
        @Override
        protected void onPreExecute()
        {
            final String METODO = "onPreExecute()";
            Log.i(ACTIVITY,METODO);
            progress_dialog = new ProgressDialog(MainActivity.this); //Aqui lanzo una ventana para advertir que se están descargando el JSON de POIS
            progress_dialog.setMessage("Descargando archivos...");
            progress_dialog.setCancelable(false);
            progress_dialog.show();
        }
        protected String doInBackground(String... urls)
        {
            final String METODO = "doInBackground()";
            Log.i(ACTIVITY,METODO);
            return readJSONFeed(urls[0]); //Desde aquí llamo al método que descarga el JSON
        }

        protected void onPostExecute(String result)
        {
            final String METODO = "onPostExecute()";
            Log.i(ACTIVITY, METODO);
            MyApplication app = (MyApplication) getApplication();
            try
            {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray pois = new JSONArray(jsonObject.getString("matches")); //Aqui extraigo lo que contiene el array de JSON "list"
                //---print out the content of the json feed---
                lista_partidos = new ArrayList<MatchsDay>();
                for (int x = 0; x < pois.length(); x++) //En este bucle introduzco los datos en los vectores correspondientes
                {
                    JSONObject poisItem = pois.getJSONObject(x);
                    MatchsDay partido = new MatchsDay();
                    partido.setId(poisItem.getString("id").toString().trim());
                    Log.i(ACTIVITY, METODO+" ID:"+partido.getId());
                    partido.setRound(poisItem.getString("round").toString().trim());
                    partido.setLocal(poisItem.getString("local").toString().trim());
                    partido.setVisitor(poisItem.getString("visitor").toString().trim());
                    partido.setCompetitionName(poisItem.getString("competition_name").toString().trim());
                    partido.setLeagueId(poisItem.getString("league_id").toString().trim());
                    partido.setTeam1(poisItem.getString("team1").toString().trim());
                    partido.setTeam2(poisItem.getString("team2").toString().trim());
                    partido.setNumc(poisItem.getString("numc").toString().trim());
                    partido.setYear(poisItem.getString("year").toString().trim());
                    partido.setPlayoffs(poisItem.getString("playoffs").toString().trim());
                    partido.setGroupCode(poisItem.getString("group_code").toString().trim());
                    partido.setCoef(poisItem.getString("coef").toString().trim());
                    partido.setCflag(poisItem.getString("cflag").toString().trim());
                    partido.setLocalShield(poisItem.getString("local_shield").toString().trim());
                    partido.setVisitorShield(poisItem.getString("visitor_shield").toString().trim());
                    partido.setDate(poisItem.getString("date").toString().trim());
                    partido.setHour(poisItem.getString("hour").toString().trim());
                    partido.setMinute(poisItem.getString("minute").toString().trim());
                    partido.setResult(poisItem.getString("result").toString().trim());
                    partido.setLiveMinute(poisItem.getString("live_minute").toString().trim());
                    partido.setStatus(poisItem.getString("status").toString().trim());
                    partido.setChannels(poisItem.getString("channels").toString().trim());

                    lista_partidos.add(partido);

                }

            }
            catch (Exception e)
            {
                Log.d("ReadPlacesFeedTask", e.getLocalizedMessage());
            }

            progress_dialog.dismiss(); //Cierro el cuadro de dialogo


            app.setListaPartidos(lista_partidos);

            Intent intent = new Intent(MainActivity.this, MatchsDayActivity.class);
            startActivity(intent);
            finish();

            //Script para mostrar en la misma activity

            /*if(lista_partidos.size()<=0)
            {
                Log.w(ACTIVITY, METODO + " La lista está vacía");
            }
            else
            {
                Log.w(ACTIVITY, METODO + " La lista no está vacía");
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

}
