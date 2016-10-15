package com.ebp.dao;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ebp.domain.Item;
import com.ebp.exception.ItemInsertException;
@Repository
public class ItemDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * wangjiafu
	 * @param item
	 * @throws ItemInsertException 
	 */
	public void addItem(Item item) throws ItemInsertException{
		try{
			hibernateTemplate.save(item);
		} catch (DataAccessException e) {
			throw new ItemInsertException(e.getMessage());
		}
	}
}
