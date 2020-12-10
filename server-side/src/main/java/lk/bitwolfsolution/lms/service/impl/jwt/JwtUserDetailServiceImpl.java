package lk.bitwolfsolution.lms.service.impl.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lk.bitwolfsolution.lms.model.admin.UserCredential;
import lk.bitwolfsolution.lms.service.api.admin.user.UserCredentialService;

@Service
@Qualifier("jwtUserDetailService")
public class JwtUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserCredentialService userCredentialService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredential userCredential = userCredentialService.findUserCredentialByUsername(username);
		if (userCredential == null) {
			throw new UsernameNotFoundException(String.format("User : %s not found.", username));
		}
		return null;
	}

}
