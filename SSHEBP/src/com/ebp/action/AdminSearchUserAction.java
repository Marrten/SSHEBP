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
import com.ebp.exception.UserExistsException;
import com.ebp.service.AdminUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * 
 * @author Chen
 *
 */
@Namespace(value="/admin")
@ParentPackage(value="struts-default")
@Action(value="AdminSearchUser")
@Controller
@Scope("prototype")
@Results({  
   @Result(name="success", location="/admin/userDetail.jsp"), 
   @Result(name="input", type="redirect",location="/admin/AdminUserList.action") 
})
public class AdminSearchUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6772437478117314612L;
	
	private String search;
	
	@Resource
	private AdminUserService adminUserService;
	
	@RequiredStringValidator(
        key = "error.search.required",
        trim = true
    )
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String execute() throws Exception {
		
		// 获取request对象
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = request.getSession();
        User user = null;
		try {
			user = adminUserService.researchUser(search);
		} catch (UserExistsException e) {
			session.setAttribute("userfield", e.getMessage());
			return INPUT;
		}
		session.setAttribute("userfield", "");
		request.setAttribute("user", user);
		return SUCCESS;
		
	}

}
