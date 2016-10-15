package com.ebp.action;

import java.util.Map;

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
import com.ebp.exception.AdminOrderException;
import com.ebp.service.AdminOrdersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * 
 * @author Chen
 *
 */

@Namespace(value="/admin")
@ParentPackage(value="struts-default")
@Action(value="AdminSearchOrder")
@Controller
@Scope("prototype")
@Results({  
   @Result(name="success", location="/admin/searchOrders.jsp"), 
   @Result(name="input", type="redirect",location="/admin/AdminOrders.action") 
})
public class AdminSearchOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7127404889694730152L;
	
	@Resource
	private AdminOrdersService adminOrdersService;

	private String search;
	
	@RequiredStringValidator(
		key="error.search.required",
		trim=true
	)
	public String getSearch() {
		return search;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String execute() throws Exception {
		
		// 获取request对象
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = request.getSession();
		Map<User, Orders> map = null;
		try {
			int userId = Integer.parseInt(search);
			map = adminOrdersService.queryOrders(userId);
		} catch (AdminOrderException e) {
			
			System.out.println(e.getMessage());
			session.setAttribute("orders", "订单不存在");
			return INPUT;
		}catch (NumberFormatException e) {
			session.setAttribute("orders", "数字转换异常");
			return INPUT;
		}
		session.setAttribute("orders", "");
		request.setAttribute("map", map);
		return SUCCESS;
	}


}
