<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page import="java.nio.charset.Charset" %>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title}</title>
</head>
<body>
  <h1>АСУ Перевозки</h1>
  <a href="podhod">Подход</a>
  <a href="user">Профиль</a>
  <a href="logout">Выход</a>
  
  <h2>${param.title}</h2>

 
  <jsp:include page="${param.content}.jsp"/> 
   
</body>
</html>