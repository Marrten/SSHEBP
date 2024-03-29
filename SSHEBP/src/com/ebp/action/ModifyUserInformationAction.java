package com.ebp.action;

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

import com.ebp.domain.User;
import com.ebp.exception.UserException;
import com.ebp.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Namespace(value="/ebp")
@ParentPackage(value="struts-default")
@Action(value="ModifyUserInformation")
@Results({  
   @Result(name="success", location="/WEB-INF/jspf/modifysuccess.jsp"), // 跳转到修改成功页面
   @Result(name="input", location="/ebp/personal.jsp") 
})
@Controller
@Scope("protoType")
public class ModifyUserInformationAction extends ActionSupport{

	private static final long serialVersionUID = -7202996430924242486L;
	
	@Resource
	private UserService userService;
	
	private String username;
	private String password;
	private String confirmPassword;
	private String phone;
	private String gender;
	
	@RequiredStringValidator(
		message="账户名不能为空",
		trim=true,
		shortCircuit=true
	)
	@StringLengthFieldValidator(
		key="账户名长度非法",
		minLength="4",
		maxLength="20"
	)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@RequiredStringValidator(
		message="密码不能为空",
		trim=true,
		shortCircuit=true
	)
	@StringLengthFieldValidator(
		message="非法密码",
		minLength="6",
		maxLength="30"
	)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@RequiredStringValidator(
		message="请保证确认密码不为空",
		trim=true,
		shortCircuit=true
	)
	@StringLengthFieldValidator(
		message="确认密码非法",
		minLength="4",
		maxLength="30"
	)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@RequiredStringValidator(
		message="手机号不能为空",
		trim=true,
		shortCircuit=true
	)
	@RegexFieldValidator(
		message="手机号码非法",
		trim=true,
		regexExpression="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"
	)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@RequiredStringValidator(
		key="性别不能为空",
		trim=true
	)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String execute() throws Exception {
		
		if (!password.equals(confirmPassword)) {
			this.getActionErrors().add("两次密码不相同");
			return INPUT;
		}
		
		// 从session中获取到账号密码
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
//		User user = new User(1, "luoyuan", "wupanhua", "123456", "123456", "F", null, 20000.0);
		
		user.setPassword(password);
		user.setPhone(phone);
		user.setGender(gender);
		
		
		try {
			userService.ModifyUserInfromation(user);
			return SUCCESS;
		} catch (UserException e) {
			this.getActionErrors().add(e.getMessage());
			return INPUT;
		}
	}
	
}
