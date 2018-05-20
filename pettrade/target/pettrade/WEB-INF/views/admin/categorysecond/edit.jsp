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
<title>二级类目列表</title>
<link rel="stylesheet" type="text/css" href="${path }/css/css.css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${path }/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">网站管理</a>&nbsp;-</span>&nbsp;二级类目管理
			</div>
		</div>

		<div class="page ">
			<!-- 修改类目页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>修改二级类目</span>
				</div>
				<form action="${path }/updateCategorySecond" method="post">
					<input type="hidden" name="csid" value="${categorySecond.csId }" />
					<div class="baBody">
						<div class="bbD">
							二级分类名称：<input type="text" name="csname" class="input1"
								value="${categorySecond.csName }" />
						</div>

						<div class="bbD">
							所属一级分类名称： <select name="cid">
								<c:forEach items="${categorys}" var="c">
									<option value="${c.cid }"
										<c:if test="${categorySecond.category.cid == c.cid}">selected</c:if> />
									<c:out value="${c.cname }" />
								</c:forEach>
							</select>
						</div>

						<div class="bbD">
							<p class="bbDP">
								<button class="btn_ok btn_yes" type="submit">修改</button>
								<a class="btn_ok btn_no" href="#" onclick="history.go(-1)">取消</a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>