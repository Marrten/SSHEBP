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
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Namespace(value="/ebp")
@ParentPackage(value="struts-default")
@Action(value="Recharge")
@Results({  
   @Result(name="success", location="/WEB-INF/jspf/modifysuccess.jsp"), // 跳转到修改成功页面
   @Result(name="input", location="/ebp/userbalance.jsp") 
})
@Controller
@Scope("protoType")
public class RechargeAction extends ActionSupport{
	
	private static final long serialVersionUID = 8810391660427100203L;
	
	@Resource
	private UserService userService;
	
	private String money;
	
	@RequiredStringValidator(
		message="余额不能为空",
		trim=true,
		shortCircuit=true
	)
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String execute() throws Exception {
		
		double charge = 0;
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
		
		try {
			charge = Double.parseDouble(money);
		} catch (NumberFormatException e) {
			request.setAttribute("tips", "sucer!");
			return INPUT;
		}
		
		if (charge <= 0) {
			request.setAttribute("tips", "You are sucer!");
			return INPUT;
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		User user = new User(1, "luoyuan", "wupanhua", "123456", "123456", "F", null, 20000.0);
		user.setBalance(user.getBalance() + charge);
		try {
			userService.chargeMoney(user);
			return SUCCESS;
		} catch(UserException e) {
			this.getActionErrors().add(e.getMessage());
			return INPUT;
		}
	}

}
