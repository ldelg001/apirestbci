package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class ForbiddenException extends Exception{
	

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -4937111376165165611L;

	public ForbiddenException() {
		super(IMessages.PETICION_PROHIBIDA);
	} 
	
	public ForbiddenException(String detail) {
		super(IMessages.PETICION_PROHIBIDA + ". " + detail);
	}

}