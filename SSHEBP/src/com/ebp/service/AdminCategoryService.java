package com.ebp.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebp.dao.AdminCategoryDAO;
import com.ebp.dao.CategoryDAO;
import com.ebp.domain.Category;
import com.ebp.exception.CategoryException;

@Service
public class AdminCategoryService {
	@Resource
	private AdminCategoryDAO adminCategoryDAO;
	
	public Map<String, Integer> getCategorys() throws CategoryException{
		return adminCategoryDAO.getCategorys();
	}
	public Map<String,Integer> getName(int id) throws CategoryException{
		List<Category> list = adminCategoryDAO.findName(id);
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (Category category : list) {  
			map.put(category.getName(),category.getId()); 
	    }  
		return map;
	}
	
}
