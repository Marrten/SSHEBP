<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心我的余额</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  	<link rel="icon" href="ebp/image/icon.png">
  	<link rel="stylesheet" type="text/css" href="ebp/css/bootstrap.css">
  	<link rel="stylesheet" type="text/css" href="ebp/css/duokan.css">
  	<script type="text/javascript" src="ebp/js/jquery-3.1.0.js"></script>
  	<script type="text/javascript" src="ebp/js/bootstrap.js"></script>
  	<style type="text/css">
       *{margin: 0;padding: 0;}
      /*---------- 左边导航 ----------*/
         .person-center{width: 1190px; margin: 0 auto;}
         .person-left{
          width: 235px;
          height: 500px;
          float: left;
         }

         .person-left h3{color: gray;}
         .person-left a{font-size: 16px; font-weight: bold;}
         .person-left a:link{color: black;}
         .person-left a:visited{color: black;}
         .person-left a:active{color: black;}

         .act{
          background-color: rgb(244,242,239);
          border-right: 5px solid orange;
         }
        /* --------右边内容--------- */
         .person-right3{
          width: 955px;
          float: right;
          border-left: 1px solid #DBDBDB;
        }
        .person-top{
            width: 925px;
            margin-left: 30px;
            margin-top: 30px;
            padding-top: 10px;
            border-bottom: 1px solid #DBDBDB;
        }
        .person-content,.person-pay{
          padding-top: 30px;
          padding-left: 30px;
        }


        .person-price{
          padding-top: 10px;
          margin-left: 30px;
          border-bottom: 1px solid #DBDBDB;
        }

        .person-right3 .person-price .balance{
          font-size: 30px;
          font-weight: bold;
          color: rgb(229,158,80);
        }
        .person-right3 .person-price .pay{
          margin-top: 50px;
        }
  </style>
</head>
<body>
  <div class="person-center">

   <!-- 头部分 -->
      <div class="headbox">
        <div class="navbox">
          <div class="nav-left">
             <ul class="lt-list">
                   <li class="lt-li"><a class="nav-a" href="#" target="_blank">小米网</a></li>
                   <li class="part">|</li>
                   <li class="lt-li"><a class="nav-a" href="#" target="_blank">MIUI</a></li>
                   <li class="part">|</li>
                   <li class="lt-li"><a class="nav-a" href="#" target="_blank">米聊</a></li>
                   <li class="part">|</li>
                   <li class="lt-li"><a class="nav-a" href="#" target="_blank">游戏</a></li>
                   <li class="part">|</li>
                   <li class="lt-li"><a class="nav-a checked" href="#" target="_blank">多看阅读</a></li>
                   <li class="part">|</li>
                   <li class="lt-li"><a class="nav-a" href="#" target="_blank">云服务</a></li>
                   <li class="part">|</li>
                   <li class="lt-li"><a class="nav-a" href="#" target="_blank">小米网移动版</a></li>
               </ul>
          </div>

          <div class="nav-right">
            <ul class="rt-list">
                <c:choose>
   					<c:when test="${empty sessionScope.user}">
   						<li class="rt-li"><a href="ebp/login.jsp">登录</a>/<a href="ebp/register.jsp">注册</a></li>
   					</c:when>
   					<c:otherwise>
   						<li class="rt-li"><a href="ebp/login.jsp">${sessionScope.user.username}</a></li>
   					</c:otherwise>
   				</c:choose>
              <li class="part">|</li>
              <li class="rt-li shop"><a href="ebp/shoppingcart.jsp">购物车</a></li>
              <li class="part">|</li>
              <li class="rt-li myPerson"><a href="#">个人中心</a></li>
            </ul>
          </div>
        </div>
      </div>

      <!-- 主体部分 -->
      <div class="mbody">
          <!-- 主体搜索部分 -->
        <div class="body-top">
          <div class="logo">
             <img src="ebp/image/logo.png">
          </div>
        </div>

         <!-- 主导航部分 -->
        <div class="main-nav">
              <ul class="center-nav">
                <li><a href="ebp/Category.action">首页</a></li>
                <li><a href="#">榜单</a></li>
                <li><a href="#">书评</a></li>
                <li><a href="#">精品.免费</a></li>
                <li><a href="#">分类</a></li>
                <li><a href="#">客户端</a></li>
                <li><a href="#">论坛</a></li>
            </ul>
        </div>
       <!-- 左边导航 -->
     <div class="person-left">
       <ul class="nav nav-pills nav-stacked">
        <li><h3>个人中心</h3></li>
        <li value="1"><a href="ebp/personal.jsp">帐号设置</a></li>
        <li value="2"><a href="ebp/QueryOrders.action?currentPage=1">订单</a></li>
        <li class="act" value="3"><a href="javascript:void(0)">我的余额</a></li>
       </ul>
     </div>

     <!-- 右边内容显示:我的余额-->
    <div class="person-right3">
          <div class="person-top">
          <h4>我的余额</h4>
         </div>
         <div class="person-price">
                  <p class="balance"><span>${sessionScope.user.balance}</span>&nbsp;书币</p>
                  <h4 class="pay">账户充值</h4>
         </div>

         <div class="person-pay">
            <form class="form-horizontal" role="form" action="ebp/Recharge.action" method="POST">

               <div class="form-group">
               
               	  <s:actionerror/>
               	  
                  <label for="inputPassword" class="col-md-2 control-label">充值金额:</label>
                  <div class="col-md-4">
                      <input type="text" class="form-control" id="inputMoney" onkeyup="clearNoNum(this)" value="${requestScope.tips}" name="money" placeholder="请输入充值金额:">
                  </div>
              </div>

                <div class="form-group">
                  <div class="col-md-offset-2 col-md-2">
                      <button type="submit" class="btn btn-primary">确认充值</button>
                  </div>
              </div>
            </form>
         </div>
    </div>

  </div>
</body>
<script type="text/javascript">
	function clearNoNum(obj) {   
		obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  

		obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是. 

		obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的.   

		obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");

	}
</script>
</html>
