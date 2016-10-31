<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page errorPage="/WEB-INF/jsp/error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<sql:setDataSource var="myData" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="2" />

	    <c:set var="id" scope="request" value="${param['id']}" />
		<c:set var="fname" scope="request" value="${param['firstname']}" />
		<c:set var="lname" scope="request" value="${param['lastname']}" />
		<c:set var="address" scope="request" value="${param['address']}" />
		<c:set var="phone" scope="request" value="${param['phone']}" />
		<c:set var="dob" scope="request" value="${param['dob']}" />
		
		<sql:update var="count" dataSource="${myData}">INSERT INTO fernando.students (id, fname, lname, address, phone) VALUES
		 ('${id}', '${fname}', '${lname}', '${address}', '${phone}' ) </sql:update>
		  
		  <c:if test='${count == 1}'>
		     Student added <c:out value="${fname }"/>&nbsp<c:out value="${last }"/> into Database
		     </c:if>
		     <a href="<c:url value='index.jsp'/>">Return to Main Page</a>
</body>
</html>