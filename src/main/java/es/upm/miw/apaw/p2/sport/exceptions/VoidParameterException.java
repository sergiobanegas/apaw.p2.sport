package es.upm.miw.apaw.p2.sport.exceptions;

public class VoidParameterException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "No se ha introducido ningún parámetro en el campo ";

    public VoidParameterException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }

    public VoidParameterException() {
        this("");
    }

}
