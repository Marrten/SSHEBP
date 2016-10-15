package com.ebp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebp.dao.AdminUserDAO;
import com.ebp.domain.User;
import com.ebp.exception.InsertException;
import com.ebp.exception.UserExistsException;
import com.ebp.formbean.QueryBean;

@Service
@Transactional
public class AdminUserService {
	
	@Resource
	private AdminUserDAO adminUserDAO;
	
	/**
	 * @author Chen
	 * @param queryBean
	 * @return
	 * @throws InsertException
	 */
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageBean<User> getAllUser(QueryBean queryBean) throws InsertException{
		final int maxLines = queryBean.getPageSize();//每页显示的最大数量
		final int page = queryBean.getCurrentPage();//当前页号
		QueryResult<User> result = adminUserDAO.getAllUser(maxLines,page);
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setList(result.getList());
		pageBean.setTotalRecord(result.getTotalRecord());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		return pageBean;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public User researchUser(String username) throws UserExistsException{
		
		User users = adminUserDAO.researchUser(username);
		return users;
	}

}
