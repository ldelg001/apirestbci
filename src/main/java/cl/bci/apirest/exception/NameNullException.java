package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class NameNullException extends Exception{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -2970293472334493618L;

	public NameNullException() {
		super(IMessages.NOMBRE_NO_INGRESADO);
	} 
	
	public NameNullException(String detail) {
		super(IMessages.NOMBRE_NO_INGRESADO);
	}

}
