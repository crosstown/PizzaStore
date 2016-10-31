

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql setDataSource var="myData" driver=" oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="2" />

	<sql:query dataSource="${myData}"
		sql="Select FNAME, LNAME, ADDRESS, PHONE, DOB from FERNANDO.STUDENTS"
		var="result" />

	<TABLE border="2">
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<c:forEach var="column" items="${row}">
					<td><c:out value="${column.value}" /></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>