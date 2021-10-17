package cl.bci.apirest.util;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Clase que expone respuesta al usuario.
 * @author ldelgado
 *
 */
public class UserExpone {

	private UUID iduser;
	
	private String name;
	private String email;
	private String password;
	private Timestamp datecreated;
	private Timestamp datemodified;
	private Timestamp datelast_login;
	private String token;
	private boolean isactive;
	
	public UUID getIduser() {
		return iduser;
	}

	public void setIduser(UUID iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public Timestamp getDatemodified() {
		return datemodified;
	}

	public void setDatemodified(Timestamp datemodified) {
		this.datemodified = datemodified;
	}

	public Timestamp getDatelast_login() {
		return datelast_login;
	}

	public void setDatelast_login(Timestamp datelast_login) {
		this.datelast_login = datelast_login;
	}

	public boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
