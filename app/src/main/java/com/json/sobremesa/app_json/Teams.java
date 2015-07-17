package com.json.sobremesa.app_json;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sobremesa on 09/07/2015.
 */
public class Teams implements Serializable
{
    /*
    [id] => 1617
            [nameShow] => MÃ¡laga
            [basealias] => malaga
            [CountryCode] => es
            [location] =>
            [basename] => MÃ¡laga
            [stadium] => La Rosaleda
            [short_name] => MAL
            [managerNow] => Javi Gracia
            [seats] => 30377
            [website] => http://www.malagacf.com/
            [yearFoundation] => 1948
            [city] =>
            [address] => Avenida de la Palmilla / Paseo de Martiricos
            [phone] => (+34) 952.61.42.10
            [fax] => (+34) 952.61.37.37
            [chairman] => Abdullah Ben Nasser Al Thanis
            [fullName] => MÃ¡laga Club de FÃºtbol, S. A. D.
            [yearlyBudget] => 25700000
            [info] =>
            [fans] => 26503
            [typefield] => Natural
            [ctype] => 1
            [yearBuilt] => 1941
            [size] => 105 x 68 metros
            [historical] => Copa Intertoto de la UEFA 2002
            [comments] => 83678
            [color1] => #1538E8
            [color2] => #FFFFFF
            [kit_home] => Espana/Liga_BBVA/malaga_home
            [kit_away] => Espana/Liga_BBVA/malaga_away
            [kit_third] =>
            [twitter] => @MalagaCF
            [twitter_coach] =>
            [twitter_president] => @ANAALThani
            [twitter_b] =>
            [qod] => 86
            [pod] => 1163
            [last_change] => 2014-08-05 17:43:10
            [relations] => 36
            [relatedImg] =>
            [basealias_old] =>
            [patrocinador] => Unesco
            [patrocinador_b] => Porsche
            [team_b] => MÃ¡laga B
            [proveedor] => Nike
            [lugar_entrenamiento] =>  La Academia del MÃ¡laga Club de FÃºtbol
            [repeat_year] =>
            [no_year] => 1994,1995,1996,1997,1998
            [error_date] => 2013-07-29 12:47:14
            [fifaId] => 13
            [main_image] => 1
            [type_team] => 0
            [active_relations] => 2
            [match_played] => 704
            [match_to_play] => 750
            [localidad] =>
            [geonameid] => 2514256
            [hid] => 175
            [hid_B] => 0
            [translate] => 0
            [email] =>
            [Name] => EspaÃ±a
            [Continent] => Europa
            [Region] => Europa del Sur
            [shield] => http://thumb.resfu.com/img_data/escudos/medium/1617.jpg?size=120x&ext=png&lossy=1&1
            [img_stadium] => http://thumb.resfu.com/img_data/estadios/original/1617.jpg?size=640x460&ext=png&lossy=1&1
     */
    private static final long serialVersionUID = 1566632448541564056L;
    //Atributos
    private String id;
    private String name_show;
    private String basealias;
    private String country_code;
    private String location;
    private String basename;
    private String stadium;
    private String short_name;
    private String manager_now;
    private String seats;
    private String website;
    private String year_foundation;
    private String city;
    private String address;
    private String phone;
    private String fax;
    private String chairman;
    private String full_name;
    private String yearlyBudget;
    private String info;
    private String fans;
    private String typefield;
    private String ctype;
    private String year_built;
    private String size;
    private String historical;
    private String comments;
    private String color1;
    private String color2;
    private String kit_home;
    private String kit_away;
    private String kit_third;
    private String twitter;
    private String twitter_coach;
    private String twitter_president;
    private String twitter_b;
    private String god;
    private String pod;
    private String last_change;
    private String relations;
    private String relatedImg;
    private String basealias_old;
    private String patrocinador;
    private String patrocinador_b;
    private String team_b;
    private String proveedor;
    private String lugar_entrenamiento;
    private String repeat_year;
    private String no_year;
    private String error_date;
    private String fifaId;
    private String main_image;
    private String type_name;
    private String active_played;
    private String match_to_play;
    private String localida;
    private String geonameid;
    private String hid;
    private String hid_B;
    private String translate;
    private String email;
    private String name;
    private String continent;
    private String region;
    private String shield;
    private String img_stadium;
    private String position;
    private String t_squad;
    private String has_news;

