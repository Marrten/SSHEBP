<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            	<c:choose>
	    			<c:when test="${empty admin}">
	    				<li class="rt-li"><a href="admin/adminLogin.jsp">登录</a></li>
	    			</c:when>
	    						
	    			<c:otherwise>
	    				<li class="rt-li"><a href="#">${admin.username}</a></li>
	    			</c:otherwise>
	    		</c:choose>
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
	 	 	<li value="2"><a href="admin/BookList">书籍管理</a></li>
	 	 	<li value="3"><a href="admin/AdminOrders.action">订单管理</a></li>
	 	 </ul>
	 </div>
	   <!-- 管理项对应的内容 -->
	   <!-- 内容一:用户管理 -->
	   <div class="manager-content1">
	   	    <table class="table table-hover" border="1px" width="600px">
	   	    	<caption>
	   	    	 用户管理
	   	    	 	<form action="admin/AdminSearchUser.action" onsubmit="return chechForm()">
		   	    	 <div class="col-lg-4" style="float: right;width:400px;">
						<span><font color='red'><s:actionerror /></font></span>
						<div class="input-group">
							<input type="text" class="form-control" id="search" name="search" value="" placeholder='用户名'>
							<span class="input-group-btn">
								<button class="btn btn-info" type="submit">
									搜索
								</button>
							</span>
						</div>
					</div>
				  </form>
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
	   	    		<c:forEach var="user" items="${pageBean.list}">
			    		<tr>
			    			<td>${user.id}</td>
			    			<td>${user.name}</td>
			    			<td>${user.username}</td>
			    			<td>${user.gender}</td>
			    			<td>${user.phone}</td>
			    			<td>${user.registerTime}</td>
			    			<td>${user.balance}</td>
			    		</tr>
		    		</c:forEach>
	   	    	</tbody>
	   	    </table>

           <!--  页面切换按钮  -->
               <div class="person-bottom" style="padding-top: 50px; float: right;">
                   
                   <div style="float:right;">
              <p class='bottom-txt' style=''>共${pageBean.totalPage}页</p>
                   <button class="btn btn-default">
                   <a href="javascript:void(0)" onclick="gotoPage(${pageBean.previousPage})">上一页
                   </a>
                   </button>
                   
                   <c:forEach items="${pageBean.pageBar}" var="number">
		    		<button>
			    		<a href="javascript:void(0)" onclick="gotoPage(${number})">
				    		<c:if test="${pageBean.currentPage eq number}">
				    			<font style="color: red;">${number}</font>
				    		</c:if>
				    		<c:if test="${pageBean.currentPage ne number}">
				    			${number}
				    		</c:if>
			    		</a>
		    		</button>
		    	</c:forEach>
                   <p class='bottom-txt' style=''>......</p>
                   <button class="btn btn-default" >
                   <a href="javascript:void(0)" onclick="gotoPage(${pageBean.nextPage})">下一页</a>
                   </button>
                   
                   <span class="bottom-txt">到第<input type="text" id="currentPage" value="${pageBean.currentPage}" style="width: 40px; height: 35px; text-align: center;">页</span>
                   <button class="btn btn-default" onclick='gotoPage(document.getElementById("currentPage").value)'>确定</button>
                   </div>
               </div>
	   </div>
	</div>
</body>
<script type="text/javascript">

	function chechForm() {
		
		var search = document.getElementById("search").value;
		
		if(search == "" || search == null){
			alert("不能输入空值。。。");
			return false;
		}
			
		
		return true;
	}

	function gotoPage(num){
		var numcheck = /^[1-9][0-9]*$/ ;
		if(num == "" || num == null){
			alert("不能输入空值。。。");
			return;
		}
		
		if(!(numcheck.test(num))){
			alert("请输入正整数。。。");
			document.getElementById("currentPage").value = "";
			return;
		}
		if(num > ${pageBean.totalPage}){
			num = ${pageBean.totalPage};
		}
		if(num<1){
			num = 1;
		}
		window.location.href = "admin/AdminUserList.action?currentPage="+num;
	}
</script>

</html>
