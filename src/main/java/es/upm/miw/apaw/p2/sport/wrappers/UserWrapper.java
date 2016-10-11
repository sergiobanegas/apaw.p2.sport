package es.upm.miw.apaw.p2.sport.wrappers;

public class UserWrapper {
    private int id;

    private String nick;

    private String email;

    public UserWrapper() {
    }

    public UserWrapper(int id, String nick, String email) {
        this.setId(id);
        this.setNick(nick);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"nick\":\"" + nick + "\",\"email\":\"" + email + "\"}";
    }

}
