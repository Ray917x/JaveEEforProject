<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料</title>
</head>
<body>
	<div align="center">
		<h2>資料</h2>

		<jsp:useBean id="animal" scope="request"
			class="com.lcpan.bean.AnimalBean" />
		<form method="post" action="/JSP/AnimalUpdate">
			<table>
				<tr>
					<td>編號
					<td><input type="text" name="animal_id"
						value="<%= animal.getAnimal_id() %>">
				<tr>
					<td>地點
					<td><input type="text" name="animal_place"
						value="<%= animal.getAnimal_place() %>">
				<tr>
					<td>種類
					<td><input type="text" name="animal_kind"
						value="<%= animal.getAnimal_kind() %>">
				<tr>
					<td>性別
					<td><input type="text" name="animal_sex"
						value="<%= animal.getAnimal_sex() %>">
				<tr>
					<td>體型
					<td><input type="text" name="animal_bodytype"
						value="<%= animal.getAnimal_bodytype() %>">
				<tr>
					<td>顏色
					<td><input type="text" name="animal_colour"
						value="<%= animal.getAnimal_colour() %>">
				<tr>		
					<td>發現地點
					<td><input type="text" name="animal_foundplace"
						value="<%= animal.getAnimal_foundplace() %>">
				<tr>		
					<td>註記
					<td><input type="text" name="animal_remark"
						value="<%= animal.getAnimal_remark() %>">
			</table>
			確認修改?<input type="submit" value="確認" />
		</form>
	</div>

</body>
</html>