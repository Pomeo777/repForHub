package project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.entity.User;
import project.services.UserDAOServiceImpl;




@RestController
public class RESTUserController {
	
	static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	//Inject Services class for work with DB
	@Autowired
	private UserDAOServiceImpl userDAOServiceImpl;
	
	/*
	 * method for add Users in DB by request - POST
	 * @param User - the object of class User. Contains in @RequestBody.
	 * 
	 * 
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void createUser(@RequestBody User user) {
		log.debug("In method createUser. User : {}", user.toString());
		boolean result = userDAOServiceImpl.createUser(user);
		log.debug("result of saving user - {}", result);
	
	}

	
	/*
	 * the comments from next three methods //TODO
	 * 
	 * 
	 * 
	 */
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	public User getUser(@PathVariable("id") int id){
		return  userDAOServiceImpl.get(id); 
	}

	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE})
	public void deleteUser(@PathVariable("id") int id) {
		userDAOServiceImpl.delete(id);
	}
	

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
	public void updateUser(@RequestBody User user, @PathVariable("id") int id) {
		User usr = new User();
		usr.setId(id);
		userDAOServiceImpl.updateUser(usr);
	}
}
