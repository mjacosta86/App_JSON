package com.json.sobremesa.app_json;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sobremesa on 16/07/2015.
 */
public class Competitions implements Serializable
{
    /*
                            [id] => 1
                            [coef] => 76.000
                            [name] => Liga BBVA
                            [year] => 2016
                            [continent] => eu
                            [flag] => http://thumb.resfu.com/media/img/flags/st3/large/es.png?size=100x65c&ext=png&lossy=1&1
                            [logo] => http://thumb.resfu.com/media/img/league_logos/primera.png?size=120x&ext=png&lossy=1&1
                            [phases] => Array
     */
    private static final long serialVersionUID = 1866632448561564056L;
    private String id;
    private String coef;
    private String name;
    private String year;
    private String continent;
    private String flag;
    private String logo;
    private ArrayList<Competitions> phases;

    public Competitions(String id, String coef, String name, String year, String continent, String flag, String logo, ArrayList<Competitions> phases) {
        this.id = id;
        this.coef = coef;
        this.name = name;
        this.year = year;
        this.continent = continent;
        this.flag = flag;
        this.logo = logo;
        this.phases = phases;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ArrayList<Competitions> getPhases() {
        return phases;
    }

    public void setPhases(ArrayList<Competitions> phases) {
        this.phases = phases;
    }
}
