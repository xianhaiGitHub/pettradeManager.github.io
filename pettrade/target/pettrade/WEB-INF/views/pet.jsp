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
<title>宠物交易</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/pet.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
</head>
<body class="bg-index">
	<!-- 宠物页面头部 -->
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="container petContent">
		<!-- 左侧宠物分类 -->
		<div class="span6">
			<div class="hotPetCategory">
				<c:forEach items="${sessionScope.categoryList }" var="cList">
					<dl>
						<dt>
							<a href="${path }/fingdByCid/<c:out value="${cList.cid }"/>/1"><c:out
									value="${cList.cname }" /></a>
						</dt>
						<c:forEach items="${cList.categorySeconds }" var="csList">
							<dd>
								<a
									href="${path }/fingdByCsid/<c:out value="${csList.csId }"/>/1"><c:out
										value="${csList.csName }" /></a>
							</dd>
						</c:forEach>
					</dl>
				</c:forEach>
			</div>
		</div>

		<!-- 详细宠物展示 -->
		<div class="span18 last">
			<div class="petImage">
				<a title="" style="outline-style: none; text-decoration: none;"
					id="zoom" rel="gallery"> <img style="opacity: 1;" title="宠物图片"
					class="medium" src="${path }/<c:out value="${pet.image }"/>" />
				</a>
			</div>

			<!-- 宠物的具体信息 -->
			<div class="name">
				<c:out value="${pet.pname }" />
			</div>
			<div class="sn">
				<div>
					<span>宠物编号:</span>
					<c:out value="${pet.pid }" />
				</div>
			</div>

			<div class="info">
				<dl>
					<dt>活动价:</dt>
					<dd>
						<strong>￥：<c:out value="${pet.shopPrice }" /></strong> 参 考 价：
						<!-- 市场价 -->
						<del>
							￥
							<c:out value="${pet.markPrice }" />
							元
						</del>

					</dd>
				</dl>
				<dl>
					<dt>促销:</dt>
					<dd>
						<a target="_blank" title="限时抢购">限时抢购</a>
					</dd>
				</dl>

			</div>

			<!-- 加入购物车 -->
			<form id="cartForm" action="${path }/addCart" method="post">

				<input type="hidden" name="pid" value="<c:out value="${pet.pid }"/>" />

				<div class="action">
					<dl class="quantity">
						<dt>购买数量:</dt>
						<dd>
							<input id="count" name="count" value="1" maxlength="5"
								type="number" min="0" onpaste="return false;" />
						</dd>
						<dd>件</dd>

						<dd>
							<input id="inventory" type="hidden" value="${pet.inventory}" />
						</dd>
						<dd>
							&nbsp;&nbsp;库存&nbsp;
							<c:out value="${pet.inventory}" />
							&nbsp; 件
						</dd>
					</dl>

					<div class="buy">
						<input id="addCart" class="addCart" value="加入购物车" type="button"
							onclick="addToCart()" />
					</div>
				</div>
			</form>

			<!-- 宠物介绍部分 -->
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">宠物介绍</a></li>
				</ul>
			</div>
			<div id="introduction" class="introduction">
				<div class="title">
					<!-- 宠物的描述 -->
					<strong><c:out value="${pet.pdesc }" /></strong>
				</div>
				<div>
					<!-- 宠物图片 -->
					<img width="100%" src="${path }/<c:out value="${pet.image }"/>" />
				</div>
			</div>
		</div>
	</div>

	<!-- foot  -->
	<div class="container footer">
		<div class="span24">
			<div class="copyright">2014级 Copyright@2017-2018</div>
		</div>
	</div>
	<script type="text/javascript">
		function addToCart() {
			alert("添加购物已经执行");
			var count = $("#count").val();
			var inventory = $("#inventory").val();
			if (eval(count) > eval(inventory)) {
				alert("亲,库存不足哦");
				return false;
			}
			//提交至购物车中保存
			document.getElementById("cartForm").submit();
		}
	</script>
</body>
</html>