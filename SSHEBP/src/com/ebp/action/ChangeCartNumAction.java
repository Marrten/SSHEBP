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
@Action("ChangeCartNum")
@Controller
@Scope("protoType")
@Results({
	@Result(name="success",type="redirect", location="/ebp/shoppingcart.jsp")
})
public class ChangeCartNumAction extends ActionSupport{

	private static final long serialVersionUID = 7932209976707182264L;
	
	private String book_id;
	private String book_num;

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_num() {
		return book_num;
	}

	public void setBook_num(String book_num) {
		this.book_num = book_num;
	}

	@Override
	public String execute() throws Exception {
		int id = Integer.parseInt(book_id);
		int num = Integer.parseInt(book_num);
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		
		HttpSession session = request.getSession();
		ShoppingCart shoppingcart = (ShoppingCart) session.getAttribute("shoppingcart");
		Map<Integer, CartItem> map = shoppingcart.getMap();
		if(map != null){
			int amount = map.get(id).getBook().getAmount();
			if(num <= amount&&num>0){
				map.get(id).setNum(num);
			}
		}
		return SUCCESS;
	}
	
	

}
