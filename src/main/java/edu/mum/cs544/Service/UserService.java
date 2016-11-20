package edu.mum.cs544.Service;

import java.util.List;

import edu.mum.cs544.Domain.User;

public interface UserService {

	public void save(User user);
	public List<User> findAll();
	public User findByUsername(String username);
 }
