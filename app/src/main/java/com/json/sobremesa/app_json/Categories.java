package com.json.sobremesa.app_json;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sobremesa on 09/07/2015.
 */
public class Categories //implements Serializable
{
    /*
    [category] => Array
        (
            [spain] => Array
                (
                    [ligas] => Array
                        (
                            [0] => Array
                                (
                                    [id] => 1
                                    [league_id] => 15373
                                    [order] => 1
                                    [year] => 2016
                                    [c_pending] =>
                                    [name] => Liga BBVA
                                    [country] =>
                                    [continent] => eu
                                    [current_round] => 1
                                    [total_group] => 1
                                    [total_rounds] => 38
                                    [flag] => http://thumb.resfu.com/media/img/flags/st3/large/es.png?size=100x65c&ext=png&lossy=1&1
                                    [logo] => http://thumb.resfu.com/media/img/league_logos/primera.png?size=120x&ext=png&lossy=1&1
                                    [phase] =>
                                    [playoff] => 0
                                    [group_code] => 1
                                    [legend] => Array
                                        (
                                        )

                                    [legend_dict] => Array
                                        (
                                        )

                                    [leader] => Array
                                        (
                                            [shield] => http://thumb.resfu.com/img_data/escudos/medium/347.jpg?size=90x&ext=png&lossy=1&1
                                        )

                                )

     */
   // private static final long serialVersionUID = 1566632478541564056L;
    //Atributos
    private String id;
    private String league_id;
    private String order;
    private String year;
    private String c_pending;
    private String name;
    private String country;
    private String continent;
    private String current_round;
    private String total_group;
    private String total_rounds;
    private String flag;
    private String logo;
    private String phase;
    private String playoff;
    private String group_code;
    //Arrays
    private ArrayList<String> legend;
    private ArrayList<String> legend_dict;
    private ArrayList<String> leader;


    public Categories(){}

    public Categories(String i,
                      String li,
                      String or,
                      String ye,
                      String cp,
                      String na,
                      String co,
                      String cn,
                      String cu,
                      String tg,
                      String tr,
                      String fl,
                      String gp,
                      String ph,
                      String pl,
                      String lo,
                      ArrayList<String> le,
                      ArrayList<String> ld,
                      ArrayList<String> lr)
    {
        this.id = i;
        this.league_id = li;
        this.order = or;
        this.year = ye;
        this.c_pending = cp;
        this.name = na;
        this.country = co;
        this.continent = cn;
        this.current_round = cu;
        this.total_group = tg;
        this.total_rounds = tr;
        this.flag = fl;
        this.group_code = gp;
        this.logo = lo;
        this.phase = ph;
        this.playoff = pl;
        this.legend = le;
        this.legend_dict = ld;
        this.leader = lr;

    }
    //Getters
    public String getId()
    {
        return id;
    }
    public String getLeagueId()
    {
        return league_id;
    }
    public String getOrder()
    {
        return order;
    }
    public String getYear()
    {
        return year;
    }
    public String getCPending()
    {
        return c_pending;
    }
    public String getName()
    {
        return name;
    }
    public String getCountry()
    {
        return country;
    }
    public String getContinent()
    {
        return continent;
    }
    public String getCurrentRound()
    {
        return current_round;
    }
    public String getTotalGroup()
    {
        return total_group;
    }
    public String getTotalRounds()
    {
        return total_rounds;
    }
    public String getFlag()
    {
        return flag;
    }
    public String getGroupCode()
    {
        return group_code;
    }
    public String getPhase()
    {
        return phase;
    }
    public String getPlayoff()
    {
        return playoff;
    }
    public String getLogo()
    {
        return logo;
    }
    public ArrayList<String> getLegend()
    {
        return legend;
    }
    public ArrayList<String> getLegendDict()
    {
        return legend_dict;
    }
    public ArrayList<String> getLeader()
    {
        return leader;
    }


    //Setters
    public void setId(String i)
    {
        this.id = i;
    }
    public void setLeagueId(String le)
    {
        this.league_id = le;
    }
    public void setOrder(String or)
    {
        this.order = or;
    }
    public void setYear(String ye)
    {
        this.year = ye;
    }
    public void setName(String na)
    {
        this.name = na;
    }
    public void setCPending(String cp)
    {
        this.c_pending = cp;
    }
    public void setCountry(String co)
    {
        this.country = co;
    }
    public void setContinent(String co)
    {
        this.continent = co;
    }
    public void setCurrentRound(String cr)
    {
        this.current_round = cr;
    }
    public void setTotalGroup(String tg)
    {
        this.total_group = tg;
    }
    public void setTotalRounds(String tr)
    {
        this.total_rounds = tr;
    }
    public void setFlag(String fl)
    {
        this.flag = fl;
    }
    public void setGroupCode(String gp)
    {
        this.group_code = gp;
    }
    public void setPlayoff(String pl)
    {
        this.playoff = pl;
    }
    public void setPhase(String ph)
    {
        this.phase = ph;
    }
    public void setLogo(String lo)
    {
        this.logo = lo;
    }
    public void setLegend(ArrayList<String> le)
    {
        this.legend = le;
    }
    public void setLegendDict(ArrayList<String> ld)
    {
        this.legend_dict = ld;
    }
    public void setLeader(ArrayList<String> le)
    {
        this.leader = le;
    }




}
