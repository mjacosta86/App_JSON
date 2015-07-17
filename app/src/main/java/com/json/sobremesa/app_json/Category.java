package com.json.sobremesa.app_json;

import java.io.Serializable;

/**
 * Created by sobremesa on 16/07/2015.
 */
public class Category implements Serializable
{
    /*
    [category_id] => 1
                    [team_id] => 214628
                    [league_id] => 15373
                    [cat_name] => Liga BBVA
                    [year] => 2016
                    [tables] => 1
                    [current_round] => 1
                    [group_code] => 1
                    [total_group] => 1
                    [active_year] => 2016
                    [alias] => primera
                    [table_suffix] =>
                    [completeName] => Liga BBVA
                    [completeAlias] => primera
     */
    private static final long serialVersionUID = 1566632608541564056L;
    private String category_id;
    private String team_id;
    private String league_id;
    private String cat_name;
    private String year;
    private String tables;
    private String current_round;
    private String group_code;
    private String total_group;
    private String active_year;
    private String alias;
    private String table_suffix;
    private String complete_name;
    private String complete_alias;

    public Category(){}

    public Category(String category_id, String team_id, String league_id, String cat_name, String year, String tables, String current_round, String group_code, String total_group, String active_year, String alias, String table_suffix, String complete_name, String complete_alias) {
        this.category_id = category_id;
        this.team_id = team_id;
        this.league_id = league_id;
        this.cat_name = cat_name;
        this.year = year;
        this.tables = tables;
        this.current_round = current_round;
        this.group_code = group_code;
        this.total_group = total_group;
        this.active_year = active_year;
        this.alias = alias;
        this.table_suffix = table_suffix;
        this.complete_name = complete_name;
        this.complete_alias = complete_alias;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getCurrent_round() {
        return current_round;
    }

    public void setCurrent_round(String current_round) {
        this.current_round = current_round;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getTotal_group() {
        return total_group;
    }

    public void setTotal_group(String total_group) {
        this.total_group = total_group;
    }

    public String getActive_year() {
        return active_year;
    }

    public void setActive_year(String active_year) {
        this.active_year = active_year;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTable_suffix() {
        return table_suffix;
    }

    public void setTable_suffix(String table_suffix) {
        this.table_suffix = table_suffix;
    }

    public String getComplete_name() {
        return complete_name;
    }

    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }

    public String getComplete_alias() {
        return complete_alias;
    }

    public void setComplete_alias(String complete_alias) {
        this.complete_alias = complete_alias;
    }
}
