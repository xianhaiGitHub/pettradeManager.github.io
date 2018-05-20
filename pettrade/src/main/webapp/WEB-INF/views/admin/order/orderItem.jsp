<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物详情</title>
<link rel="stylesheet" type="text/css" href="${path }/css/css.css" />
<link href="${path }/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="0" class="table table-hover">
			<tr class="success">
				<td width="150px" class="tdColor">宠物编号</td>
				<td width="100px" class="tdColor">宠物价格</td>
				<td width="200px" class="tdColor">购买宠物数量</td>
				<td width="100px" class="tdColor">总价格</td>
				<td width="100px" class="tdColor">操作</td>
			</tr>
			<c:forEach items="${orderItem }" var="ot">
				<tr>
					<td>${ot.pet.pid}</td>
					<td>${ot.pet.shopPrice }</td>
					<td>${ot.count }</td>
					<td>${ot.subtotal }</td>
					<td><a href="${path }/toEditUser/<c:out value="${u.uid }" />">
							<img class="operation" src="${path }/img/update.png">
					</a> <a
						href="${path }/deleteUser/<c:out value="${u.uid }" />/<c:out value="${page }" />">
							<img class="operation delban" src="${path }/img/delete.png">
					</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>