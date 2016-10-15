package com.ebp.service;

import java.util.Date;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebp.dao.UserDAO;
import com.ebp.domain.User;
import com.ebp.exception.LoginException;
import com.ebp.exception.RegisterException;
import com.ebp.exception.UserException;
import com.ebp.exception.UserExistsException;
import com.ebp.utils.MD5Util;

@Service
@Transactional
public class UserService {
	@Resource
	private UserDAO userDAO;
	/**
	 * @author liqiang
	 * @param username
	 * @param password
	 * @param registerTime
	 * @throws RegisterException
	 */
	public void register(String username,String password,Date registerTime) throws RegisterException{
		password = MD5Util.getProcessor(password);
		User user = new User(username, password, registerTime);
		userDAO.register(user);
	}
	/**
	 * author liqiang
	 * @param username
	 * @param password
	 * @return
	 * @throws LoginException
	 * @throws com.ebp.exception.LoginException 
	 * @throws javax.security.auth.login.LoginException 
	 */
	//@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public User login(String username, String password) throws LoginException{
		password = MD5Util.getProcessor(password);
		return userDAO.login(username,password);
	}
	/**
	 * author liqiang
	 * @param username
	 * @return
	 * @throws UserExistsException
	 */
	//@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public User getUser(String username) throws UserExistsException{
		User users = userDAO.getUserByName(username);
		return users;
	}
	/**
	 * 余额充值
	 * @author wupanhua
	 * @param user
	 * @throws UserException
	 */
	@Transactional(propagation=Propagation.SUPPORTS)
	public void chargeMoney(User user) throws UserException {
		userDAO.updateUsers(user);
	}
	
	/**
	 * 修改用户信息
	 * @author wupanhua
	 * @param user
	 * @throws UserException
	 */
	@Transactional(propagation=Propagation.SUPPORTS)
	public void ModifyUserInfromation(User user) throws UserException {
		userDAO.updateUsers(user);
	}
	
	/**
	 * wangjiafu
	 * @param id
	 * @return
	 * @throws UserExistsException 
	 */
	public User getUserById(int id) throws UserExistsException {
		return userDAO.getUserById(id);
	}
}
