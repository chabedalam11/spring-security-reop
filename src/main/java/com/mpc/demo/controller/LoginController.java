package com.mpc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mpc.demo.dto.UserDto;
import com.mpc.demo.email.EmailService;
import com.mpc.demo.entity.User;
import com.mpc.demo.event.OnRegistrationCompleteEvent;
import com.mpc.demo.service.UserService;


@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	private static final String TAG ="LoginController :: {} ";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		//emailService.sendSimpleMessage("chabedalam11@gmail.com", "test 2 ", "Hello chabed");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		UserDto user = new UserDto();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(
			  @ModelAttribute("user") @Valid UserDto userDto, 
			  BindingResult bindingResult,WebRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(userDto.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			return new ModelAndView("registration", "user", userDto);
		} else {
			User registered =userService.saveUser(userDto);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new UserDto());
			modelAndView.setViewName("registration");
			
			//send email
			
			try {
		        String appUrl = request.getContextPath();
		        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
		    } catch (Exception me) {
		    	me.printStackTrace();
		        return new ModelAndView("emailError", "user", new UserDto());
		    }
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getFirstName()+ " " + user.getLastName());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/form", method = RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getFirstName()+ " " + user.getLastName());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/form");
		return modelAndView;
	}
	

}
