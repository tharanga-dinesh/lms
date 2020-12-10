package lk.bitwolfsolution.lms.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.bitwolfsolution.lms.model.admin.UserCredential;

@Repository
public interface UserCredentialDao extends JpaRepository<UserCredential, Integer>{

	@Query("FROM UserCredential WHERE username = :username")
	UserCredential findUserCredentialByUsername(@Param("username") String username);
	
}
