package com.ebp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebp.dao.AdminOrdersDAO;
import com.ebp.domain.Orders;
import com.ebp.domain.User;
import com.ebp.exception.AdminOrderException;
import com.ebp.exception.BookException;
import com.ebp.exception.UserException;
import com.ebp.formbean.QueryBean;

@Service
@Transactional
public class AdminOrdersService {
	
	@Resource
	private AdminOrdersDAO adminOrdersDAO;
	
	/**
	 * @author Chen
	 * 订单分页
	 * @param queryBean
	 * @return
	 * @throws AdminOrderException
	 * @throws BookException 
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageBean<Orders> getAllOrders(QueryBean queryBean) throws AdminOrderException, BookException{
		final int maxLines = queryBean.getPageSize();//每页显示的最大数量
		final int page = queryBean.getCurrentPage();//当前页号
		QueryResult<Orders> result = adminOrdersDAO.getAllOrders(maxLines,page);
		PageBean<Orders> pageBean = new PageBean<Orders>();
		pageBean.setList(result.getList());
		pageBean.setTotalRecord(result.getTotalRecord());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		return pageBean;
		
	}
	/**
	 * @author Chen 
	 * 返回所有订单
	 * @return
	 * @throws AdminOrderException 
	 * @throws BookException 
	 * @throws UserException 
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Map<User, Orders> queryOrders(int user_id) throws AdminOrderException, UserException, BookException {
		return adminOrdersDAO.queryOrders(user_id);
	}
	
}
