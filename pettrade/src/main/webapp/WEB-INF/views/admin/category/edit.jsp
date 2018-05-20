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
<link rel="stylesheet" type="text/css"
	href="${path }/css/manhuaDate.1.0.css">
<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
<script type="text/javascript" src="${path }/js/manhuaDate.1.0.js"></script>
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input.mh_date").manhuaDate({
			Event : "click",//可选               
			Left : 0,//弹出时间停靠的左边位置
			Top : -16,//弹出时间停靠的顶部边位置
			fuhao : "-",//日期连接符默认为-
			isTime : false,//是否开启时间值默认为false
			beginY : 1949,//年份的开始默认为1949
			endY : 2100
		//年份的结束默认为2049
		});
	});
</script>
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
			<!-- 修改类目页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>修改一级类目</span>
				</div>
				<form action="${path }/updateCategory" method="post">
					<input type="hidden" name="cid" value="${category.cid}" />
					<div class="baBody">
						<div class="bbD">
							一级分类名称：<input type="text" name="cname" class="input1"
								value="${category.cname}" />
						</div>

						<%-- <div class="bbD">
						折&nbsp;&nbsp;&nbsp;&nbsp;扣&nbsp;&nbsp;&nbsp;&nbsp;率：<input type="text" name="discount" class="input1" value="${category.discount}" />
					</div>
					
					<div class="cfD">
						优&nbsp;&nbsp;惠&nbsp;&nbsp;时&nbsp;&nbsp;间：
						<input type="text"  class="vinput mh_date" name="privilegeTime" class="input1" value="${category.privilegeTime}" readonly="true"/>
					</div> --%>

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