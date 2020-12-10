package lk.bitwolfsolution.lms.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.bitwolfsolution.lms.model.admin.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
