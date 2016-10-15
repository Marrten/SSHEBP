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
import com.ebp.exception.AdminOrderException;
import com.ebp.formbean.QueryBean;
import com.ebp.service.AdminOrdersService;
import com.ebp.service.PageBean;
import com.ebp.utils.WebUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Chen
 *
 */

@Namespace(value="/admin")
@ParentPackage(value="struts-default")
@Action(value="AdminOrders")
@Controller
@Scope("prototype")
@Results({  
   @Result(name="success", location="/admin/orders.jsp"), 
   @Result(name="input", location="/errors/orders.jsp") 
})
public class AdminOrdersAction extends ActionSupport {

	private static final long serialVersionUID = -6212752721084723572L;
	
	@Resource
	private AdminOrdersService adminOrdersService;

	@Override
	public String execute() throws Exception {
		
		// 获取request对象
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = request.getSession();
		QueryBean queryBean = WebUtil.formBean(request, QueryBean.class);
		queryBean.setPageSize(3);
		PageBean<Orders> pageBean = null;
		try{
			pageBean = adminOrdersService.getAllOrders(queryBean);
		}catch(AdminOrderException e){
			e.printStackTrace();
			return INPUT;
		}
		
		String orders = (String)session.getAttribute("orders");
		
		if(orders != "" || orders != null){
			this.addActionError(orders);
		}
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	
	}
	
}
