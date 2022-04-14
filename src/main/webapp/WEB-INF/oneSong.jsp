<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<p>
		<c:out value="${song.songName }" />
	</p>
	<p>
		<c:out value="${song.artist }" />
	</p>
	<p>
		<c:out value="${song.rating }" />
	</p>
	<form action="/songs/${song.id }" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete" class="btn btn-link">
	</form>
</body>
</html>