<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ebp.dao.UserDAO"%>
<%@page import="com.ebp.domain.User"%>
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
		 	 	<li value="1"><a href="admin/AdminUserList.action">用户管理</a></li>
		 	 	<li value="2"><a href="admin/BookList.action">书籍管理</a></li>
		 	 	<li class="act" value="3"><a href="admin/AdminOrders.action">订单管理</a></li>
		 	 </ul>
		 </div>

		   <!-- 管理项对应的内容 -->
		   <!-- 内容一:订单管理 -->
		   <div class="manager-content1">
		   	  <!-- 右边内容显示:我的订单-->
		      <div class="person-right2">
		        <div class="person-top">
		             <h4>订单列表</h4>
		        </div>

		        <div class="indent">
		          <div class="panel  panel-warning">
		              <div class="panel-heading">
		                  <h3 class="panel-title">
		                     	订单详情
		                  </h3>
			          </div>
		              <!-- 测试 -->
		              
		              <c:forEach var="entry" items="${map}">
			             <div class="panel-body">
			                <div class="panel panel-default">
			                  <div class="panel-heading">
			                      <h3 class="panel-title">
			                         <p><span class="date">${entry.key.username }&nbsp;${entry.value.createTime }&nbsp;&nbsp;&nbsp;订单号:&nbsp;</span><span class="order-number">${entry.value.orderNum }</span></p>
			                      </h3>
			                  </div>
		              	<c:forEach var="item" items="${entry.value.items }">
			                  <div class="panel-body">
			                     <div class="order number1">
			                        <div class="col-md-1">
			                            <img src="${item.book.filename }" alt="" style="width: 64px;"/>
			                        </div>
			
			                        <div class="col-md-3">
			                            <span style="font-size: 16px;font-weight: bold;">${item.book.name }</span><br/>
			                            <span>${item.book.author }</span>
			                            <p style="color: gray; margin-top: 20px;">¥<span class='unit-price'>${item.book.price }</span></p>
			                        </div>
			
			                        <div class="col-md-2 b">
			                        </div>
			
			                        <div class="col-md-1 b">
			                           <p>x<span class="book-number">${item.amount }</span></p>
			                        </div>
			
			                        <div class="col-md-2 b">
			                          <span></span>
			                        </div>
			
			                        <div class="col-md-2 b" style="text-align: center;">
			                          <p style="border-bottom: 1px solid #DBDBDB;">总额:<span class='total-amount'>${item.price }</span></p>
			                        </div>
			
			                        <div class="col-md-1">
			                            <span></span>
			                        </div>
				                    </div>
				                  </div>
	                 	</c:forEach>
				                </div>
			                 </div>
	                  </c:forEach>
	              </div>
	           </div>
            </div>
		</div>
	</div>
</body>
</html>
