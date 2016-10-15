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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebp.domain.Adminuser;

public class AdminLoginFilter implements Filter {
	
	private Properties prop = new Properties();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		// 获取properties中的配置地址
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("com/ebp/web/uri.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest )request;
		// 1. 获取当前请求的uri地址
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		// 2.获取session对象,将uri存储至session中
		HttpSession session = req.getSession();
		uri = uri.substring(contextPath.length());
		// 3. 判断该请求地址在资源文件中是否存在, 如果存在则请求放行
		if(prop.containsValue(uri)){
			chain.doFilter(request, response);
			return;
		}
		// 查找session中是否存在用户认证成功的标志
		Adminuser admin = (Adminuser)session.getAttribute("admin");
		if(admin != null){ // 用户已登录
			chain.doFilter(request, response);
		}else{ // 用户未登录或session超时
			
//			System.out.println(uri+"----filter----");
			
			session.setAttribute("uri", uri);
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(contextPath + "/admin/adminLogin.jsp");
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
