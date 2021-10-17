package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class UserNotEnabledException extends Exception{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1098517291727808788L;

	public UserNotEnabledException() {
		super(IMessages.USUARIO_INABILITADO);
	} 
	
	public UserNotEnabledException(String detail) {
		super(IMessages.USUARIO_INABILITADO + ". " + detail);
	}

}