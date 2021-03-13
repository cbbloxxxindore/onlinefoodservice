package com.gurukripa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gurukripa.dao.UseRepo;
import com.gurukripa.entites.User;
@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UseRepo ur;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user=null;
user=ur.getUserByEmail(username);

 CustomUSerDetail user1  = new CustomUSerDetail(user);
return user1 ;
	}

}
