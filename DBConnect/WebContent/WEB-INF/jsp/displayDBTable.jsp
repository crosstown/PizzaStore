

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page errorPage="/WEB-INF/jsp/error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="myData" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="2" />

	<sql:query dataSource="${myData}"
		sql="Select ID,FNAME, LNAME, ADDRESS, PHONE from FERNANDO.STUDENTS"
		var="result" />

	<TABLE border="2">
	    <tr><td bgcolor="#87CEEB">ID</td><td bgcolor="#87CEEB">FIRST NAME</td>
	    <td bgcolor="#87CEEB">LAST NAME</td><td bgcolor="#87CEEB">ADDRESS</td>
	    <td bgcolor="#87CEEB">PHONE</td></tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
			    <td><c:out value="${row.id}"></c:out> </td>
			    <td><c:out value="${row.fname}"></c:out> </td>
			    <td><c:out value="${row.lname}"></c:out> </td>
				<td><c:out value="${row.address}"></c:out> </td>
				 <td><c:out value="${row.phone}"></c:out> </td>
			</tr>
		</c:forEach>
	</TABLE>
	<br>
	<a href="<c:url value='index.jsp'/>">Return to Main Page</a>
</body>
</html>