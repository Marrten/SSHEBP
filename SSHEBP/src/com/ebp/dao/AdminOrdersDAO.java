package com.ebp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ebp.domain.Book;
import com.ebp.domain.Item;
import com.ebp.domain.Orders;
import com.ebp.domain.User;
import com.ebp.exception.AdminOrderException;
import com.ebp.exception.BookException;
import com.ebp.exception.UserException;
import com.ebp.service.QueryResult;

@Repository
public class AdminOrdersDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * @author Chen
	 * @param maxLines
	 * @param page
	 * @return
	 * @throws AdminOrderException
	 * @throws BookException
	 */
	public QueryResult<Orders> getAllOrders(final int maxLines, final int page) throws AdminOrderException, BookException{

		QueryResult<Orders> result = null;
		final String hql1 = "select o from Orders o";
		String hql2 = "select i from Item i where i.orders.id = ?";
		String hql3 = "select b from Book b where b.id = ?";
		String hql4 = "select count(o) from Orders o";
		List<Orders> orders = null;
		try {
			orders = hibernateTemplate.executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) 
					throws HibernateException, SQLException{
					Query query = session.createQuery(hql1);
					query.setFirstResult((page-1) * maxLines);
					query.setMaxResults(maxLines);
					return  query.list();
				}
			});
			
			// 查询出订单中的子条目
			for (Orders order : orders) {
				//查询订单项
				List<Item> items = hibernateTemplate.find(hql2,order.getId());
				order.setItems(items);
				for (Item item : items) {
					List<Book> books = hibernateTemplate.find(hql3, new Object[]{item.getBook().getId()});
					if (books==null || books.isEmpty()) {
						throw new BookException("未找到书籍");
					}
					if (books.size() > 1) {
						throw new BookException("找到书籍重复");
					}
					item.setBook(books.get(0));
				}

			}
		} catch (DataAccessException e) {
			throw new AdminOrderException("数据库错误");
		}
		
		try {
			List list = hibernateTemplate.find(hql4);
			Long count = (Long) list.get(0);
			result = new QueryResult<Orders>();
			result.setList(orders);
			result.setTotalRecord(count.intValue());
		} catch (DataAccessException e) {
			throw new AdminOrderException("数据库错误");
		}
		return result;
	}
	
	/**
	 * 查询订单
	 * @author Chen
	 * @param user_id
	 * @return
	 * @throws AdminOrderException
	 * @throws UserException 
	 * @throws BookException 
	 */
	public Map<User, Orders> queryOrders(int user_id) throws AdminOrderException, UserException, BookException {	
		String hql0 = "select u from User u where u.id = ?";
		String hql1 = "select o from Orders o where o.user.id=?";
		String hql2 = "select i from Item i where i.orders.id = ? ";
		String hql3 = "select b from Book b where b.id = ?";
		Map<User, Orders> map = new HashMap<User, Orders>();
		try {
			List<Orders> orders = hibernateTemplate.find(hql1, user_id);
			if(orders == null ||orders.isEmpty()){
				throw new AdminOrderException("订单不存在!");
			}
			// 查询出订单中的子条目
			for (Orders order : orders) {
				//查询订单用户
				List<User> user = hibernateTemplate.find(hql0,order.getUser().getId());
				if(user == null || user.isEmpty()){
					throw new UserException("用户不存在");
				}
				if(user.size() > 1){
					throw new UserException("用户记录重复");
				}
				//查询订单项
				List<Item> items = hibernateTemplate.find(hql2,order.getId());
				order.setItems(items);
				for (Item item : items) {
					List<Book> book = hibernateTemplate.find(hql3, item.getBook().getId());
					if(book == null || book.isEmpty()){
						throw new BookException("书籍不存在");
					}
					if(book.size() > 1){
						throw new BookException("书籍记录重复");
					}
					item.setBook(book.get(0));
				}
				map.put(user.get(0), order);
			}
		} catch (DataAccessException e) {
			throw new AdminOrderException("数据库错误");
		}
		return map;
	}
}
