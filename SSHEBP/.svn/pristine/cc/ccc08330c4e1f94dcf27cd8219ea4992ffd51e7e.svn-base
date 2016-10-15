package com.ebp.action;

import java.util.HashMap;
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

import com.ebp.domain.Book;
import com.ebp.domain.User;
import com.ebp.exception.BalanceNotEnoughException;
import com.ebp.exception.BookNumNotEnoughException;
import com.ebp.exception.UserExistsException;
import com.ebp.service.BookService;
import com.ebp.service.CartItem;
import com.ebp.service.ShoppingCart;
import com.ebp.service.ShoppingService;
import com.ebp.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/ebp")
@ParentPackage("struts-default")
@Action("Shopping")
@Controller
@Scope("protoType")
@Results({
	@Result(name="input",type="redirect",location="/ebp/shoppingErro.jsp"),
	@Result(name="success", location="/ebp/shoppingOK.jsp")
})
public class ShoppingAction extends ActionSupport{

	private static final long serialVersionUID = 2750681532827046792L;

	private String book_id;
	@Resource
	private ShoppingService shoppingService;
	@Resource
	private BookService bookService;
	@Resource
	private UserService userService;
	
	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	@Override
	public String execute() throws Exception {
		Map<String, String> errors = new HashMap<String, String>();
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("errors", errors);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ShoppingCart shoppingcart = null;
		if(book_id == null){
			shoppingcart = (ShoppingCart) session.getAttribute("shoppingcart");
			if(shoppingcart == null){
				return null;
			}
		}else{
			int id = Integer.parseInt(book_id);
			Book book = bookService.getBookById(id);
			
			shoppingcart = new ShoppingCart();
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setNum(1);
			shoppingcart.getMap().put(id, cartItem);
		}
		
		
		try {
			shoppingService.shoppingBook(shoppingcart, user);
			User user1 = userService.getUser(user.getUsername());
			shoppingcart.getMap().clear();
			session.setAttribute("user", user1);
			//response.sendRedirect("/EBP/ebp/shoppingOK.jsp");
			return SUCCESS;
		} catch (BalanceNotEnoughException e) {
			errors.put("balance", e.getMessage());
			//request.getRequestDispatcher("/ebp/shoppingErro.jsp").forward(request, response);
			return INPUT;
		} catch (BookNumNotEnoughException ex) {
			errors.put("bookNum", ex.getMessage());
			//request.getRequestDispatcher("/ebp/shoppingErro.jsp").forward(request, response);
			return INPUT;
		} catch (UserExistsException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
