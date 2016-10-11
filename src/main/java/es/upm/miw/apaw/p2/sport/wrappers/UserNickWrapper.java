package es.upm.miw.apaw.p2.sport.wrappers;

public class UserNickWrapper {

    private String nick;

    public UserNickWrapper() {
    }

    public UserNickWrapper(String nick) {
        this.setNick(nick);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "{\"nick\":\"" + nick + "\"}";
    }

}
