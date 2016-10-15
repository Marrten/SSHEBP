package com.ebp.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.domain.Book;
import com.ebp.exception.BookExistsExecption;
import com.ebp.service.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")	
@Action(value="FindBook")
@Results({
	@Result(name="success",location="/admin/findResult.jsp"),
	@Result(name="input", location="/admin/BookList"),
})
public class FindBookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	@Resource
	private BookService bookService;
	
	@RequiredStringValidator(
	        key = "error.bookName.crequested",
	        trim = true
	    )
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public void validate() {
		if(name == null){
			addFieldError("name", "书名不能为空");
		}
	}
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext(); 
        HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		Book book = null;
       try{
    	  book = bookService.findBook(name);
       }catch(BookExistsExecption e){
    	   this.addActionError(getText("error.findbook.failure", new String[]{e.getMessage()}));
       }
//		System.out.println(book);
		request.setAttribute("book", book);
		return SUCCESS;
	}
	
	
}
