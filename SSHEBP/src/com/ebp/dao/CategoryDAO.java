package com.ebp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ebp.domain.Category;
import com.ebp.exception.CategoryException;

@Repository
public class CategoryDAO {
	/**
	 * @author Chen
	 *获取书籍类型 
	 * @return
	 * @throws CategoryExceptionp
	 */
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public Map<String, List<Category>> getCategory() throws CategoryException{
		
		
		List<Category> list1 = null;
		String hql = "select c from Category c where c.parent.id is null";
		String hql2 = "select c from Category c where c.parent.id = ?";
		try{
			list1 = hibernateTemplate.find(hql);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new CategoryException("查询一级目录异常");
		}
		List<Category> list2 = null;
		
		Map<String, List<Category>> map = new HashMap<String, List<Category>>();
		for (Category category : list1) {
			int id = category.getId();
			
			try{
				list2 = hibernateTemplate.find(hql2 ,id);
			} catch (DataAccessException e) {
				throw new CategoryException("查询二级目录异常");
			}
			map.put(category.getName(), list2);
		}
		return map;
	}
	


}
