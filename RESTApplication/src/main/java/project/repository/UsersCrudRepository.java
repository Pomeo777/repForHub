package project.repository;

import java.util.List;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import project.entity.User;

/*
 * Special SpringBoot interface which contains methods for work with database
 * 
 */

@Repository
public interface UsersCrudRepository  extends CrudRepository<User, Integer>{

	
	//creating a new  method which we need 
	List<User> findByUserNameAndPassword(String userName, String password); 
}
