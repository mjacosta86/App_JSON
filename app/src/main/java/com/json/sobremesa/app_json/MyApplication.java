package com.json.sobremesa.app_json;

import android.app.Application;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by sobremesa on 11/07/2015.
 */
public class MyApplication extends Application
{
    String key_pro = "65f8402127f4aae612732b4cb6089c22"; //Key buena pero caduca el 10/08/2015
    String key_free = "9fb0641102eeb3cd7d7db99606624a08";
    String tz = "Europe/Madrid";
    String format = "json";
    String req;
    ArrayList<MatchsDay> lista_partidos;
    ArrayList<Categories> lista_categorias;
    //JSONArray json_partidos;

    //SETTERS
    public void setKeyPro(String k)
    {
       key_pro = k;
    }
    public void setKeyFree(String k)
    {
        key_free = k;
    }
    public void setTimeZone(String t)
    {
        tz = t;
    }
    public void setFormat(String f)
    {
        format = f;
    }
    public void setRequire(String r)
    {
        req = r;
    }
    public void setListaPartidos(ArrayList<MatchsDay> l)
    {
        lista_partidos = l;
    }
    public void setListaCategorias(ArrayList<Categories> l)
    {
        lista_categorias = l;
    }
    /*public void setJSONPartidos(JSONArray p)
    {
        json_partidos = p;
    }*/
    //GETTERS
    public String getKeyPro()
    {
        return key_pro;
    }
    public String getKeyFree()
    {
        return key_free;
    }
    public String getTimeZone()
    {
        return tz;
    }
    public String getFormat()
    {
        return format;
    }
    public String getRequire()
    {
        return req;
    }
    public ArrayList<MatchsDay> getListaPartidos()
    {
        return lista_partidos;
    }
    public ArrayList<Categories> getListaCategorias()
    {
        return lista_categorias;
    }
    /*public JSONArray getJSONPartidos()
    {
        return json_partidos;
    }*/


}
