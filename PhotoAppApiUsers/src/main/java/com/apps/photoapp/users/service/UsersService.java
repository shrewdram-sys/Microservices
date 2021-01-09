package com.apps.photoapp.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.apps.photoapp.users.shared.UserDto;

public interface UsersService extends UserDetailsService{

	UserDto createUser(UserDto userDetails);
	
	UserDto getUserDetailsByEmail(String email);
}
