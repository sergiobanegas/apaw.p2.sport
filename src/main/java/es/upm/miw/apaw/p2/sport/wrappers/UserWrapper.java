package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.List;

public class UserWrapper {
    private int id;

    private String nick;

    private String email;

    private List<SportWrapper> sports;

    public UserWrapper() {
    }

    public UserWrapper(int id, String nick, String email, List<SportWrapper> sports) {
        this.setId(id);
        this.setNick(nick);
        this.setEmail(email);
        this.setSports(sports);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SportWrapper> getSports() {
        return sports;
    }

    public String getEmail() {
        return email;
    }

    public String getNick() {
        return nick;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setSports(List<SportWrapper> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"nick\":\"" + nick + "\",\"email\":\"" + email + "\",\"sports\":\"" + sports + "\"}";
    }

}
