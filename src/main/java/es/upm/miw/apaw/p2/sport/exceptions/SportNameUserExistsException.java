package es.upm.miw.apaw.p2.sport.exceptions;

public class SportNameUserExistsException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public SportNameUserExistsException(String userNick, String sportName) {
        super("El usuario con nick '" + userNick + "' ya practica el deporte con nombre '" + sportName + "'");
    }

    public SportNameUserExistsException() {
        this("", "");
    }
}
