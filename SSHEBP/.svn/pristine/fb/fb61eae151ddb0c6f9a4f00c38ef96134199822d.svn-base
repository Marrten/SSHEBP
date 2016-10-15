<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>购买成功</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv='refresh' content='3;url=ebp/Category.action'>
<script type='text/javascript'>
	var i = 3;
	function getTime() {
		document.getElementById('num').innerHTML = "<font color='red'>" + i
				+ "</font>";
		i -= 1;
		var x = setTimeout('getTime()', 1000);
		if (i <= 0) {
			clearTimeout(x);
		}
	}
	window.onload = getTime;
</script>
</HEAD>
<BODY>
	<h2>
		购买成功!!页面将在
		<div id='num' style='display:inline;'>3</div>
		秒后跳转到主页面
	</h2>
</BODY>
</html>
