<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		Значение атрибутов приложения(applicationAttribute):
		<%= application.getAttribute("applicationAttribute") %>
		<br /> значения атрибутов сеанса (sessionAttribute):
		<%= session.getAttribute("sessionAttribute") %>
		<br /> значения атризуьов запроса (requestAttribute):
		<%= request.getAttribute("requestAttribute") %>
		<br />
	</p>
	<p>
		<br /> <br />
		<%
		Enumeration<String> appAttrName = pageContext.getAttributeNamesInScope(pageContext.APPLICATION_SCOPE); 
		while(appAttrName.hasMoreElements())
		{
			out.print(appAttrName.nextElement() + "<br />");
		}
	%>
	</p>
	<p>
		<a href="buggy.jsp">Эта страница будет генерировать исключение</a>
	</p>
</body>
</html>