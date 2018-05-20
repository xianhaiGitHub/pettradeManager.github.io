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
<title>会员登录</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/login.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${path }/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${path }/js/messages_zh.js"></script>
</head>
<body class="bg-index">
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="container login">
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<form id="loginForm" action="${path }/login" method="post">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td><input type="text" name="userName" class="text" required minlength="3" maxlength="20"/> <c:if
											test="${noExistuser != null }">
											<font color="red">用户不存在,请检查用户名是否正确</font>
										</c:if></td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" name="password" class="text" required minlength="6" maxlength="20"//>
										<c:if test="${errorPassword != null}">
											<font color="red">密码错误</font>
										</c:if></td>
								</tr>
								<tr>
									<th>验证码:</th>
									<td><span class="fieldSet"> <input type="text"
											id="captcha" name="checkcode" class="text captcha"
											maxlength="4" /> <img id="captchaImage" class="captchaImage"
											src="${path }/getCheckCodeImage" onclick="changeImg()"
											title="点击更换验证码" />

									</span> <c:if test="${errorCheckCode !=null}">
											<font color="red">验证码出错</font>
										</c:if></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true" />记住用户名
									</label> <label> &nbsp;&nbsp;<a>找回密码</a>
									</label></td>
								</tr>
								<tr>
									<th>&nbsp;<font color="red">${registersuccess }</font></th>
									<td><input type="submit" class="submit" value="登 录" /></td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>
												<a href="${path }/userRegister">还没有注册账号？立即注册</a>
											</dt>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="copyright">2014级 Copyright © 2017-2018 版权所有</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#loginForm").validate({
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
	function changeImg() {
		var img1 = document.getElementById("captchaImage");
		img1.src = "${path }/getCheckCodeImage" + "?date=" + new Date();
	}
</script>
</html>