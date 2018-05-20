<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<!-- 若客户未登录 -->
			<c:if test="${sessionScope.user == null }">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${path }/userLogin">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${path }/userRegister">注册</a>|
				</li>
			</c:if>
			<!-- 若客户已登录 -->
			<c:if test="${sessionScope.user != null }">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<c:out value="${user.userName }" />
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${path}/findOrderByUid/1">我的订单</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${path }/exit">退出</a>|</li>
			</c:if>
		</ul>
		<ul>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${path }/admin">宠物交易后台</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${path }/myCart">购物车</a>
	</div>
</div>

<div class="span24">
	<ul class="mainNav">
		<li><a href="${path }/index">首页</a>|</li>
		<c:forEach items="${sessionScope.categoryList }" var="c">
			<li><a href="${path }/fingdByCid/<c:out value="${c.cid }"/>/1"><c:out value="${c.cname }"/></a></li>
		</c:forEach>
	</ul>
</div>