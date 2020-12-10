package lk.bitwolfsolution.lms.service.impl.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.bitwolfsolution.lms.dao.admin.UserCredentialDao;
import lk.bitwolfsolution.lms.model.admin.UserCredential;
import lk.bitwolfsolution.lms.service.api.admin.user.UserCredentialService;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {

	@Autowired
	private UserCredentialDao userCredentialDao;
	
	@Override
	public UserCredential findUserCredentialByUsername(String username) {
		return userCredentialDao.findUserCredentialByUsername(username);
	}

}
