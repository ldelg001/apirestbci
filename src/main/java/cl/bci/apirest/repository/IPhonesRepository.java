package cl.bci.apirest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.bci.apirest.model.entity.Phones;

/**
 * IPhonesRepository: interfaz persistencia de entidad telefonos. 
 * @author ldelgado.
 *
 */
@Repository
public interface IPhonesRepository extends JpaRepository<Phones, Serializable>{

	 
	
}
