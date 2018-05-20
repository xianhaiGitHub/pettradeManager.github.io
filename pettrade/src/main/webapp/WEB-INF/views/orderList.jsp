<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>订单页面</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/cart.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/pet.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- 页头 -->
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>


	<div class="container cart">
		<div class="span24">
			<div>
				<ul>
					<li class="current"></li>
					<li><b>我的订单</b></li>
				</ul>
			</div>
			<table class="table table-hover">
				<tbody>
					<c:forEach items="${orders}" var="order">
						<tr class="danger">
							<th colspan="5">订单编号:<c:out value="${order.oid}" />&nbsp;&nbsp;&nbsp;&nbsp;
								订单金额:<font color="red"><c:out value="${order.total }" /></font>
								&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${order.state == 1}">
									<a href="${path }/findByOid/<c:out value="${order.oid}" />">
										<font color="red">付款</font>
									</a>
								</c:if> <c:if test="${order.state == 2}">
									已付款
								</c:if> <c:if test="${order.state == 3}">
									<a href="${path }/updateState/<c:out value="${order.oid}" />">确认收货</a>
								</c:if> <c:if test="${order.state == 4}">
									交易成功
								</c:if>
							</th>
						</tr>
						<tr>
							<th>宠物图片</th>
							<th>宠物名称</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach var="orderItem" items="${order.orderItems}">
							<tr>
								<td width="60"><a
									href="${path }/findByPid/<c:out value="${orderItem.pet.pid}"/>">
										<img src="${path }/<c:out value="${orderItem.pet.image}"/>" />
								</a></td>
								<td><c:out value="${ orderItem.pet.pname}" /></td>
								<td><c:out value="${orderItem.pet.shopPrice}" /></td>
								<td class="quantity" width="60"><c:out
										value="${orderItem.count}" /></td>
								<td width="140"><span class="subtotal">￥<c:out
											value="${orderItem.subtotal}" />
								</span></td>
							</tr>
						</c:forEach>
					</c:forEach>
					<tr>
						<th colspan="5">
							<div class="pagination">
								<span>第 <c:out value="${page}" />/<c:out
										value="${count}" />页
								</span>
								<!-- 首页 -->
								<span><a class="firstPage"
									href="${path }/findOrderByUid/1"></a></span>
								<c:if test="${page != 1}">
									<span><a class="previousPage"
										href="${path }/findOrderByUid/<c:out value="${page-1}"/>"></a></span>
								</c:if>
								<c:forEach var="i" begin="1" end="${count }">
									<span> <!-- 如果是当前页则不能够点击 --> <c:if test="${i == page }">
											<span class="currentPage">${page }</span>
										</c:if> <c:if test="${i != page }">
											<a href="${path }/findOrderByUid/<c:out value="${i}"/>">
												<c:out value="${i}" />
											</a>
										</c:if>
									</span>
								</c:forEach>
								<!-- 下一页 -->
								<c:if test="${page !=count }">
									<span><a class="nextPage"
										href="${path }/findOrderByUid/<c:out value="${page+1}"/>"></a></span>
								</c:if>
								<!-- 尾页 -->
								<a class="lastPage"
									href="${path }/findOrderByUid/<c:out value="${count}"/>"></a>
							</div>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<!-- 页脚  -->
	<div class="container footer">
		<div class="span24">
			<div class="copyright">2014级 Copyright @ 2017-2018 版权所有</div>
		</div>
	</div>

</body>
</html>