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
<title>客户列表</title>
<link rel="stylesheet" type="text/css" href="${path }/css/css.css" />
<link href="${path }/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${path }/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">会员管理</a>&nbsp;-</span>&nbsp;会员管理
			</div>
		</div>

		<div class="page">
			<div class="banner">
				<div class="banShow">
					<table border="1" cellspacing="0" cellpadding="0" class="table table-hover">
						<tr class="success">
							<td width="150px" class="tdColor tdC">序号</td>
							<td width="100px" class="tdColor">客户昵称</td>
							<td width="200px" class="tdColor">客户密码</td>
							<td width="100px" class="tdColor">姓名</td>
							<td width="250px" class="tdColor">邮箱</td>
							<td width="250px" class="tdColor">收货地址</td>
							<td width="50px" class="tdColor">状态</td>
							<td width="100px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${userList }" var="u">
							<tr>
								<td>${u.uid}</td>
								<td>${u.userName }</td>
								<td>${u.password }</td>
								<td>${u.name }</td>
								<td>${u.email }</td>
								<td>${u.addr }</td>
								<td>${u.state }</td>
								<td><a href="${path }/toEditUser/<c:out value="${u.uid }" />">
										<img class="operation" src="${path }/img/update.png">
								</a> <a
									href="${path }/deleteUser/<c:out value="${u.uid }" />/<c:out value="${page }" />">
										<img class="operation delban" src="${path }/img/delete.png">
								</a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging">
						第
						<c:out value="${page}" />
						页/共
						<c:out value="${totalPage }" />
						页
						<c:if test="${page != 1 }">
							<a href="${path }/listUser/1">首页</a>|
								<a href="${path }/listUser/<c:out value="${page - 1 }"/>">上一页</a>|
							</c:if>
						<c:if test="${page != totalPage }">
							<a href="${path }/listUser/<c:out value="${page + 1 }"/>">下一页</a>|
									<a href="${path }/listUser/<c:out value="${totalPage }"/>">尾页</a>|
							</c:if>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>