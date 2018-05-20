<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>宠物列表</title>
<link href="${path }/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${path }/css/css.css" />
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${path }/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">宠物管理</a>&nbsp;-</span>&nbsp;宠物管理
			</div>
		</div>

		<div class="page">
			<div class="banner">
				<div class="add">
					<a class="addA" href="${path }/toaddpet">添加宠物</a>
				</div>
				<!-- 一级类目 表格 显示 -->
				<div class="banShow">
					<table border="1" cellspacing="0" cellpadding="0" class="table table-hover">
						<tr>
							<td width="50px" class="tdColor tdC">序号</td>
							<td width="150px" class="tdColor">宠物图片</td>
							<td width="250px" class="tdColor">宠物名称</td>
							<td width="250px" class="tdColor">市场价格</td>
							<td width="250px" class="tdColor">宠物价格</td>
							<td width="250px" class="tdColor">库存</td>
							<td width="250px" class="tdColor">日期</td>
							<td width="50px" class="tdColor">是否热门</td>
							<td width="150px" class="tdColor">操作</td>
						</tr>

						<c:forEach items="${listPet }" var="pets">
							<tr>
								<td>${pets.pid }</td>
								<td><img width="100" src="${path }/${pets.image }"></td>
								<td>${pets.pname }</td>
								<td>${pets.markPrice }</td>
								<td>${pets.shopPrice }</td>
								<td>${pets.inventory }</td>
								<td>${pets.pdate }</td>
								<td><c:if test="${pets.isHot == 1 }">是</c:if> <c:if
										test="${pets.isHot != 1 }">否</c:if></td>
								<td><a
									href="${path }/toEditPet/<c:out value="${pets.pid }"/>">
										<img class="operation" src="${path }/img/update.png">
								</a> <a
									href="${path }/deletePet/<c:out value="${pets.pid}"/>/<c:out value="${page}"/>">
										<img class="operation delban" src="${path }/img/delete.png">
								</a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="paging">
						第
						<c:out value="${currPage }" />
						页/共
						<c:out value="${totalPetPage }" />
						页
						<c:if test="${currPage != 1 }">
							<a href="${path }/listpet/1">首页</a>|
							<a href="${path }/listpet/<c:out value="${currPage - 1 }"/>">上一页</a>|
						</c:if>
						<c:if test="${currPage != totalPetPage }">
							<a href="${path }/listpet/<c:out value="${currPage + 1 }"/>">下一页</a>|
							<a href="${path }/listpet/<c:out value="${totalPetPage }"/>">尾页</a>|
					 	</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>