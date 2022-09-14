<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, com.lcpan.bean.AnimalBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>animals</title>
</head>
<body style="background-color: black">
	<div align="center">
		<h2>animals</h2>
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
		   <!-- <th>更新日</th> -->		
				


				<c:forEach items="${animals}" var="animal" varStatus="s">
					<tr>
						<td>${animal.animal_id}
						<td>${animal.animal_place}
						<td>${animal.animal_kind}
						<td>${animal.animal_sex}
						<td>${animal.animal_bodytype}
						<td>${animal.animal_colour}
						<td>${animal.animal_foundplace}
						<td>${animal.animal_remark}
						
				   <!-- <td>${animal.animal_update} -->		
						
						 
						
						
				</c:forEach>
		</table>
		
	</div>
</body>

</html>