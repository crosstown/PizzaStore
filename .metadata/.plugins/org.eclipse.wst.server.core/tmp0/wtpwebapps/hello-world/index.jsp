<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:redirect url="/displayDBTable.jsp" />
<select>
    <option value="" disabled="disabled" selected="selected">Please select an option</option>
    <option value="1">Display Students</option>
    <option value="2">Add Student</option>
    <option value="3">Delete Student</option>
</select>
</body>
</html>
