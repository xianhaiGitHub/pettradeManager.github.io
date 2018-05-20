<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员编辑</title>
<link href="${path }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
</head>

<body>
	<form:form name="Form1" action="${path }/updateUser" method="post" modelAttribute="user">
		<table width="100%" class="table table-hover">
			<tr>
				<td align="right"><strong>编辑用户</strong></td>
			</tr>
			<form:hidden path="state"/>
			<form:hidden path="uid"/>
			<form:hidden path="code"/>
			<form:hidden path="key"/>
			<tr>
				<td align="right">客户名称：</td>
				<td><form:input type="text" path="userName" class="form-control input-sm" width="100px"/></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><form:input type="password" path="password" class="form-control input-sm" /></td>
			</tr>
			<tr>
				<td align="right">真实姓名：</td>
				<td><form:input type="text" path="name" class="form-control input-sm" /></td>
			</tr>
			<tr>
				<td align="right">邮箱：</td>
				<td><form:input type="text" path="email" class="form-control input-sm" /></td>
			</tr>
			<tr>
				<td align="right">电话：</td>
				<td><form:input type="text" path="phone" class="form-control input-sm" /></td>
			</tr>
			<tr>
				<td align="right">收货地址：</td>
				<td><form:input type="text" path="addr" class="form-control input-sm" /></td>
			</tr>
			<tr>
				<td align="center"class="ta_01" style="WIDTH: 100%" bgColor="#f5fafe" colSpan="4">
					<button class="btn btn-success" type="submit" value="确定">确定</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-primary" type="button" onclick="history.go(-1)" value="返回">返回</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</HTML>