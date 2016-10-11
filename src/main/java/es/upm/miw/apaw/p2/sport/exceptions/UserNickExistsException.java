package es.upm.miw.apaw.p2.sport.exceptions;

public class UserNickExistsException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "Ya existe un usuario con el nick ";

    public UserNickExistsException(String detail) {
        super(DESCRIPTION + "'" + detail + "'");
    }

    public UserNickExistsException() {
        this("");
    }
}
