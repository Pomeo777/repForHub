package project.repository;

import java.util.List;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import project.entity.User;


@Repository
public interface UsersCrudRepository  extends CrudRepository<User, Integer>{

	List<User> findByUserNameAndPassword(String userName, String password); 
}
