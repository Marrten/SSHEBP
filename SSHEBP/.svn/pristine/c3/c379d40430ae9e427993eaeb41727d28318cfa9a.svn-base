package com.ebp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ebp.utils.AuthCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("/ebp")
@ParentPackage("struts-default")
@Action(value="AuthCode")
@Controller
@Scope("prototype")
@Results({
	@Result(name="input", location="/ebp/register.jsp"),
	@Result(name="success", location="/ebp/login.jsp")
})
public class AuthCodeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		String authCode = AuthCode.getAuthCode();
		  ActionContext ctx = ActionContext.getContext(); 
		  HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  request.getSession().setAttribute("authCode", authCode);//将验证码保存到session中，便于以后验证
		  try {  
	            //发送图片  
	            ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", response.getOutputStream());
	           // PrintWriter out = response.getWriter();
	        } catch (IOException e){  
	            e.printStackTrace();  
	        }  
		  return null;
	}
	
	
}
