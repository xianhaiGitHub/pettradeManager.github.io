<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物交易首页</title>
<link href="${path }/css/slider.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body class="bg-index">
	<div class="container header">
		<!-- 头部菜单 -->
		<%@ include file="menu.jsp"%>
	</div>
	<div class="container index">

		<div class="span24">
			<div id="hotPet" class="hotPet clearfix">

				<div class="title">
					<strong>热门宠物</strong>
					<!-- <a  target="_blank"></a> -->
				</div>
				<ul class="tab">
					<li class="current"><a href="#" target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<ul class="tabContent" style="display: block;">
					<c:forEach items="${mostHotPet }" var="pet" >
					<li><a href="${path }/findByPid/<c:out value="${pet.pid }"/>" target="_blank"> <img
							src="${path }/<c:out value="${pet.image }"/>" style="display: block;" />
					</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="span24">
			<div id="newPet" class="newPet clearfix">
				<div class="title">
					<strong>最新宠物</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a href="#" target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>

				<ul class="tabContent" style="display: block;">
					<c:forEach items="${mostNewPet }" var="pet">
					<li><a href="" target="_blank"> <img
							src="${path }/<c:out value="${pet.image }"/>" style="display: block;" />
					</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>新手指南</dt>
					<dd>
						<a target="_blank">支付方式</a> |
					</dd>
					<dd>
						<a target="_blank">配送方式</a> |
					</dd>
					<dd>
						<a target="_blank">售后服务</a> |
					</dd>
					<dd>
						<a target="_blank">购买帮助</a> |
					</dd>
					<dd>
						<a target="_blank">礼品卡</a> |
					</dd>
					<dd>
						<a target="_blank">银联卡</a> |
					</dd>
					<dd class="more">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>

	<div class="container footer">
		<div class="span24">
			<div class="copyright">2014级 Copyright @ 2017-2018 版权所有</div>
		</div>
	</div>
</body>
</html>