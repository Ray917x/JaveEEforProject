<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
</head>
<body>
<%--JSP element demo --%>
 <%!int count = 0;%>
 <%count++;%>
 Welcome,your visitor umber is
 <%=count%>
</body>
</html>