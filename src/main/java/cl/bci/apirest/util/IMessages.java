package cl.bci.apirest.util;

/**
 * Interfaz que maneja descripciones de mensajes.
 * @author ldelgado
 *
 */
public interface IMessages {

	static final String CORREO_INVALIDO = "Formato de correo invalido";
	static final String CORREO_REGISTRADO = "El correo ya registrado";
	static final String CORREO_NO_INGRESADO = "Correo no ingresado";
	static final String NOMBRE_NO_INGRESADO = "Nombre no ingresado";
	static final String CLAVE_NO_INGRESADO = "Clave no ingresada";
	static final String CLAVE_INVALIDO = "La clave debe tener una letra Mayuscula, letras minúsculas, y dos numeros";
	static final String PETICION_PROHIBIDA = "La peticion esta prohibida";
	static final String USUARIO_INABILITADO = "Usuario no habilitado";
}
