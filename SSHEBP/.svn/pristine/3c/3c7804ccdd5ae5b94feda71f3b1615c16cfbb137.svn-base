<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="admin/js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="admin/js/bootstrap.js"></script>
	
	<style type="text/css">
		*{
			margin:0;
			padding: 0;
		}
		body{
			width:100%;
			height:380px;
		}
		.box{
			width:300px;
			margin-left: 40%;
			margin-top:400px;
		}
		.mm{
			margin-bottom: 20px;
		}
		input{
			width:200px;
			height:25px;
		}
		span{
			color:red;
		}
		
		label{
			font-size: 20px;
		}
		
	</style>
  </head>
  
  <body style="background-image: url(admin/image/lan.jpg);">
  	
<%--     <form action='<c:url value="admin/AdminLogin.action" />' method='POST'> --%>
    <form action="admin/AdminLogin.action" method='POST'>
    	<div class="box">
    	  <div class="ll">
    	  <font color='red'><s:actionerror /></font>
		    <div class="mm">
	    		<label>用户名</label>
		      <input type="text" class="form-control" name="username" value="${param.username}" placeholder="请输入用户名">
		      <p>
		      	<font color='red' size="-1"><i>
                    <s:fielderror>
                        <s:param>username</s:param>
                    </s:fielderror>
                </i>
                </font>
		      </p>
		    </div>
		    
		  </div>
		  <div class="ll">
		    <div class="mm">
		    	<label>密&nbsp;码</label>
		      <input type="password" class="form-control" name="password" placeholder="请输入密码">
		      <p>
		      <font color='red' size="-1"><i>
                    <s:fielderror>
                        <s:param>password</s:param>
                    </s:fielderror>
                </i>
              </font>
		      </p>
		      
		    </div>
		  </div>
			  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default" style="width:100px;height:30px;margin-left:160px;">登录</button>
		    </div>
		  </div>
	    </div>  
    </form>
  </body>
</html>
