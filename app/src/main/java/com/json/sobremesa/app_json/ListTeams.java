package com.json.sobremesa.app_json;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sobremesa on 09/07/2015.
 */
public class ListTeams implements Serializable
{
    /*
    [team] => Array
        (
            [0] => Array
                (
                    [id] => 183
                    [nameShow] => Almería
                    [translate] => 0
                    [group_code] => 1
                    [favorite] => 0
                    [basealias] => almeria
                    [fullName] => Unión Deportiva Almería
                    [alerts] =>
                    [shield] => http://thumb.resfu.com/img_data/escudos/medium/183.jpg?size=60x&ext=png&lossy=1&1
                )

     */
    private static final long serialVersionUID = 1566632448541564056L;
    //Atributos
    private String id;
    private String name_show;
    private String translate;
    private String group_code;
    private String favourite;
    private String basealias;
    private String full_name;
    private String alerts;
    private String shield;



    public ListTeams(){}

    public ListTeams(String i,
                 String nm,
                 String tr,
                 String gp,
                 String fa,
                 String ba,
                 String fn,
                 String al,
                 String sh)
    {
        this.id = i;
        this.name_show = nm;
        this.translate = tr;
        this.group_code = gp;
        this.favourite = fa;
        this.basealias = ba;
        this.full_name = fn;
        this.alerts = al;
        this.shield = sh;


    }
    //Getters
    public String getId()
    {
        return id;
    }
    public String getNameShow()
    {
        return name_show;
    }
    public String getTranslate()
    {
        return translate;
    }
    public String getGroupCode()
    {
        return group_code;
    }
    public String getFavourite()
    {
        return favourite;
    }
    public String getBaseAlias()
    {
        return basealias;
    }
    public String getFullName()
    {
        return full_name;
    }
    public String getAlerts()
    {
        return alerts;
    }

    //Setters
    public void setId(String i)
    {
        this.id = i;
    }
    public void setNameShow(String na)
    {
        this.name_show = na;
    }
    public void setTranslate(String tr)
    {
        this.translate = tr;
    }
    public void setGroupCode(String gp)
    {
        this.group_code = gp;
    }
    public void setFavourite(String fa)
    {
        this.favourite = fa;
    }
    public void setBaseAlias(String ba)
    {
        this.basealias = ba;
    }
    public void setFullName(String fn)
    {
        this.full_name = fn;
    }
    public void setAlerts(String al)
    {
        this.alerts = al;
    }





}
