package com.ebp.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.domain.Orders;
import com.ebp.domain.User;
import com.ebp.exception.OrdersException;
import com.ebp.formbean.QueryBean;
import com.ebp.service.OrdersService;
import com.ebp.service.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/ebp")
@ParentPackage(value="struts-default")
@Action(value="QueryOrders")
@Results({  
   @Result(name="success", location="/ebp/orders.jsp"), // 跳转到修改成功页面
   @Result(name="input", location="/ebp/personal.jsp") 
})
@Controller
@Scope("protoType")
public class QueryOrdersAction extends ActionSupport {

	private static final long serialVersionUID = 3706825870486291045L;
	
	@Resource
	private OrdersService ordersService;

	private String currentPage;
	
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String execute() throws Exception {
		
		QueryBean queryBean = new QueryBean();
		int c = Integer.parseInt(currentPage);
		queryBean.setCurrentPage(c);
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			user = new User();
			session.setAttribute("user", user);
			return INPUT;
		}
		
		PageBean<Orders> pageBean = null;
		try {
			pageBean = ordersService.getUserOrders(user.getId(), queryBean);
			session.setAttribute("orders", pageBean);
			System.out.println("action:" + pageBean.getCurrentPage());
			return SUCCESS;
		} catch (OrdersException e) {
			this.addActionError(e.getMessage());
			return SUCCESS;
		}
		
	}
	
}
