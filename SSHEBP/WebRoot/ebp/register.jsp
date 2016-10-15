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
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="ebp/css/bootstrap.css">
    <script type="text/javascript" src="ebp/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="ebp/js/bootstrap.js"></script>
    <style>
     *{
         margin: 0px;
         padding: 0px;
     }
     /*布局开始*/
     #login_dialog {
         position: fixed;
         left: 50%;
         top: 15%;
         /* background-color: #303a40; */
         width: 500px;
         margin-left: -200px;
         margin-top: -100px;
         font-family: "黑体";
         /*禁止复制粘贴*/
         -moz-user-select: none;
         -webkit-user-select: none;
         user-select:none;
     }
     .register_dialog_title {
         height: 35px;
         line-height: 35px;
         margin: 0 5px;
     }

     .register_dialog_info {
         float: left;
         margin-left:10px;
         color: #fff;
         margin-top: 5px;
         font-size: 20px;
     }
     #register_dialog {
         position: fixed;
         left: 40%;
         top: 40%;
         background-color: #303a40;
         width: 500px;
     /*  height: 600px; */
         margin-left: -200px;
         margin-top: -200px;
         font-family: "黑体";
         -moz-user-select:none; /*火狐*/
         -webkit-user-select:none; /*webkit浏览器*/
         -ms-user-select:none; /*IE10*/
         -khtml-user-select:none; /*早期浏览器*/
         user-select:none;
     }

     .register_dialog_info {
         float: left;
         margin-left:10px;
         color: #fff;
         margin-top: 5px;
         font-size: 20px;
     }
     .dialog_close {
         cursor: pointer;
         width: 40px;
         height:40px;
         border-radius:25px;
         float: right;
         line-height:40px;
         font-size: 20px;
         color: #d8dadb;
         font-family: "微软雅黑";
         text-align: center;
         cursor:center;
     }
     form{padding: 20px 0px;}
     ul li {list-style: none;}
     .sub {
         text-align: center;
     }
     .sub input {
         display: inline-block;
         width: 300px;
         background-color: rgb(255, 109, 11);
         color: rgb(255, 255, 255);
         font-size: 20px;
         text-align: center;
         height: 40px;
         line-height: 40px;
         font-family: 黑体;
         outline: none;
         border: none;
         margin: auto;
     }
     .dialog_close:hover {
         background-color: #566
     }
     input[type = "submit"]:hover{cursor: pointer;}
     /*布局结束*/
     .reg-box { padding-left: 30px; }

     .reg-box li { line-height: 50px; width: 500px; overflow: hidden; }

     .reg-box li label { width: 80px; height: 50px; float: left; line-height: 50px; text-align: right; padding-right: 20px; }

     .reg-box li input,.reg-box li select{ padding: 6px 0; font-size: 16px; width: 296px; height: 50px; line-height: 28px; border: 1px solid #dddddd; text-indent: 0.5em; float: left; }

     .reg-box li select option{font-size:16px;}

     .registered .btn a { background: #ff7200; margin-left: 110px; }
     /*验证码*/
     .add { width: 128px; height: 44px; float: left; _display: inline; cursor: pointer; margin-left: 20px; }

     .reg-box li .sradd { width: 148px; text-indent: 4px; font-size: 14px; }

     .reg-box li .input-code { width: 106px; padding: 10px; font-family: Arial; font-style: italic; color: red; letter-spacing: 1px; cursor: pointer; text-align: center; text-indent: 0; }

     .yzm,.phoKey { background: #ff7200; text-align: center; line-height: 44px; color: #fff; }

     .phoKey{letter-spacing: 3px; font-size:18px;}

     .yzmc { background: #dddddd; text-align: center; line-height: 44px; color: #999; }

     .error { clear:both;display:block;color: red; padding-left: 90px; padding-bottom:5px;height:20px;float: left; font-size:12px;line-height: 20px;}

     input { background-color: #fff; outline: none; }

     .reg-box li { width: auto; }

     .reg-box li input.errorC, .errorC{ border: 1px solid red; }

     .reg-box li input.checkedN , .checkedN{ border: 1px solid #1ece6d; }
     #gender{width: 15px;}
     #usernames{display:block;}
        </style>
    
  </head>
  <body>
        <div id="login_dialog" class="panel panel-success">
             <div class="panel-heading"> 
                <h3 class="panel-title">注册</h3> 
             </div> 
             <span style="color:red;font-size:30px;align="center"><s:actionerror /></span>
            <div style="background-color:#ffffff;margin:10px;" class="panel-body">
                <form action="ebp/Register" method="post">                
                    <ul class="reg-box">                 
                        <li>
                            <label for="">用户名</label><input type="text" name="username" value="${formbean.username}" placeholder="请输入您的用户名" class="account" style="color:#999;" onBlur="usernameCheck(this)" onFocus="textFocus(this)"/>
                            <span class="error error5" id="username"></span>
                        </li>
                            	<font color='red' size="-1" id="usernames"><i>
                    				<s:fielderror>	
			                        	<s:param>username</s:param>
			                   	 	</s:fielderror>
               					 </i></font>
                        <li>
                            <label for="">密    码</label><input type="password" name="password" value="${formbean.password}" class = "password" placeholder="请输入密码" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/><br>
                            <span class="error error6"></span>
                        </li>
                           		<font color='red' size="-1" id="usernames"><i>
                    				<s:fielderror>	
			                        	<s:param>passsword</s:param>
			                   	 	</s:fielderror>
               					 </i></font>
                        <li>
                            <label for="">确认密码</label><input type="password" name="repassword" value="${formbean.repassword}" class = "email" placeholder="请再次输入密码" style="color:#999;" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
                            <span class="error error4"> </span>
                        </li>
                        <font color='red' size="-1" id="usernames"><i>
                    				<s:fielderror>	
			                        	<s:param>repassword</s:param>
			                   	 	</s:fielderror>
               					 </i></font>
                        <li>
                            <label for="">验证码</label><input type="text" name="code" class="sradd photokey" placeholder="请输入验证码" style="color:#999;ime-mode:disabled;-webkit-ime-mode:inactive;" onBlur="textBlur(this)" onFocus=" textFocus(this) "  />
                           <span><img src="ebp/AuthCode" onclick="reflush(this)"></span>
                            <span class="error error7">
                    		</span>
                        </li>
                            	<font color='red' size="-1" id="usernames"><i>
                    				<s:fielderror>	
			                        	<s:param>code</s:param>
			                   	 	</s:fielderror>
               					 </i></font>
                        
                    </ul>
                    <div class="sub">
                        <input type="submit" class="loin_btn" value="注册" />
                    </div> 
                    	                
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">
    
    function reflush(img){
  	var url = img.src;
	if(url!=null&&url.lastIndexOf("?")!=-1){
		url=url.substring(0,url.indexOf("?"));
	}
	img.src = url+"?"+new Date().getMilliseconds();
  }    
    //文本框默认提示文字
    function textFocus(el) {
        if (el.defaultValue == el.value) { el.value = ''; el.style.color = '#333'; }
    }
    function textBlur(el) {
        if (el.value == '') { el.value = el.defaultValue; el.style.color = '#999'; }
    }

    $(function(){ 
        //注册页面的提示文字
       (function register(){
           //手机号栏失去焦点
            $(".reg-box .phone").blur(function(){
                reg=/^1[3|4|5|7|8][0-9]\d{4,8}$/;//验证手机正则(输入前7位至11位)

                if( $(this).val()==""|| $(this).val()=="请输入您的手机号")
                { 
                    $(this).addClass("errorC");
                    $(this).next().html("请输入您的手机号");
                    $(this).next().css("display","block");
                }
                else if($(this).val().length<11)
                {   
                    $(this).addClass("errorC");
                    $(this).next().html("手机号长度有误！");
                    $(this).next().css("display","block");
                }
                else if(!reg.test($(".reg-box .phone").val()))
                {   
                    $(this).addClass("errorC");
                    $(this).next().html("手机号不存在!");
                    $(this).next().css("display","block");
                }
                else
                {
                    $(this).addClass("checkedN");
                    $(this).removeClass("errorC");
                    $(this).next().empty();
                }
            });

            //验证码栏失去焦点
            $(".reg-box .phonekey").blur(function(){
                reg=/^[A-Za-z0-9]{6}$/;
                if( $(this).val()=="" || $(this).val()=="请输入收到的验证码")
                {
                    $(this).addClass("errorC");
                   // $(this).next().next().html("请填写验证码");
                    $(this).next().next().css("display","block");
                }
                else if(!reg.test($(".phonekey").val()))
                {
                    $(this).addClass("errorC");
                  //  $(this).next().next().html("验证码输入有误！");
                    $(this).next().next().css("display","block");
                } 
                else 
                {
                    $(this).removeClass("errorC");
                    $(this).next().next().empty();
                    $(this).addClass("checkedN");
              }
            });

            //密码栏失去焦点
            $(".reg-box .password").blur(function(){
                reg=/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
                if(!reg.test($(".password").val()))
                {
                    $(this).addClass("errorC");
                    $(this).next().html("格式有误，请输入6~12位的数字、字母或特殊字符！");
                    $(this).next().css("display","block");
                }
                else 
                {
                    $(this).removeClass("errorC");
                    $(".reg-box .error3").empty();
                    $(this).addClass("checkedN");
                }
            });
            /*确认密码失去焦点*/
            $(".reg-box .email").blur(function(){
                var pwd1=$('.reg-box .password').val();
                var pwd2=$(this).val();
                console.log(pwd1);
                console.log(pwd2);
                if(($(this).val() == '请再次输入密码' || $(this).val() == "") && (pwd1 == "请输入密码" || pwd1 == "") ){                  
                        return;
                }else if(pwd1!=pwd2)
                {
                    $(this).addClass("errorC");
                    $(this).removeClass("checkedN");
                    $(this).next().html("两次密码输入不一致！");
                    $(this).next().css("display","block");
                }
                else 
                {
                    $(this).removeClass("errorC");
                    $(this).next().empty();
                    $(this).addClass("checkedN");
                }
            });
       })();
        /*生成验证码*/
        (function create_code(){
            function shuffle(){
                var arr=['1','r','Q','4','S','6','w','u','D','I','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                        'q','2','s','t','8','v','7','x','y','z','A','B','C','9','E','F','G','H','0','J','K','L','M','N','O','P','3','R',
                        '5','T','U','V','W','X','Y','Z'];
                return arr.sort(function(){
                    return (Math.random()-.5);
                });
            };
            shuffle();      
            function show_code(){
                var ar1='';
                var code=shuffle();
                for(var i=0;i<4;i++){
                    ar1+=code[i];
                };
                $(".reg-box .phoKey").text(ar1);
            };
            show_code();
            $(".reg-box .phoKey").click(function(){
                show_code();
            }); 
        })();

        //注册页面的提示文字
   
        //账户输入框失去焦点
        (function login_validate(){
             $(".reg-box .account").blur(function(){
                 reg=/[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/;

                  if( $(this).val()==""|| $(this).val()=="请输入您的用户名")
                { 
                    $(this).addClass("errorC");
                    $(this).next().html("用户名不能为空");		
                    $(this).next().css("display","block");
                }
                else if($(".reg-box .account").val().length<2)
                {   
                    $(this).addClass("errorC");
                    $(this).next().html("用户名长度有误！");
                    $(this).next().css("display","block");
                }
                else
                {
                    //$(this).addClass("checkedN");
                    //$(this).removeClass("errorC");
                   // $(this).next().empty();
                } 
               
            }); 
            /*密码输入框失去焦点*/
            $(".reg-box .admin_pwd").blur(function(){
                reg=/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;

                if($(this).val() == "请输入密码"){
                    $(this).addClass("errorC");
                    $(this).next().html("密码不能为空！");
                    $(this).next().css("display","block");

                }else if(!reg.test($(".admin_pwd").val()))
                {
                    $(this).addClass("errorC");
                    $(this).next().html("密码为6~12位的数字、字母或特殊字符！");
                    $(this).next().css("display","block");
                }else
                {
                    $(this).addClass("checkedN");
                    $(this).removeClass("errorC");
                    $(this).next().empty();
                }
            });

            /*验证码输入框失去焦点*/
            $(".reg-box .photokey").blur(function(){
                var code1=$('.reg-box input.photokey').val().toLowerCase();
                var code2=$(".reg-box .phoKey").text().toLowerCase(); 
                if(code1!=code2)
                {
                   // $(this).addClass("errorC");
                  //  $(this).next().next().html("验证码输入错误！");
                    $(this).next().next().css("display","block");
                }
                else 
                {
                    $(this).removeClass("errorC");
                    $(this).next().next().empty();
                    $(this).addClass("checkedN");
                }
            })
        })();
    }); 

    /*清除提示信息*/
    function emptyRegister(){
        $(".reg-box .phone,.reg-box .phonekey,.reg-box .password,.reg-box .email").removeClass("errorC");;
        $(".reg-box .error1,.reg-box .error2,.reg-box .error3,.reg-box .error4").empty();
    }
    function emptyLogin(){
        $(".reg-box .account,.reg-box .admin_pwd,.reg-box .photokey").removeClass("errorC");;
        $(".reg-box .error5,.reg-box .error6,.reg-box .error7").empty();
    }
	 
	 //验证用户名是否已存在
	 function usernameCheck(obj){
		 var username = $.trim($(".reg-box .account").val());
		//alert(username);
	    var param = "username=" + username;
			$.ajax({   
				url: "ebp/userIsExist.jsp",
				data: param,
				dataType: "json",
				type: "get",
				success: successful,
				async: true,
				cache: false
			});
			
			function successful(data){
		 		if(data != null){
			 	 $("#username").html("用户名已存在").css('color','red').css('size','10px');
			 }else{
			 	$("#username").text("");
			 }
		}
	}
		
</script>
</html>
  
