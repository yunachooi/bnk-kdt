package com.example.securityEx01.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.securityEx01.entity.User;

public class CustomUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private User user;
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		
		return collection;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}
	@Override
	public String getUsername() {
		
		return user.getUsername();
	}
	public String getName() {
		return user.getName();
	}
	public String getRole() {
		return user.getRole();
	}

}
