package com.mpc.demo.service;

import com.mpc.demo.dto.UserDto;
import com.mpc.demo.entity.User;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto);     
		      //throws EmailExistsException;
}
