package com.ebp.action;

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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/ebp")
@ParentPackage(value="struts-default")
@Action(value="Quit")
@Controller
@Scope("protoType")
@Results({  
   @Result(name="success", location="/admin/Category"), 
})
public class QuitAction extends ActionSupport{

	private static final long serialVersionUID = 707770194050865828L;

	@Override
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
		
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);
		session.invalidate();
		//request.getRequestDispatcher("/servlet/CategoryServlet").forward(request, response);
		return SUCCESS;
	}

	
}
