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
<title>Login/Register</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-3">Events Near You</h1>
		<div class="d-flex justify-content-center gap-3 mt-3">
			<div class="w-50">
				<h4>Register Here!</h4>
				<form:form action="/register" method="post" modelAttribute="newUser">
			        <div class="form-group">
			            <label>First Name:</label>
			            <form:input path="firstName" class="form-control" />
			            <form:errors path="firstName" class="text-danger" />
			        </div>
			        <div class="form-group">
			            <label>Last Name:</label>
			            <form:input path="lastName" class="form-control" />
			            <form:errors path="lastName" class="text-danger" />
			        </div>
			        <div class="form-group">
			            <label>Email:</label>
			            <form:input path="email" class="form-control" />
			            <form:errors path="email" class="text-danger" />
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
			            <form:errors path="state" class="text-danger" />
			        </div>
			        <div class="form-group">
			            <label>Password:</label>
			            <form:password path="password" class="form-control" />
			            <form:errors path="password" class="text-danger" />
			        </div>
			        <div class="form-group">
			            <label>Confirm Password:</label>
			            <form:password path="confirm" class="form-control" />
			            <form:errors path="confirm" class="text-danger" />
			        </div>
			        <br />
			        <input type="submit" value="Register" class="btn btn-primary" />
		    	</form:form>
			</div>
			
		    <div class="w-50">
		    	<h4>Login Here!</h4>
		    	<p class="text-danger"><c:out value="${error}"></c:out></p>
		    	<form:form action="/login" method="post" modelAttribute="newLogin">
			        <div class="form-group">
			            <label>Email:</label>
			            <form:input path="email" class="form-control" />
			            <form:errors path="email" class="text-danger" />
			        </div>
			        <div class="form-group">
			            <label>Password:</label>
			            <form:password path="password" class="form-control" />
			            <form:errors path="password" class="text-danger" />
			        </div>
			        <br />
			        <input type="submit" value="Login" class="btn btn-success" />
		   		</form:form>
		    </div>
		    
		</div>
	</div>
	
</body>
</html>