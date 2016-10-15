package com.ebp.action;

import java.io.IOException;
import java.util.Date;





import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.exception.RegisterException;
import com.ebp.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
@Namespace("/ebp")
@ParentPackage("struts-default")
@Action(value="Register")
@Controller
@Scope("prototype")
@Results({
	@Result(name="input", location="/ebp/register.jsp"),
	@Result(name="success", location="/ebp/login.jsp")
	//@Result(name="error", location="/ebp/register.jsp")
})
public class RegisterAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String repassword;
	private String code;
	
	
	@Resource
	private UserService userService;
	
	@RequiredStringValidator(
			key = "error.login.username.required",
			trim = true,
			shortCircuit = true
		)
		@StringLengthFieldValidator(
			key = "error.usernameField.length",
			minLength = "4",
			maxLength = "20"
		)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@RequiredStringValidator(
			key = "error.login.password.required",
			trim = true,
			shortCircuit = true
		)
		@StringLengthFieldValidator(
			key = "error.passwordField.length",
			minLength = "6",
			maxLength = "30"
		)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@RequiredStringValidator(
			key = "error.login.password.required",
			trim = true,
			shortCircuit = true
		)
		@StringLengthFieldValidator(
			key = "error.passwordField.length",
			minLength = "6",
			maxLength = "30"
		)
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	@RequiredStringValidator(
	        key = "error.code.crequested",
	        trim = true
	    )
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public void validate() {
		if(!password.equals(repassword)){
			addFieldError("repassword", getText("error.repasswordField.required"));
		}
		 	ActionContext ctx = ActionContext.getContext(); 
	        //HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
	        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
	        String path = request.getContextPath();
	        //验证验证码是否正确
			HttpSession session = request.getSession();
			
			System.out.println(session.getAttribute("authCode")+","+code);
			
			if(code.equals(session.getAttribute("authCode"))){
				
			}else{
				addFieldError("code", getText("error.code.crequested"));
			}
	}
	
	@Override
	public String execute() throws RegisterException, ServletException, IOException {
		 	Date registerTime = new Date();
	        try {
	        	userService.register(username, password, registerTime);
	        } catch (RegisterException e) { 
	            this.addActionError(getText("error.login.failure", new String[]{e.getMessage()}));
	            return INPUT; 
	        }
	        ActionContext ctx = ActionContext.getContext(); 
	        HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
	        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
	        String path = request.getContextPath();
	        HttpSession session = request.getSession();
	        //验证验证码是否正确
			
			/*System.out.println(session.getAttribute("authCode")+","+code);
			
			if(code.equals(session.getAttribute("authCode"))){
				
			}else{
				addFieldError("code", getText("error.code.crequested"));
				return INPUT;
			}*/
	        response.sendRedirect(path+"/ebp/login.jsp");
	        return SUCCESS;
	}
	
	
}
