package project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import project.controllers.UserDTO;

@Entity
@Table(name = "users")
public class User implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	
	public User() {
		
	}
	
	public User(Integer id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password= password;
	}

		public static User fromDTO(UserDTO userDTO) {
			User user = new User();
			user.setUserName(userDTO.getUserName()); 
			user.setPassword(userDTO.getPassword());
			return user;
		}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}
