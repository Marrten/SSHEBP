package com.ebp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebp.dao.CategoryDAO;
import com.ebp.domain.Category;
import com.ebp.exception.CategoryException;

@Service
public class CategoryService {
	
	@Resource
	private CategoryDAO categoryDAO;
	
	
	/**
	 * @author Chen
	 * @return 菜单列表
	 * @throws CategoryException 
	 */
	public Map<String, List<Category>> getCategory() throws CategoryException{
		
		return categoryDAO.getCategory();
	}

}
