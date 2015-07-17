package com.json.sobremesa.app_json;

import java.io.Serializable;

/**
 * Created by sobremesa on 09/07/2015.
 */
public class MatchsDay implements Serializable
{
    /*
    [id] => 1322927
    [round] => 12
    [local] => Goiás EC
    [visitor] => Santos FC
    [competition_name] => Liga Brasileña
    [league_id] => 11071
    [team1] => 173845
    [team2] => 173853
    [numc] => 130
    [year] => 2015
    [playoffs] =>
    [group_code] => 1
    [coef] => 45.000
    [cflag] => http://cdn.popuz.com/media/img/flags/st3/small/br.png
    [local_shield] => http://thumb.resfu.com/img_data/escudos/medium/1245.jpg?size=60x
    [visitor_shield] => http://thumb.resfu.com/img_data/escudos/medium/2270.jpg?size=60x
    [date] => 2015/07/09
    [hour] => 00
    [minute] => 30
    [result] => 4-1
    [live_minute] =>
    [status] => 1
    [channels] => Array
     */
    private static final long serialVersionUID = 1566632478541064056L;
    private String id;                  //ID de partido
    private String round;               //Jornada de partido
    private String local;               //Equipo Local
    private String visitor;             //Equipo Visitante
    private String competition_name;    //Nombre de la competicion
    private String league_id;           //Id de la competicion
    private String team1;               //Id equipo local
    private String team2;               //Id equipo visitante

    private String numc;
    private String year;
    private String playoffs;
    private String group_code;
    private String coef;
    private String cflag;               //Bandera
    private String local_shield;        //Escudo equipo local
    private String visitor_shield;      //Escudo equipo visitante
    private String date;                //Fecha
    private String hour;                //Hora
    private String minute;              //Minuto
    private String result;              //Resultado
    private String live_minute;         //Minuto actual
    private String status;
    private String channels;

    public MatchsDay(){}

    public MatchsDay(String i,
                       String ro,
                       String lo,
                       String vi,
                       String co,
                       String le,
                       String t1,
                       String t2,
                       String nu,
                       String ye,
                       String pl,
                       String gp,
                       String coe,
                       String cf,
                       String ls,
                       String vs,
                       String da,
                       String ho,
                       String mi,
                       String re,
                       String li,
                       String st,
                       String ch)
    {
        this.id = i;
        this.round=ro;
        this.local=lo;
        this.visitor = vi;
        this.competition_name = co;
        this.league_id = le;
        this.team1 = t1;
        this.team2 = t2;
        this.numc = nu;
        this.year = ye;
        this.playoffs = pl;
        this.group_code = gp;
        this.coef = coe;
        this.cflag = cf;
        this.local_shield = ls;
        this.visitor_shield = vs;
        this.date = da;
        this.hour = ho;
        this.minute = mi;
        this.result = re;
        this.live_minute = li;
        this.status = st;
        this.channels = ch;


    }
    //Getters
    public String getId()
    {
        return id;
    }
    public String getRound()
    {
        return round;
    }
    public String getLocal()
    {
        return local;
    }
    public String getVisitor()
    {
        return visitor;
    }
    public String getCompetitionName()
    {
        return competition_name;
    }
    public String getLeagueId()
    {
        return league_id;
    }
    public String getTeam1()
    {
        return team1;
    }
    public String getTeam2()
    {
        return team2;
    }
    public String getNumc()
    {
        return numc;
    }
    public String getYear()
    {
        return year;
    }
    public String getPlayoffs()
    {
        return playoffs;
    }
    public String getGroupCode()
    {
        return group_code;
    }
    public String getCoef()
    {
        return coef;
    }
    public String getCflag()
    {
        return cflag;
    }
    public String getLocalShield()
    {
        return local_shield;
    }
    public String getVisitorShield()
    {
        return visitor_shield;
    }
    public String getDate()
    {
        return date;
    }
    public String getHour()
    {
        return hour;
    }
    public String getMinute()
    {
        return minute;
    }
    public String getResult()
    {
        return result;
    }
    public String getLiveMinute()
    {
        return live_minute;
    }
    public String getStatus()
    {
        return status;
    }
    public String getChannels()
    {
        return channels;
    }

    //Setters
    public void setId(String i)
    {
        this.id = i;
    }
    public void setRound(String ro)
    {
        this.round = ro;
    }
    public void setLocal(String lo)
    {
        this.local = lo;
    }
    public void setVisitor(String vi)
    {
        this.visitor = vi;
    }
    public void setCompetitionName(String co)
    {
        this.competition_name = co;
    }
    public void setLeagueId(String le)
    {
        this.league_id = le;
    }
    public void setTeam1(String t1)
    {
        this.team1 = t1;
    }
    public void setTeam2(String t2)
    {
        this.team2 = t2;
    }
    public void setNumc(String nu)
    {
        this.numc = nu;
    }
    public void setYear(String ye)
    {
        this.year = ye;
    }
    public void setPlayoffs(String pl)
    {
        this.playoffs = pl;
    }
    public void setGroupCode(String gp)
    {
        this.group_code = gp;
    }
    public void setCoef(String coe)
    {
        this.coef = coe;
    }
    public void setCflag(String cl)
    {
        this.cflag = cl;
    }
    public void setLocalShield(String ls)
    {
        this.local_shield = ls;
    }
    public void setVisitorShield(String vs)
    {
        this.visitor_shield = vs;
    }
    public void setDate(String da)
    {
        this.date = da;
    }
    public void setHour(String ho)
    {
        this.hour = ho;
    }
    public void setMinute(String mi)
    {
        this.minute = mi;
    }
    public void setResult(String re)
    {
        this.result = re;
    }
    public void setLiveMinute(String lm)
    {
        this.live_minute = lm;
    }
    public void setStatus(String st)
    {
        this.status = st;
    }
    public void setChannels(String ch)
    {
        this.channels = ch;
    }




}
