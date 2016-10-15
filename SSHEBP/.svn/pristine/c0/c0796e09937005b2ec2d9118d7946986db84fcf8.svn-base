package com.ebp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ebp.domain.Adminuser;
import com.ebp.exception.LoginException;
/**
 * 
 * @author Chen
 *
 */
@Repository
public class AdminDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public Adminuser getAdminuser(String username, String password) throws LoginException{
		List<Adminuser> list = null;
		
		String hql = "select au from Adminuser au where au.username=? and au.password=?";
		try {
			list = hibernateTemplate.find(hql, new Object[]{username,password});
			if(list == null || list.isEmpty()){
				throw new LoginException("用户不存在！");
			}
			if(list.size() > 1){
				throw new LoginException("用户重复");
			}
		} catch (DataAccessException e) {
			throw new LoginException("数据库发生错误");
		}
		return list.get(0);
	}
}
