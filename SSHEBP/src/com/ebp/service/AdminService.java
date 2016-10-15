package com.ebp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebp.dao.AdminDAO;
import com.ebp.domain.Adminuser;
import com.ebp.exception.LoginException;
import com.ebp.utils.MD5Util;
@Service
@Transactional
public class AdminService {
	
	@Resource
	private AdminDAO adminDAO;
	
	/**
	 * @author Chen
	 * @param username
	 * @param password
	 * @return
	 * @throws LoginException
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Adminuser getAdminuser(String username, String password) throws LoginException{
		Adminuser admin = null;
		password = MD5Util.getProcessor(password);
		admin = adminDAO.getAdminuser(username,password);
		return admin;
	}
	
}
