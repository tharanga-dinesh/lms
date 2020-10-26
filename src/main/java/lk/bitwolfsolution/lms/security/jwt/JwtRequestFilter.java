package lk.bitwolfsolution.lms.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lk.bitwolfsolution.lms.util.JwtTokenUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired 
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestTokenHeader = request.getHeader("authorization");
		
		String userName = null; 
		String jwtToken = null;
		
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
			
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

		}
		
		
		filterChain.doFilter(request, response);
	}

}
