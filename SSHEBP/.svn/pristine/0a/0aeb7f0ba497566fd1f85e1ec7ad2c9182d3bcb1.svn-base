<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.ebp.service.UserService"%>
<%@ page import="com.ebp.domain.User"%>
<%@page import="net.sf.json.JSONObject"%>

<%
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/ebp/config/ApplicationContext.xml");
			UserService userService = (UserService) context.getBean("userService");
			String username = request.getParameter("username");
			
				Map<String, String> map = new HashMap<String, String>();
				User user = userService.getUser(username);
				JSONObject obj = null;
				if(user == null){
					out.print(obj);
				}
				map.put("1", username);
				obj = JSONObject.fromObject(map);
				out.print(obj);
%>


