package com.mpc.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpc.demo.dto.UserDto;
import com.mpc.demo.entity.User;
import com.mpc.demo.repo.RoleRepository;
import com.mpc.demo.repo.UserRepository;

import java.util.Arrays;

import javax.transaction.Transactional;



@Service
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	
	@Autowired
    private UserRepository repository;
	 
	@Autowired
	private RoleRepository roleRepository;

     
    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) 
       {
         
        if (emailExist(accountDto.getEmail())) {   
        	logger.error("Email already exist");
        	System.out.println("Email already exist");
         }
        User user = new User();    
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return repository.save(user);       
    }
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
