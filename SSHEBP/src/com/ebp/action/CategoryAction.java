package com.ebp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.ebp.domain.Category;
import com.ebp.exception.BookExistsExecption;
import com.ebp.exception.CategoryException;
import com.ebp.formbean.QueryBean;
import com.ebp.service.BookService;
import com.ebp.service.CategoryService;
import com.ebp.service.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/ebp")
@ParentPackage(value="struts-default")
@Action(value="Category")
@Controller
@Scope("protoType")
@Results({  
   @Result(name="success", location="/ebp/index.jsp"), 
   @Result(name="input", location="/errors/category.jsp") 
})
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CategoryService categoryService;
	@Resource
	private BookService bookService;
	
	@Override
	public String execute() throws Exception {
		
		// 获取request对象
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        
		Map<String, List<Category>> map = null;
		try {
			map = categoryService.getCategory();
		} catch (CategoryException e) {
			return INPUT;
		}
		
		Map<Integer,Book> recommendMap = new HashMap<Integer, Book>();
		Random r1 = new Random();
		int num1 = r1.nextInt(5)+1;
		int num2 = r1.nextInt(5)+1;
		while (num1 == num2) {
			num2 = r1.nextInt(5)+1;
		}
		int num3 = r1.nextInt(5)+1;
		while(num1 == num3||num2 == num3){
			num3 = r1.nextInt(5)+1;
		}
		
		Book book1 = bookService.getBookById(num1);
		Book book2 = bookService.getBookById(num2);
		Book book3 = bookService.getBookById(num3);
		recommendMap.put(1, book1);
		recommendMap.put(2, book2);
		recommendMap.put(3, book3);
		
		request.setAttribute("map", map);
		request.setAttribute("recommendMap", recommendMap);
		
		int category_id = 5;
		if (request.getParameter("category_id") != null) {
			category_id = Integer.parseInt(request.getParameter("category_id"));
		}
		
		QueryBean queryBean = new QueryBean();
		PageBean<Book> pageBean = new PageBean<Book>();
		
		queryBean.setCurrentPage(1);
		queryBean.setPageSize(6);
		try {
			pageBean = bookService.getBooksByCategoryId(queryBean, category_id);
			List<Book> list = pageBean.getList();
			
			Map<Integer, Book> books = new HashMap<Integer, Book>();
			for (int i = 0; i < list.size(); i++) {
				books.put(i, list.get(i));
			}
			request.setAttribute("books", books);
		} catch (BookExistsExecption e) {
			this.addActionError(e.getMessage());
			return SUCCESS;
		}
		return SUCCESS;
	}

}
