<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ride Conformed</title>
</head>
<body>
	<h2 align="center">Ride Conformed</h2>
		<table style="with: 80%" border="1" >
			<tr>
			<td>CUSTOMER NAME</td>
			<td>SOURCE</td>
			<td>DESTINATION</td>
			<td>DURATION</td>
			<td>DATE OF RIDE</td>
			</tr>
		
			<c:forEach items="${rideDetails}" var="ride">
				<tr>
					<td>${ride.username}</td>
					<td>${ride.source}</td>
					<td>${ride.destination}</td>
					<td>${ride.duration}</td>
					<td>${ride.date}</td>
					
				</tr>
				
			</c:forEach>

		</table>
		
</body>
</html>