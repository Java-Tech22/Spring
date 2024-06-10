package controllers.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateUser(String username, String password) {
		if(username.equalsIgnoreCase("Preeti") && password.equals("admin"))   {
			return true;
		}
		return false;
	}

}
