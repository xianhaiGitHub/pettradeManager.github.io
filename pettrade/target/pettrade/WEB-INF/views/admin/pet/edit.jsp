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
<title>编辑宠物</title>
<link rel="stylesheet" type="text/css" href="${path }/css/css.css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${path }/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">宠物管理</a>&nbsp;-</span>&nbsp;宠物管理
			</div>
		</div>
		<div class="page ">
			<!-- 修改类目页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>修改宠物</span>
				</div>
				<form action="${path }/updatePet" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="pid" value="${pet.pid }" />
					<div class="baBody">
						<div class="bbD">
							宠物名称：<input type="text" name="pname" class="input1"
								value="${pet.pname }" />
						</div>
						<div class="bbD">
							是否热门：<select name=isHot>
								<option value="1"
									<c:if test="${pet.isHot == 1 }">selected</c:if>>是</option>
								<option value="0"
									<c:if test="${pet.isHot == 0 }">selected</c:if>>否</option>
							</select>
						</div>
						<div class="bbD">
							市场价格：<input type="text" name="markPrice"
								value="${pet.markPrice }" class="input1" />
						</div>
						<div class="bbD">
							宠物价格：<input type="text" name="shopPrice"
								value="${pet.shopPrice }" class="input1" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;库存量: <input type="text" name="inventory" value="${pet.inventory }"
								class="input1" />
						</div>
						上传宠物图片：
						<div class="bbDd">
							<c:if test="${pet.image!=null&&pet.image!=''}">
								<img src="${path }/${pet.image}" width="100" height="80" />
							</c:if>
							<input type="file" class="file" name="upload" />
						</div>

						<div class="bbD">
							所属二级分类： <select name="csid">
								<c:forEach items="${categorySeconds}" var="c">
									<option value="${c.csId }"
										<c:if test="${pet.categorySecond.csId == c.csId }">selected</c:if> />
									<c:out value="${c.csName }" />
								</c:forEach>
							</select>
						</div>
						<div class="bbD">
							宠物描述：
							<textarea name="pdesc" rows="5" cols="100">${pet.pdesc }</textarea>
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