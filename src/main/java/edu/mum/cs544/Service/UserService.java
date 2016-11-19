package edu.mum.cs544.Service;

import java.util.List;

import edu.mum.cs544.Domain.UserAutentication;

public interface UserService {

	public void save(UserAutentication user);
	public List<UserAutentication> findAll();
	public UserAutentication findByUsername(String username);
 }
