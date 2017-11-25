package com.chegaai.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByEmail(String email);

	@Modifying
	@Query("update User u set u.cidade = ?2 where u.id = ?1")
	public void updateCidade(String id, String cidade);
}
