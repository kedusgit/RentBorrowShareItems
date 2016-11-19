package edu.mum.cs544.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.Domain.UserAutentication;

public interface UserRepository extends JpaRepository<UserAutentication, Integer> {

//	@Query("SELECT u FROM User u WHERE u.username =:username")
	UserAutentication findByUsername(String username);
}
