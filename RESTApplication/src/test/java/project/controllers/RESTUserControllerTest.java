package project.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import project.entity.User;
import project.services.UserDAOServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class RESTUserControllerTest {

	
	@Mock
	private UserDAOServiceImpl userDAOServiceImpl;
	@InjectMocks
	RESTUserController restUsController;

	
	@Test
	public void testCreateUser() {
		//when(userDAOServiceImpl.post(new User())).thenReturn(true);
		User us = new User();
	restUsController.createUser(us);
	verify(userDAOServiceImpl).createUser(us);
	}
	
	
	@Test 
	public void  testGetUser() {
		when(userDAOServiceImpl.get(12)).thenReturn( User.fromDTO(new UserDTO("adad", "sdaczvcsf")));
		restUsController.getUser(12);
		verify(userDAOServiceImpl).get(12);
		
	}
	

}
