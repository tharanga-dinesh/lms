package lk.bitwolfsolution.lms.service.api.admin.user;

import lk.bitwolfsolution.lms.model.admin.UserCredential;

public interface UserCredentialService {

	UserCredential findUserCredentialByUsername(String username);

}
