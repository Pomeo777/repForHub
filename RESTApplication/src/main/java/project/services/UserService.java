package project.services;

import project.entity.User;

public interface UserService {

	boolean createUser(User user);
	User get(int id);
	void updateUser(User user);
	void delete(int id);
	
}
