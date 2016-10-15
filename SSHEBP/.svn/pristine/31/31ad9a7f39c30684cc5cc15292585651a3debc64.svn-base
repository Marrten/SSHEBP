<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加书籍</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
   	<link rel="icon" href="admin/image/icon.png">
  	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.css">
  	<link rel="stylesheet" type="text/css" href="admin/css/manager.css">
  	<script type="text/javascript" src="admin/js/jquery-3.1.0.js"></script>
  	<script type="text/javascript" src="admin/js/bootstrap.js"></script>
  	<style type="text/css">
  	.content-collection{width: 955px;height: 395px; margin-top: 20px;}

	.collection-img a{font-size: 14px; font-weight: bold;}
	.collection-img a:link { color:black; text-decoration: none;}
	.collection-img a:visited{color:black; text-decoration: none;}
	.collection-img a:hover{color:orange; text-decoration: none;}
	.collection-img a:active {color:black; text-decoration: none;}
	
	.collection-img p span{font-size: 12px; font-weight: bold;}
	.collection-img p del{font-size: 12px; color: gray;}
	
	.collection-img .collection{
	  width: 285px;
	  height: 155px;
	  margin-top: 30px;
	  margin-left: 30px;
	  float: left;
	}
	.collection-img .center,.collection-img .right{
	  border-left: 1px solid #D8D8D8;
	  padding-left: 10px;
	}
	.collection .left-img{
	  width: 96px;
	  height: 155px;
	  float: left;
	}
	.collection .right-button{
	  width: 170px;
	  height: 155px;
	  float: right;
	
	}
	.collection .right-button .information{
	  height: 120px;
	}
	.reg-box { padding-left: 30px; }
	
	.reg-box li { line-height: 30px; width: 600px; overflow: hidden; }
	
	.reg-box li label { width: 68px; height: 50px; float: left; line-height: 50px; text-align: right; padding-right: 20px; }
	 form{padding: 20px 0px;}
	/* ul li {list-style: none;} */
	.sub {text-align: center;}
	.add{float: left;padding-left: 100px;}
	.filename{width:100px;}
