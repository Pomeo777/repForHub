package project.controllers;

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
	
	@Autowired
	private UserDAOServiceImpl userDAOServiceImpl;
	
	
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	public User getUser(@PathVariable("id") int id){
		System.out.println("into get");
		return  userDAOServiceImpl.get(id); 
	}

	
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
	public void createUser(@RequestBody User user) {
		userDAOServiceImpl.createUser(user);
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
