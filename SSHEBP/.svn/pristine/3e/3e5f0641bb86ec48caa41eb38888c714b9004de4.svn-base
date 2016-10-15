package com.ebp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebp.dao.OrdersDAO;
import com.ebp.domain.Orders;
import com.ebp.exception.OrdersException;
import com.ebp.formbean.QueryBean;

@Service
@Transactional
public class OrdersService {
	
	@Resource
	private OrdersDAO ordersDAO;
	
	/**
	 * @author wupanhua
	 * @param  userId
	 * @throws OrdersException 
	 */
	public PageBean getUserOrders(int userId, QueryBean queryBean) throws OrdersException {
		// 获取用户订单
		QueryResult queryResult = ordersDAO.getUserOrders(userId, queryBean);
		
		PageBean pageBean = new PageBean();
		pageBean.setList(queryResult.getList());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		
		return pageBean;
	}
	/**
	 * @author wangjiafu
	 * @param  order
	 * @throws OrdersException
	 */
	@Transactional(propagation=Propagation.SUPPORTS)
	public void add(Orders order) throws OrdersException {
		ordersDAO.addOrder(order);
	}
	/**
	 * @author wupanhua
	 * @param orderId
	 * @throws OrdersException 
	 */
	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteOrder(String orderId) throws OrdersException {
		Orders order = ordersDAO.getOrder(orderId);
		order.setDelete_id(1);
	}


}
