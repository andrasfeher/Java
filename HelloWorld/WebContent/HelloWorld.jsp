<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	java.util.Date today = new java.util.Date();
	String text = "Today's data is: " + today.toString();
	
	out.println("two by two is " + (2 * 2));
%>

<%=
	"Hello World JSP from Java. " + text
%>


</body>
</html>