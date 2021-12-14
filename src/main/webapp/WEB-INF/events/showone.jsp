<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${event.name}"/></h1>
		<div class="w-50 p-3">
			<p>Host: <c:out value="${event.host.firstName} ${event.host.lastName}"/></p>
			<p>Date: <c:out value="${event.date}"/></p>
			<p>Location: <c:out value="${event.location}, ${event.state}"/></p>
			<p>People Attending: <c:out value="${numUsers}"/></p>
			<br />
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Hey</td>
						<td>Hey</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="w-50 p-3">
			<h3>Message Wall</h3>
			<br />
			
		</div>
	</div>
</body>
</html>