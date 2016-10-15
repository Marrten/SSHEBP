package com.ebp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebp.dao.ItemDAO;
import com.ebp.domain.Item;
import com.ebp.exception.ItemInsertException;
@Service
public class ItemService {
	@Resource
	private ItemDAO itemDAO;
	
	/**
	 * wangjiafu
	 * @param item
	 * @throws ItemInsertException
	 */
	public void addItem(Item item) throws ItemInsertException{
		itemDAO.addItem(item);
	}
}
