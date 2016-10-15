<%@ page  import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="com.ebp.domain.Book"%>
<%@page import="com.ebp.service.BookService"%>
<%
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/ebp/config/ApplicationContext.xml");
	BookService bookService = (BookService) context.getBean("bookService");
	int id  = Integer.parseInt(request.getParameter("id"));
	Book book =  bookService.getBookById(id);
	request.setAttribute("book", book);
	request.getRequestDispatcher("/admin/load.jsp").forward(request, response);
	
%>

