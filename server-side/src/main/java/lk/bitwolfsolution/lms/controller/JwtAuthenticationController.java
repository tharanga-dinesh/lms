package lk.bitwolfsolution.lms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController(JwtAuthenticationController.REQUEST_URL)
public class JwtAuthenticationController {

	public final static String REQUEST_URL = "/authenticate";
	
}
