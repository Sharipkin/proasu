<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Профиль пользователя</title>
</head>
<body>
<h2>Пользователь: <%= request.getRemoteUser() %></h2>
<form action="switchstation" method="post">

	<c:forEach var="list" items="${listkodst }">
	  
	  <input type="radio" name="userkodst" 
	  	value="${list }"<c:if test="${list == activkodst}"> checked </c:if> >
	 	 ${list }<br>
	 
	</c:forEach>
	<input type="submit" value="Изменить код станции">
</form>
<a href="./">Главная</a>
<%= page.toString() %>
</body>
</html>