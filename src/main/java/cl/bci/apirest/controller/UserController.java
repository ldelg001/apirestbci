package cl.bci.apirest.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.apirest.exception.EmailNullException;
import cl.bci.apirest.exception.FormatEmailException;
import cl.bci.apirest.exception.NameNullException;
import cl.bci.apirest.exception.PasswordInvalidException;
import cl.bci.apirest.exception.PasswordNullException;
import cl.bci.apirest.exception.RegisteredMailException;
import cl.bci.apirest.model.entity.Phones;
import cl.bci.apirest.model.entity.User;
import cl.bci.apirest.security.UserAuthentication;
import cl.bci.apirest.service.PhonesService;
import cl.bci.apirest.service.UserService;
import cl.bci.apirest.util.TokenValidate;
import cl.bci.apirest.util.UserExpone;
import cl.bci.apirest.util.Validate;

/**
 * Clase controlador que expone la api.
 * 
 * @author Leonel Delgado.
 * @version 1.0
 */
@RestController
//@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PhonesService phonesService;

	@PostMapping(value = "/user")
	public UserAuthentication login(@RequestBody String cadenaIngreso) {
		
		JSONObject userJson = new JSONObject(cadenaIngreso);
		
		String name = userJson.getString("name");
		String password = userJson.getString("password");
		String token = TokenValidate.getJWTToken(name);
		UserAuthentication user = new UserAuthentication();
		user.setName(name);
		user.setPassword(password);
		user.setToken(token);		
		return user;
		
	}
	
	
	@RequestMapping(value = "/crearuser", method = RequestMethod.POST)
	public UserExpone saveUser(@RequestBody String cadenaIngreso) throws FormatEmailException, EmailNullException,
			RegisteredMailException, NameNullException, PasswordInvalidException, PasswordNullException {

		JSONObject userJson = new JSONObject(cadenaIngreso);

		String name = userJson.getString("name");

		if (name == null || name.isEmpty()) {
			throw new NameNullException();
		}

		LocalDateTime create = LocalDateTime.now();
		
		UserExpone userExpone = new UserExpone();
		
		// Consulta si ya existe usuario
		User userAux = userService.findUser(name);

		// Usuario no existe,por tanto se crea.
		if (userAux == null)
		{

			String token = TokenValidate.getJWTToken(name);

			String email = userJson.getString("email");

			if (email == null || email.isEmpty()) {
				throw new EmailNullException();
			}

			if (!Validate.valiteEmail(email)) {
				throw new FormatEmailException(email);
			}

			if (userService.existeEmailNewUser(email)) {
				throw new RegisteredMailException(email);
			}

			String password = userJson.getString("password");

			if (password == null || password.isEmpty()) {
				throw new PasswordNullException();
			}

			if (!Validate.valitePassword(password)) {
				throw new PasswordInvalidException(password);
			}

			User user = new User();

			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			
			user.setDatecreated(Timestamp.valueOf(create));
			user.setDatelast_login(Timestamp.valueOf(create));
			user.setIsactive(true);
			user.setToken(token);

			userAux = userService.save(user);

			userExpone = Validate.setUserExpone(userAux);
			
			
			JSONArray phones = (JSONArray) userJson.get("phones");

			for (int i = 0; i < phones.length(); i++) {
				String number = phones.getJSONObject(i).getString("number");
				String citycode = phones.getJSONObject(i).getString("citycode");
				String contrycode = phones.getJSONObject(i).getString("contrycode");

				System.out.println(number + " " + citycode + " " + contrycode);

				Phones phone = new Phones();
				if (!number.isEmpty()) {
					phone.setNumber(Long.parseLong(number));
				}
				if (!citycode.isEmpty()) {
					phone.setCitycode(Long.parseLong(citycode));
				}
				if (!contrycode.isEmpty()) {
					phone.setContrycode(Long.parseLong(contrycode));
				}

				phone.setUser(userAux);
				phonesService.save(phone);
			}
		}
		else
		{
			
			String email = userJson.getString("email");

			if (email == null || email.isEmpty()) {
				throw new EmailNullException();
			}

			if (!Validate.valiteEmail(email)) {
				throw new FormatEmailException(email);
			}

			if (userService.existeEmailUserSave(email, name)) {
				throw new RegisteredMailException(email);
			}

			String password = userJson.getString("password");

			if (password == null || password.isEmpty()) {
				throw new PasswordNullException();
			}

			if (!Validate.valitePassword(password)) {
				throw new PasswordInvalidException(password);
			}
			boolean updateUser = false;
			
			if (!userAux.getEmail().equals(email))
			{
				userAux.setEmail(email);
				updateUser = true;
			}
			if (!userAux.getPassword().equals(password))
			{
				userAux.setPassword(password);
				updateUser = true;
			}
			
			if (updateUser)
			{
				userAux.setDatemodified(Timestamp.valueOf(create));
			}
			else
			{
				userAux.setDatelast_login(Timestamp.valueOf(create));
			}
			
			userService.update(userAux);

			userExpone = Validate.setUserExpone(userAux);
			
			
		}
		return userExpone;

	}


}
