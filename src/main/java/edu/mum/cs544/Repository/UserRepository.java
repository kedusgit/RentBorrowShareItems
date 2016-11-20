package edu.mum.cs544.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.Domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	@Query("SELECT u FROM User u WHERE u.username =:username")
	User findByUsername(String username);
}
