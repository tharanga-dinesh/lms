package lk.bitwolfsolution.lms.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
 
	private static final long serialVersionUID = 1860181619799046213L;

	public static final long JWT_TOKEN_VALIIDITY = 1000 * 3600;
	
	@Value("${jwt.secret}")
	private String secret;
	
	// retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}
	
	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
		Claims claim = getAllClaimsFromToken(token);
		return claimsResolver.apply(claim);
	}

	private Claims getAllClaimsFromToken(String token) { 
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	//generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		String userName = userDetails.getUsername();
		return doGenerateToken(claims, userName);
	}
	
	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIIDITY))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
}
