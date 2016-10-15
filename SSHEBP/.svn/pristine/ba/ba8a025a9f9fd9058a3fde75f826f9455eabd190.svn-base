package com.ebp.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.domain.Book;
import com.ebp.exception.BookAddExecption;
import com.ebp.service.BookService;
import com.ebp.utils.FileUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
@Controller
@Namespace("/admin")
@ParentPackage("struts-default")	
@Scope("prototype")
@Action(value="AddBook")
@Results({
	@Result(name="success", location="/admin/bookAddSuccess.jsp"),
	@Result(name="input",type="chain",location="AdminCategory")
})
public class AddBookAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String author;
	private String descration;
	private String oldprice;
	private String price;
	private int amount;
	private int category_id;
	@Resource
	private BookService bookService;
	
	private File filename;
	private String filenameFileName;
	private String filenameContentType; //上传文件的类型
	private String savePath = "/images";
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public File getFilename() {
		return filename;
	}
	public void setFilename(File filename) {
		this.filename = filename;
	}
	public String getFilenameFileName() {
		return filenameFileName;
	}
	public void setFilenameFileName(String filenameFileName) {
		this.filenameFileName = filenameFileName;
	}
	public String getFilenameContentType() {
		return filenameContentType;
	}
	public void setFilenameContentType(String filenameContentType) {
		this.filenameContentType = filenameContentType;
	}
	public String getSavePath() {
		String str = ServletActionContext.getServletContext().getRealPath(savePath);
		return str;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Override
	public void validate() {
		int oldprice = -1;
		try {
            oldprice = Integer.parseInt(this.oldprice);
            if(oldprice <= 0){
            	addFieldError("oldprice", getText("error.oldpriceField.positives"));
            }
        } catch (NumberFormatException e) {
        	addFieldError("oldprice", getText("error.oldpriceField.positive"));
        } 
		
		int price = -1;
		try {
			price = Integer.parseInt(this.price);
            if(oldprice <= 0){
            	addFieldError("price", getText("error.oldpriceField.positives"));
            }
        } catch (NumberFormatException e) {
        	addFieldError("price", getText("error.oldpriceField.positive"));
        } 
		
		if(amount <= 0){
			addFieldError("amount", getText("error.amountField.positives"));
		}
		
	}
	@Override
	public String execute() throws Exception {
		String realname = filenameFileName;
			System.out.println(filenameFileName);
		String names = UUID.randomUUID().toString()+ realname;//UUID
			System.out.println(names);
		String last = names.substring(names.lastIndexOf(".")+1);
		names = names.substring(0, ((names.length())-(realname.length())))+"."+last;
			System.out.println(names);
		
		String path = FileUtils.generateFilename(getSavePath(), names);
			System.out.println(getSavePath());
		FileOutputStream fos =  new FileOutputStream(path);
			System.out.println(path);
		String filenames = "images"+path.substring(getSavePath().length(), path.length());
			System.out.println(filenames);
		FileInputStream fis = new FileInputStream(filename);
		byte []buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer))>0){
			fos.write(buffer,0,len);
		}
		double oldprice = Double.parseDouble(this.oldprice);
		double price = Double.parseDouble(this.price);
		Book book = new Book(name, author, descration, oldprice, price, filenames, amount, category_id);
		try{
			bookService.addBook(book);
		}catch(BookAddExecption e){
			 this.addActionError(getText("error.addbook.failure", new String[]{e.getMessage()}));
			 return INPUT;
		}
		fos.close();
		fis.close();
		return SUCCESS;
	}
	
}
