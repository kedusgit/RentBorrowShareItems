package edu.mum.cs544.Domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "cs544db")
public class UserAutentication implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String username;
	private String password;
	private String verifyPassword;
	private String firstName;
	private String lastName;
	private Integer gender;
	private String email;
	private boolean enabled;
	private List<Authorities> authoritieses;

	public UserAutentication() {
	}

	public UserAutentication(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public UserAutentication(String username, String password, String verifyPassword, String firstName, String lastName,
			Integer gender, String email, boolean enabled, List<Authorities> authoritieses) {
		this.username = username;
		this.password = password;
		this.verifyPassword = verifyPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.enabled = enabled;
		this.authoritieses = authoritieses;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "verifyPassword")
	public String getVerifyPassword() {
		return this.verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	@Column(name = "firstName", length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "enabled", nullable = false, columnDefinition = "BIT", length = 1)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(List<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

}
