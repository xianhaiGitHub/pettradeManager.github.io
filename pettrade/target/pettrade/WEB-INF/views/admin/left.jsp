<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物交易管理系统首页</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>
<body>
<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="adminWelcome" target="mainFrame">
			<div class="line"> <img src="img/coin01.png" />&nbsp;&nbsp;首页
			</div>
			</a>

			 <dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin07.png" /><img class="icon2"
						src="img/coin08.png" /> 会员管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="listUser/1" target="mainFrame"
						class="cks">会员管理</a><img class="icon5" src="img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin03.png" /><img class="icon2"
						src="img/coin04.png" />类目管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="listCategory/1"
						target="mainFrame">一级类目管理</a><img class="icon5" src="img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="listCategorySecond/1"
						target="mainFrame">二级类目管理</a><img class="icon5" src="img/coin21.png" />
				</dd>
			</dl>
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/dog.png" /><img class="icon2"
						src="img/dog.png" />宠物管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="listpet/1"
						target="mainFrame" class="cks">宠物管理</a><img class="icon5"
						src="img/coin21.png" />
				</dd>
			</dl>
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin11.png" /><img class="icon2"
						src="img/coin12.png" /> 订单管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="listOrder/1" target="mainFrame"
						class="cks">订单管理</a><img class="icon5" src="img/coin21.png" />
				</dd>
			</dl>
			<!-- <dl class="system_log">
				<dt>
					<img class="icon1" src="img/coinL1.png" /><img class="icon2"
						src="img/coinL2.png" /> 系统管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a href="changepwd"
						target="mainFrame" class="cks">修改密码</a><img class="icon5"
						src="img/coin21.png" />
				</dd>
			</dl> -->

		</div>

	</div>
</body>
</html>