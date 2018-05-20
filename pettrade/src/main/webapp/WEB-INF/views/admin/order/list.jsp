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
<link href="${path }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>订单列表</title>
<script type="text/javascript">
	function showDetail(oid){
		alert("显示订单详情");
		window.location.href = "${path }/findOrderItem/"+oid;
	}
</script>
</head>
<body>
	<form id="Form1" name="Form1" action="${path }/user/list.jsp"
		method="post">
		<table class="table table-hover">
			<tr class="active">
				<td><strong>订单列表</strong></td>
			</tr>
			<tr class="success">
				<td align="center" width="10%">订单编号</td>
				<td align="center" width="20%">订单时间</td>
				<td align="center" width="10%">订单金额</td>
				<td align="center" width="10%">收货人</td>
				<td align="center" width="20%">订单状态</td>
				<td align="center" width="20%">订单详情</td>
				<td align="center" width="15%">删除</td>
			</tr>
			<c:forEach var="o" items="${orders}">
				<tr>
					<td align="center"><c:out value="${o.oid }" /></td>
					<td align="center"><c:out value="${o.ordertime }" /></td>
					<td align="center"><c:out value="${o.total }" /></td>
					<td align="center"><c:out value="${o.name }" /></td>
					<td align="center">
						<c:if test="${o.state==1}">
									未付款
					    </c:if> <c:if test="${o.state==2}">
							<a
								href="${path }/updateStateOrder/<c:out value="${o.oid }"/>/<c:out value="${page}"/>">
								<font color="blue">发货</font>
							</a>
						</c:if> 
						<c:if test="${o.state==3}">
								等待确认收货
								</c:if> <c:if test="${o.state==4}">
													订单完成
								</c:if>
					<td align="center">
						<input type="button" class="btn-primary"
						value="订单详情" id="but<c:out value="${o.oid }"/>"
						onclick="showDetail(<c:out value="${o.oid }"/>)" />
						<div id="div
							<c:out value="${o.oid }"/>">
						</div>
					</td>

					<td align="center">
					<a id="delete"
						href="${path }/deleteOrder/<c:out value="${o.oid}"/>"><input  type="button" class="btn-success" value="删除"/>
					</a></td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="7">第<c:out value="${page }" />/<c:out
						value="${count }" />页 <c:if test="${page != 1 }">
						<a href="${path }/listOrder/1">首页</a>|
									<a href="${path }/listOrder/<c:out value="${page - 1 }"/>">上一页</a>|
								</c:if> <c:if test="${page != count }">
						<a href="${path }/listOrder/<c:out value="${page + 1 }"/>">下一页</a>|
									<a href="${path }/listOrder/<c:out value="${count }"/>">尾页</a>|
								</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>
