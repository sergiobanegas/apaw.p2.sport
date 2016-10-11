package es.upm.miw.apaw.p2.sport.exceptions;

public class InvalidSportNameException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "El valor del voto debe estar entre 0 y 10";

	public InvalidSportNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidSportNameException() {
		this("");
	}

}
