package es.upm.miw.apaw.p2.sport.exceptions;

public class NotFoundSportNameException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "No existe un equipo con el nombre ";

    public NotFoundSportNameException(String detail) {
        super(DESCRIPTION + "'" + detail + "'");
    }

    public NotFoundSportNameException() {
        this("");
    }
}
