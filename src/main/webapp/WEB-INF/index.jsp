
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3>
			Your Gold:
			<c:out value="${gold}"></c:out>
		</h3>
		<div class="d-flex justify-content-between">
			<div class="d-flex flex-column">
				<h3>Farm</h3>
				<form action="action" method="post"
					>
					<label>(earns 10 - 20 gold)</label>
					<input type ="hidden" name="location" value="farm">
					 <input type="submit" value="Find Gold">
				</form>
			</div>
			<div class="d-flex flex-column">
				<h3>Cave</h3>
				<form action="action" method="post"
					>
					<label>(earns 5 - 10 gold)</label>
					<input type ="hidden" name="location" value="cave">
					 <input type="submit" value="Find Gold">
				</form>
			</div>
			<div class="d-flex flex-column">
				<h3>House</h3>
				<form action="action" method="post"
					>
					<label>(earns 2 - 5 gold)</label>
					<input type ="hidden" name="location" value="house">
					 <input type="submit" value="Find Gold">
				</form>
			</div>
			<div class="d-flex flex-column">
				<h3>Casino</h3>
				<form action="action" method="post"
					>
					<label>(earns / looses 0 - 50 gold)</label>
					<input type ="hidden" name="location" value="casino">
					 <input type="submit" value="Find Gold">
				</form>
			</div>
		</div>
		<div class="bordered">
		    <c:forEach var="oneStatusUpdate" items="${status}">
       			 <p><c:out value="${oneStatusUpdate}"></c:out></p>
   			 </c:forEach>
		
		
		</div>
	</div>
</body>
</html>