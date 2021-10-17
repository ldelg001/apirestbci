package cl.bci.apirest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.bci.apirest.model.entity.User;

/**
 * IUserRepository: interfaz persistencia de entidad usuario. 
 * @author ldelgado.
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Serializable>{

	/**
	 * Obtiene usuario por email.
	 * @param email
	 * @return User
	 */
	public abstract User findByEmail(String email); 
	
	/**
	 * Obtiene Usuario por nombre.
	 * @param name
	 * @return User
	 */
	public abstract User findByName(String name); 
	 
	
	/**
	 * Obtiene Usuario por email y nombre.
	 * @param email
	 * @param name
	 * @return User
	 */
	@Query(value="SELECT * FROM user WHERE email =:email and name !=:name ", nativeQuery=true)
	public User existeEmailUserSave(String email, String name);
	 

}
