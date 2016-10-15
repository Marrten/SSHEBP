<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ebp.dao.UserDAO"%>
<%@page import="com.ebp.domain.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>书籍管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="icon" href="admin/image/icon.png">
	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="admin/css/manager.css">
	<script type="text/javascript" src="admin/js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="admin/js/bootstrap.js"></script>

</head>

<body>
  <!-- 头部分 -->
      <div class="headbox">
          <div class="nav-right">
            <ul class="rt-list">
              <li class="rt-li"><a href="dklogin.html">登录</a>/<a href="dklogin.html">注册</a></li>
            </ul>
          </div>
      </div>

  <!-- 搜索导航部分 -->
      <!-- 主体搜索部分 -->
    <div class="mbody">
        <div class="body-top">
          <div class="logo">
             <img src="admin/image/logo.png">
          </div>
        </div>


         <!-- 主导航部分 -->
        <div class="main-nav">
              <ul class="center-nav">
                <li class="checked"><a href="ebp/Category.action">首页</a></li>
                <li><a href="#">榜单</a></li>
                <li><a href="#">书评</a></li>
                <li><a href="#">精品.免费</a></li>
                <li><a href="#">分类</a></li>
                <li><a href="#">客户端</a></li>
                <li><a href="#">论坛</a></li>
            </ul>
        </div>
    </div>



	<div class="manager-body body1">
	   <!-- 管理导航项 -->
		 <div class="manager-nav">
		 	 <ul class="nav nav-pills nav-stacked">
		 	 	<li><h3>管理项</h3></li>
		 	 	<li class="act" value="1"><a href="admin/AdminUserList.action">用户管理</a></li>
		 	 	<li value="2"><a href="admin/BookList.action">书籍管理</a></li>
		 	 	<li value="3"><a href="admin/AdminOrders.action">订单管理</a></li>
		 	 </ul>
		 </div>

		   <!-- 管理项对应的内容 -->
		   <!-- 内容一:用户管理 -->
		   <div class="manager-content1">
		   	    <table class="table table-hover" border="1px" width="600px">
		   	    	<caption>
		   	    	 用户管理
		   	    	</caption>
		   	    	<thead>
		   	    		<tr>
		   	    			<th>序号</th>
		   	    			<th>姓名</th>
		   	    			<th>用户名</th>
		   	    			<th>性别</th>
		   	    			<th>电话</th>
		   	    			<th>注册时间</th>
		   	    			<th>账户余额</th>
		   	    		</tr>
		   	    	</thead>
		   	    	
		   	    	<tbody>
			    		<tr>
			    			<td>${user.id}</td>
			    			<td>${user.name}</td>
			    			<td>${user.username}</td>
			    			<td>${user.gender}</td>
			    			<td>${user.phone}</td>
			    			<td>${user.registerTime}</td>
			    			<td>${user.balance}</td>
			    		</tr>
			    		
		   	    	</tbody>
		   	    </table>
		   </div>
		</div>


</body>
<script type="text/javascript" src="admin/js/manager.js"></script>

</html>
