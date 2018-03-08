package com.mpc.demo.service;

import com.mpc.demo.dto.UserDto;
import com.mpc.demo.entity.User;

public interface UserService {
	public User findUserByEmail(String email);
	public User saveUser(UserDto userDto);
	void createVerificationTokenForUser(User user, String token);
}
