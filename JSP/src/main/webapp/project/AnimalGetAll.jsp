<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, com.lcpan.bean.AnimalBean" %>
<%! @SuppressWarnings("unchecked") %>
<html>
<head><title>資料</title></head>
<body style="background-color: yellow">
    <div align="center">
        <h2>資料</h2>
        <table border="1">
            <tr style="background-color: white">
                <th>編號</th>
                <th>地點</th>
                <th>種類</th>
                <th>性別</th>
                <th>體型</th>
                <th>顏色</th>
                <th>發現地點</th>
                <th>註記</th>
                <% List<AnimalBean> animals = (ArrayList<AnimalBean>)request.getAttribute("animals");
                        for(AnimalBean animal : animals) { %>
            <tr>
                <td>
                    <%= animal.getAnimal_id()%></td>
                <td>
                    <%= animal.getAnimal_place()%></td>
                <td>
                    <%= animal.getAnimal_kind()%></td>
                <td>
                    <%= animal.getAnimal_sex()%></td>
                <td>
                    <%= animal.getAnimal_bodytype()%></td>
                <td>
                    <%= animal.getAnimal_colour()%></td>
                <td>
                    <%= animal.getAnimal_foundplace()%></td>
                <td>
                    <%= animal.getAnimal_remark()%></td>
               
            </tr>
            <% } %>
        </table>
        <h3>共<%= animals.size() %>筆
        </h3>
    </div>
</body>

</html>