<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.ebp.service.CartItem"%>
<%@page import="com.ebp.service.ShoppingCart"%>
<%@page import="com.ebp.service.BookService"%>
<%@page import="com.ebp.domain.Book"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	AbstractApplicationContext context = (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE); 
	BookService bookService = (BookService)context.getBean("bookService");
	System.out.println(bookService);
	int book_id = Integer.parseInt(request.getParameter("book_id"));
	Book book = bookService.getBookById(book_id);
	System.out.println(book.getName());
	
	ShoppingCart shoppingcart = (ShoppingCart) session.getAttribute("shoppingcart");
	if(shoppingcart == null){
		shoppingcart = new ShoppingCart();
		session.setAttribute("shoppingcart", shoppingcart);
	}
	
	Map<Integer, CartItem> map = shoppingcart.getMap();
	
	//map的id设为与book的id相同
	CartItem cartitem = map.get(book_id);
	if(cartitem == null){
		cartitem = new CartItem();
		cartitem.setBook(book);
		cartitem.setNum(1);
		map.put(book_id, cartitem);
	}else{
		cartitem.setNum(cartitem.getNum() + 1);
	}
	
	Map<String, String> map1 = new HashMap<String, String>();
	map1.put("name", cartitem.getBook().getName());
	JSONObject obj = JSONObject.fromObject(map1);
	out.println(obj);
 %>

