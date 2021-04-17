<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<form action="ride" method="post">
		<table style="with: 80%" border="1">
			<tr>
			<td>RouteId</td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>
		
			<c:forEach items="${rList}" var="route">
				<tr>
					<td>${route.routeId}</td>
					<td>${route.source}</td>
					<td>${route.destination}</td>
					<td>${route.duration}</td>
					
					<td><input type = "hidden" name="action" value="book"/></td>
					<td><input name="Book" type="submit" value="Book${route.routeId}">
					
					</td>
				</tr>
				
			</c:forEach>

		</table>
		</form>


</body>
</html>