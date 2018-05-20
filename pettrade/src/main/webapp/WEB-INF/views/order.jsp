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
<title>订单页面</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/cart.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- 页头 -->
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>
	
	<div class="container cart">
		<div class="span24">
			<div class="step step1">
				<ul>
					<li class="current"></li>
					<li>生成订单成功</li>
				</ul>
			</div>
			<!-- 订单列表 -->
			<table class="table table-hover">
				<tbody>
					<tr>
						<th colspan="5">订单编号:<c:out value="${order.oid}" />&nbsp;&nbsp;&nbsp;&nbsp;</th>
					</tr>
					<tr>
						<th>图片</th>
						<th>宠物名称</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<c:forEach var="orderItem" items="${order.orderItems}">
						<tr>
							<td width="60">
								<img src="${path }/<c:out value="${ orderItem.pet.image}"/>" />
							</td>
							<td><c:out value="${orderItem.pet.pname}" /></td>
							<td><c:out value="${orderItem.pet.shopPrice}" /></td>
							<td class="quantity" width="60"><c:out value="${orderItem.count}" /></td>
							<td width="140"><span class="subtotal">￥<c:out	value="${orderItem.subtotal}" /></span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<!-- 订单总计 -->
			
			<dl id="giftItems" class="hidden" style="display: none;">
			</dl>
			<div class="total">
				<em id="promotion"></em>宠物总计金额: <strong id="effectivePrice">￥<c:out value="${order.total}" />元
				</strong>
			</div>
			
			<!-- 提交订单 -->
			<form id="orderForm" action="${path }/orderPay" method="post">
				<input type="hidden" name="oid" value="<c:out value="${order.oid}"/>" />
				<div class="span24">
					<p>
						收货地址:<input name="addr" type="text" class ="form-control input-sm" value="<c:out value="${sessionScope.user.addr}"/>" style="width: 350px" />
					
						收货人:<input name="name" type="text" class ="form-control input-sm" value="<c:out value="${sessionScope.user.userName}"/>" style="width: 150px" />
					
					  	联系方式:<input name="phone" type="text" class ="form-control input-sm" value="<c:out value="${sessionScope.user.phone}"/>" style="width: 150px" />
					 		   <input name="total" type="hidden" value="${order.total}" />
					 支付方式:
				<label ><input name="paytype" type="radio" value="0" />钱包支付</label>
				<label ><input name="paytype" type="radio" value="1" />在线支付</label>
					</p>
					<hr />
					<p style="text-align: right">
						<a href="javascript:document.getElementById('orderForm').submit();">
							<img src="${path }/images/finalbutton.gif" width="204" height="51" border="0" />
						</a>
					</p>
				</div>
			</form>
			
		</div>
	</div>
	
	<!-- foot  -->
	<div class="container footer">
		<div class="span24">
			<div class="copyright">2014级 Copyright @ 2017-2018 版权所有</div>
		</div>
	</div>
	
</body>
</html>