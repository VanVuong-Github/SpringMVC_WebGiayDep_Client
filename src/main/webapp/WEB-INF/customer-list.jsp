<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div style="margin-top: 50px"></div>
		<table class="table table-striped text-center">
			<thead class="table-dark">
				<tr>
					<th>id</th>
					<th>first name</th>
					<th>last name</th>
					<th>email</th>
					<th>phoneNumber</th>
					<th>address</th>
					<th>urlImage</th>
					<th>status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}" varStatus="i">
					<tr>
						<td>${customer.id }</td>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<td>${customer.phoneNumber }</td>
						<td>${customer.address }</td>
						<td>${customer.urlImage }</td>
						<td>${customer.status }</td>
						<td>
							<a href="update?id=${customer.id }" class="btn btn-outline-primary">Cập nhật</a> 
							<a href="delete?id=${customer.id }" class="btn btn-outline-danger" onclick="return confirm('Bạn có muốn xóa không?')">Xóa</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr>
		<a class="btn btn-success" href="add">Thêm lớp học mới</a> 
	</div>

</body>
</html>