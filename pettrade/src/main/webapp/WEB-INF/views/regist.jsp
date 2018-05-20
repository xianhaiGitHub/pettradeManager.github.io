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
<title>用户注册</title>
<link href="${path }/css/common.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/register.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${path }/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${path }/js/messages_zh.js"></script>
</head>
<body class="bg-index">
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>用户注册</strong>USER REGISTER
					</div>
					<form id="registerform" action="${path }/register" method="post">
						<table>
							<tbody>
								<tr>
									<th><span class="requiredField">*</span>用户名:</th>
									<td><input type="text" id="userName" name="userName"
										class="text" required minlength="3" maxlength="20"
										onblur="checkUserName()" /> <span id="span1"
										style="padding-left: 10px;"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>密&nbsp;&nbsp;码:</th>
									<td><input type="password" name="password" class="text"
										required minlength="3" maxlength="20" /></td>
								</tr>
								<tr>
									<th>E-mail:</th>
									<td><input type="text" name="email" class="text" /></td>
								</tr>
								<tr>
									<th>姓名:</th>
									<td><input type="text" name="name" class="text" required />
									</td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>电话:</th>
									<td><input type="text" name="phone" class="text" required />
									</td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>地址:</th>
									<td><input type="text" name="addr" class="text" required />
									</td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>验证码:</th>
									<td><span class="fieldSet"> <input type="text" id="checkcode"
											name="checkcode" class="text captcha" maxlength="4" /> <img id="checkImg" class="captchaImage"
											src="${path }/getCheckCodeImage" onclick="changeImg()" title="点击更换验证码" />
									</span> <c:if test="${errorCheckCode!= null}">
											<font color="red">验证码出错</font>
										</c:if></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><input type="submit" class="submit" value="确认注册" /></td>
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
	<div id="_my97DP"
		style="position: absolute; top: -1970px; left: -1970px;"></div>
</body>
<script type="text/javascript">
		$(function() {
			$("#registerform").validate({
				submitHandler : function(form) {
					form.submit();
				}
			});
		});

		function checkUserName() {
			$.post(
				"${path }/checkUser/" + $("#userName").val(),
				{},
				function(data) {
					if (data == 1) {
						//alert("用户已经注册");
						document.getElementById("span1").innerHTML = "<font color='red'>用户名已经被注册</font>";
						$("#username").val("");
						$("#username").focus();
						$(".submit").unbind("click",
								function(event) {

								});
					} 
				});
		}
	    function changeImg() {
	        var img1 = document.getElementById("checkImg");
	        img1.src = "${path }/getCheckCodeImage"
	            + "?date=" + new Date();
	    }
	</script>
</html>
