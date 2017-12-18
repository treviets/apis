package net.cd.common.util;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.cd.jpa.entity.security.AuthenticationUser;


@Service
@Scope("singleton")
public class UserUtil {

	public Integer getUserLoginId() throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){ 
        		AuthenticationUser authenticationUser = (AuthenticationUser)auth.getPrincipal();
        		return authenticationUser.getId();
        }
		return 0;
	}
	
	public String getLoginedIdentifier() throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){ 
        	AuthenticationUser authenticationUser = (AuthenticationUser)auth.getPrincipal();
        		return authenticationUser.getIdentifier();
        }
		return null;
	}
	
	public String generateRandomActivationCode() {
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		
		return String.valueOf(n);
	}
    
}
