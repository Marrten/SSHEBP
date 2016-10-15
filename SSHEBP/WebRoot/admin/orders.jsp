<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ebp.dao.UserDAO"%>
<%@page import="com.ebp.domain.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	             <h4 >订单列表</h4>
				 <caption>
		   	    	 	<form action="admin/AdminSearchOrder.action" onsubmit="return chechForm()">
			   	    	 <div class="col-lg-4" style="float: right;width:400px;">
							<%-- <font color='red' ><s:actionerror /></font> --%>
							<div class="input-group">
								<input type="text" class="form-control" id="search" name="search" value="" placeholder='用户ID'>
								<span class="input-group-btn">
									<button class="btn btn-info" type="submit">
										搜索
									</button>
								</span>
							</div>
						</div>
					  </form>
		   	      </caption>
	          </div>
	        <div class="indent">
	          <div class="panel  panel-warning">
	              <div class="panel-heading">
	                  <h3 class="panel-title" style="margin-left: 400px;">
	                     	<font color='red' ><s:actionerror /></font>
	                  </h3>
		          </div>
		              
	              <!-- 测试 -->
	              <c:forEach var="order" items="${pageBean.list}">
	              
		             <div class="panel-body">
		                <div class="panel panel-default">
		                  <div class="panel-heading">
		                      <h3 class="panel-title">
		                         <p><span class="date">用户:&nbsp;${order.user.id }订单生成时间:&nbsp;${order.createTime }&nbsp;&nbsp;&nbsp;订单号:&nbsp;</span><span class="order-number">${order.orderNum }</span></p>
		                      </h3>
		                  </div>
	              	<c:forEach var="item" items="${order.items }">
		                  <div class="panel-body">
		                     <div class="order number1">
		                        <div class="col-md-1">
		                            <img src="${item.book.filename}" alt="" style="width: 64px;"/>
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
	           <!--  页面切换按钮  -->
	          <div class="person-bottom" style="padding-top: 5px; float: right;">
                   
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
                   <%-- <p class='bottom-txt' style=''>共${pageBean.totalPage}页</p> --%>
                   <span class="bottom-txt">到第<input type="text" id="currentPage" value="${pageBean.currentPage}" style="width: 40px; height: 35px; text-align: center;">页</span>
                   <button class="btn btn-default" onclick='gotoPage(document.getElementById("currentPage").value)'>确定</button>
                   </div>
               </div>
               </div>
		   </div>

		</div>
</body>
<!-- <script type="text/javascript" src="js/manager.js"></script> -->
	<script type="text/javascript">
		function chechForm() {
			
			var search = document.getElementById("search").value;
			var numcheck = /^[1-9][0-9]*$/ ;
			if(search == "" || search == null){
				alert("不能输入空值。。。");
				return false;
			}
				
			if(!(numcheck.test(search))){
				alert("请输入正整数。。。");
				return false;
			}
			return true;
		}
  		function gotoPage(num){
  			var numcheck = /^([1-9][0-9]*)$/ ;
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
  			window.location.href = "admin/AdminOrders.action?currentPage="+num;
  		}
  		
  		
  	</script>

</html>
