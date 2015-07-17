package com.json.sobremesa.app_json;

import java.io.Serializable;

/**
 * Created by sobremesa on 16/07/2015.
 */
public class Tables implements Serializable
{
    /*
    [tables] => Array
                (
                    [0] => Array
                        (
                            [nameShow] => Athletic
                            [diff] => 100
                            [points] => 0
                            [gf] => 0
                            [ga] => 0
                            [win_h] => 0
                            [draw_h] => 0
                            [lose_h] => 0
                            [win_a] => 0
                            [draw_a] => 0
                            [lose_a] => 0
                            [team] => 214626
                            [league_id] => 15373
                            [round] => 1
                            [team_name] =>
                            [form] =>
                            [form_res] =>
                            [priority] => 0
                            [position] => 1
                            [teamId] => 347
                        )
     */

    private static final long serialVersionUID = 1566932448541564056L;
    private String nameShow;
    private String diff;
    private String points;
    private String gf;
    private String ga;
    private String win_h;
    private String draw_h;
    private String lose_h;
    private String win_a;
    private String draw_a;
    private String lose_a;
    private String team;
    private String league_id;
    private String round;
    private String team_name;
    private String form;
    private String form_res;
    private String priority;
    private String position;
    private String team_id;

    public Tables(){}

    public Tables(String nameShow, String diff, String points, String gf, String ga, String win_h, String draw_h, String lose_h, String win_a, String draw_a, String lose_a, String team, String league_id, String round, String team_name, String form, String form_res, String priority, String position, String team_id) {
        this.nameShow = nameShow;
        this.diff = diff;
        this.points = points;
        this.gf = gf;
        this.ga = ga;
        this.win_h = win_h;
        this.draw_h = draw_h;
        this.lose_h = lose_h;
        this.win_a = win_a;
        this.draw_a = draw_a;
        this.lose_a = lose_a;
        this.team = team;
        this.league_id = league_id;
        this.round = round;
        this.team_name = team_name;
        this.form = form;
        this.form_res = form_res;
        this.priority = priority;
        this.position = position;
        this.team_id = team_id;
    }

    public String getNameShow() {

        return nameShow;
    }

    public void setNameShow(String nameShow) {
        this.nameShow = nameShow;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public String getWin_h() {
        return win_h;
    }

    public void setWin_h(String win_h) {
        this.win_h = win_h;
    }

    public String getDraw_h() {
        return draw_h;
    }

    public void setDraw_h(String draw_h) {
        this.draw_h = draw_h;
    }

    public String getLose_h() {
        return lose_h;
    }

    public void setLose_h(String lose_h) {
        this.lose_h = lose_h;
    }

    public String getWin_a() {
        return win_a;
    }

    public void setWin_a(String win_a) {
        this.win_a = win_a;
    }

    public String getDraw_a() {
        return draw_a;
    }

    public void setDraw_a(String draw_a) {
        this.draw_a = draw_a;
    }

    public String getLose_a() {
        return lose_a;
    }

    public void setLose_a(String lose_a) {
        this.lose_a = lose_a;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getForm_res() {
        return form_res;
    }

    public void setForm_res(String form_res) {
        this.form_res = form_res;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
