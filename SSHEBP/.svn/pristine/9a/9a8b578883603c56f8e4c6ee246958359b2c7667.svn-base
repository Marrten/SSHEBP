package com.ebp.action;

import java.util.List;
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
import com.ebp.service.OrdersService;
import com.ebp.service.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/ebp")
@ParentPackage(value="struts-default")
@Action(value="DeleteOrderAction")
@Results({  
   @Result(name="success", type="redirect", location="/user/QueryOrders.action"), // 跳转到修改成功页面
   @Result(name="input", location="/ebp/personal.jsp") 
})
@Controller
@Scope("protoType")
public class DeleteOrderAction extends ActionSupport{

	private static final long serialVersionUID = 4041659987735264911L;
	@Resource
	private OrdersService ordersService;
	
	private String OrderId;

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	@Override
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		
		PageBean pageBean = (PageBean) session.getAttribute("orders");
		List<Orders> list = pageBean.getList();
		
		ordersService.deleteOrder(OrderId);
		
		for (Orders order : list) {
			if (order.getId().equals(OrderId)) {
				list.remove(order);
				break;
			}
		}
		return SUCCESS;
	}
	
}
