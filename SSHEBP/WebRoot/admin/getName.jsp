<%@page import="com.ebp.service.AdminCategoryService"%>
<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="net.sf.json.JSONObject"%>
<%
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/ebp/config/ApplicationContext.xml");
			AdminCategoryService adminCategoryService = (AdminCategoryService)context.getBean("adminCategoryService");
			int id  = Integer.parseInt(request.getParameter("id"));
			System.out.print(id);
			Map map = adminCategoryService.getName(id);
			System.out.println(map);
			JSONObject obj = JSONObject.fromObject(map);
			out.print(obj);
%>