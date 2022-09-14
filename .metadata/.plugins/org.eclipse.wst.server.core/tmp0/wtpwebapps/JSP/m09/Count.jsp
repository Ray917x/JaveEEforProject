<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
</head>
<body>
 <h1>Hello,<%=request.getParameter("username")%></h1>
 <jsp:useBean id="stringBean" class="com.lcpan.bean.StringBean" />
 <ol>
 <li>Initial value(from jsp:getProperty):
 <i><jsp:getProperty name="stringBean" property="massage" /> </i>
 
 <li>Initial value(from jsp:expression):
 <i><%=stringBean.getMessage()%> </i>
 
 <li><jsp:setProperty name="stringBean" property="message" value="This is a test" />
 value after setting property with jsp:setProperty:
 <i><jsp:getProperty property="message" name="stringBean" /></i>
 
 <li><% stringBean.setMessage("Learning JSP is wonderful"); %>>
 value after setting property with expression:
 <i><%= stringBean.getMessage() %>/></i>
 
 
 
 </ol>
</body>
</html>