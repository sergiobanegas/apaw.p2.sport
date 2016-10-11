package es.upm.miw.apaw.p2.sport.exceptions;

public class NotFoundSportNameException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El nombre del equipo no existe";

	public NotFoundSportNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundSportNameException() {
		this("");
	}
}
