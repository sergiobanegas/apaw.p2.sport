package es.upm.miw.apaw.p2.sport.exceptions;

public class InvalidUserFieldException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Nombre y email del usuario no encontrados";

	public InvalidUserFieldException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserFieldException() {
		this("");
	}

}
