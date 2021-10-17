package cl.bci.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cl.bci.apirest.model.entity.User;
import cl.bci.apirest.repository.IUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private IUserRepository repository;
	
	@Test
	public void saveUser()
	{
		User user = new User();
		user.setName("Leonel Delgado");
		user.setEmail("ldelg001@gmail.cl");
		user.setPassword("Tuber12");
		LocalDateTime create = LocalDateTime.now();
		user.setDatecreated(Timestamp.valueOf(create));
		user.setIsactive(true);
		repository.save(user);
		repository.flush();
		
		assertEquals(1, repository.findAll().size()); 
		
	}
}
