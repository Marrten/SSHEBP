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
import com.ebp.formbean.QueryBean;
import com.ebp.service.BookService;
import com.ebp.service.PageBean;
import com.ebp.utils.WebUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("/admin")
@ParentPackage("struts-default")
@Action(value="BookList")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success", location="/admin/bookList.jsp"),
})
public class AdminBookListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Resource
	private BookService bookService;
	@Override
	public String execute() throws Exception {
		 	ActionContext ctx = ActionContext.getContext(); 
	        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
	        
			//book分页
			QueryBean queryBean = WebUtil.formBean(request, QueryBean.class);
			//设置显示条数
			queryBean.setPageSize(5);
			queryBean.setstartIndex(1);
			PageBean<Book> pageBean = null;
			try{
				pageBean = bookService.getBooks(queryBean);
			}catch(Exception e){
				return INPUT;
			}
			request.setAttribute("pageBean", pageBean);
			return SUCCESS;
	}
	
	
}
