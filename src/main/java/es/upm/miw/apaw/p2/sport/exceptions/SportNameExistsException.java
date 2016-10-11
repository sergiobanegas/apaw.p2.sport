package es.upm.miw.apaw.p2.sport.exceptions;

public class SportNameExistsException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "Ya existe un deporte con el nombre ";

	public SportNameExistsException(String detail) {
		super(DESCRIPTION + ": " + detail);
	}

	public SportNameExistsException() {
		this("");
	}
}
