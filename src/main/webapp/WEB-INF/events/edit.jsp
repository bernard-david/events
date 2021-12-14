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
		<br />
		<h5>Edit Event</h5>
		<form:form action="/events/${event.id}/edit" method="post" modelAttribute="event">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
		            <label>Name:</label>
		            <form:input path="name" class="form-control" />
		            <form:errors path="name" class="text-danger" />
		   	</div>
		   	<div class="form-group">
		            <label>Date:</label>
		            <form:input type="date" path="date" class="form-control" />
		            <form:errors path="date" class="text-danger" />
		   	</div>
		   	<div class="form-group">
		            <label>Location:</label>
		            <form:input path="location" class="form-control" />
		            <form:errors path="location" class="text-danger" />
		   	</div>
		   	<div class="form-group">
		            <label>State:</label>
		            <form:select path="state" class="form-select">
		            	<form:option value="AK"/>
		            	<form:option value="AL"/>
		            	<form:option value="AR"/>
		            	<form:option value="AZ"/>
		            	<form:option value="CA"/>
		            	<form:option value="CO"/>
		            	<form:option value="CT"/>
		            	<form:option value="DE"/>
		            	<form:option value="FL"/>
		            	<form:option value="GA"/>
		            	<form:option value="HI"/>
		            	<form:option value="IA"/>
		            	<form:option value="ID"/>
		            	<form:option value="IL"/>
		            	<form:option value="IN"/>
		            	<form:option value="KS"/>
		            	<form:option value="KY"/>
		            	<form:option value="LA"/>
		            	<form:option value="MA"/>
		            	<form:option value="MD"/>
		            	<form:option value="ME"/>
		            	<form:option value="MI"/>
		            	<form:option value="MN"/>
		            	<form:option value="MO"/>
		            	<form:option value="MS"/>
		            	<form:option value="MT"/>
		            	<form:option value="NC"/>
		            	<form:option value="ND"/>
		            	<form:option value="NE"/>
		            	<form:option value="NH"/>
		            	<form:option value="NJ"/>
		            	<form:option value="NM"/>
		            	<form:option value="NV"/>
		            	<form:option value="NY"/>
		            	<form:option value="OH"/>
		            	<form:option value="OK"/>
		            	<form:option value="OR"/>
		            	<form:option value="PA"/>
		            	<form:option value="RI"/>
		            	<form:option value="SC"/>
		            	<form:option value="SD"/>
		            	<form:option value="TN"/>
		            	<form:option value="TX"/>
		            	<form:option value="UT"/>
		            	<form:option value="VA"/>
		            	<form:option value="VT"/>
		            	<form:option value="WA"/>
		            	<form:option value="WI"/>
		            	<form:option value="WV"/>
		            	<form:option value="WY"/>
		            </form:select>
		    </div>
		    <br />
		    <form:hidden path="host" value="${user.id}"/>
		    <input type="submit" value="Edit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>