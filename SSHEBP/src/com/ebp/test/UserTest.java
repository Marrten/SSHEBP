package com.ebp.test;

import java.util.Date;

import javax.security.auth.login.LoginException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ebp.dao.UserDAO;
import com.ebp.domain.User;
import com.ebp.exception.RegisterException;
import com.ebp.exception.UserExistsException;
import com.ebp.service.UserService;
import com.ebp.utils.MD5Util;

public class UserTest {

	public static void main(String[] args) throws RegisterException, LoginException, UserExistsException, com.ebp.exception.LoginException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/ebp/config/ApplicationContext.xml");
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		UserService userService = (UserService) context.getBean("userService");
		System.out.println(userService);
		//System.out.println(userDAO);
		String password = "qwe123";
		//password = MD5Util.getProcessor(password);
		Date registerTime = new Date();
		//User user = new User("ajshdjash",password,registerTime);
		//userService.register("afsdga", password, registerTime);
		//User user = userService.login("afsdga", password);
		//User user = userService.getUser("lisi");
		//System.out.println(user);
		//System.out.println(user);
		//userDAO.insert(user);
		
		//User user = userDAO.login("ajshdjash",password);
		
		//User user = userDAO.getUserByName("wifi");
		//System.out.println(user);
		
	}
	
}
