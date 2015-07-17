package com.json.sobremesa.app_json;

import java.io.Serializable;

/**
 * Created by sobremesa on 09/07/2015.
 */
public class Players implements Serializable
{
    /*
    [squad] => Array
                (
                    [0] => Array
                        (
                            [id] => 109854
                            [nick] => A. Cousillas
                            [name] =>
                            [last_name] =>
                            [alias] => a-cousillas-109854
                            [role] => 1
                            [year] => 2016
                            [squadNumber] =>
                            [num] =>
                            [pos] =>
                            [idplayer] =>
                            [goals] =>
                            [reds] =>
                            [yellows] =>
                            [CountryCode] => AR
                            [image] => http://thumb.resfu.com/img_data/players/medium/109854.jpg?size=60x&ext=png&lossy=1&1
                        )
     */
    private static final long serialVersionUID = 1566632448541564056L;
    //Atributos
    private String id;
    private String nick;
    private String name;
    private String last_name;
    private String alias;
    private String role;
    private String year;
    private String squadNumber;
    private String num;
    private String pos;
    private String id_player;
    private String goals;
    private String reds;
    private String yellows;
    private String country_code;
    private String image;

    public Players(){}

    public Players(String id, String nick, String name, String last_name, String alias, String role, String year, String squadNumber, String num, String pos, String id_player, String goals, String reds, String yellows, String country_code, String image) {
        this.id = id;
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.alias = alias;
        this.role = role;
        this.year = year;
        this.squadNumber = squadNumber;
        this.num = num;
        this.pos = pos;
        this.id_player = id_player;
        this.goals = goals;
        this.reds = reds;
        this.yellows = yellows;
        this.country_code = country_code;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getReds() {
        return reds;
    }

    public void setReds(String reds) {
        this.reds = reds;
    }

    public String getYellows() {
        return yellows;
    }

    public void setYellows(String yellows) {
        this.yellows = yellows;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
