package com.ebp.action;

import java.util.Map;

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

import com.ebp.service.CartItem;
import com.ebp.service.ShoppingCart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/ebp")
@ParentPackage("struts-default")
@Action("DelBookFromCart")
@Controller
@Scope("protoType")
@Results({
	@Result(name="success",type="redirect", location="/ebp/shoppingcart.jsp")
})
public class DelBookFromCartAction extends ActionSupport{

	private static final long serialVersionUID = -5456438424414950357L;

	private String book_id;

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	@Override
	public String execute() throws Exception {
		int id = Integer.parseInt(book_id);
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		
		HttpSession session = request.getSession();
		ShoppingCart shoppingcart = (ShoppingCart) session.getAttribute("shoppingcart");
		Map<Integer, CartItem> map = shoppingcart.getMap();
		map.remove(id);
		return SUCCESS;
	}
	
	
}
