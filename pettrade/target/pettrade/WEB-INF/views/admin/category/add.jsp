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
<title>一级类目列表</title>
<link rel="stylesheet" type="text/css" href="${path }/css/css.css" />
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${path }/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">网站管理</a>&nbsp;-</span>&nbsp;一级类目管理
			</div>
		</div>

		<div class="page ">
			<!-- 新增类目页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>新增一级类目</span>
				</div>
				<form action="${path }/addCategory" method="post">
					<div class="baBody">
						<div class="bbD">
							一级分类名称：<input type="text" name="cname" class="input1" />
						</div>

						<div class="bbD">
							<p class="bbDP">
								<button class="btn_ok btn_yes" type="submit">提交</button>
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