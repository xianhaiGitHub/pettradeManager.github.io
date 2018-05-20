<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/cart.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>
	<!-- 当购物车不为空的情况  -->
	<div class="container cart">
		<c:if test="${fn:length(sessionScope.cart.cartItems) != 0 }">
			<div class="span24">
				<table>
					<tbody>
						<tr>
							<th>宠物图片</th>
							<th>宠物名称</th>
							<th>宠物价格</th>
							<th>宠物数量</th>
							<th>小计</th>
							<th>操作</th>
						</tr>

						<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
							<tr>
								<td width="60"><a
									href="${path }/findByPid/<c:out value="${cartItem.pet.pid}"/>">
										<img src="${path }/<c:out value="${cartItem.pet.image}"/>" />
								</a></td>
								<td><a target="_blank"
									href="${path }/findByPid/<c:out value="${cartItem.pet.pid}"/>">
										<c:out value="${cartItem.pet.pname}" />
								</a></td>
								<td>${cartItem.pet.shopPrice }</td>
								<td class="quantity" width="60"><c:out
										value="${cartItem.count}" /></td>
								<td width="140"><span class="subtotal">￥<c:out
											value="${cartItem.subtotal}" /></span></td>
								<td><a
									href="${path }/deleteCart/<c:out value="${cartItem.pet.pid}"/>"
									class="delete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


				<div class="bottom">

					<a href="${path }/clearCart" id="clear" class="clear">清空购物车</a> <a
						href="${path }/submitOrders" id="submit" class="submit">提交订单</a>
				</div>
			</div>
		</c:if>
	</div>



	<!-- 当购物车为空的情况  -->
	<c:if test="${fn:length(sessionScope.cart.cartItems) == 0 }">
		<div class="span24">
			<div class="step step1">
				<center style="color: red">
					<span><h2>
							您还没有 <a href="${path }/index" style="color: #843d11">购买宠物</a> 或未
							<a href="${path }/userLogin" style="color: #843d11">登录</a> ! ! !
						</h2></span>
				</center>
			</div>
		</div>
	</c:if>
	<!-- 页脚  -->
	<div class="container footer">
		<div class="span24">
			<div class="copyright">2014级 Copyright@ 2017-2018 版权所有</div>
		</div>
	</div>
</body>
</html>