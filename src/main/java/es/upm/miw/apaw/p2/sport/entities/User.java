package es.upm.miw.apaw.p2.sport.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;

    private String nick;

    private String email;

    private List<Sport> sports;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
        this.sports=new ArrayList<Sport>();
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }

    public boolean hasSport(String sportName) {
        for (Sport sportUser : sports) {
            if (sportUser.getName() == sportName) {
                return true;
            }
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }
}
