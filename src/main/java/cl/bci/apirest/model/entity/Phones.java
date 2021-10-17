package cl.bci.apirest.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad Telefonos.
 * @author ldelgado
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="phones")
public class Phones implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idphone;
	private Long number;
	private Long citycode;
	private Long contrycode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iduser")
	private User user;

	public Long getIdphone() {
		return idphone;
	}

	public void setIdphone(Long idphone) {
		this.idphone = idphone;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getCitycode() {
		return citycode;
	}

	public void setCitycode(Long citycode) {
		this.citycode = citycode;
	}

	public Long getContrycode() {
		return contrycode;
	}

	public void setContrycode(Long contrycode) {
		this.contrycode = contrycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
