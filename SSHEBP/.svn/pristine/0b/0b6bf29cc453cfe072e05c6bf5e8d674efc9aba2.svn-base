<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心订单</title>
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
        .person-right1,.person-right2,.person-right3{
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

        .person-right2 .indent{
          margin-top:10px;
          margin-left: 30px;
          width: 925px;
        }
        .person-right2 .indent p span{font-size: 14px;}
        .person-right2 .indent .date{color: gray;}
        /* 页面切换按钮 */
        .person-right2 .person-bottom{
          width: 955px;
        }
        .person-right2 .person-bottom button,.bottom-txt{
          float: right;
          margin-left: 10px;
        }
        .person-right2 .person-bottom .bottom-txt{
          /* width: 50px;
          height: 30px; */
          line-height: 35px;
          /* text-align: center; */
        }


        .person-price{
          padding-top: 10px;
          margin-left: 30px;
          border-bottom: 1px solid #DBDBDB;
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
              <li class="rt-li myPerson"><a href="ebp/personal.jsp">个人中心</a></li>
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
        <li class="act" value="2"><a href="javascript:void(0)">订单</a></li>
        <li value="3"><a href="ebp/userbalance.jsp">我的余额</a></li>
       </ul>
     </div>

     <!-- 右边内容显示:我的订单-->
     <div class="person-right2">
            <div class="person-top">
              <h4>我的订单</h4>
            </div>

        <div class="indent">
          <div class="panel  panel-warning">
              <div class="panel-heading">
                  <h3 class="panel-title">订单详情</h3>
              </div>
              <div class="panel-body">
              
              <c:choose>
              	<c:when test="${empty sessionScope.orders.list}">
              		<s:actionerror/>
              	</c:when>
              	<c:otherwise>
		 				<c:forEach var="order" items="${sessionScope.orders.list}">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<p><span class="date">${order.createTime}&nbsp;&nbsp;&nbsp;订单号:&nbsp;</span><span class="order-number">${order.orderNum}</span>
											<!-- <div class="col-md-1" style="float:right; display:inline;"> -->
												<a href="user/DeleteOrderAction?orderId=${order.id}" id="hello" style="float:right; display:inline;">删除</a>
											<!-- </div> -->
										</p>
									</h3>
								</div>
								
								<c:forEach var="item" items="${order.items}">
									<div class="panel-body">
										<div class="col-md-1">
											<img src="${item.book.filename }" alt="" style="width: 64px;"/>
										</div>
									
										<div class="col-md-3">
											<span style="font-size: 16px;font-weight: bold;">${item.book.name}</span><br/>
											<span>${item.book.author}</span>
											<p style="color: gray; margin-top: 20px;">¥<span class='unit-price'>${item.book.price}</span></p>
										</div>
										<div class="col-md-2">
										</div>
										<div class="col-md-1 b">
											<p>x<span class="book-number">${item.amount}</span></p>
										</div>
										<div class="col-md-2 b">
											<span>退/换货</span>
										</div>
										<div class="col-md-2 b" style="text-align: center;">
											<p style="border-bottom: 1px solid #DBDBDB;">总额:<span class='total-amount'>${item.price}</span></p>
											<span>在线支付</span>
										</div>
										
									</div>
									
								</c:forEach>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
              </div>
              </div>
           </div>
          <!--  页面切换按钮  -->
          <c:if test="${! empty sessionScope.orders.list}">
	          <div class="person-bottom">
	              <button class="btn btn-default" onclick="turn()">确定</button>
	              <span class="bottom-txt">
	              	<!-- <input type="text" value="1" style="width: 40px; height: 35px; text-align: center;"> -->
	              	至<select style="width: 40px; height: 35px; text-align: center; padding:5px;">
	              		<c:forEach var="i" begin="1" end="${sessionScope.orders.totalPage}">
	              			<option selected>${i}</option>
	              		</c:forEach>
	              			<!-- <option selected>2</option> -->
	              	</select>
	              </span>
	              
	              <p class='bottom-txt' style=''>共${sessionScope.orders.totalPage}页</p>
	              <button class="btn btn-default" onclick="gotoPage(${sessionScope.orders.nextPage})">下一页&nbsp;&gt;</button>
	              <!-- <p class='bottom-txt' style=''>......</p> -->
	               <!-- <div class="btn-group"> -->
		               <!-- 显示页码 -->
			    		<c:forEach items="${sessionScope.orders.pageBar}" var="page">
			    		<%-- <c:forEach begin="${fn:length(sessionScope.orders.pageBar)}" end="1" step="1"> --%>
			    			<c:choose>
				    			<c:when test="${sessionScope.orders.currentPage eq page}">
				    				<p class='bottom-txt' onclick="gotoPage(${page})">${page}</p>
				    			</c:when>
				    			<c:otherwise>
				    				<button class="btn btn-default" onclick="gotoPage(${page})">${page}</button>
				    			</c:otherwise>
			    			</c:choose>
			    		</c:forEach>
	               <!-- </div> -->
	               
	              <button class="btn btn-default" onclick="gotoPage(${sessionScope.orders.previousPage})">&lt;&nbsp;上一页</button>
	          </div>
          </c:if>
          </div>

       </div>

        </div>
  </div>
</body>
<script type="text/javascript">
	function deleteItem(orderId){
		window.location.href = "ebp/DeleteOrder.action?orderId=" + orderId;
	};
	function gotoPage(page) {
		// 从这里跳转
		window.location.href="ebp/QueryOrders.action?currentPage=" + page;
	}
	function turn(){
		var page = $('option:selected').text();
		window.location.href="ebp/QueryOrders.action?currentPage=" + page;
	}
</script>
</html>