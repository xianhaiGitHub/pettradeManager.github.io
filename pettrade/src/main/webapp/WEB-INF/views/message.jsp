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
<link href="${path }/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="divcontent">
<table width="850px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
      <tr>
        <td style="width:98"><img src="${path }/images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
        <td style="padding-top:30px">
        <font style="font-weight:bold; color:#FF0000">
          <c:if test="${withoutLogin != null}">
                                               您还没有登陆，请先登录
          </c:if>
          
          <c:if test="${payment == 'payok'}">
                                               您支付成功，请返回<a href="${path }/findOrderByUid/1">订单列表</a>
          </c:if>
          
          <c:if test="${payment == 'payerror'}">
                                               您支付失败
          </c:if>
        </font>
        <br />
            <br />
          <a href="${path }/index">首页</a>
          
          <c:if test="${withoutLogin != null}">
          	<a href="${path }/userRegister">注册</a>
          	<a href="${path }/userLogin">登录</a>
          </c:if>
         </td>
      </tr>
    </table>
    <h1>&nbsp;</h1></td>
    </tr>
</table>
</div>
</body>
</html>