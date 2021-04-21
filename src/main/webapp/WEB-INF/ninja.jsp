<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Dojo And Ninja</title>
</head>
<body>
	<div class="container p-5 mt-5">
		<div class="form-group mt-5">
			<h1>New Ninja</h1>
			<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
                <p>
                    <form:label path="dojo">Dojo: </form:label>
                    <form:errors path="dojo"/>
                    <form:select path="dojo" class="input-group-text">
                        <c:forEach items="${dojos}" var="dojo">
                            <form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
                        </c:forEach>
                    </form:select>
                </p>
                <p>
                    <form:label path="firstName">First Name: </form:label>
                    <form:errors path="firstName"/>
                    <form:input path="firstName" class="input-group-text"/>
                </p>
                <p>
                    <form:label path="lastName">Last Name: </form:label>
                    <form:errors path="lastName"/>
                    <form:input path="lastName" class="input-group-text"/>
                </p> 
                <p>
                    <form:label path="age">Age: </form:label>
                    <form:errors path="age"/>
                    <form:input type="number" path="age" class="input-group-text"/>
                </p> 
	            <input type="submit" value="Create" class="btn btn-primary btn-lg mt-3"/>
       		</form:form>
		</div>
	</div>
</body>
</html>