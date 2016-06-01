<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String uri = request.getRequestURI();

String pageName = uri.substring(uri.lastIndexOf("/")+1);
out.print(pageName);
%>