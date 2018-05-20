<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物管理系统首页</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>
<body>
	<div class="head">
		<div class="headL">
			<!-- <img class="headLogo" src="img/headLogo.png" />  -->
		</div>
		<div class="headR">
			<p class="p1">
				欢迎,${admin.username }
			</p>
			<p class="p2">
				<a href="#" class="resetPWD">重置密码</a>&nbsp;&nbsp;
				<a href="javascript:exit()" class="goOut">退出</a>
			</p>
		</div>
	</div>
</body>
<script type="text/javascript">
	function exit() {
		window.open('adminOut','_top')
	}
</script>
</html>