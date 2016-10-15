package com.ebp.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.domain.Book;
import com.ebp.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")	
@Action(value="UpdateBook")
@Results({
	@Result(name="input", location="/admin/loadBook.jsp"),
	@Result(name="success", type="redirect",location="/admin/BookList")
})
public class UpdateBookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String author;
	private String descration;
	private String oldprice;
	private String price;
	private String amount;
	@Resource
	private BookService bookService;
	
	@RequiredStringValidator(
	        key = "error.bookName.required",
	        trim = true
	    )
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@RequiredStringValidator(
	        key = "error.bookName.required",
	        trim = true
	    )
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@RequiredStringValidator(
	        key = "error.bookName.required",
	        trim = true
	    )
	public String getDescration() {
		return descration;
	}
	public void setDescration(String descration) {
		this.descration = descration;
	}
	public String getOldprice() {
		return oldprice;
	}
	public void setOldprice(String oldprice) {
		this.oldprice = oldprice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public void validate() {
		double oldprice = -1;
		try {
            oldprice = Double.parseDouble(this.oldprice);
            if(oldprice <= 0){
            	addFieldError("oldprice", getText("error.oldpriceField.positives"));
            }
        } catch (NumberFormatException e) {
        	addFieldError("oldprice", getText("error.oldpriceField.positive"));
        } 
		
		double price = -1;
		try {
			price = Double.parseDouble(this.price);
            if(price <= 0){
            	addFieldError("price", getText("error.oldpriceField.positives"));
            }
        } catch (NumberFormatException e) {
        	addFieldError("price", getText("error.oldpriceField.positive"));
        } 
		int amount = 0;
		try {
			amount = Integer.parseInt(this.amount);
            if(amount <= 0){
            	addFieldError("price", getText("error.oldpriceField.positives"));
            }
        } catch (NumberFormatException e) {
        	addFieldError("price", getText("error.oldpriceField.positive"));
        } 
	}
	@Override
	public String execute() throws Exception {
		double oldprice = Double.parseDouble(this.oldprice);
		double price = Double.parseDouble(this.price);
		int amount = Integer.parseInt(this.amount);
		System.out.println("+++++++"+id);
		System.out.println("========="+oldprice);
		Book book = new Book(id, name, author, descration, oldprice, price, amount);
		System.out.println(book);
		bookService.update(book);
		return SUCCESS;
		
	}
	
	
}
