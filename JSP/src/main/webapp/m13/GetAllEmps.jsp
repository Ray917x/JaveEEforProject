<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, com.lcpan.bean.EmpBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>員工資料</title></head>
<body style="background-color: yellow">
    <div align="center">
        <h2>員工資料</h2>
        <table border="1">
            <tr style="background-color: white">
                <th>員工編號</th>
                <th>姓名</th>
                <th>到職日</th>
                <th>薪水</th>
                <th>部門編號</th>
                <th>職稱</th>
         
            
                <c:forEach items="${emps}" var="emp" varStatus="s">
                <tr><td>${emp.empno}
                <td>${emp.ename}
                <td>${emp.hiredate}
                <td>${emp.salary}
                <td>${emp.deptno}
                <td>${emp.title}
                
                <c:set var="count" value="${s.count}" />
                </c:forEach>
           </table>
        <h3>共${count}筆</h3>
    </div>
</body>

</html>