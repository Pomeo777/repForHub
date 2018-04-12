package project.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.entity.User;
import project.repository.UsersCrudRepository;


@Service
public class UserDAOServiceImpl implements UserService  {
	
	static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	@Autowired
	UsersCrudRepository usersRepository;
	
	
	@Override
	public boolean createUser(User user) {
		log.debug("post method");
		List<User> usersList = usersRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(usersList.size() > 0) {
			log.debug("same user is in db");
			return  false;
		}else {
		usersRepository.save(user);
		log.debug("user was seved");
		return true;
		}
	}

	@Override
	public User get(int id) {
		log.debug("get method");
		return usersRepository.findOne(id);	
	}
	
	@Override
	public void updateUser(User user) {
		log.debug("put method");
		usersRepository.save(user);
		
	}

	@Override
	public void delete(int id) {
		log.debug("delete method");
		usersRepository.delete(id);
		
	}

	
}
