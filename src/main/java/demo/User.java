package demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity(name="users") // POJO
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsers;
	@Column(name="userName", length=45, nullable= false)
	private String userName;
	@Column(name="password", length=45, nullable= false)
	private String password;
	// alt shif s r
	public Integer getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(Integer idUsers) {
		this.idUsers = idUsers;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return userName + password;
	}
}
