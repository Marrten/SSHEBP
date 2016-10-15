package com.ebp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ebp.domain.Orders;
import com.ebp.exception.OrdersException;
import com.ebp.formbean.QueryBean;
import com.ebp.service.QueryResult;

@Repository
public class OrdersDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	// and o.delete_id = 0
	private static final String RETRIEVE_USER_ORDERS = "select o from Orders o where o.user.id = ? and o.delete_id = 0";
	private static final String HOW_MANY_ROW = "select count(o.id) from Orders o where o.user.id = ? and o.delete_id = 0";
	private static final String FIND_ORDERS = "select o from Orders o where o.id = ?";
	
	/**
	 * @author wangjiafu
	 * @param  order
	 * @throws OrdersException 
	 */
	public void addOrder(Orders order) throws OrdersException{
		try{
			hibernateTemplate.save(order);
		} catch (DataAccessException e) {
			throw new OrdersException(e.getMessage());
		}
	}
	/**
	 * 获取用户订单
	 * @author wupanhua
	 * @throws OrdersException 
	 */
	@SuppressWarnings("unchecked")
	public QueryResult getUserOrders(final int userId, final QueryBean queryBean) throws OrdersException {
		
		QueryResult queryResult = new QueryResult();
		
		try{
			List<Orders> list = hibernateTemplate.executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException{
					Query query = session.createQuery(RETRIEVE_USER_ORDERS);
					query.setFirstResult(queryBean.getstartIndex());
					query.setMaxResults(queryBean.getPageSize());
					query.setInteger(0, userId);
					return query.list();
				}
			});
			
			if (list == null || list.isEmpty()) {
				throw new OrdersException("尚无订单");
			}
			List<Long> count = hibernateTemplate.find(HOW_MANY_ROW, userId);
			long temp = count.get(0);
			System.out.println(temp);
			queryResult.setList(list);
			queryResult.setTotalRecord((int)temp);
			
			return queryResult; 
		} catch(DataAccessException e) {
			e.printStackTrace();
			throw new OrdersException("查询失败");
		}
	}
	/**
	 * @author wupanhua
	 * @param  orderId
	 * @throws OrdersException 
	 */
	public Orders getOrder(String orderId) throws OrdersException {
		try{
			List<Orders> order = hibernateTemplate.find(FIND_ORDERS, orderId);
			if (order == null | order.isEmpty()) {
				throw new OrdersException("无此订单");
			}
			return order.get(0);
		} catch(DataAccessException e) {
			throw new OrdersException("删除失败");
		}
	}

}
