package com.ebp.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.domain.Book;
import com.ebp.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/ebp")
@ParentPackage("struts-default")
@Action("ShowBookInfo")
@Controller
@Scope("protoType")
@Results({
	@Result(name="success", location="/ebp/bookInfo.jsp")
})
public class ShowBookInfoAction extends ActionSupport{

	private static final long serialVersionUID = 297566402295009854L;

	private String book_id;
	@Resource
	private BookService bookService;

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	@Override
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		int id = Integer.parseInt(book_id);
		Book book = bookService.getBookById(id);
		request.setAttribute("book", book);
		//request.getRequestDispatcher("/ebp/bookInfo.jsp").forward(request, response);
		return SUCCESS;
	}
	
	
}
