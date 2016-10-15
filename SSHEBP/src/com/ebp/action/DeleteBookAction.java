package com.ebp.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")	
@Action(value="DeleteBook")
@Results({
	@Result(name="success", type="redirect",location="/admin/BookList")
})
public class DeleteBookAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int id;
	@Resource
	private BookService bookService;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		bookService.dropBOOK(id);
		return SUCCESS;
	}
	
	
	
	
}
