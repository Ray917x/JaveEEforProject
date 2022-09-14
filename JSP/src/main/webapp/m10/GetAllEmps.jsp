<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, com.lcpan.bean.EmpBean" %>
<%! @SuppressWarnings("unchecked") %>
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
                <% List<EmpBean> emps= (ArrayList<EmpBean>)request.getAttribute("emps");
                        for(EmpBean emp : emps) { %>
            <tr>
                <td>
                    <%= emp.getEmpno()%></td>
                <td>
                    <%= emp.getEname()%></td>
                <td>
                    <%= emp.getHiredate()%></td>
                <td>
                    <%= emp.getSalary()%></td>
                <td>
                    <%= emp.getDeptno()%></td>
                <td>
                    <%= emp.getTitle()%></td>

            </tr>
            <% } %>
        </table>
        <h3>共<%= emps.size() %>筆
        </h3>
    </div>
</body>

</html>