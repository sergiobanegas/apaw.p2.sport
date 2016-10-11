package es.upm.miw.apaw.p2.sport.wrappers;

public class UserNickEmailWrapper {

    private String nick;

    private String email;

    public UserNickEmailWrapper() {
    }

    public UserNickEmailWrapper(String nick, String email) {
        this.setNick(nick);
        this.setEmail(email);
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
        return "{\"nick\":\"" + nick + "\",\"email\":\"" + email + "\"}";
    }

}