    private ArrayList<Category> categories;
    private ArrayList<Competitions> competitions;
    private ArrayList<Tables> tables;
    private ArrayList<Players> squad;


    public Teams(){}

    public Teams(String id, String name_show, String basealias, String country_code, String location, String basename, String stadium, String short_name, String manager_now, String seats, String website, String year_foundation, String city, String address, String phone, String fax, String chairman, String full_name, String yearlyBudget, String info, String fans, String typefield, String ctype, String year_built, String size, String historical, String comments, String color1, String color2, String kit_home, String kit_away, String kit_third, String twitter, String twitter_coach, String twitter_president, String god, String twitter_b, String pod, String last_change, String relations, String relatedImg, String basealias_old, String patrocinador, String patrocinador_b, String team_b, String proveedor, String lugar_entrenamiento, String repeat_year, String no_year, String error_date, String fifaId, String main_image, String type_name, String active_played, String match_to_play, String localida, String geonameid, String hid, String hid_B, String translate, String email, String name, String region, String continent, String shield, String img_stadium, String position, String t_squad, String has_news, ArrayList<Category> categories, ArrayList<Competitions> competitions, ArrayList<Tables> tables, ArrayList<Players> squad) {
        this.id = id;
        this.name_show = name_show;
        this.basealias = basealias;
        this.country_code = country_code;
        this.location = location;
        this.basename = basename;
        this.stadium = stadium;
        this.short_name = short_name;
        this.manager_now = manager_now;
        this.seats = seats;
        this.website = website;
        this.year_foundation = year_foundation;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.chairman = chairman;
        this.full_name = full_name;
        this.yearlyBudget = yearlyBudget;
        this.info = info;
        this.fans = fans;
        this.typefield = typefield;
        this.ctype = ctype;
        this.year_built = year_built;
        this.size = size;
        this.historical = historical;
        this.comments = comments;
        this.color1 = color1;
        this.color2 = color2;
        this.kit_home = kit_home;
        this.kit_away = kit_away;
        this.kit_third = kit_third;
        this.twitter = twitter;
        this.twitter_coach = twitter_coach;
        this.twitter_president = twitter_president;
        this.god = god;
        this.twitter_b = twitter_b;
        this.pod = pod;
        this.last_change = last_change;
        this.relations = relations;
        this.relatedImg = relatedImg;
        this.basealias_old = basealias_old;
        this.patrocinador = patrocinador;
        this.patrocinador_b = patrocinador_b;
        this.team_b = team_b;
        this.proveedor = proveedor;
        this.lugar_entrenamiento = lugar_entrenamiento;
        this.repeat_year = repeat_year;
        this.no_year = no_year;
        this.error_date = error_date;
        this.fifaId = fifaId;
        this.main_image = main_image;
        this.type_name = type_name;
        this.active_played = active_played;
        this.match_to_play = match_to_play;
        this.localida = localida;
        this.geonameid = geonameid;
        this.hid = hid;
        this.hid_B = hid_B;
        this.translate = translate;
        this.email = email;
        this.name = name;
        this.region = region;
        this.continent = continent;
        this.shield = shield;
        this.img_stadium = img_stadium;
        this.position = position;
        this.t_squad = t_squad;
        this.has_news = has_news;
        this.categories = categories;
        this.competitions = competitions;
        this.tables = tables;
        this.squad = squad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_show() {
        return name_show;
    }

    public void setName_show(String name_show) {
        this.name_show = name_show;
    }

    public String getBasealias() {
        return basealias;
    }

    public void setBasealias(String basealias) {
        this.basealias = basealias;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getManager_now() {
        return manager_now;
    }

    public void setManager_now(String manager_now) {
        this.manager_now = manager_now;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYear_foundation() {
        return year_foundation;
    }

    public void setYear_foundation(String year_foundation) {
        this.year_foundation = year_foundation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getYearlyBudget() {
        return yearlyBudget;
    }

    public void setYearlyBudget(String yearlyBudget) {
        this.yearlyBudget = yearlyBudget;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getTypefield() {
        return typefield;
    }

    public void setTypefield(String typefield) {
        this.typefield = typefield;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getYear_built() {
        return year_built;
    }

    public void setYear_built(String year_built) {
        this.year_built = year_built;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHistorical() {
        return historical;
    }

    public void setHistorical(String historical) {
        this.historical = historical;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getKit_home() {
        return kit_home;
    }

    public void setKit_home(String kit_home) {
        this.kit_home = kit_home;
    }

    public String getKit_away() {
        return kit_away;
    }

    public void setKit_away(String kit_away) {
        this.kit_away = kit_away;
    }

    public String getKit_third() {
        return kit_third;
    }

    public void setKit_third(String kit_third) {
        this.kit_third = kit_third;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitter_coach() {
        return twitter_coach;
    }

    public void setTwitter_coach(String twitter_coach) {
        this.twitter_coach = twitter_coach;
    }

    public String getTwitter_president() {
        return twitter_president;
    }

    public void setTwitter_president(String twitter_president) {
        this.twitter_president = twitter_president;
    }

    public String getTwitter_b() {
        return twitter_b;
    }

    public void setTwitter_b(String twitter_b) {
        this.twitter_b = twitter_b;
    }

    public String getGod() {
        return god;
    }

    public void setGod(String god) {
        this.god = god;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getLast_change() {
        return last_change;
    }

    public void setLast_change(String last_change) {
        this.last_change = last_change;
    }

    public String getRelatedImg() {
        return relatedImg;
    }

    public void setRelatedImg(String relatedImg) {
        this.relatedImg = relatedImg;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getBasealias_old() {
        return basealias_old;
    }

    public void setBasealias_old(String basealias_old) {
        this.basealias_old = basealias_old;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getPatrocinador_b() {
        return patrocinador_b;
    }

    public void setPatrocinador_b(String patrocinador_b) {
        this.patrocinador_b = patrocinador_b;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public String getLugar_entrenamiento() {
        return lugar_entrenamiento;
    }

    public void setLugar_entrenamiento(String lugar_entrenamiento) {
        this.lugar_entrenamiento = lugar_entrenamiento;
    }

    public String getRepeat_year() {
        return repeat_year;
    }

    public void setRepeat_year(String repeat_year) {
        this.repeat_year = repeat_year;
    }

    public String getNo_year() {
        return no_year;
    }

    public void setNo_year(String no_year) {
        this.no_year = no_year;
    }

    public String getError_date() {
        return error_date;
    }

    public void setError_date(String error_date) {
        this.error_date = error_date;
    }

    public String getFifaId() {
        return fifaId;
    }

    public void setFifaId(String fifaId) {
        this.fifaId = fifaId;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getActive_played() {
        return active_played;
    }

    public void setActive_played(String active_played) {
        this.active_played = active_played;
    }

    public String getMatch_to_play() {
        return match_to_play;
    }

    public void setMatch_to_play(String match_to_play) {
        this.match_to_play = match_to_play;
    }

    public String getLocalida() {
        return localida;
    }

    public void setLocalida(String localida) {
        this.localida = localida;
    }

    public String getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(String geonameid) {
        this.geonameid = geonameid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHid_B() {
        return hid_B;
    }

    public void setHid_B(String hid_B) {
        this.hid_B = hid_B;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getImg_stadium() {
        return img_stadium;
    }

    public void setImg_stadium(String img_stadium) {
        this.img_stadium = img_stadium;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getT_squad() {
        return t_squad;
    }

    public void setT_squad(String t_squad) {
        this.t_squad = t_squad;
    }

    public String getHas_news() {
        return has_news;
    }

    public void setHas_news(String has_news) {
        this.has_news = has_news;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Competitions> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(ArrayList<Competitions> competitions) {
        this.competitions = competitions;
    }

    public ArrayList<Tables> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Tables> tables) {
        this.tables = tables;
    }

    public ArrayList<Players> getSquad() {
        return squad;
    }

    public void setSquad(ArrayList<Players> squad) {
        this.squad = squad;
    }
}
