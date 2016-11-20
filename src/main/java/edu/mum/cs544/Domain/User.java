package edu.mum.cs544.Domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.Email;



@Entity
@Table(name = "user", catalog = "cs544db")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Integer userId;
	
	
	private String username;
	private String password;
	private String verifyPassword;
	@NotNull(message="first name required")
	private String firstName;
	@NotNull(message="last name required")
	private String lastName;
	private Integer gender;
	@NotNull(message="email can not be empty")
	@Email(message="email format not matched")
	private String email;
	private boolean enabled;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Authorities> authoritieses;
	@Embedded
	private Address address;
	
	
	@OneToMany(mappedBy="owner")
	private List<Item> items;

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, String verifyPassword, String firstName, String lastName,
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
	
	public List<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(List<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

	
	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
