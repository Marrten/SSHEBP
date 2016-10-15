<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
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
	<script type="text/javascript">
		function findBooks(id) {
			
			window.location.href="ebp/Category.action?category_id=" + id;
			/* alert(id); */
		}
	</script>
</head>
	<body>
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
	    					<c:when test="${empty user}">
	    						<li class="rt-li"><a href="ebp/login.jsp">登录</a>/<a href="ebp/register.jsp">注册</a></li>
	    					</c:when>
	    						
	    					<c:otherwise>
	    						<li class="rt-li"><a href="action/Quit">退出</a></li>
	    						<li class="part">|</li>
	    						<li class="rt-li"><a href="ebp/personal.jsp">${user.username}</a></li>
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

	    		<div class="serch">
	    			<input class="txt" type="text" placeholder="搜索书名或作者...">
	    			<input class="butn" type="button">
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

        <!-- 主体内容一:首页内容 -->
        <div class="body-content1">

		    <!-- 主体banner部分 -->
		    <div class="banner">
		         <!-- 左侧盒子:小说分类导航 -->
		    	<div id="big_banner_wrap">
		         <ul id="banner_menu_wrap">
		            <c:set var="top" value="55" />
		            <c:forEach items="${map}" var="entry">
		              <c:set var="top" value="${top - 55}" />
				      <li class="active">
		                 <a>${entry.key}</a>
		                 <a class="banner_menu_i carousel-control right">&rsaquo;</a>
		                 <div class="banner_menu_content" style="width: 300px; height:630px; top:${top}px;">
		                     
		                     <ul class="banner_menu_content_ul">
		                     	<c:forEach var="category" items="${entry.value}">
			                     	<li><a href="javascript:void(0)" >${category.name }</a><span onclick="findBooks(${category.id})">选购</span></li>
		                     	</c:forEach>
		                        
		                     </ul>
			             </div>
		             </li>
					</c:forEach>
		         </ul>
                </div>

		    	<!-- 右侧盒子:循环滚动图片浏览 -->
		    	<div id="big_banner_pic_wrap">
		    	    <!-- 轮播插件 -->
					<!--
						容器:carousel slide
						自动轮播:data-ride="carousel"
					 -->
					 <!-- 保证容器大小和图片要一致  否则出现问题 -->
					<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width:955px">
						<!-- 分页控件 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" class="active" data-slide-to="0"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
							<li data-target="#myCarousel" data-slide-to="3"></li>
							<i data-target="#myCarousel" data-slide-to="4"></i>
							<li data-target="#myCarousel" data-slide-to="5"></li>
						</ol>
						<!-- 图片内容 <-->
						<div class="carousel-inner">
							<div class="item active">
								<a href="#"><img src="ebp/image/scr1.jpg" alt="第一张"></a>
							</div>
							<div class="item">
								<a href="#"><img src="ebp/image/scr2.jpg" alt="第二张"></a>
							</div>
							<div class="item">
								<a href="#"><img src="ebp/image/scr3.jpg" alt="第三张"></a>
							</div>
							<div class="item">
								<a href="#"><img src="ebp/image/scr4.jpg" alt="第四张"></a>
							</div>
							<div class="item">
								<a href="#"><img src="ebp/image/scr5.jpg" alt="第五张"></a>
							</div>
							<div class="item">
								<a href="#"><img src="ebp/image/scr6.jpg" alt="第六张"></a>
							</div>
						</div>
						<!-- data-slide:上下图片的切换 -->
						<a href="#myCarousel" data-slide="prev" class="carousel-control left"><span class="glyphicon glyphicon-chevron-left"></span></a>
						<a href="#myCarousel" data-slide="next" class="carousel-control right"><span class="glyphicon glyphicon-chevron-right"></span></a>

					</div>

					<!-- 重磅推荐 -->
                    <div class="choose-title">重磅推荐</div>

                    <div class="collection-img">
						<c:forEach items="${recommendMap}" var="entry">
						<c:if test="${entry.key % 3 == 1}">
                        <div class="collection left">
	                        <div class="left-img">
	                    		<img src="${entry.value.filename}">
		                    	<p class="price">
		                    		<span>￥${entry.value.price }</span>
		                    		<del>￥${entry.value.oldprice }</del>
		                    	</p>
	                        </div>

	                    	<div class="right-button">
	                    	    <div class="information">
		                    	    <p><a href="ebp/ShowBookInfo.action?book_id=${entry.value.id }">${entry.value.name }</a></p>
		                    		<p>${entry.value.descration }</p>
	                    	    </div>

	                    		<div class="bt">
	                    			<button  class="btn btn-info btn-sm" onclick="buyAtOnce(${entry.value.id })">立即购买</button>
	                    			<button class="btn btn-info btn-sm" onclick="addBook(${entry.value.id })">加入购物车</button>
	                    		</div>
	                    	</div>
                       </div>
                       </c:if>
						
					   <c:if test="${entry.key % 3 == 2}">
                       <div class="collection center">
	                        <div class="left-img">
	                    		<img src="${entry.value.filename}">
		                    	<p class="price">
		                    		<span>￥${entry.value.price }</span>
		                    		<del>￥${entry.value.oldprice }</del>
		                    	</p>
	                        </div>

	                    	<div class="right-button">
	                    	    <div class="information">
	                    	    	<p><a href="ebp/ShowBookInfo.action?book_id=${entry.value.id }">${entry.value.name }</a></p>
	                    		    <p>${entry.value.descration }</p>
	                    	    </div>

	                    		<div class="bt">
	                    			<button  class="btn btn-info btn-sm" onclick="buyAtOnce(${entry.value.id })">立即购买</button>
	                    			<button class="btn btn-info btn-sm" onclick="addBook(${entry.value.id })">加入购物车</button>
	                    		</div>
	                    	</div>
                       </div>
                       </c:if>
                       
					   <c:if test="${entry.key % 3 == 0}">
                       <div class="collection right">
	                        <div class="left-img">
	                    		<img src="${entry.value.filename}">
		                    	<p class="price">
		                    		<span>￥${entry.value.price }</span>
		                    		<del>￥${entry.value.oldprice }</del>
		                    	</p>
	                        </div>

	                    	<div class="right-button">
	                    	    <div class="information">
	                    	    	<p><a href="ebp/ShowBookInfo.action?book_id=${entry.value.id }">${entry.value.name }</a></p>
	                    		    <p>${entry.value.descration }</p>
	                    	    </div>

	                    		<div class="bt">
	                    			<button  class="btn btn-info btn-sm" onclick="buyAtOnce(${entry.value.id })">立即购买</button>
	                    			<button class="btn btn-info btn-sm" onclick="addBook(${entry.value.id })">加入购物车</button>
	                    		</div>
	                    	</div>
                       </div>
                       </c:if>
                       </c:forEach>

                       <div class="new-flash">
                       	 <p>活动快讯</p>
                       	 <ul>
                       	 	<li>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</li>
                       	 	<li><a href="#">超级畅销的好书特价啦，戳此看看～</a></li>
                       	 </ul>
                       </div>
                    </div>
			        </div>
	        </div>

	        <!-- 主体content部分 -->
	        <div class="content">
	            <!-- 左侧广告栏 -->
	            <div class="poster">
	            	<ul class="poster-list">
	            		<li><img src="ebp/image/content1.jpg"></li>
	            		<li><img src="ebp/image/content2.jpg"></li>
	            		<li><img src="ebp/image/content3.jpg"></li>
	            	</ul>
	            </div>

	            <!-- 右侧书籍展示 -->
	            <div class="content-collection">
	                <div class="content-top">
	                    <div class="collection-img">
	                
	                <c:forEach var="book" items="${requestScope.books}">
	                	<c:if test="${book.key % 6 == 0}">
	                		<div class="collection left">
		                        <div class="left-img">
		                    		<img src="${book.value.filename}">
			                    	<p class="price">
			                    		<span>￥${book.value.price}</span>
			                    		<del>￥${book.value.oldprice}</del>
			                    	</p>
		                        </div>
	
		                    	<div class="right-button">
		                    	    <div class="information">
			                    	    <p><a href="ebp/ShowBookInfo.action?book_id=${book.value.id }">${book.value.name}</a></p>
			                    		<p>${book.value.descration}</p>
		                    	    </div>
	
		                    		<div class="bt">
		                    			<button  class="btn btn-info btn-sm" onclick="buyAtOnce(${book.value.id})">立即购买</button>
		                    			<button class="btn btn-info btn-sm" onclick="addBook(${book.value.id})">加入购物车</button>
		                    		</div>
		                    	</div>
                       		</div>
	                	</c:if>
	                	<c:if test="${book.key % 6 == 1}">
	                		<div class="collection center">
		                        <div class="left-img">
		                    		<img src="${book.value.filename}">
			                    	<p class="price">
			                    		<span>￥${book.value.price}</span>
			                    		<del>￥${book.value.oldprice}</del>
			                    	</p>
		                        </div>
	
		                    	<div class="right-button">
		                    	    <div class="information">
		                    	    	<p><a href="ebp/ShowBookInfo.action?book_id=${book.value.id }">${book.value.name}</a></p>
		                    		    <p>${book.value.descration} </p>
		                    	    </div>
	
		                    		<div class="bt">
		                    			<button class="btn btn-info btn-sm" onclick="buyAtOnce(${book.value.id})">立即购买</button>
		                    			<button class="btn btn-info btn-sm" onclick="addBook(${book.value.id})">加入购物车</button>
		                    		</div>
		                    	</div>
	                       </div>
	                	</c:if>
	                	<c:if test="${book.key % 6 == 2}">
	                		<div class="collection right">
		                        <div class="left-img">
		                    		<img src="${book.value.filename}">
			                    	<p class="price">
			                    		<span>￥${book.value.price}</span>
			                    		<del>￥${book.value.oldprice}</del>
			                    	</p>
		                        </div>
	
		                    	<div class="right-button">
		                    	    <div class="information">
		                    	    	<p><a href="ebp/ShowBookInfo.action?book_id=${book.value.id }">${book.value.name}</a></p>
		                    		    <p>${book.value.descration} </p>
		                    	    </div>
	
		                    		<div class="bt">
		                    			<button class="btn btn-info btn-sm" onclick="buyAtOnce(${book.value.id})">立即购买</button>
		                    			<button class="btn btn-info btn-sm" onclick="addBook(${book.value.id})">加入购物车</button>
		                    		</div>
		                    	</div>
		                </div>
	                	</c:if>
	                	<c:if test="${book.key % 6 == 3}">
	                		<div class="content-bottom">
			                    <div class="collection-img">
		
		                        <div class="collection left">
			                        <div class="left-img">
			                    		<img src="${book.value.filename}">
				                    	<p class="price">
				                    		<span>￥${book.value.price}</span>
				                    		<del>￥${book.value.oldprice}</del>
				                    	</p>
			                        </div>
		
			                    	<div class="right-button">
			                    	    <div class="information">
				                    	    <p><a href="ebp/ShowBookInfo.action?book_id=${book.value.id }">${book.value.name}</a></p>
		                    		    	<p>${book.value.descration} </p>
			                    	    </div>
		
			                    		<div class="bt">
			                    			<button class="btn btn-info btn-sm" onclick="buyAtOnce(${book.value.id})">立即购买</button>
		                    				<button class="btn btn-info btn-sm" onclick="addBook(${book.value.id})">加入购物车</button>
			                    		</div>
			                    	</div>
		                       </div>
	                	</c:if>
	                	<c:if test="${book.key % 6 == 4}">
	                		<div class="collection center">
		                        <div class="left-img">
		                    		<img src="${book.value.filename}">
			                    	<p class="price">
			                    		<span>￥${book.value.price}</span>
			                    		<del>￥${book.value.oldprice}</del>
			                    	</p>
		                        </div>
	
		                    	<div class="right-button">
		                    	    <div class="information">
		                    	    	<p><a href="ebp/ShowBookInfo.action?book_id=${book.value.id }">${book.value.name}</a></p>
		                    		    	<p>${book.value.descration} </p>
		                    	    </div>
	
		                    		<div class="bt">
		                    			<button class="btn btn-info btn-sm" onclick="buyAtOnce(${book.value.id})">立即购买</button>
		                    			<button class="btn btn-info btn-sm" onclick="addBook(${book.value.id})">加入购物车</button>
		                    		</div>
		                    	</div>
	                       </div>
	                	</c:if>
	                	<c:if test="${book.key % 6 == 5}">
	                		<div class="collection right">
		                        <div class="left-img">
		                    		<img src="${book.value.filename}">
			                    	<p class="price">
			                    		<span>￥${book.value.price}</span>
			                    		<del>￥1${book.value.oldprice}</del>
			                    	</p>
		                        </div>
	
		                    	<div class="right-button">
		                    	    <div class="information">
		                    	    	<p><a href="ebp/ShowBookInfo.action?book_id=${book.value.id }">${book.value.name}</a></p>
		                    		    	<p>${book.value.descration} </p>
		                    	    </div>
	
		                    		<div class="bt">
		                    			<button class="btn btn-info btn-sm" onclick="buyAtOnce(${book.value.id})">立即购买</button>
		                    			<button class="btn btn-info btn-sm" onclick="addBook(${book.value.id})">加入购物车</button>
		                    		</div>
		                    	</div>
		                	</div>
	                	</c:if>
	                </c:forEach>
	                <span><s:actionerror/></span>
	                
                 </div>
	            </div>

	        </div>
        </div>

        <!--  页面切换按钮  -->
	    <!-- <div class="person-bottom" style="padding-top: 50px; float: right; ">
	        <button class="btn btn-default">确定</button>
	        <span class="bottom-txt">到第<input type="text" value="1" style="width: 40px; height: 35px; text-align: center;">页</span>
	        <p class='bottom-txt' style=''>共35页</p>
	        <button class="btn btn-default">下一页&nbsp;&gt;</button>
	        <p class='bottom-txt' style=''>......</p>
	        <button  class="btn btn-default">7</button>
	        <button  class="btn btn-default">6</button>
	        <button  class="btn btn-default">5</button>
	        <button  class="btn btn-default">4</button>
	        <button   class="btn btn-default">3</button>
	        <button  class="btn btn-default">2</button>
	        <p class='bottom-txt' style=''>1</p>
	        <button class="btn btn-default disabled">&lt;&nbsp;上一页</button>
	    </div> -->

   </body>
<script type="text/javascript" src="ebp/js/duokan.js"></script>

</html>
