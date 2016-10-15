package com.ebp.web;

import java.io.IOException;


import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebp.domain.User;

//@WebFilter(filterName="LoginFilter", urlPatterns={"/ebp/Shopping.action","/ebp/personal.jsp",
//		"/ebp/orders.jsp","/ebp/userbalance.jsp"})
public class LoginFilter implements Filter {

	private static final String LOGIN_PREFIX = "/ebp/";
	private static final String LOGIN_PAGE = "login.jsp";
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// 1. 获取session对象
		HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        
        // 2. 获取当前请求的URI
        String requestURI = req.getRequestURI();
        String uri = requestURI.substring(requestURI.indexOf(LOGIN_PREFIX));
        String queryString = req.getQueryString();
        System.out.println("uri======>"+uri);
        
    	// 3. 在session中获取AdminUser对象
        User user = (User)session.getAttribute("user");
        if (user == null) { // 用户没有登录
        	// 4. 把用户访问的地址存储至session中
        	String url = uri + "?" + queryString;
            session.setAttribute("url", url);
            // 5. 把页面重定向至登录页
            String loginUri = req.getContextPath() + LOGIN_PREFIX + LOGIN_PAGE;
            ((HttpServletResponse)response).sendRedirect(loginUri);
            return;               
        } 
        
        chain.doFilter(request, response);		
	}
	
	@Override
	public void destroy() {
		
	}
	
}
