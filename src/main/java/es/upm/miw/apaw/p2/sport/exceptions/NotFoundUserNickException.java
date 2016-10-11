package es.upm.miw.apaw.p2.sport.exceptions;

public class NotFoundUserNickException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "No existe un usuario con el nick ";

	public NotFoundUserNickException(String detail) {
		super(DESCRIPTION + "'" + detail+"'");
	}

	public NotFoundUserNickException() {
		this("");
	}
}
