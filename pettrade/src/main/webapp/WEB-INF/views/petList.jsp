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
<title>宠物交易</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/pet.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="container petList">
		<!-- 左侧宠物分类 -->
		<div class="span6">
			<div class="hotPetCategory">
				<c:forEach items="${sessionScope.categoryList }" var="cList">
					<dl>
						<dt>
							<a href="${path }/fingdByCid/<c:out value="${cList.cid }"/>/1"><c:out value="${cList.cname }" /></a>
						</dt>
						<c:forEach items="${cList.categorySeconds }" var="csList">
							<dd>
								<a href="${path }/fingdByCsid/<c:out value="${csList.csId }"/>/1"><c:out value="${csList.csName }" /></a>
							</dd>
						</c:forEach>
					</dl>
				</c:forEach>
			</div>
		</div>
		<div class="span18 last">
			<!-- 各项宠物 -->
			<div id="result" class="result table clearfix">
				<ul>
				<c:forEach items="${pets }" var="pet">
					<li><a href="${path }/findByPid/<c:out value="${pet.pid}"/>">
							<img src="${path }/<c:out value="${pet.image }"/>" width="170" height="170"
							style="display: inline-block;" /> <span style='color: green'><c:out value="${pet.pname }"/></span>
							<span class="price"> 交易价： ￥<c:out value="${pet.shopPrice }"/> </span>
					</a></li>
				</c:forEach>
				</ul>
			</div>

			<!-- 按照一类目和二级类目来分页 -->
			<div class="pagination">

				<!-- 根据一级分类的cid是不是为空来显示上一页下一页 -->
				<c:if test="${cid != null }">
					<span>第 <c:out value="${page }"/>页/共<c:out value="${totalPage }"/>页</span>
					<!-- 首页 -->
					<span><a class="firstPage" href="${path }/fingdByCid/{cid}/1"></a></span>

					<!-- 上一页 -->
					<c:if test="${page != 1 }">
						<span><a class="previousPage" href="${path }/fingdByCid/{cid}/<c:out value="${page-1 }"/>"></a></span>
					</c:if>

					<c:forEach begin="1" end="${totalPage }" var="i">
						<span> 
						<!-- 如果是当前页则不能够点击 --> 
						<c:if test="${i == page }">
								<span class="currentPage">${page }</span>
						</c:if> 
						<c:if test="${i != page }">
								<a href="${path }/fingdByCid/{cid}/<c:out value="${i }"/>"><c:out value="${i }" /></a>
						</c:if>
						</span>
					</c:forEach>
					<!-- 下一页 -->
					<c:if test="${page != totalPage }">
						<span><a class="nextPage" href="${path }/fingdByCid/{cid}/<c:out value="${page+1 }"/>"></a></span>
					</c:if>

					<!-- 尾页 -->
					<span><a class="lastPage" href="${path }/fingdByCid/{cid}/<c:out value="${totalPage }"/>"></a></span>
				</c:if>
				<!-- 根据二级分类的csid是不是为空来显示上一页下一页的 -->
				<c:if test="${csid != null }">
					<span>第 <c:out value="${page }"/>页/共<c:out value="${totalPage }"/>页</span>
					<!-- 首页 -->
					<span><a class="firstPage" href="${path }/fingdByCid/{cid}/1"></a></span>

					<!-- 上一页 -->
					<c:if test="${page != 1 }">
						<span><a class="previousPage" href="${path }/fingdByCid/{cid}/<c:out value="${page-1 }"/>"></a></span>
					</c:if>

					<c:forEach begin="1" end="${totalPage }" var="i">
						<span> 
						<!-- 如果是当前页则不能够点击 --> 
						<c:if test="${i == page }">
								<span class="currentPage">${page }</span>
						</c:if> 
						<c:if test="${i != page }">
								<a href="${path }/fingdByCid/{cid}/<c:out value="${i }"/>"><c:out value="${i }" /></a>
						</c:if>
						</span>
					</c:forEach>
					<!-- 下一页 -->
					<c:if test="${page != totalPage }">
						<span><a class="nextPage" href="${path }/fingdByCid/{cid}/<c:out value="${page+1 }"/>"></a></span>
					</c:if>

					<!-- 尾页 -->
					<span><a class="lastPage" href="${path }/fingdByCid/{cid}/<c:out value="${totalPage }"/>"></a></span>
				</c:if>
			</div>
		</div>
		<!-- foot -->
		<div class="container footer">
			<div class="span24">
				<div class="copyright">2014级Copyright © 2017-2018 版权所有</div>
			</div>
		</div>
	</div>
</body>
</html>