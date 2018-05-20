<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物交易管理</title>
<link href="${path }/css/public.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/page.css" rel="stylesheet" type="text/css"  />
<link href="${path }/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
<script type="text/javascript" src="${path }/js/public.js"></script>
</head>
<body>
	<!-- 登陆 start -->
	<div class="logDiv">
		<img class="logBanner" src="img/bg-login.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">宠物管理系统登录</p>
				<p class="p2"><a href="${path }/index">返回首页</a></p>
			</div>
			<!-- 输入框 -->
			<form action="adminLogin" method="post">
				<div class="lgD">
					<img class="img1" src="img/logName.png" />
					<input type="text" class="form-control" name="username" placeholder="输入用户名" />
					<%-- <form:input path="username"/>
					<font color="red"><form:errors path="username"></form:errors></font> --%>
				</div>
				<div class="lgD">
					<img class="img1" src="img/logPwd.png" />
					<input type="password" class="form-control" name="password" placeholder="输入用户密码" />
					<%-- <form:input path="password"/>
					<font color="red"><form:errors path="password"></form:errors></font> --%>
				</div>
				<div class="logC">
					<button class="form-control">登 录</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 登录 end -->

	<!-- 登录页面底部 -->
	<div class="logFoot">
		<p class="p1">版权所有：2014级</p>
		<p class="p2">@CopyRight 2017~2018</p>
	</div>
	<!-- 登录页面底部end -->
</body>
</html>