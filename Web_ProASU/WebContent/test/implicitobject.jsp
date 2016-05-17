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
		<%
		  application.setAttribute("applicationAttribute", new String("Эта строка доступна для всех сеансов"));
		  session.setAttribute("sessionAttribute", new String("Эта строка доступна для всех запросов"));
		  request.setAttribute("requestAttribute", new String("Эта строка доступна в одном запросе"));
		  Enumeration<String> initParametrNames = config.getInitParameterNames();
		  out.print("Инициальзация параметров, полученных из неявных <br />");
		  out.print("объектов конфигурации <br /><br />");
		  
		  while(initParametrNames.hasMoreElements())
		  {
			  String parametrName = initParametrNames.nextElement();
			  out.print(parametrName + " = ");
			  out.print(config.getInitParameter(parametrName));
			  out.print("<br />");
		  }	  
			  out.print("Неаявный объект <b>page</b> имеет тип ");
			  out.print(page.getClass().getName() + "<br /><br />");
			  
			  out.print("Размер буфера: "+response.getBufferSize()+" байт");
  
  
		%>

	</p>
	<p>
		<a href="test/implicitobject2.jsp">Щелкните здесь для продолжения</a>
	</p>

</body>
</html>