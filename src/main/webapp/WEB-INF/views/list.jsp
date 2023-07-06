<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Gbook List page
</h1>

	<ul>
		<c:forEach var="dto" items="${dtoList}" >
			<li>${dto}</li>
		</c:forEach>	
	</ul>

</body>
</html>