</style>
</head>
<body>
  <!-- 搜索导航部分 -->
      <!-- 主体搜索部分 -->
    <div class="mbody">
        <div class="body-top">
          <div class="logo">
             <img src="admin/image/logo.png">
          </div>

          <div class="serch">
            <input class="txt" type="text" placeholder="搜索书名或作者...">
            <input class="butn" type="button">
          </div>
        </div>


         <!-- 主导航部分 -->
        <div class="main-nav">
              <ul class="center-nav">
                <li class="checked"><a href="abp/Category.jsp">首页</a></li>
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
        <li class="act"  value="2"><a href="admin/BookList">书籍管理</a></li>
        <li value="3"><a href="admin/AdminOrders.action">订单管理</a></li>
       </ul>
     </div>

       <!-- 管理项对应的内容 -->
       <!-- 内容二:书籍管理 -->
       <div class="manager-content2">

           <div class="panel-heading">
                  	书籍管理
                <div style="float: right;">
                <a href="admin/AdminCategory" style="color:blue;">
                <button class="btn btn-success addrepertory">添加<span class="glyphicon glyphicon-plus"></span></button></a>
                </div>

                <div class="col-md-4" style="float: right;  margin-top:-18px;">
                <form method="post" action="admin/FindBook">
                   	<div class="input-group">
                      <input type="text" class="form-control" placeholder='书名'>
                      	<span class="input-group-btn">
                       <button class="btn btn-info" type="button">搜索</button>
                      	</span>
                  	</div>
                </form>
                </div>
           </div>
           <div class="add">
             <form action="admin/AddBook" method="post" enctype="multipart/form-data">                
                    <ul class="reg-box">                 
                        <li>
                            <label for="">书名</label><input type="text" class="name" name="name" value="${param.name}" onBlur="checkName(this)" style="color:black; border:1px solid gray;"/>
                        	<span id="name">${errorMsgs.name}</span>
                        </li>
                        <li>
                            <label for="">作者</label><input type="text" class="author" name="author" value="${param.author}" onBlur="checkAuthor(this)" style="color:black;border:1px solid gray;" />
                        	<span id="author">${errorMsgs.author}</span>
                        </li>
                        <li>
                            <label for="">描述</label><textarea name="descration" class="descration" value="${param.descration}" onBlur="checkDescration(this)" cols="22px" rows="1px"></textarea>
                       		<span id="descration">${errorMsgs.descration}</span>
                        </li>
                        <li>
                            <label for="">原价</label><input type="text" name="oldprice" class="oldprice" value="${param.oldprice}" onBlur="checkOldprice(this)" style="color:black;border:1px solid gray;" />
                        	<span id="oldprice">${errorMsgs.oldprice}</span>
                        </li>
                        <li>
                            <label for="">现价</label><input type="text" name="price"  class="price" value="${param.price}" onBlur="checkPrice(this)" style="color:black;border:1px solid gray;" />
                        	<span id="price">${errorMsgs.price}</span>
                        </li>
                        <li>
                            <label for="">图片</label><input type="file" class="file" name="filename"  style="color:#999;" />
                        </li>
                        <li>
                            <label for="">数量</label><input type="text" class="amount" name="amount" value="${param.price}" onBlur="checkAmount(this)" style="color:black;border:1px solid gray;" />
                       		<span id="amount">${errorMsgs.amount}</span>
                        </li>
                        <li>
                            <label for="">类别</label>
                            <select id="firstname" onchange="getWhmans()" >
                            	<option>-请选择-</option>
                            <c:forEach items="${map}" var="entry">
								<option value="${entry.value}" check="">${entry.key}</option>
							</c:forEach>
							</select>
							<select	id="two" name="category_id"> 
                            	<option>请选择</option>  
                       	 	</select>
                        </li>
                    </ul>
                    <div class="sub" style="float: left;margin-top:-18px;margin-left:100px">
                        <input type="submit" class="btn btn-info" value="提交" />
                    </div>                  
                </form>
           </div>
          </div>
       </div>
      </div>
  </div>
</body>
<script type="text/javascript">
	var xmlDom = null;
	function getWhmans() {
		var id = $("#firstname option:selected").val();
		//alert(id);
		var param = "id="+id;
			$.ajax({   
				url: "admin/getName.jsp",
				data: param,
				dataType: "json",
				type: "get",
				success: successful,
				async: true,
				cache: false
			});
			function successful(data){
				$("#two").empty();
				$("#two").append("<option value='0'>-请选择-</option>");
				for(var attr in data){
					console.log(data[attr]);
					$("#two").append("<option value='" + data[attr] + "'>" + attr + "</option>");
				}
				
			}
		}
	function checkName(obj){
		if($.trim($(".reg-box .name").val()) == ''){
			 $(" .reg-box #name").html("书名不能为空").css('color','red').css('size','10px');
		}
	}
	function checkAuthor(obj){
		if($.trim($(".reg-box .author").val()) == ''){
			 $(" .reg-box #author").html("作者不能为空").css('color','red').css('size','10px');
		}
	}
	function checkDescration(obj){
		if($.trim($(".reg-box .descration").val()) == ''){
			 $(" .reg-box #descration").html("描述信息不能为空").css('color','red').css('size','10px');
		}
	}
	function checkOldprice(obj){
		var re = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
		if(re.test($(".reg-box .oldprice").val())){
		}else{
		 $(" .reg-box #oldprice").html("请输入正确的价格").css('color','red').css('size','10px');
		}
	}
	function checkPrice(obj){
		var re = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
		if(re.test($(".reg-box .price").val())){
		}else{
		 $(" .reg-box #price").html("请输入正确的价格").css('color','red').css('size','10px');
		}
	} 
	function checkAmount(obj){
		var re = /^\d+$ /;
		if(re.test($(".reg-box .amount").val())){
		}else{
		 $(" .reg-box #amount").html("请输入正确的数量").css('color','red').css('size','10px');
		}
	}
</script>
</html>
