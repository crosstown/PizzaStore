<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page errorPage="/WEB-INF/jsp/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
<sql:setDataSource var="myData" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="2" />

	    <c:set var="id" scope="request" value="${param['id']}" />
	    
	    <sql:update var="count" dataSource="${myData}">DELETE fernando.students WHERE id='${id}'</sql:update>
	    
	    <c:if test='${count > 0}'>
		     Student erased <c:out value="${fname }"/>&nbsp<c:out value="${last }"/> from Database
		     </c:if>
		     <a href="<c:url value='index.jsp'/>">Return to Main Page</a>
</body>
</html>