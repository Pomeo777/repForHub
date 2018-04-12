package project.services;

import project.entity.User;

/*
 * Interface which set our methods
 * 
 */

public interface UserService {

	boolean createUser(User user);
	User get(int id);
	void updateUser(User user);
	void delete(int id);
	
}
