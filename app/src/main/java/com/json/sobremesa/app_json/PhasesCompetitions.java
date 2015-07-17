package com.json.sobremesa.app_json;

import java.io.Serializable;

/**
 * Created by sobremesa on 16/07/2015.
 */
public class PhasesCompetitions implements Serializable
{
    /*
    (
                                            [id] => 1
                                            [group] => 1
                                            [type] => group
                                            [current_round] => 1
                                            [total_rounds] => 38
                                            [total_teams] => 20
                                            [is_current] => 1
                                        )
     */
    private static final long serialVersionUID = 1866632448541564056L;
    private String id;
    private String group;
    private String type;
    private String current_round;
    private String total_rounds;
    private String total_teams;
    private String is_current;

    public PhasesCompetitions(){}

    public PhasesCompetitions(String id, String group, String type, String current_round, String total_rounds, String total_teams, String is_current) {

        this.id = id;
        this.group = group;
        this.type = type;
        this.current_round = current_round;
        this.total_rounds = total_rounds;
        this.total_teams = total_teams;
        this.is_current = is_current;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrent_round() {
        return current_round;
    }

    public void setCurrent_round(String current_round) {
        this.current_round = current_round;
    }

    public String getTotal_rounds() {
        return total_rounds;
    }

    public void setTotal_rounds(String total_rounds) {
        this.total_rounds = total_rounds;
    }

    public String getTotal_teams() {
        return total_teams;
    }

    public void setTotal_teams(String total_teams) {
        this.total_teams = total_teams;
    }

    public String getIs_current() {
        return is_current;
    }

    public void setIs_current(String is_current) {
        this.is_current = is_current;
    }


}
