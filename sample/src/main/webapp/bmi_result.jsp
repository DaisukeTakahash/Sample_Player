<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP&サーブレット連携</title>
</head>
<body>
	<ul>
	<li>身長：${param['height']}</li>
	<li>体重：${param['weight']}</li>
	<li>BMI値：<c:out value="${bmi}"/></li>
	<li>判定結果：${requestScope['rank']}</li>
	</ul>
</body>
</html>