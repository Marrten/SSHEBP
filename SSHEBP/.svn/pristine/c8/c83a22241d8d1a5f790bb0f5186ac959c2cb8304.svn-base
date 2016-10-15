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
import com.ebp.formbean.QueryBean;
import com.ebp.service.AdminUserService;
import com.ebp.service.PageBean;
import com.ebp.utils.WebUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author Chen
 *
 */

@Namespace(value="/admin")
@ParentPackage(value="struts-default")
@Action(value="AdminUserList")
@Controller
@Scope("prototype")
@Results({  
   @Result(name="success", location="/admin/manager.jsp"), 
   @Result(name="input", location="/errors/user.jsp") 
})
public class AdminUserListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private AdminUserService adminUserService;

	@Override
	public String execute() throws Exception {
		
		// 获取request对象
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session = request.getSession();
		//User分页
		QueryBean queryBean = WebUtil.formBean(request, QueryBean.class);
		//设置显示条数
		queryBean.setPageSize(5);
		PageBean<User> pageBean = null;
		try{
			pageBean = adminUserService.getAllUser(queryBean);
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
		String userfield = (String)session.getAttribute("userfield");
		
		if(userfield != "" || userfield != null){
			this.addActionError(userfield);
		}
		
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

}
