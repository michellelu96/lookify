<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
</head>
<body>
	<div class="d-flex flex-column align-items-center">
		<h1>Add a song</h1>
		<form:form action="/songs/new" method="post" modelAttribute="lookify">

			<p>
				<form:errors path="songName" class="error" />
			</p>
			<p>
				<form:errors path="artist" class="error" />
			</p>
			<p>
				<form:errors path="rating" class="error" />
			</p>


			<p>
				<form:label path="songName">Song Name:</form:label>
				<form:input path="songName" type="text" />
			</p>
			<p>
				<form:label path="artist">Artist:</form:label>
				<form:input path="artist" type="text" />
			</p>
			<p>
				<form:label path="rating">Rating: </form:label>
				<form:input type="number" path="rating" />
			</p>
	
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>